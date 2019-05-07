package org.tinker.asset.constant;

/**
 * Redis 常量字典
 */
public interface RedisKeyPrefix {

	/**
	 * shiro session-id
	 */
	public static final String SHIRO_SESSION_ID_PREFIX = "tinker:SHIRO_SESSION_ID_";
	
	/**
	 * shiro 权限信息
	 */
	public static final String SHIRO_CACHE_BEAN_PREFIX 	= "tinker:SHIRO_CACHE_AUTHORIZATION_";
	
	/**
	 * 用户个人信息
	 */
	public static final String ACCOUNT_USER_INFO_PREFIX = "tinker:ACCOUNT_USER_INFO_";

}
