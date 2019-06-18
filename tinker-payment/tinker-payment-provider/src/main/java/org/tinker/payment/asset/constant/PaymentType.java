package org.tinker.payment.asset.constant;

import org.tinker.asset.MybatisEnumTemplate;

import lombok.Getter;

@Getter
public enum PaymentType implements MybatisEnumTemplate {

	ALI(1),
	WECHART(2);
	
	
	private final Integer type;
	
	private PaymentType(Integer type) {
		this.type = type;
	}

	@Override
	public String getCode() {
		return String.valueOf(type);
	}

	@Override
	public String getMessage() {
		return this.name();
	}
}
