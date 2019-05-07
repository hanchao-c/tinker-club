package org.tinker.auth.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.persistent.Transactional_auth;
import org.tinker.asset.util.IDUtil;
import org.tinker.auth.repository.RolePermissionRelationRepository;
import org.tinker.auth.repository.RoleRepository;
import org.tinker.auth.repository.UserRoleRelationRepository;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.repository.tk.model.RolePermissionRelation;
import org.tinker.auth.repository.tk.model.UserRoleRelation;
import org.tinker.auth.service.PermissionService;
import org.tinker.auth.service.RoleService;
import org.tinker.util.Propagater;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private UserRoleRelationRepository userRoleRelationRepository;
	@Autowired
	private RolePermissionRelationRepository rolePermissionRelationRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PermissionService permissionService;

	@Override
	public List<Role> getByAccount(String account) {
		//获取菜单对应关系
		List<UserRoleRelation> userRoleRelations = userRoleRelationRepository.getByAccount(account);
		if (CollectionUtils.isEmpty(userRoleRelations)) {
			return Collections.emptyList();
		}
		List<String> roleIds = userRoleRelations.stream()
				.map(UserRoleRelation::getRoleId)
				.collect(Collectors.toList());
		//获取角色
		return roleRepository.getByIds(roleIds);
	}

	@Override
	public Page<Role> queryPage(PageRequest pageRequest) {
		return roleRepository.queryPage(pageRequest);
	}

	@Transactional
	@Override
	public void createRolePermissions(Role role, String[] permissionIds) {
		String roleId = IDUtil.uuid();
		role.setId(roleId);
		//创建角色
		roleRepository.create(role);
		//创建角色菜单对应关系
		if(ArrayUtils.isNotEmpty(permissionIds)) {
			Stream.of(permissionIds).map(permissionId -> {
				return new RolePermissionRelation()
						.withId(IDUtil.uuid())
						.withRoleId(roleId)
						.withPermissionId(permissionId);
			}).forEach(rolePermissionRelationRepository::create);
		}
	}

	@Override
	public RolePermissionModel getRolePermissionsByRoleId(String roleId) {
		//获取角色信息
		Role role = roleRepository.getById(roleId);
		//获取角色菜单对应关系
		List<RolePermissionRelation> permissions = rolePermissionRelationRepository.getByRoleId(roleId);
		List<String> permissionIds = permissions.stream()
				.map(RolePermissionRelation::getPermissionId)
				.collect(Collectors.toList());
		return new RolePermissionModel(role, permissionIds);
	}

	@Transactional_auth
	@Override
	public void updateRoleAndPermissions(Role role, String[] lastPermissionIds, String[] currentPermissionIds) {
		Set<String> last = ArrayUtils.isNotEmpty(lastPermissionIds) ? Sets.newTreeSet(Arrays.asList(lastPermissionIds)) : Sets.newTreeSet();
		Set<String> current = ArrayUtils.isNotEmpty(currentPermissionIds) ? Sets.newTreeSet(Arrays.asList(currentPermissionIds)) : Sets.newTreeSet();
		//删除无效角色菜单对应关系
		Sets.difference(last, current).stream().forEach(permissionId -> {
			rolePermissionRelationRepository.deleteByRoleIdAndPermissionId(role.getId(), permissionId);
		});
		//创建有效角色菜单对应关系
		Sets.difference(current, last).stream().map(permissionId -> {
			return new RolePermissionRelation()
					.withId(IDUtil.uuid())
					.withRoleId(role.getId())
					.withPermissionId(permissionId);
		}).forEach(rolePermissionRelationRepository::create);
		//修改角色信息
		roleRepository.update(role);
	}

	@Transactional_auth
	@Override
	public void deleteRolePermissionsByRoleId(String roleId) {
		//校验当前角色是否正在有用户在使用
		int count = userRoleRelationRepository.countByRoleId(roleId);
		if(count > 0) {
			//有账号增在使用当前角色
			Propagater.throwOf("当前角色正在被其他账号使用");
		}
		//删除角色
		roleRepository.deleteById(roleId);
		//删除角色菜单对应关系
		rolePermissionRelationRepository.deleteByRoleId(roleId);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.listAll();
	}
	
	@Override
	public List<PermissionCascade> getCascade(String parentId) {
		return permissionService.getCascade(parentId);
	}
	
	@Setter
	@Getter
	@ToString
	public static class RolePermissionModel {
		
		private Role role;
		private List<String> permissionIds = Lists.newArrayListWithExpectedSize(0);

		public RolePermissionModel(Role role, List<String> permissionIds) {
			this.role = role;
			this.permissionIds = permissionIds;
		}

	}

}
