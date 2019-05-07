package org.tinker.cms.model.mock;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.tinker.cms.repository.tk.model.Watch;

public class WatchMock extends Watch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max = 30)
	@Override
	public String getSubject() {
		return super.getSubject();
	}
	
	@NotBlank
	@Override
	public String getBrand() {
		return super.getBrand();
	}
	
	@NotBlank
	@Override
	public String getType() {
		return super.getType();
	}
	
	@NotBlank
	@Override
	public String getMainPictureUrl() {
		return super.getMainPictureUrl();
	}
	
	@Size(max = 300)
	@Override
	public String getDescription() {
		return super.getDescription();
	}
	
	@NotBlank
	@Override
	public String getSubPictureUrls() {
		return super.getSubPictureUrls();
	}
	
	
}
