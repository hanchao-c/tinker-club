package org.tinker.auth.shiro.handler;

import java.util.List;

import org.tinker.auth.shiro.model.ShiroPermission;

/**
 * 
 * @param <T>
 */
public interface ShiroPermissionHandler<T extends ShiroPermission> {

	/**
	 * 获取ShiroPermission
	 * @param roleId
	 * @return
	 */
	List<T> getByRole(String roleId);
	
	
}
