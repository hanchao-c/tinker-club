package org.tinker.asset.page;

import java.util.Collection;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractPageRequest implements PageRequest {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 分页信息 从${offset}开始
	 */
	@PositiveOrZero
	private int offset;
	
	/**
	 * 分页信息 每页查询${pageSize}条
	 */
	@Positive
	private int pageSize;
	
	/**
	 * 
	 */
	public abstract Collection<Sort> getSorts();
	
}
