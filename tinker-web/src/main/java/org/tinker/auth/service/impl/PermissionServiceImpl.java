package org.tinker.auth.service.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.tinker.asset.persistent.Transactional_auth;
import org.tinker.asset.util.IDUtil;
import org.tinker.auth.repository.PermissionRepository;
import org.tinker.auth.repository.RolePermissionRelationRepository;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.model.Permission;
import org.tinker.auth.repository.tk.model.RolePermissionRelation;
import org.tinker.auth.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private RolePermissionRelationRepository rolePermissionRelationRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public List<Permission> getByRole(String roleId) {
		//获取角色菜单关系
		List<RolePermissionRelation> rolePermissionRelations = rolePermissionRelationRepository.getByRoleId(roleId);
		if(CollectionUtils.isEmpty(rolePermissionRelations)){
			return Collections.emptyList();
		}
		List<String> permissionIds = rolePermissionRelations.stream()
				.map(RolePermissionRelation::getPermissionId)
				.collect(Collectors.toList());
		//获取菜单
		return permissionRepository.getByIds(permissionIds);
	}

	@Override
	public void create(Permission permission) {
		if(StringUtils.isBlank(permission.getId())) {
			permission.setId(IDUtil.uuid());
		}
		String parentId = permission.getParentId();
		//获取同级菜单中最大排序
		Integer sequence = permissionRepository.getMaxSequenceByParentId(parentId);
		//排序+1
		permission.setSequence(null == sequence ? 1 : sequence + 1);
		//创建菜单
		permissionRepository.create(permission);
	}

	@Override
	public List<PermissionCascade> getCascade(String parentId) {
		return permissionRepository.getCascade(parentId);
	}

	@Override
	public Permission getById(String id) {
		return permissionRepository.getById(id);
	}

	@Override
	public void update(Permission permission) {
		permissionRepository.update(permission);
	}

	@Transactional_auth
	@Override
	public void deleteById(String id) {
		Permission permission = permissionRepository.getById(id);
		if(null != permission) {
			deepDelete(permission);
		}
	}
	
	/**
	 * 递归删除多级菜单
	 * @param permission 菜单
	 */
	private void deepDelete(Permission permission) {
		//删除当前菜单
		permissionRepository.deleteById(permission.getId());
		//获取同级菜单
		List<Permission> subPermisstions = permissionRepository.getByParentId(permission.getId());
		if(!CollectionUtils.isEmpty(subPermisstions)){
			//递归删除多级菜单 
			subPermisstions.forEach(this::deepDelete);
		}
	}

	@Override
	public List<PermissionCascade> getAcitveCascadeByAccount(String account) {
		//获取当前用户所有对应的菜单
		List<String> activePermissionIds = permissionRepository.getActivePermissionIds(account);
		//获取所有系统菜单
		List<PermissionCascade> cascade = permissionRepository.getCascade("root");
		//激活用户对应的菜单
		activePermissionCascade(activePermissionIds, cascade.iterator(), null);
		//删除系统菜单中未被当前用户激活的菜单
		filter(cascade.iterator());
		return cascade;
	}

	
	/**
	 * 过滤未被激活的菜单
	 */
	private void filter(Iterator<PermissionCascade> iterator) {
		while (iterator.hasNext()) {
			PermissionCascade child = iterator.next();
			List<PermissionCascade> permissionCascades = child.getPermissionCascades();
			filter(permissionCascades.iterator());
			if(null == child.getInUsing()) {
				iterator.remove();
			}
		}		
	}

	/**
	 * 递归激活用户对应菜单
	 * @param activePermissionIds 可激活的菜单ids
	 * @param allPermission 所有系统菜单
	 * @param parent 父菜单 (作为临时变量,递归使用)
	 */
	private void activePermissionCascade(List<String> activePermissionIds, Iterator<PermissionCascade> allPermission, PermissionCascade parent) {
		while (allPermission.hasNext()) {
			PermissionCascade child = allPermission.next();
			if(activePermissionIds.contains(child.getId())) {
				if(null != parent) {
					//激活父菜单
					parent.setInUsing(true);
				}
				//激活当前子菜单
				child.setInUsing(true);
				parent = child;
			}
			List<PermissionCascade> permissionCascades = child.getPermissionCascades();
			//递归激活用户对应菜单
			activePermissionCascade(activePermissionIds, permissionCascades.iterator(), child);
		}
	}

	@Transactional_auth
	@Override
	public void sortSequence(String currentId, String parentId, String[] childrenIds) {
		//替换菜单的父菜单id
		permissionRepository.updateParentIdById(currentId, parentId);
		for (int i = 0; i < childrenIds.length; i++) {
			String id = childrenIds[i];
			//同级菜单排序
			permissionRepository.updateSequenceById(id, i);
		}
	}

}
