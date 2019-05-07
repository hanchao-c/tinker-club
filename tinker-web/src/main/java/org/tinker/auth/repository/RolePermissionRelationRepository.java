package org.tinker.auth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.auth.repository.tk.mapper.RolePermissionRelationMapper;
import org.tinker.auth.repository.tk.model.RolePermissionRelation;
import org.tinker.auth.repository.tk.model.RolePermissionRelationExample;

@Repository
public class RolePermissionRelationRepository {

	@Autowired
	private RolePermissionRelationMapper rolePermissionRelationMapper;

	public List<RolePermissionRelation> getByRoleId(String roleId) {
		RolePermissionRelationExample example = new RolePermissionRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return rolePermissionRelationMapper.selectByExample(example);
	}

	public void create(RolePermissionRelation relation) {
		rolePermissionRelationMapper.insert(relation);
	}

	public void deleteByRoleIdAndPermissionId(String roleId, String permissionId) {
		RolePermissionRelationExample example = new RolePermissionRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId).andPermissionIdEqualTo(permissionId);
		rolePermissionRelationMapper.deleteByExample(example);
	}

	public void deleteByRoleId(String roleId) {
		RolePermissionRelationExample example = new RolePermissionRelationExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		rolePermissionRelationMapper.deleteByExample(example);
	}

	
	
}
