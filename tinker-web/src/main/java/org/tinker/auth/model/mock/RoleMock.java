package org.tinker.auth.model.mock;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.tinker.auth.repository.tk.model.Role;

public class RoleMock extends Role {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max = 30)
	@Override
	public String getRoleName() {
		return super.getRoleName();
	}
	
	@Size(max = 200)
	@Override
	public String getDescription() {
		return super.getDescription();
	}
	
}
