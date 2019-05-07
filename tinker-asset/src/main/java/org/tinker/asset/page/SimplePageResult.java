package org.tinker.asset.page;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.tinker.asset.ObjectConverter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 默认分页结果
 * @param <T>
 */
@Getter
@Setter
@ToString
public class SimplePageResult<T> implements Page<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 总数量
	 */
	private int total;
	
	/**
	 * 分页数据对象集合
	 */
	private List<T> content;
	
	public SimplePageResult(int total, List<T> content) {
		this.total = total;
		if(null == content) {
			content = Collections.emptyList();
		}
		this.content = content;
	}
	
	public SimplePageResult() {
		this(0, Collections.emptyList());
	}
	
	public boolean isEmpty() {
		return CollectionUtils.isEmpty(this.content);
	}

	@Override
	public <M> Page<M> mapTo(Class<M> clazz) {
		return mapTo(clazz, null);
	}
	
	@Override
	public <M> Page<M> mapTo(Class<M> clazz, ObjectConverter converter) {
		final ObjectConverter objectConverter;
		if(null == converter) {
			objectConverter = ObjectConverter.CGLIB_BEAN_COPIER;
		}else {
			objectConverter = converter;
		}
		return this.map(source -> objectConverter.convert(source, clazz));
	}
	
	@Override
	public <M> Page<M> map(Function<? super T, ? extends M> mapper) {
		Objects.requireNonNull(mapper);
		if(CollectionUtils.isEmpty(this.content)) {
			return empty();
		}
		List<M> mappedContent = this.content.stream().map(mapper).collect(Collectors.toList());
		return new SimplePageResult<M>(this.total, mappedContent);
	}
	
	
	public static <S> SimplePageResult<S> empty() {
		return new SimplePageResult<>();
	}

}