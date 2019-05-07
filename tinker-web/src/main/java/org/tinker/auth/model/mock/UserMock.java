package org.tinker.auth.model.mock;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.tinker.asset.Groups.Create;
import org.tinker.asset.Groups.Update;
import org.tinker.auth.repository.tk.model.User;

public class UserMock extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(groups = { Create.class, Update.class })
	@Size(max = 30, groups = Create.class)
	@Override
	public String getName() {
		return super.getName();
	}

	@NotBlank(groups = { Create.class, Update.class })
	@Size(max = 50, groups = { Create.class, Update.class })
	@Override
	public String getAccount() {
		return super.getAccount();
	}

	@NotBlank(groups = Create.class)
	@Size(min = 8, max = 16, groups = Create.class)
	@Override
	public String getPassword() {
		return super.getPassword();
	}

}
