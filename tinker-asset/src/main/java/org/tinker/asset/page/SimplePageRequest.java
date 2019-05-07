package org.tinker.asset.page;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class SimplePageRequest extends AbstractPageRequest {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 排序字段
	 */
	private String sortColumn;
	
	/**
	 * 排序规则 asc desc
	 */
	private SortSequence sortSequence;
	
	
	public SimplePageRequest() {
		super();
	}
	
	public SimplePageRequest(int offset, int pageSize) {
		super(offset, pageSize);
	}
	
	public SimplePageRequest(int offset, int pageSize, String sortColumn, SortSequence sortSequence) {
		super(offset, pageSize);
		this.sortColumn = sortColumn;
		this.sortSequence = sortSequence;
	}
	
	@Override
	public Collection<Sort> getSorts() {
		List<Sort> singleSort = Lists.newArrayListWithExpectedSize(1);
		this.sortColumn = StringUtils.trimToNull(sortColumn);
		if(StringUtils.isNotBlank(this.sortColumn)) {
			this.sortSequence = null == this.sortSequence ? SortSequence.ASC : this.sortSequence;
			singleSort.add(new Sort(sortColumn, sortSequence));
		}
		return singleSort;
	}
	
}
