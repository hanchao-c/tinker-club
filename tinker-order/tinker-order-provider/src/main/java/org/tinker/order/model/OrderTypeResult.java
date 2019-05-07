package org.tinker.order.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.tinker.order.asset.constant.OrderType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderTypeResult implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<OrderType> orderTypes;
	
	private String orderId;
	
	public OrderTypeResult(String orderId) {
		this.orderId = orderId;
		this.orderTypes = Arrays.asList(OrderType.pick(), OrderType.pick());
	}
}
