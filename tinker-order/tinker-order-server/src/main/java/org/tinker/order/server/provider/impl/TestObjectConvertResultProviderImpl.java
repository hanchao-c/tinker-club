package org.tinker.order.server.provider.impl;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tinker.asset.ObjectConverter;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest;
import org.tinker.asset.page.SimplePageResult;
import org.tinker.asset.page.SimplePageRequest;
import org.tinker.asset.util.EnumTemplateUtil;
import org.tinker.order.asset.constant.OrderState;
import org.tinker.order.asset.constant.PayState;
import org.tinker.order.model.ObjectConvertResult;
import org.tinker.order.provider.TestObjectConvertResultProvider;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.service.UncompletedOrderService;


@Component
public class TestObjectConvertResultProviderImpl implements TestObjectConvertResultProvider {

	@Autowired
	private UncompletedOrderService uncompletedOrderService;

	//============================= DO -> DTO [Page] =============================
	
	@Override
	public Page<ObjectConvertResult> queryPageWithCglibBeanCopierConverter(PageRequest pageRequest) {
		Page<UncompletedOrder> page = getPage(pageRequest);
		//使用 CGLIB BeanCopier 
		//速度较快,扩展性较差,代码开发少
		return page.mapTo(ObjectConvertResult.class);
	}

	@Override
	public Page<ObjectConvertResult> queryPageWithJacksonObjectMapperConverter(PageRequest pageRequest) {
		Page<UncompletedOrder> page = getPage(pageRequest);
		//使用 JACKSON ObjectMapper 
		//速度较慢,扩展性较好(需配合JACKSON注解使用),代码开发少
		return page.mapTo(ObjectConvertResult.class, ObjectConverter.JACKSON_CONVERTER);
	}
	
	@Override
	public Page<ObjectConvertResult> queryPageWithGetterSetter(PageRequest pageRequest) {
		Page<UncompletedOrder> page = getPage(pageRequest);
		//使用 getter setter
		//速度最快,扩展性最好,代码开发大
		return page.map(order -> {
			ObjectConvertResult objectConvertResult = new ObjectConvertResult();
			objectConvertResult.setAmount(order.getAmount());
			objectConvertResult.setCreateTime(order.getCreateTime());
			objectConvertResult.setOrderId(order.getOrderId());
			objectConvertResult.setOrderState(EnumUtils.getEnum(OrderState.class, order.getOrderState()));
			objectConvertResult.setOrderTime(order.getOrderTime());
			objectConvertResult.setPaymentTimes(Long.valueOf(order.getPaymentTimes()));
			objectConvertResult.setPayState(EnumTemplateUtil.getByCode(order.getPayState(), PayState.class));
			objectConvertResult.setProductName(order.getProductName());
			objectConvertResult.setUserId(order.getUserId());
			return objectConvertResult;
		});
	}
	
	@Override
	public Page<ObjectConvertResult> queryPageWithCustomType(PageRequest pageRequest) {
		Page<UncompletedOrder> page = SimplePageResult.empty();
		//自定义转换
		return page.map(order -> {
			//可以使用其他工具类 如 spring的BeanUtils 或者 Apache-common的BeanUtils等
			return null;
		});
	}
	
	private Page<UncompletedOrder> getPage(PageRequest pageRequest) {
		return uncompletedOrderService.queryPage(pageRequest);
	}
	
	private UncompletedOrder getObject() {
		SimplePageRequest pageRequest = new SimplePageRequest(0, 1);
		Page<UncompletedOrder> page = getPage(pageRequest);
		if(!page.isEmpty()) {
			return page.getContent().get(0);
		}
		return null;
	}

	
	//============================= DO -> DTO [Page]=============================
	
	//============================= DO -> DTO [Object] =============================
	
	@Override
	public ObjectConvertResult queryObjectWithCglibBeanCopierConverter() {
		//使用 CGLIB BeanCopier 
		//速度较快,扩展性较差,代码开发少
		UncompletedOrder order = getObject();
		return ObjectConverter.CGLIB_BEAN_COPIER.convert(order, ObjectConvertResult.class);
	}

	@Override
	public ObjectConvertResult queryObjectWithJacksonObjectMapperConverter() {
		UncompletedOrder order = getObject();
		//使用 JACKSON ObjectMapper 
		//速度较慢,扩展性较好(需配合JACKSON注解使用),代码开发少
		return ObjectConverter.JACKSON_CONVERTER.convert(order, ObjectConvertResult.class);
	}

	@Override
	public ObjectConvertResult queryObjectWithGetterSetter() {
		UncompletedOrder order = getObject();
		//使用 getter setter
		//速度最快,扩展性最好,代码开发大
		ObjectConvertResult objectConvertResult = new ObjectConvertResult();
		objectConvertResult.setAmount(order.getAmount());
		objectConvertResult.setCreateTime(order.getCreateTime());
		objectConvertResult.setOrderId(order.getOrderId());
		objectConvertResult.setOrderState(EnumUtils.getEnum(OrderState.class, order.getOrderState()));
		objectConvertResult.setOrderTime(order.getOrderTime());
		objectConvertResult.setPaymentTimes(Long.valueOf(order.getPaymentTimes()));
		objectConvertResult.setPayState(EnumTemplateUtil.getByCode(order.getPayState(), PayState.class));
		objectConvertResult.setProductName(order.getProductName());
		objectConvertResult.setUserId(order.getUserId());
		return objectConvertResult;
	}

	@Override
	public ObjectConvertResult queryObjectWithCustomType() {
		//自定义转换
		return null;
	}

}
