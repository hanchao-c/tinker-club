package org.tinker.asset.page;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.session.RowBounds;
import org.tinker.asset.page.PageRequest.Sort;

import com.google.common.base.Throwables;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.common.Mapper;

/**
 * Mybatis分页查询工具类 
 */
@Slf4j
public class MybatisPageQueryer {

	private static final String EXAMPLE_ORDER_CLAUSE_FIELD = "orderByClause";
	
	/**
	 * 分页查询
	 * @param mapper 数据查询对象
	 * @param example 查询条件
	 * @param rowBounds 分页信息
	 * @return
	 */
	public static <T> Page<T> query(Mapper<T> mapper, Object example, PageRequest pageRequest) {
		checkNotNull(mapper);
		checkNotNull(example);
		checkNotNull(pageRequest);
		int count = mapper.selectCountByExample(example);
		//只有符合条件数据的数量大于0时 才会进行数据的查询
		if(count > 0) {
			//设置排序条件
			setOrderClauseToExample(example, pageRequest.getSorts());
			//获取分页信息
			RowBounds rowBounds = new RowBounds(pageRequest.getOffset(), pageRequest.getPageSize());
			//列表查询
			List<T> list = mapper.selectByExampleAndRowBounds(example, rowBounds);
			return new SimplePageResult<>(count, list);
		}
		return SimplePageResult.empty();
	}

	private static void setOrderClauseToExample(Object example, Collection<Sort> sorts) {
		if(CollectionUtils.isNotEmpty(sorts)) {
			Field declaredField = FieldUtils.getDeclaredField(example.getClass(), EXAMPLE_ORDER_CLAUSE_FIELD, true);
			if(null != declaredField) {
				String orderByClause = sorts.stream().map(Sort::toString).collect(Collectors.joining(", "));
				try {
					FieldUtils.writeDeclaredField(example, EXAMPLE_ORDER_CLAUSE_FIELD, orderByClause, true);
				} catch (IllegalAccessException e) {
					log.error("动态设置排序条件失败", e);
					Throwables.throwIfUnchecked(e);
					throw new RuntimeException(e);
				}
			}
		}
	}
	
}
