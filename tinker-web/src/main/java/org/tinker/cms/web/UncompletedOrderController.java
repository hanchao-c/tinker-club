package org.tinker.cms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.SearchablePageRequest;
import org.tinker.asset.response.ResponseEntityWrapper;
import org.tinker.asset.util.EnumTemplateUtil;
import org.tinker.cms.service.UncompletedOrderService;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.UncompletedOrderTransfer;

@RestController
@RequestMapping("uncompletedOrders")
public class UncompletedOrderController {

	@Autowired
	private UncompletedOrderService uncompletedOrderService;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<UncompletedOrderTransfer>> queryPage(
			String orderStateCode, String payStateCode, 
			@Valid SearchablePageRequest pageRequest) {
		OrderState orderState = EnumTemplateUtil.getIfPosible(orderStateCode, OrderState.class);
		PayState payState = EnumTemplateUtil.getIfPosible(payStateCode, PayState.class);
		Page<UncompletedOrderTransfer> page = uncompletedOrderService.queryPage(orderState, payState, pageRequest);
		return ResponseEntityWrapper.OK(page);
	}
}
