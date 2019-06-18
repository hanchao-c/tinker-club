package org.tinker.asset.page;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections4.CollectionUtils;
import org.tinker.asset.ObjectConverter;

/**
 * 分页信息
 * @param <T>
 */
public interface Page<T> extends Serializable{

	/**
	 * 获取总数量
	 * @return
	 */
	int getTotal();
	
	/**
	 * 获取分页数据
	 * @return
	 */
	List<T> getContent();
	
	/**
	 * 是否存在数据
	 * @return
	 */
	default boolean isEmpty(){
		return CollectionUtils.isEmpty(getContent());
	}
	
	
	/**
	 * 类型转换
	 * @param clazz 目标类型
	 * @return
	 */
	<M> Page<M> mapTo(Class<M> clazz);
	
	/**
	 * 类型转换
	 * @param clazz 目标类型
	 * @param converter 转换器
	 * @return
	 */
	<M> Page<M> mapTo(Class<M> clazz, ObjectConverter converter);
	
	/**
	 * 类型转换
	 * @param mapper 类型转换function
	 * @return
	 */
	<M> Page<M> map(Function<? super T, ? extends M> mapper);
	
}
