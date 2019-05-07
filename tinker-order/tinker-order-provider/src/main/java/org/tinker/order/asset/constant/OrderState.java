package org.tinker.order.asset.constant;

import org.tinker.asset.Template.EnumTemplate;

public enum OrderState implements EnumTemplate{
	
	OPEN("开启"),
	STOP("暂停"),
	DELAY("延时"),
	CLOSE("关闭"),
	UN_KNOW("未知");
	
	private String instruction;
	
	private OrderState(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public String getCode() {
		return this.name();
	}

	@Override
	public String getMessage() {
		return instruction;
	}

}
