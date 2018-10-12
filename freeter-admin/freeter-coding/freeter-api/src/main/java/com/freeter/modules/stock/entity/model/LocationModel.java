package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class LocationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String gpsTimestamp;
	
	private String lastTimestamp;
	
	private BigDecimal lat;
	
	private BigDecimal lng;
	
	private BigDecimal baidulat;
	
	private BigDecimal baidulng;
	
	private String imei;
	
	private Long battery;
	
	private Integer locateMode;
	
	private String address;
	
	private LatlngModel point;
	
	private Integer sort;
	
	private String frameNumber;

	public String getGpsTimestamp() {
		return gpsTimestamp;
	}

	public void setGpsTimestamp(String gpsTimestamp) {
		this.gpsTimestamp = gpsTimestamp;
	}

	public String getLastTimestamp() {
		return lastTimestamp;
	}

	public void setLastTimestamp(String lastTimestamp) {
		this.lastTimestamp = lastTimestamp;
	}

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

	public BigDecimal getBaidulat() {
		return baidulat;
	}

	public void setBaidulat(BigDecimal baidulat) {
		this.baidulat = baidulat;
	}

	public BigDecimal getBaidulng() {
		return baidulng;
	}

	public void setBaidulng(BigDecimal baidulng) {
		this.baidulng = baidulng;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Long getBattery() {
		return battery;
	}

	public void setBattery(Long battery) {
		this.battery = battery;
	}

	public Integer getLocateMode() {
		return locateMode;
	}

	public void setLocateMode(Integer locateMode) {
		this.locateMode = locateMode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LatlngModel getPoint() {
		return point;
	}

	public void setPoint(LatlngModel point) {
		this.point = point;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}
	
}
