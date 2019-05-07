package org.tinker.order.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.server.repository.UncompletedOrderRepository;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.service.UncompletedOrderService;

@Service
public class UncompletedOrderServiceImpl implements UncompletedOrderService {

	@Autowired
	private UncompletedOrderRepository uncompletedOrderRepository;
	
	@Override
	public Page<UncompletedOrder> queryPage(PageRequest pageRequest) {
		return uncompletedOrderRepository.queryPage(pageRequest);
	}

	@Override
	public Page<UncompletedOrder> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest) {
		return uncompletedOrderRepository.queryPage(orderState, payState, pageRequest);
	}

}
