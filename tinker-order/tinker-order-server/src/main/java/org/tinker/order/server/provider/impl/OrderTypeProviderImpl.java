package org.tinker.order.server.provider.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.tinker.order.model.OrderTypeResult;
import org.tinker.order.provider.OrderTypeProvider;

@Service
public class OrderTypeProviderImpl implements OrderTypeProvider {

	@Override
	public OrderTypeResult[] getOrderTypes(String... orderIds) {
		return Arrays.stream(orderIds).map(OrderTypeResult::new).toArray(OrderTypeResult[]::new);
	}

}
