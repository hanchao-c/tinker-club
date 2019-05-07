package org.tinker.order.server.service;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;

public interface UncompletedOrderService {

	Page<UncompletedOrder> queryPage(PageRequest pageRequest);

	Page<UncompletedOrder> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest);
	
}
