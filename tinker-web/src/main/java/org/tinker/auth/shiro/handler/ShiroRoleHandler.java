package org.tinker.auth.shiro.handler;

import java.util.List;

import org.tinker.auth.shiro.model.ShiroRole;

/**
 * 
 * @param <T>
 */
public interface ShiroRoleHandler<T extends ShiroRole> {

	/**
	 * 获取ShiroRole
	 * @param account 账号
	 * @return
	 */
	List<T> getByAccount(String account);

}
