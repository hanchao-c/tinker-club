package org.tinker.auth.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.auth.model.mock.RoleMock;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.service.RoleService;
import org.tinker.auth.service.impl.RoleServiceImpl.RolePermissionModel;

/**
 *  系统角色以及菜单
 */
@RestController
@RequestMapping("roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * 角色列表
	 * @param pageRequest 页面表格控件datatables请求参数
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<Role>> queryPage(@Valid SearchablePageRequest pageRequest) {
		Page<Role> pagedList = roleService.queryPage(pageRequest);
		return ResponseEntityWrapper.OK(pagedList);
	}

	/**
	 * 创建角色以及角色菜单对应关系
	 * @param role 角色信息
	 * @param permissionIds 菜单ids 
	 * @return
	 */
	@PostMapping
	public void createRolePermission(@Valid RoleMock role, @RequestParam(required = false, value = "permissionIds[]") String[] permissionIds) {
		roleService.createRolePermissions(role, permissionIds);
	}

	/**
	 * 获取角色以及角色菜单对应关系
	 * @param id 角色Id
	 * @return
	 */
	@GetMapping("{roleId}")
	public ResponseEntity<RolePermissionModel> getRolePermissionByRoleId(@NotBlank @PathVariable("roleId") String roleId) {
		RolePermissionModel model = roleService.getRolePermissionsByRoleId(roleId);
		return ResponseEntityWrapper.OK(model);
	}

	/**
	 * 修改角色以及角色菜单对应关系
	 * @param role 角色信息
	 * @param lastPermissionIds 原菜单ids
	 * @param currentPermissionIds 现菜单ids
	 * @return
	 */
	@PutMapping
	public void updateRolePermission(@Valid RoleMock role,
			@RequestParam(required = false, value = "lastPermissionIds[]") String[] lastPermissionIds,
			@RequestParam(required = false, value = "currentPermissionIds[]") String[] currentPermissionIds) {
		roleService.updateRoleAndPermissions(role, lastPermissionIds, currentPermissionIds);
	}

	/**
	 * 删除角色以及角色菜单对应关系
	 * @param id
	 * @return
	 */
	@DeleteMapping("{roleId}")
	public void deleteRolePermissionsByRoleId(@NotBlank @PathVariable("roleId") String roleId) {
		roleService.deleteRolePermissionsByRoleId(roleId);
	}


	/**
	 * 获取菜单树
	 * @param parentId 父菜单id
	 * @return
	 */
	@GetMapping("cascade")
	public ResponseEntity<List<PermissionCascade>> getPermissionCascade(@NotBlank String parentId) {
		List<PermissionCascade> cascade = roleService.getCascade(parentId);
		return ResponseEntityWrapper.OK(cascade);
	}


}
