package org.tinker.asset.webplugin.select2;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

/**
 * 前端控件 select2 分页查询结果
 * 
 */
public class Select2Response {

	/**
	 * 查询结果
	 */
	private List<Select2Structure> items;
	/**
	 * 是否还有下一页
	 */
	private boolean hasMore;
	
	public Select2Response(List<Select2Structure> items) {
		if(CollectionUtils.isEmpty(items)) {
			items = Lists.newArrayListWithCapacity(0);
		}
		this.hasMore = hasMore(items);
		this.items = items;
	}
	
	public static Select2Response empty() {
		return new Select2Response(Lists.newArrayListWithCapacity(0));
	}
	
	/**
	 * 判断是否还有下一页 
	 * @param list
	 * @return
	 */
	private boolean hasMore(List<Select2Structure> list) {
		//如果查询的结果大于分页默认查询数量,说明还有下一页
		if (list.size() > Select2Params.length) {
			//删除最后一个元素 保证返回结果与查询条件相符
			list.remove(list.size() - 1);
			return true;
		}
		return false;
	}

	public List<Select2Structure> getItems() {
		return items;
	}

	public void setItems(List<Select2Structure> items) {
		this.items = items;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	
	@Override
	public final String toString() {
		return MoreObjects.toStringHelper(this.getClass())
				.add("items.size", this.items.size())
				.add("hasMore", hasMore)
				.toString();
	}

	
}
