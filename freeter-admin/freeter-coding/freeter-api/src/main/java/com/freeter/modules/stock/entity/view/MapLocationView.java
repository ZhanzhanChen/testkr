package com.freeter.modules.stock.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;

public class MapLocationView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String deviceNumber;
	
	private Long BatteryPCT;
	
	private String address;
	
	private String locationType;
	
	private String locationTime;
	
	private String checkTime;
	
	private BigDecimal lat;
	
	private BigDecimal lng;

	private String Vinnumber;
	
	private String carStatus;
	
	public String getVinnumber() {
		return Vinnumber;
	}

	public void setVinnumber(String vinnumber) {
		Vinnumber = vinnumber;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public Long getBatteryPCT() {
		return BatteryPCT;
	}

	public void setBatteryPCT(Long batteryPCT) {
		BatteryPCT = batteryPCT;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationTime() {
		return locationTime;
	}

	public void setLocationTime(String locationTime) {
		this.locationTime = locationTime;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
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

}
