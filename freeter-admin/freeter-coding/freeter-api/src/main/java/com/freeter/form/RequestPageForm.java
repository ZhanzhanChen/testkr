package com.freeter.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 接收轮子前端数据
 * @author Administrator
 *
 */
public class RequestPageForm implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * 每页数量
	 */
	private Long pageSize;
	
	/*
	 * 当前页数
	 */
	private Long pageIndex;
	
	private List<SortForm> sort;
	
	/*
	 * 筛选条件
	 */
	private FilterForm filter;
	
	private List<FiltersForm> filters;

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<SortForm> getSort() {
		return sort;
	}

	public void setSort(List<SortForm> sort) {
		this.sort = sort;
	}

	public FilterForm getFilter() {
		return filter;
	}

	public void setFilter(FilterForm filter) {
		this.filter = filter;
	}

	public List<FiltersForm> getFilters() {
		return filters;
	}

	public void setFilters(List<FiltersForm> filters) {
		this.filters = filters;
	}
	
	
}
