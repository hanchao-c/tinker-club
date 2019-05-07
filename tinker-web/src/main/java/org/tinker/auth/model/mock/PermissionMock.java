package org.tinker.auth.model.mock;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tinker.auth.repository.tk.model.Permission;

public class PermissionMock extends Permission {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(max = 20)
	@Override
	public String getPermissionName() {
		return super.getPermissionName();
	}


	@Length(max = 200)
	@Override
	public String getNote() {
		return super.getNote();
	}
	
}
