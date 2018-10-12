package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TbFenceinfoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@NotNull (message = "围栏名称不能为空")			
	@ApiModelProperty(value = "围栏名称")
	private String fenceName;
	@NotNull (message = "围栏区域信息不能为空")
	@ApiModelProperty(value = "围栏区域信息")
	private List fencePoints;
	@NotNull (message = "请选择经销商")
	@ApiModelProperty(value = "经销商id")
	private String dealerId;
	/**
	 * 围栏地址
	 */
	@NotNull (message = "围栏地址不能为空")					
	@ApiModelProperty(value = "围栏地址")
	private String fenceAddr;
	public String getFenceName() {
		return fenceName;
	}
	public void setFenceName(String fenceName) {
		this.fenceName = fenceName;
	}
	public List getFencePoints() {
		return fencePoints;
	}
	public void setFencePoints(List fencePoints) {
		this.fencePoints = fencePoints;
	}
	public String getFenceAddr() {
		return fenceAddr;
	}
	public void setFenceAddr(String fenceAddr) {
		this.fenceAddr = fenceAddr;
	}
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	
}
