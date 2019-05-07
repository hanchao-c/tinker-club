package org.tinker.auth.service;

import java.util.List;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.service.impl.RoleServiceImpl.RolePermissionModel;
import org.tinker.auth.shiro.handler.ShiroRoleHandler;

public interface RoleService extends ShiroRoleHandler<Role>{

	/**
	 * 分页查询角色列表
	 * @param pageRequest
	 * @return
	 */
	Page<Role> queryPage(PageRequest pageRequest);

	/**
	 * 创建角色以及角色菜单对应关系
	 * @param role 角色信息
	 * @param permissionIds 菜单ids
	 */
	void createRolePermissions(Role role, String[] permissionIds);

	/**
	 * 修改角色以及角色菜单对应关系
	 * @param role 角色信息 
	 * @param lastPermissionIds 原菜单ids
	 * @param currentPermissionIds 现菜单ids
	 */
	void updateRoleAndPermissions(Role role, String[] lastPermissionIds, String[] currentPermissionIds);

	/**
	 * 获取角色以及角色菜单对应关系
	 * @param roleId 角色id
	 * @return
	 */
	RolePermissionModel getRolePermissionsByRoleId(String roleId);

	/**
	 * 删除角色以及角色菜单对应关系
	 * @param roleId 角色id
	 */
	void deleteRolePermissionsByRoleId(String roleId);

	/**
	 * 获取所有角色
	 * @return
	 */
	List<Role> getAllRoles();

	/**
	 * 获取菜单树
	 * @param parentId 父菜单id
	 * @return
	 */
	List<PermissionCascade> getCascade(String parentId);


}
