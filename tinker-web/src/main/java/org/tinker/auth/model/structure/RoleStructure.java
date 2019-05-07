package org.tinker.auth.model.structure;

import org.tinker.asset.webplugin.select2.Select2Structure;

public class RoleStructure implements Select2Structure {

	private static final long serialVersionUID = -7429049908020522066L;

	private String roleId;
	private String roleName;

	public RoleStructure(String roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	@Override
	public String getId() {
		return roleId;
	}

	@Override
	public String getText() {
		return roleName;
	}

	@Override
	public String toString() {
		return "RoleStructure [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
