package org.tinker.auth.shiro.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.tinker.asset.constant.RedisKeyPrefix;

/**
 * Shiro cache (session,authInfo)
 */
public class ShrioRedisCache implements Cache<Object, AuthorizationInfo>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String SHIRO_CACHE_BEAN_PREFIX = RedisKeyPrefix.SHIRO_CACHE_BEAN_PREFIX;
	
	private final RedisTemplate<String, AuthorizationInfo> template;
	
	public ShrioRedisCache(RedisTemplate<String, AuthorizationInfo> template) {
		this.template = template;
	}
	
	private String decorate(Object key) {
		return SHIRO_CACHE_BEAN_PREFIX.concat(key.toString());
	}

	@Override
	public AuthorizationInfo get(Object key) throws CacheException {
		return template.opsForValue().get(this.decorate(key));
	}

	@Override
	public AuthorizationInfo put(Object key, AuthorizationInfo value) throws CacheException {
		template.opsForValue().set(this.decorate(key), value);
		return value;
	}

	@Override
	public AuthorizationInfo remove(Object key) throws CacheException {
		template.delete(this.decorate(key));
		return null;
	}

	@Override
	public void clear() throws CacheException {
		throw new AssertionError();
	}

	@Override
	public int size() {
		throw new AssertionError();
	}

	@Override
	public Set<Object> keys() {
		throw new AssertionError();
	}

	@Override
	public Collection<AuthorizationInfo> values() {
		throw new AssertionError();
	}
	
}
