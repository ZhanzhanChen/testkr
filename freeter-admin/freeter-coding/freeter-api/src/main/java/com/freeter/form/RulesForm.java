package com.freeter.form;

import java.io.Serializable;

public class RulesForm implements Serializable {

	
	/**
	 * 接收前端数据filter--》rules
	 */
	private static final long serialVersionUID = 1L;

	private String field;
	
	private String op;
	
	private String data;
	
	private String[] datas;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getData() {
		return null == data || data.length() == 0 ?null : data.trim();
	}

	public void setData(String data) {
		this.data = data;
	}

	public String[] getDatas() {
		return datas;
	}

	public void setDatas(String[] datas) {
		this.datas = datas;
	}
	
}
