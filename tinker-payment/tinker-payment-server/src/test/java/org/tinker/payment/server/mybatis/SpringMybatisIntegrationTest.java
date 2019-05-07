package org.tinker.payment.server.mybatis;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.tinker.asset.util.IDUtil;
import org.tinker.payment.asset.constant.NoticeState;
import org.tinker.payment.asset.constant.PaymentState;
import org.tinker.payment.server.ApplicationTestContext;
import org.tinker.payment.server.repository.tk.mapper.PayRecordMapper;
import org.tinker.payment.server.repository.tk.model.PayRecord;

public class SpringMybatisIntegrationTest extends ApplicationTestContext {

	@Autowired
	private PayRecordMapper payRecordMapper;
	
	private final List<PaymentState> paymentStates = Arrays.asList(PaymentState.values());
	private final List<NoticeState> noticeStates = Arrays.asList(NoticeState.values());
	
	@Test
	@Rollback(true)
	@Transactional
	public void testIntegration() {
		for (int i = 0; i < 50; i++) {
			PayRecord payRecord = new PayRecord();
			payRecord.setOrderId(IDUtil.uuid());
			payRecord.setAmount(new BigDecimal(RandomUtils.nextInt(0, 30)));
			payRecord.setCreateTime(LocalDateTime.now().minus(Duration.ofMinutes(RandomUtils.nextInt(150, 10000000))));
			payRecord.setId(IDUtil.uuid());
			payRecord.setPaymentState(randomPick(paymentStates).name());
			payRecord.setNoticeState(randomPick(noticeStates).name());
			payRecordMapper.insert(payRecord);
		}
	}
	
	private <T> T randomPick(List<T> srcs) {
		return srcs.get((int) (Math.random() * srcs.size()));
	}
	
	
	
}
