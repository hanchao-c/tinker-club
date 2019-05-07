package org.tinker.asset.response;

import org.tinker.asset.Responsive;

import lombok.Getter;
import lombok.ToString;

/**
 * 默认的带有code, message的返回对象
 */
@ToString
@Getter
public class DefaultResponse implements Responsive {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String code;
	private final String message;

	public DefaultResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}


}
