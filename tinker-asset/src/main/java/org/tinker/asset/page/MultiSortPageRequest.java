package org.tinker.asset.page;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import lombok.ToString;

@ToString(callSuper = true)
public class MultiSortPageRequest extends AbstractPageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Collection<Sort> sorts = Lists.newArrayListWithExpectedSize(4);
	
	public MultiSortPageRequest() {
		super();
	}
	
	public MultiSortPageRequest(int offset, int pageSize) {
		super(offset, pageSize);
	}
	
	public MultiSortPageRequest(int offset, int pageSize, Sort... sorts) {
		super(offset, pageSize);
		addSorts(sorts);
	}
	
	public MultiSortPageRequest addSort(Sort sort) {
		checkNotNull(sort);
		this.sorts.add(sort);
		return this;
	}
	
	public MultiSortPageRequest addSorts(Sort... sorts) {
		checkNotNull(sorts);
		this.sorts.addAll(Arrays.asList(sorts));
		return this;
	}
	
	public MultiSortPageRequest addSort(String sortColumn, SortSequence sortSequence) {
		sortColumn = StringUtils.trimToNull(sortColumn);
		if(StringUtils.isNotBlank(sortColumn)) {
			sortSequence = null == sortSequence ? SortSequence.ASC : sortSequence;
			sorts.add(new Sort(sortColumn, sortSequence));
		}
		return this;
	}
	
	@Override
	public Collection<Sort> getSorts() {
		return this.sorts;
	}
}
