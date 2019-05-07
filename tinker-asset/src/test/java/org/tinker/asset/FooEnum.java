package org.tinker.asset;

import org.tinker.asset.Template.EnumTemplate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum FooEnum implements EnumTemplate{

	OK("OK__", "message_ok"),
	NOT_OK("NOT_OK___", "message_not_ok");
	
	private final String code;
	private final  String message;
	
	private FooEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
