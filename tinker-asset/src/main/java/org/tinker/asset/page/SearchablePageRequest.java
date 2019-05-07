package org.tinker.asset.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class SearchablePageRequest extends SimplePageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String search;

	
}
