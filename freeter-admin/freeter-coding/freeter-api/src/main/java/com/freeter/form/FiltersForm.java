package com.freeter.form;

import java.io.Serializable;

public class FiltersForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String field;
	
	private String op;
	
	private String term;

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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	
}
