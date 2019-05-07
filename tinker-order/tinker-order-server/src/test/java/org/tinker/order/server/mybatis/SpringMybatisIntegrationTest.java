package org.tinker.order.server.mybatis;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.tinker.asset.util.IDUtil;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.server.ApplicationTestContext;
import org.tinker.order.server.repository.custom.mapper.VirtualMapper;
import org.tinker.order.server.repository.tk.mapper.UncompletedOrderMapper;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringMybatisIntegrationTest extends ApplicationTestContext {

	@Autowired
	private UncompletedOrderMapper uncompletedOrderMapper;
	@Autowired
	private VirtualMapper virtualMapper;
	
	private final List<PayState> payStates = Arrays.asList(PayState.values());
	private final List<OrderState> orderStates = Arrays.asList(OrderState.values());
	private final List<String> productNames = Arrays.asList("小熊猫", "长白山", "利群", "红塔山", "芙蓉王", "黄鹤楼", "雪茄");
	
	
	@Test
	@Rollback
	@Transactional
	public void testIntegration() {
		
		for (int i = 0; i < 130; i++) {
			UncompletedOrder uncompletedOrder = new UncompletedOrder();
			uncompletedOrder.setOrderId(IDUtil.uuid());
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime createTime = now.minus(Duration.ofMinutes(RandomUtils.nextInt(150, 10000000)));
			uncompletedOrder.setCreateTime(createTime);
			LocalDateTime orderTime = createTime.minus(Duration.ofMinutes(RandomUtils.nextInt(150, 10000000)));
			uncompletedOrder.setOrderTime(orderTime);
			uncompletedOrder.setAmount(new BigDecimal(RandomUtils.nextInt(0, 30)));
			uncompletedOrder.setId(IDUtil.uuid());
			uncompletedOrder.setOrderState(randomPick(orderStates).getCode());
			uncompletedOrder.setPaymentTimes(RandomUtils.nextInt(0, 10));
			uncompletedOrder.setPayState(randomPick(payStates).getCode());
			uncompletedOrder.setProductName(randomPick(productNames));
			uncompletedOrder.setUserId(IDUtil.uuid());
			uncompletedOrderMapper.insert(uncompletedOrder);
		}
		
		log.info(StringUtils.wrap("tk.mapper(mybatis) integration test", " ===================== "));
		Assert.assertNotNull(uncompletedOrderMapper);
		Assert.assertNotNull(virtualMapper);
		log.info(JacksonUtil.toJSONString(uncompletedOrderMapper.selectAll()));
	}
	
	private <T> T randomPick(List<T> srcs) {
		return srcs.get((int) (Math.random() * srcs.size()));
	}
	
	
	
}
