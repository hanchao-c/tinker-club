package org.tinker.auth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.auth.repository.custom.mapper.PermissionCascadeMapper;
import org.tinker.auth.repository.custom.model.PermissionCascade;
import org.tinker.auth.repository.tk.mapper.PermissionMapper;
import org.tinker.auth.repository.tk.model.Permission;
import org.tinker.auth.repository.tk.model.PermissionExample;

@Repository
public class PermissionRepository {

	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private PermissionCascadeMapper permissionCascadeMapper;

	public List<Permission> getByIds(List<String> permissionIds) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andIdIn(permissionIds);
		return permissionMapper.selectByExample(example);
	}

	public void create(Permission permission) {
		permissionMapper.insert(permission);
	}

	public List<PermissionCascade> getCascade(String parentId) {
		return permissionCascadeMapper.getCascade(parentId);
	}

	public Permission getById(String id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	public void update(Permission permission) {
		permissionMapper.updateByPrimaryKey(permission);
	}

	public void deleteById(String id) {
		permissionMapper.deleteByPrimaryKey(id);
	}

	public List<Permission> getByParentId(String parentId) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return permissionMapper.selectByExample(example);
	}
	
	public List<String> getActivePermissionIds(String account) {
		return permissionCascadeMapper.getActivePermissionIds(account);
	}

	public void updateParentIdById(String currentId, String parentId) {
		Permission permission = new Permission();
		permission.setId(currentId);
		permission.setParentId(parentId);
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	public void updateSequenceById(String id, int sequence) {
		Permission permission = new Permission();
		permission.setId(id);
		permission.setSequence(sequence);
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	public Integer getMaxSequenceByParentId(String parentId) {
		return permissionCascadeMapper.getMaxSequenceByParentId(parentId);
	}
}
