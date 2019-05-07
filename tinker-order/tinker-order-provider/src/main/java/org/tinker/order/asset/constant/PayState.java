package org.tinker.order.asset.constant;

import org.tinker.asset.Template.EnumTemplate;

public enum PayState implements EnumTemplate {

	SUCCESS("0001", "支付成功"),
	FAIL("0002", "支付失败"),
	WAITING_FOR("0003", "待支付"),
	CLOSED("1001", "支付关闭");
	
	private final String code;
	private final String message;
	
	private PayState(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
