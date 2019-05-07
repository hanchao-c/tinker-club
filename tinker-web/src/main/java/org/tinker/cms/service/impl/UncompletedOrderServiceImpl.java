package org.tinker.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.cms.service.UncompletedOrderService;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.UncompletedOrderTransfer;
import org.tinker.order.provider.UncompletedOrderProvider;

@Service
public class UncompletedOrderServiceImpl implements UncompletedOrderService {

	@Autowired
	private UncompletedOrderProvider uncompletedOrderProvider;
	
	@Override
	public Page<UncompletedOrderTransfer> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest) {
		return uncompletedOrderProvider.queryPage(orderState, payState, pageRequest);
	}

}
