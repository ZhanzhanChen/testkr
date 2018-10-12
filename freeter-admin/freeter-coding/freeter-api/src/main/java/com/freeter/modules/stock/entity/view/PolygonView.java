package com.freeter.modules.stock.entity.view;

import java.io.Serializable;

public class PolygonView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String lat;
	String lng;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}

}
