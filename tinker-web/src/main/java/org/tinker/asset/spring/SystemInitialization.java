package org.tinker.asset.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tinker.asset.constant.SystemUser;
import org.tinker.asset.util.IDUtil;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 系统初始化业务
 */
@Component
@Slf4j
public class SystemInitialization implements InitializingBean{
	

	@Autowired
	private UserService userService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("检查系统超级用户");
		User user = userService.getByAccount(SystemUser.SYSTEM_OWNER_ACCOUNT);
		if(null == user) {
			user = new User();
			user.setId(IDUtil.uuid());
			user.setName(SystemUser.SYSTEM_OWNER_NAME);
			user.setAccount(SystemUser.SYSTEM_OWNER_ACCOUNT);
			user.setPassword(SystemUser.SYSTEM_OWNER_PASSWORD);
			userService.create(user);
		}
	}

}
