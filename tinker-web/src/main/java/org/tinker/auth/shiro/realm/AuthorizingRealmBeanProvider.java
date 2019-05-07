package org.tinker.auth.shiro.realm;

import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.tinker.auth.repository.tk.model.Permission;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.service.PermissionService;
import org.tinker.auth.service.RoleService;
import org.tinker.auth.service.UserService;

/**
 * Shrio Realm 策略支持
 */
@Component
public class AuthorizingRealmBeanProvider extends DefaultAuthorizingRealm<User, Role, Permission> {

	@Autowired
	public AuthorizingRealmBeanProvider(
			UserService userService, 
			RoleService roleService,
			PermissionService permissionService, 
			RedisTemplate<String, AuthorizationInfo> template) {
		super(userService, roleService, permissionService, template);
	}

}
