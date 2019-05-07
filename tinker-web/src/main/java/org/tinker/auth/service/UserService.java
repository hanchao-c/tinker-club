package org.tinker.auth.service;

import java.util.List;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.webplugin.select2.Select2Structure;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.service.impl.UserServiceImpl.UserRoleModel;
import org.tinker.auth.shiro.handler.ShiroUserHandler;

public interface UserService extends ShiroUserHandler<User>{

	/**
	 * 创建用户
	 * @param user 用户信息
	 * @return
	 */
	int create(User user);

	/**
	 * 分页查询用户列表
	 * @param pageReuqest
	 * @return
	 */
	Page<User> queryPage(PageRequest pageReuqest);

	/**
	 * 修改用户信息（不包括密码）
	 * @param user
	 * @param lastRoleIds
	 * @param currentRoleIds
	 */
	void updateUserRoleExcludePassword(User user, String[] lastRoleIds, String[] currentRoleIds);

	/**
	 * 获取用户信息
	 * @param id 用户id
	 * @return
	 */
	User getById(String id);

	/**
	 * 删除用户以及用户角色对应关系
	 * @param userId 用户id
	 */
	void deleteUserRoleByUserId(String userId);

	/**
	 * 创建用户以及用户角色对应关系
	 * @param user 用户信息
	 * @param roleIds 角色ids
	 */
	void createUserAndRole(User user, String[] roleIds);

	/**
	 * 获取用户以及用户角色对应关系
	 * @param id
	 * @return
	 */
	UserRoleModel getUserRoleByUserId(String id);

	/**
	 * 重置密码
	 * @param userId 用户id
	 * @param password 密码
	 */
	void refreshPassword(String userId, String password);

	/**
	 * 获取角色列表（select2使用）
	 * @return
	 */
	List<Select2Structure> getRoleStructures();

}
