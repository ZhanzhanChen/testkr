package com.freeter.modules.stock.entity.model;

import java.io.Serializable;

/**
 * 轨迹回放前端实体
 * @author Administrator
 *
 */
public class ArchesModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vin;
	
	private String starttime;
	
	private String endtime;
	
	private Long max;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Long getMax() {
		return max;
	}

	public void setMax(Long max) {
		this.max = max;
	}

}
