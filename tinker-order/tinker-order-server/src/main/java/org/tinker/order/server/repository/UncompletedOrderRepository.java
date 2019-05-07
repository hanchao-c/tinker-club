package org.tinker.order.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tinker.asset.page.MybatisPageQueryer;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.server.repository.tk.mapper.UncompletedOrderMapper;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.repository.tk.model.UncompletedOrderExample;
import org.tinker.order.server.repository.tk.model.UncompletedOrderExample.Criteria;

@Repository
public class UncompletedOrderRepository {

	@Autowired
	private UncompletedOrderMapper uncompletedOrderMapper;

	public Page<UncompletedOrder> queryPage(PageRequest pageRequest) {
		UncompletedOrderExample example = new UncompletedOrderExample();
		return MybatisPageQueryer.query(uncompletedOrderMapper, example, pageRequest);
	}

	public Page<UncompletedOrder> queryPage(OrderState orderState, PayState payState, PageRequest pageRequest) {
		UncompletedOrderExample example = new UncompletedOrderExample();
		Criteria criteria = example.createCriteria();
		if(null != orderState) {
			criteria.andOrderStateEqualTo(orderState.getCode());
		}
		if(null != payState) {
			criteria.andPayStateEqualTo(payState.getCode());
		}
		return MybatisPageQueryer.query(uncompletedOrderMapper, example, pageRequest);
	}
	
}
