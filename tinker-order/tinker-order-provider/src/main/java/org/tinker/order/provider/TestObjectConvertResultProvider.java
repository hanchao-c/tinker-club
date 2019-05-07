package org.tinker.order.provider;

import org.tinker.asset.page.PageRequest;
import org.tinker.asset.page.Page;
import org.tinker.order.model.ObjectConvertResult;

public interface TestObjectConvertResultProvider {

	//Page对象的类型转换
	Page<ObjectConvertResult> queryPageWithCglibBeanCopierConverter(PageRequest pageRequest);
	
	Page<ObjectConvertResult> queryPageWithJacksonObjectMapperConverter(PageRequest pageRequest);
	
	Page<ObjectConvertResult> queryPageWithGetterSetter(PageRequest pageRequest);
	
	Page<ObjectConvertResult> queryPageWithCustomType(PageRequest pageRequest);
	
	//简单对象的类型转换
	ObjectConvertResult queryObjectWithCglibBeanCopierConverter();
	
	ObjectConvertResult queryObjectWithJacksonObjectMapperConverter();
	
	ObjectConvertResult queryObjectWithGetterSetter();
	
	ObjectConvertResult queryObjectWithCustomType();
	
	
}
