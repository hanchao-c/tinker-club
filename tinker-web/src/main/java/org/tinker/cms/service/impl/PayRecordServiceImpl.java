package org.tinker.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.cms.service.PayRecordService;
import org.tinker.payment.model.PayRecordTransfer;
import org.tinker.payment.provider.PayRecordProvider;

@Service
public class PayRecordServiceImpl implements PayRecordService {

	@Autowired
	private PayRecordProvider payRecordProvider;

	@Override
	public Page<PayRecordTransfer> queryPage(PageRequest pageRequest) {
		return payRecordProvider.queryPage(pageRequest);
	}
	
}
