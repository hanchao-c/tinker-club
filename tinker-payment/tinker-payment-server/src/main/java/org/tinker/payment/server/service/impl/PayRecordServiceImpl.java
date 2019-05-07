package org.tinker.payment.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.payment.server.repository.PayRecordRepository;
import org.tinker.payment.server.repository.tk.model.PayRecord;
import org.tinker.payment.server.service.PayRecordService;

@Service
public class PayRecordServiceImpl implements PayRecordService {

	@Autowired
	private PayRecordRepository payRecordRepository;
	
	@Override
	public Page<PayRecord> queryPage(PageRequest pageRequest) {
		return payRecordRepository.queryPage(pageRequest);
	}


}
