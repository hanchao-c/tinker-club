package org.tinker.order.provider;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.UncompletedOrderTransfer;

public interface UncompletedOrderProvider {

	Page<UncompletedOrderTransfer> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest);
}
