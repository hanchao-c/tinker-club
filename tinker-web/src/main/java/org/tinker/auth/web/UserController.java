package org.tinker.auth.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.Groups.Create;
import org.tinker.asset.Groups.Update;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.asset.webplugin.select2.Select2Structure;
import org.tinker.auth.model.mock.UserMock;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.service.UserService;
import org.tinker.auth.service.impl.UserServiceImpl.UserRoleModel;

/**
 * 系统用户以及角色
 *
 */
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户列表
	 * @param pageRequest 页面表格控件datatables请求参数
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<User>> queryPage(@Valid SearchablePageRequest pageRequest) {
		Page<User> page = userService.queryPage(pageRequest);
		return ResponseEntityWrapper.OK(page);
	}
	
	/**
	 * 创建用户以及用户对应角色
	 * @param user 用户信息
	 * @param roleIds 角色ids
	 * @return
	 */
	@PostMapping
	public void createUserRole(@Validated(Create.class) UserMock user, @RequestParam("roleIds[]") String[] roleIds) {
		userService.createUserAndRole(user, roleIds);
	}
	
	
	/**
	 * 修改用户以及用户对应角色
	 * @param user 用户信息
	 * @param lastRoleIds 原角色ids
	 * @param currentRoleIds 现角色ids
	 * @return
	 */
	@PutMapping
	public void updateUserRole(
			@Validated(Update.class) UserMock user, 
			@RequestParam("lastRoleIds[]") String[] lastRoleIds, 
			@RequestParam("currentRoleIds[]") String[] currentRoleIds) {
		userService.updateUserRoleExcludePassword(user, lastRoleIds, currentRoleIds);
	}
	
	/**
	 * 获取用户以及用户对应角色
	 * @param id
	 * @return
	 */
	@GetMapping("{userId}")
	public ResponseEntity<UserRoleModel> getUserRoleByUserId(@NotBlank @PathVariable("userId") String userId) {
		UserRoleModel userRoleModel = userService.getUserRoleByUserId(userId);
		return ResponseEntityWrapper.OK(userRoleModel);
	}
	
	/**
	 * 删除用户以及用户对应角色
	 * @param id
	 * @return
	 */
	@DeleteMapping("{userId}")
	public void deleteUserRoleByUserId(@NotBlank @PathVariable("userId") String userId) {
		userService.deleteUserRoleByUserId(userId);
	}
	
	/**
	 * 修改密码
	 * @param userId 用户id
	 * @param password 密码
	 * @return
	 */
	@PatchMapping("password")
	public void refreshPassword(@NotBlank String userId, @NotBlank String password) {
		userService.refreshPassword(userId, password);
	}
	
	/**
	 * 获取角色列表（select2使用）
	 * @return
	 */
	@GetMapping("roleStructures")
	public ResponseEntity<List<Select2Structure>> getRoleSelect2Structure() {
		List<Select2Structure> roleStructures = userService.getRoleStructures();
		return ResponseEntityWrapper.OK(roleStructures);
	}
	
}
