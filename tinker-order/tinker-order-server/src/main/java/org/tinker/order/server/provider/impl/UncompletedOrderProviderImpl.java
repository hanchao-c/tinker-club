package org.tinker.order.server.provider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.UncompletedOrderTransfer;
import org.tinker.order.provider.UncompletedOrderProvider;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.service.UncompletedOrderService;

@Service
public class UncompletedOrderProviderImpl implements UncompletedOrderProvider {

	@Autowired
	private UncompletedOrderService uncompletedOrderService;
	
	@Override
	public Page<UncompletedOrderTransfer> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest) {
		Page<UncompletedOrder> page = uncompletedOrderService.queryPage(orderState, payState, pageRequest);
		return page.mapTo(UncompletedOrderTransfer.class);
	}

}
