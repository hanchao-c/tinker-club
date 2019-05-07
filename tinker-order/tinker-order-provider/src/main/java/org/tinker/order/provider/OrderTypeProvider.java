package org.tinker.order.provider;

import org.tinker.order.model.OrderTypeResult;

public interface OrderTypeProvider {

	
	OrderTypeResult[] getOrderTypes(String... orderIds);
	
}
