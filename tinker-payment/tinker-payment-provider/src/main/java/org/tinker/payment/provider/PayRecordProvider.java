package org.tinker.payment.provider;

import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.payment.model.PayRecordTransfer;

public interface PayRecordProvider {

	Page<PayRecordTransfer> queryPage(PageRequest pageRequest);
}
