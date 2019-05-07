package org.tinker.payment.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.asset.page.MybatisPageQueryer;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.payment.server.repository.tk.mapper.PayRecordMapper;
import org.tinker.payment.server.repository.tk.model.PayRecord;
import org.tinker.payment.server.repository.tk.model.PayRecordExample;

@Repository
public class PayRecordRepository {
	
	@Autowired
	private PayRecordMapper payRecordMapper;

	public Page<PayRecord> queryPage(PageRequest pageRequest) {
		PayRecordExample example = new PayRecordExample();
		return MybatisPageQueryer.query(payRecordMapper, example, pageRequest);
	}

	
}
