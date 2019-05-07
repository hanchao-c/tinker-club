package org.tinker.auth.service;

import java.util.List;

import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Permission;
import org.tinker.auth.shiro.handler.ShiroPermissionHandler;

public interface PermissionService extends ShiroPermissionHandler<Permission>{

	void create(Permission permission);

	/**
	 * 获取菜单
	 * @param parentId 父菜单id
	 * @return
	 */
	List<PermissionCascade> getCascade(String parentId);

	/**
	 * 获取菜单信息
	 * @param parentId 父菜单id
	 * @return
	 */
	Permission getById(String parentId);

	/**
	 * 修改菜单信息
	 * @param permission 菜单信息
	 */
	void update(Permission permission);

	/**
	 * 删除菜单信息
	 * @param id 菜单id
	 */
	void deleteById(String id);
	
	/**
	 * 获取已被激活的菜单
	 * @param account
	 * @return
	 */
	List<PermissionCascade> getAcitveCascadeByAccount(String account);

	/**
	 * 菜单排序
	 * @param currentId 当前菜单id
	 * @param parentId 父菜单id
	 * @param childrenIds 子菜单ids
	 */
	void sortSequence(String currentId, String parentId, String[] childrenIds);


}
