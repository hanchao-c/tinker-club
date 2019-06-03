package org.tinker.asset;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.tinker.asset.util.BeanCopyUtil;
import org.tinker.asset.util.JacksonUtil;

@FunctionalInterface
public interface ObjectConverter {

	/**
	 * 引用类型数据转换
	 * @param obj 源对象
	 * @param clazz 目标对象class
	 * @return 目标对象
	 */
	<T> T convert(Object obj, Class<T> clazz);
	
	/**
	 * 引用类型集合数据转换
	 * @param sources 源对象集合
	 * @param clazz 目标对象class
	 * @return 目标对象集合
	 */
	default <T> List<T> convertList(List<?> sources, Class<T> clazz) {
		if(CollectionUtils.isEmpty(sources)) {
			return Collections.emptyList();
		}
		return sources.stream().map(source -> convert(source, clazz)).collect(Collectors.toList());
	}
	
	/**
	 * Cglib (推荐)
	 */
	public final static ObjectConverter CGLIB_BEAN_COPIER = BeanCopyUtil::copyPropertiesByClass;
	
	/**
	 * Jackson
	 */
	public final static ObjectConverter JACKSON_CONVERTER = JacksonUtil::convertJavaObject;
	
}