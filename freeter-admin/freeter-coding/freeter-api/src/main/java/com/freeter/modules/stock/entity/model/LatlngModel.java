package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LatlngModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal lat;
	
	private BigDecimal lng;
	
	private Integer sort;

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
