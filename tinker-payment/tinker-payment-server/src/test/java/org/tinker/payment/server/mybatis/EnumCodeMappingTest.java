package org.tinker.payment.server.mybatis;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.tinker.asset.util.IDUtil;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.payment.asset.constant.PaymentState;
import org.tinker.payment.asset.constant.PaymentType;
import org.tinker.payment.server.ApplicationTestContext;
import org.tinker.payment.server.repository.tk.mapper.PayTypeMapper;
import org.tinker.payment.server.repository.tk.model.PayType;
import org.tinker.payment.server.repository.tk.model.PayTypeExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumCodeMappingTest extends ApplicationTestContext {

	@Autowired
	private PayTypeMapper payTypeMapper;
	
	@Test
	@Rollback(false)
	@Transactional
	public void testIntegration() {
		
		PayType payType = new PayType();
		payType.setId(IDUtil.uuid());
		payType.setPaymentState(PaymentState.SUCCESS);
		payType.setPaymentType(PaymentType.WECHART);
		payTypeMapper.insert(payType);
		
		PayTypeExample example = new PayTypeExample();
		example.createCriteria().andPaymentStateEqualTo(PaymentState.SUCCESS);
		List<PayType> payTypes = payTypeMapper.selectByExample(example);
		log.info("------------------------");
		log.info(JacksonUtil.toJSONString(payTypes));
		log.info("------------------------");
		
		
	}
	
	
}
