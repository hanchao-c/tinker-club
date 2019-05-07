package org.tinker.payment.server.provider.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.ObjectConverter;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderType;
import org.tinker.order.model.OrderTypeResult;
import org.tinker.order.provider.OrderTypeProvider;
import org.tinker.payment.model.PayRecordTransfer;
import org.tinker.payment.provider.PayRecordProvider;
import org.tinker.payment.server.repository.tk.model.PayRecord;
import org.tinker.payment.server.service.PayRecordService;

@Service
public class PayRecordProviderImpl implements PayRecordProvider {

	@Autowired
	private OrderTypeProvider orderTypeProvider;
	
	@Autowired
	private PayRecordService payRecordService;
	
	@Override
	public Page<PayRecordTransfer> queryPage(PageRequest pageRequest) {
		Page<PayRecord> records = payRecordService.queryPage(pageRequest);
		return records.map(record -> {
			PayRecordTransfer transfer = ObjectConverter.CGLIB_BEAN_COPIER.convert(record, PayRecordTransfer.class);
			OrderTypeResult[] orderTypes = orderTypeProvider.getOrderTypes(record.getOrderId());
			if(ArrayUtils.isNotEmpty(orderTypes)) {
				String[] orderTypeNames = Arrays
						.stream(orderTypes)
						.map(OrderTypeResult::getOrderTypes)
						.flatMap(List::stream)
						.map(OrderType::name)
						.toArray(String[]::new);
				transfer.setOrderTypeNames(orderTypeNames);
			}
			return transfer;
		});
	}
	

}
