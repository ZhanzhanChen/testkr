package com.freeter.modules.stock.entity.view;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 围栏车辆信息
 * @author Administrator
 *
 */
public class FenceCarInfoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="车架号")
	private String vinnumber;
	
	@ApiModelProperty(value="定位方式")
	private String isWire;
	
	@ApiModelProperty(value="地址")
	private String address;
	
	@ApiModelProperty(value="最后定位时间")
	private String locationTime;
	
	@ApiModelProperty(value="最后检测时间")
	private String checkTime;
	
	@ApiModelProperty(value="经度")
	private BigDecimal lat;
	
	@ApiModelProperty(value="纬度")
	private BigDecimal lng;
	
	public String getVinnumber() {
		return vinnumber;
	}
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	public String getIsWire() {
		return isWire;
	}
	public void setIsWire(String isWire) {
		this.isWire = isWire;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
