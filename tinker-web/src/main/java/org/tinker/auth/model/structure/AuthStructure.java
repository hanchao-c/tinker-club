package org.tinker.auth.model.structure;

import org.tinker.asset.webplugin.select2.Select2Structure;

public class AuthStructure implements Select2Structure{
	
	private static final long serialVersionUID = 5285955006907627292L;
	
	private String auth;

	public AuthStructure(String auth) {
		this.auth = auth;
	}

	@Override
	public String getId() {
		return auth;
	}

	@Override
	public String getText() {
		return auth;
	}

	@Override
	public String toString() {
		return "AuthStructure [auth=" + auth + "]";
	}
	

}