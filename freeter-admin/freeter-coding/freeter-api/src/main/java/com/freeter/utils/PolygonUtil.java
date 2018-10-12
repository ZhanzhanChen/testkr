package com.freeter.utils;

import java.util.ArrayList;
import java.util.List;

import com.freeter.modules.stock.entity.view.PolygonView;

public class PolygonUtil {
	
	public static List<PolygonView> polygonConvert(String polstr){
		int start = polstr.indexOf('(')+2;
		int end = polstr.length()-2;
		String str= polstr.substring(start,end);
		String arr[] = str.split(",");
		List<PolygonView> list =new ArrayList<>();
		for(int i=0; i<arr.length; i++){
			String tmp[] = arr[i].trim().split(" ");
			PolygonView view = new PolygonView();
			view.setLat(tmp[1]);
			view.setLng(tmp[0]);
			list.add(view);
		}
		return list;
	}

}
