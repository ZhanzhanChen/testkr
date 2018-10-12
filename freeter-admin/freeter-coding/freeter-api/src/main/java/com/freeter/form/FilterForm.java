package com.freeter.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 接收前端数据filter
 * @author Administrator
 *
 */
public class FilterForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String op;
	
	private List<RulesForm> rules;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public List<RulesForm> getRules() {
		return rules;
	}

	public void setRules(List<RulesForm> rules) {
		this.rules = rules;
	}

}
