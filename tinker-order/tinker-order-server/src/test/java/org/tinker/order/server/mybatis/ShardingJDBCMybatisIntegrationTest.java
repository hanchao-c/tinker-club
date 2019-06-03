package org.tinker.order.server.mybatis;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.assertj.core.util.Lists;
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
import org.tinker.order.server.repository.tk.mapper.ProtocolMapper;
import org.tinker.order.server.repository.tk.mapper.UncompletedOrderMapper;
import org.tinker.order.server.repository.tk.model.Protocol;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.repository.tk.model.UncompletedOrderExample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShardingJDBCMybatisIntegrationTest extends ApplicationTestContext {

	@Autowired
	private UncompletedOrderMapper uncompletedOrderMapper;
	@Autowired
	private ProtocolMapper protocolMapper;
	@Autowired
	private VirtualMapper virtualMapper;
	
	private final List<PayState> payStates = Arrays.asList(PayState.values());
	private final List<OrderState> orderStates = Arrays.asList(OrderState.values());
	private final List<String> productNames = Arrays.asList("小熊猫", "长白山", "利群", "红塔山", "芙蓉王", "黄鹤楼", "雪茄");
	
	@Test
	@Rollback(false)
	@Transactional
	public void testIntegration() {
		
		Assert.assertNotNull(uncompletedOrderMapper);
		Assert.assertNotNull(virtualMapper);
		Assert.assertNotNull(protocolMapper);
		
		List<Long> orderIds = Lists.newArrayList();
		SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
		for (int i = 0; i < 130; i++) {
			
			Protocol protocol = new Protocol();
			protocol.setId(IDUtil.uuid());
			protocol.setItem(RandomStringUtils.randomAlphanumeric(10));
			protocolMapper.insert(protocol);
			
			UncompletedOrder uncompletedOrder = new UncompletedOrder();
			Long key = (Long) snowflakeShardingKeyGenerator.generateKey();
			orderIds.add(key);
			uncompletedOrder.setOrderId(key);
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
		for (int i = 0; i < 10; i++) {
			UncompletedOrderExample example = new UncompletedOrderExample();
			Long orderId = randomPick(orderIds);
			example.createCriteria().andOrderIdEqualTo(orderId);
			UncompletedOrder instance = uncompletedOrderMapper.selectOneByExample(example);
			log.info("orderId : {}, instance : {}", orderId, JacksonUtil.toJSONString(instance));
		}
		
		log.info("total : {}", uncompletedOrderMapper.selectCountByExample(new UncompletedOrderExample()));
		log.info(JacksonUtil.toJSONString(uncompletedOrderMapper.selectAll()));
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
	}
	
	private <T> T randomPick(List<T> srcs) {
		return srcs.get((int) (Math.random() * srcs.size()));
	}
	
}
