package org.tinker.auth.shiro.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.tinker.asset.constant.RedisKeyPrefix;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用redis对shiro登录用户的菜单、后台权限进行缓存
 */
@Component
@Slf4j
public class RedisSessionDAO extends AbstractSessionDAO {

	@Autowired
	private RedisTemplate<Serializable, Session> template;

	private final String SHIRO_SESSION_ID_PREFIX = RedisKeyPrefix.SHIRO_SESSION_ID_PREFIX;

	private String decorate(Serializable sessionId) {
		return SHIRO_SESSION_ID_PREFIX.concat(sessionId.toString());
	}

	@Override
	protected Serializable doCreate(Session session) {
		log.debug("session-create {}", session.getId());
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		template.opsForValue().setIfAbsent(this.decorate(sessionId), session);
		return sessionId;
	}
	
	@Override
	public void delete(Session session) {
		log.debug("session-delete {}", session.getId());
		if (null != session) {
			template.delete(this.decorate(session.getId()));
		}
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		if(null == session){
			throw new UnknownSessionException();
		}
		log.debug("session-update {}", session.getId());
		template.opsForValue().set(this.decorate(session.getId()), session);
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		log.debug("session-load : {}", sessionId);
		return template.opsForValue().get(this.decorate(sessionId));
	}

	@Override
	public Collection<Session> getActiveSessions() {
		log.debug("session-load-all");
		Set<Serializable> keys = template.keys(SHIRO_SESSION_ID_PREFIX.concat("*"));
		List<Session> sessions = template.opsForValue().multiGet(keys);
		if (null == sessions) {
			sessions = Lists.newArrayListWithCapacity(0);
		}
		log.debug("session.size = {}", sessions.size());
		return sessions;
	}



}
