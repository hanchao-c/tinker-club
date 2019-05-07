package org.tinker.auth.shiro.realm;

import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.List;
import java.util.stream.Stream;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.tinker.auth.shiro.cache.ShrioRedisCache;
import org.tinker.auth.shiro.handler.ShiroPermissionHandler;
import org.tinker.auth.shiro.handler.ShiroRoleHandler;
import org.tinker.auth.shiro.handler.ShiroUserHandler;
import org.tinker.auth.shiro.model.ShiroPermission;
import org.tinker.auth.shiro.model.ShiroRole;
import org.tinker.auth.shiro.model.ShiroUser;

public class DefaultAuthorizingRealm<U extends ShiroUser, R extends ShiroRole, P extends ShiroPermission> extends AuthorizingRealm {

	private ShiroUserHandler<U> userService;
	private ShiroRoleHandler<R> roleService;
	private ShiroPermissionHandler<P> permissionService;

	public DefaultAuthorizingRealm(
			ShiroUserHandler<U> userService, 
			ShiroRoleHandler<R> roleService,
			ShiroPermissionHandler<P> permissionService, 
			RedisTemplate<String, AuthorizationInfo> template) {
		this.userService = userService;
		this.roleService = roleService;
		this.permissionService = permissionService;
		// password md5
		this.setCredentialsMatcher(new HashedCredentialsMatcher(Md5Hash.ALGORITHM_NAME));
		// auth cache
		this.setCachingEnabled(true);
		this.setAuthorizationCachingEnabled(true);
		this.setAuthorizationCache(new ShrioRedisCache(template));
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String account = (String) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		List<R> roles = roleService.getByAccount(account);
		roles.stream().forEach(role -> {
			List<P> permissions = permissionService.getByRole(role.getId());
			permissions.forEach(permission -> {
				Stream.of(split(trimToEmpty(permission.getPermission()), ",")).forEach(authorizationInfo::addStringPermission);
				Stream.of(split(trimToEmpty(permission.getAuthorities()), ",")).forEach(authorizationInfo::addRole);
			});
		});
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String account = (String) authenticationToken.getPrincipal();
		U user = userService.getByAccount(account);
		if (null == user) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				account, 
				user.getPassword(),
				ByteSource.Util.bytes(account.concat(user.getSalt())), 
				super.getName());
		return simpleAuthenticationInfo;
	}

	/**
	 * protected -> public
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

}
