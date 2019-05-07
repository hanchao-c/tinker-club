package org.tinker.auth.repository.custom.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.tinker.auth.repository.tk.model.Permission;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PermissionCascade extends Permission{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4401867340579719533L;

	private List<PermissionCascade> permissionCascades;
	
	private Boolean inUsing;
	
	@JsonProperty("text")
	@Override
	public String getPermissionName() {
		return super.getPermissionName();
	}
	
	@JsonProperty("li_attr")
	private Map<String, Object> tagLiAttr;
	
	@JsonProperty("children")
	public List<PermissionCascade> getPermissionCascades() {
		return permissionCascades;
	}

	public void setPermissionCascades(List<PermissionCascade> permissionCascades) {
		this.permissionCascades = permissionCascades;
	}
	
	@JsonProperty("state")
	public State getState() {
		if(!CollectionUtils.isEmpty(this.permissionCascades)) {
			return new State().opened(true);
		}
		return null;
	}


	@Override
	public String toString() {
		return "PermissionCascade [permissionCascades=" + permissionCascades + ", super.toString()=" + super.toString() + "]";
	}
	
	public Boolean getInUsing() {
		return inUsing;
	}

	public void setInUsing(Boolean inUsing) {
		this.inUsing = inUsing;
	}

	public static class State extends HashMap<String, Object> implements Map<String, Object>{

		private static final long serialVersionUID = 1L;
		
		public State opened(boolean opened) {
			this.put("opened", opened);
			return this;
		}
	}
	
}
