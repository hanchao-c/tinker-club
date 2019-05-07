package org.tinker.cms.service;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.UncompletedOrderTransfer;

public interface UncompletedOrderService {

	Page<UncompletedOrderTransfer> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest);

}
