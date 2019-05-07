package org.tinker.payment.server.provider;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tinker.asset.page.MultiSortPageRequest;
import org.tinker.asset.page.Page;
import org.tinker.asset.page.PageRequest.SortSequence;
import org.tinker.asset.util.EnumTemplateUtil;
import org.tinker.asset.util.JacksonUtil;
import org.tinker.order.model.ObjectConvertResult;
import org.tinker.order.provider.TestObjectConvertResultProvider;
import org.tinker.payment.server.ApplicationTestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectConverterTest extends ApplicationTestContext {

	@Autowired
	private TestObjectConvertResultProvider testObjectConvertResultProvider;
	
	@Test
	public void testQueryPageConverter() {
		log.info("converter test");
		MultiSortPageRequest pageRequest = new MultiSortPageRequest(0, 10);
		pageRequest.addSort("amount", SortSequence.DESC);
		pageRequest.addSort("create_time", SortSequence.ASC);
		
		output(testObjectConvertResultProvider.queryPageWithCglibBeanCopierConverter(pageRequest), "BeanCopier");
		output(testObjectConvertResultProvider.queryPageWithJacksonObjectMapperConverter(pageRequest), "JACKSON");
		output(testObjectConvertResultProvider.queryPageWithGetterSetter(pageRequest), "Getter Setter");
	}
	
	@Test
	public void testQueryObjectConverter() {
		log.info("converter test");
		output(testObjectConvertResultProvider.queryObjectWithCglibBeanCopierConverter(), "BeanCopier");
		output(testObjectConvertResultProvider.queryObjectWithJacksonObjectMapperConverter(), "JACKSON");
		output(testObjectConvertResultProvider.queryObjectWithGetterSetter(), "Getter Setter");
	}
	
	private void output(Page<ObjectConvertResult> page, String tag) {
		log.info(StringUtils.wrap("@ObjectConvertResults [{}]", "==================="), tag);
		log.info(JacksonUtil.toJSONString(page.getContent()));
		for (ObjectConvertResult uncompletedOrderTransfer : page.getContent()) {
			log.info(EnumTemplateUtil.toEnumString(uncompletedOrderTransfer.getOrderState()));
			log.info(EnumTemplateUtil.toEnumString(uncompletedOrderTransfer.getPayState()));
		}
	}
	
	private void output(ObjectConvertResult convertResult, String tag) {
		log.info(StringUtils.wrap("@@ObjectConvertResult [{}]", "==================="), tag);
		log.info(JacksonUtil.toJSONString(convertResult));
		log.info(EnumTemplateUtil.toEnumString(convertResult.getOrderState()));
		log.info(EnumTemplateUtil.toEnumString(convertResult.getPayState()));
	}
	

}
