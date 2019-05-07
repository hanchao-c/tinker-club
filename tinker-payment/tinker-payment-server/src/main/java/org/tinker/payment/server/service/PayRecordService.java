package org.tinker.payment.server.service;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.payment.server.repository.tk.model.PayRecord;

public interface PayRecordService {

	Page<PayRecord> queryPage(PageRequest pageRequest);
	

}
