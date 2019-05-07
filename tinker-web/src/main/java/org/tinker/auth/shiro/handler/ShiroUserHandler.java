package org.tinker.auth.shiro.handler;

import org.tinker.auth.shiro.model.ShiroUser;

/**
 * 
 * @param <T>
 */
public interface ShiroUserHandler<T extends ShiroUser> {

	/**
	 * 获取ShiroUser
	 * @param account 账号
	 * @return
	 */
	T getByAccount(String account);
	
}
