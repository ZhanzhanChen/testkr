package com.freeter.form;

import java.io.Serializable;

/**
 * 接收前端数据sort
 * @author Administrator
 *
 */
public class SortForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String field;
	
	private String sort;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
