package com.freeter.utils;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RequestUtil {

	/**
	 * http post 请求
	 * @param url 地址
	 * @param param map参数
	 * @return
	 */
	public static JSONObject sendPostRequest(String url, Map<String, Object> param){
		RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
    	MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
    	headers.setContentType(type);
    	headers.add("Accept", MediaType.APPLICATION_JSON.toString());
    	JSONObject jsonObj = JSONObject.parseObject(JSON.toJSONString(param));
    	HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
    	String result = restTemplate.postForObject(url, formEntity, String.class);
    	JSONObject jsStr = JSONObject.parseObject(result);
    	return jsStr;
	}
}
