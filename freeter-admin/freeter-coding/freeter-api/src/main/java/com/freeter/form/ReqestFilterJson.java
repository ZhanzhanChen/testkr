package com.freeter.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReqestFilterJson {
	
	private String op;
	
	private List<String> groups;
	
	private List<Map> rules;
	
	public Map get() {
		Map<String,Object> hashMap = new HashMap<>();
		for (Map map : rules) {
			Object data = map.get("data");
			if(data!=null)
			{
				data = data.toString().trim();
			}
	    hashMap.put((String)map.get("field"),data);	
		}	
		return hashMap;
	}
	

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<Map> getRules() {
		return rules;
	}

	public void setRules(List<Map> rules) {
		this.rules = rules;
	}

	
	
}