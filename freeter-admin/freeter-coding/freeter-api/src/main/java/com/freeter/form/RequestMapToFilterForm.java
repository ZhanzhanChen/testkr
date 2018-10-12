package com.freeter.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.freeter.utils.StringUtil;

public class RequestMapToFilterForm {

	public static List<RulesForm> mapToFilterForm(Map<String, String[]> map){
		List<RulesForm> list = new ArrayList<>();
		int index = 0;
		for(int i=0; i<map.size(); i++){
			RulesForm rules = new RulesForm();
//			System.out.println(map.get("rules["+i+"].field")+"------"+map.get("rules["+i+"].datas[0]"));
			if(null != map.get("rules["+i+"].field") && 
					null != map.get("rules["+i+"].op") && null != map.get("rules["+i+"].data")){
				rules.setField(map.get("rules["+i+"].field")[0]);
				rules.setOp(map.get("rules["+i+"].op")[0]);
				rules.setData(map.get("rules["+i+"].data")[0]);
				list.add(rules);
			}else if(null != map.get("rules["+i+"].field") && null != map.get("rules["+i+"].op") && 
					(map.containsKey("rules["+i+"].datas[0]") || map.containsKey("rules["+i+"].datas[1]"))){
				if(map.get("rules["+i+"].op")[0].equals("bt")){
					rules.setField(map.get("rules["+i+"].field")[0]);
					rules.setOp(map.get("rules["+i+"].op")[0]);
					String[] str = new String[2];
					if(map.containsKey("rules["+i+"].datas[0]")){
						if(StringUtil.isEmpty(map.get("rules["+i+"].datas[0]")[0])){
							str[0]=map.get("rules["+i+"].datas[0]")[0];
						}
					}
					if(map.containsKey("rules["+i+"].datas[1]")){
						if(StringUtil.isEmpty(map.get("rules["+i+"].datas[1]")[0])){
							str[1]=map.get("rules["+i+"].datas[1]")[0];
						}
					}
					rules.setDatas(str);
					list.add(rules);
				}
			}
		}
		return list;
	}
}
