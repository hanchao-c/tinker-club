package org.tinker.order.asset.constant;

import java.util.Random;

public enum OrderType {

	COMPLETED,
	UN_COMPLETED,
	UN_KNOW;
	
	public static OrderType pick() {
		OrderType[] types = OrderType.values();
	    return types[new Random().nextInt(types.length)];
	}
}
