package org.tinker.cms.service;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.payment.model.PayRecordTransfer;

public interface PayRecordService {

	
	Page<PayRecordTransfer> queryPage(PageRequest pageRequest);
}
