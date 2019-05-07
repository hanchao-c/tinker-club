package org.tinker.auth.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.tinker.CompositeJUnit4SpringContext;
import org.tinker.asset.constant.SystemUser;
import org.tinker.asset.persistent.Transactional_auth;
import org.tinker.asset.util.IDUtil;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.auth.repository.tk.model.User;

import lombok.extern.slf4j.Slf4j;

@Transactional_auth
@Slf4j
public class UserServiceTest extends CompositeJUnit4SpringContext {

	@Autowired
	private UserService userService;
	
	@Test
	@Rollback
	public void testCreate() {
		
		User user = userService.getByAccount(SystemUser.SYSTEM_OWNER_ACCOUNT);
		log.info(JacksonUtil.toJSONString(user));
		
		user = new User();
		user.setId(IDUtil.uuid());
		user.setName(SystemUser.SYSTEM_OWNER_NAME);
		user.setAccount(SystemUser.SYSTEM_OWNER_ACCOUNT);
		user.setPassword(SystemUser.SYSTEM_OWNER_PASSWORD);
		userService.create(user);
		
	}

}
