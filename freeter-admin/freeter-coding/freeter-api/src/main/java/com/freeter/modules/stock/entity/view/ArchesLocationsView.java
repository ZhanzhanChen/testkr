package com.freeter.modules.stock.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;

import com.freeter.common.utils.DateUtils;

public class ArchesLocationsView implements Serializable {

	/**
	 * 轨迹返回location类
	 */
	private static final long serialVersionUID = 1L;

	private String IMEI;
	
	private Long speed;
	
	private BigDecimal lat;
	
	private BigDecimal lng;
	
	private Long ori;
	
	private Long alt;
	
	private Long bat;
	
	private String GPSTimeStamp;

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
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

	public Long getOri() {
		return ori;
	}

	public void setOri(Long ori) {
		this.ori = ori;
	}

	public Long getAlt() {
		return alt;
	}

	public void setAlt(Long alt) {
		this.alt = alt;
	}

	public Long getBat() {
		return bat;
	}

	public void setBat(Long bat) {
		this.bat = bat;
	}

	public String getGPSTimeStamp() throws Exception {
		return DateUtils.format(DateUtils.UTCCastDate(GPSTimeStamp),DateUtils.DATE_TIME_PATTERN);
	}

	public void setGPSTimeStamp(String gPSTimeStamp) {
		GPSTimeStamp = gPSTimeStamp;
	}
	
}
