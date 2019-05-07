package org.tinker.asset.webplugin.select2;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 前端控件 select2 分页查询参数
 *
 */
public class Select2Params implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 默认每次分页的查询数量 相当于 pageSize
	 */
	public static final int length = 20;
	/**
	 * select2搜索框输入的字符串
	 */
	private String searchStr;
	/**
	 * 分页信息 第{pageNumber}页
	 */
	private Integer pageNumber;

	/**
	 * 将分页信息${pageNumber}变成从第${start}开始查询
	 * @return
	 */
	public int getStart() {
		return (this.getPageNumber() - 1) * length;
	}
	
	/**
	 * 分页查询参数 pageSize + 1
	 * 目的用于判断是否还有下一页 见类Select2Response中的hasMore方法
	 * @return
	 */
	public int getExpectedLength() {
		return length + 1;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public int getPageNumber() {
		return ObjectUtils.defaultIfNull(this.pageNumber, 1);
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "Select2Params [length=" + length + ", searchStr=" + searchStr + ", pageNumber=" + pageNumber + "]";
	}
	
	
}
