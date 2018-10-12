package com.freeter.form;

import java.util.List;
import java.util.Map;
/**
 * 接收轮子前端数据
 * @author Administrator
 *
 */
public class RequestPageJson {

	 
	private int pageSize;
	private int pageIndex;
	private List<Map> sort; 
	private ReqestFilterJson filter;

	public Map get() {
	
		return filter.get();	
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<Map> getSort() {
		return sort;
	}

	public void setSort(List<Map> sort) {
		this.sort = sort;
	}

	public ReqestFilterJson getFilter() {
		return filter;
	}

	public void setFilter(ReqestFilterJson filter) {
		this.filter = filter;
	}

	
		
	

}