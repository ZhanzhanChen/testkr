package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * VIEW
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-13 16:31:38
 */
@ApiModel(value = "ViCarstatusinfoModel")
public class ViCarstatusinfoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 所属经销商Id
	 */
	
	@ApiModelProperty(value = "所属经销商Id") 
	private String dealerid;
		
	/**
	 * 根经销商Id
	 */
	
	@ApiModelProperty(value = "根经销商Id") 
	private String rootdealerid;
		
	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)") 
	private Integer carstatus;
		
	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)") 
	private Integer detailstatus;
		
	/**
	 * 车架号
	 */
	
	@ApiModelProperty(value = "车架号") 
	private String vinnumber;
		
	/**
	 * 经销商名称
	 */
	
	@ApiModelProperty(value = "经销商名称") 
	private String dealername;
		
	/**
	 * 围栏名称
	 */
	
	@ApiModelProperty(value = "围栏名称") 
	private String fencename;
		
	/**
	 * 设备工作状态(0正常1异常)
	 */
	
	@ApiModelProperty(value = "设备工作状态(0正常1异常)") 
	private Integer devicestatus;
		
	/**
	 * 设备号主键
	 */
	
	@ApiModelProperty(value = "设备号主键") 
	private String devicenumber;
				
	
	/**
	 * 设置：所属经销商Id
	 */
	 
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	
	/**
	 * 获取：所属经销商Id
	 */
	public String getDealerid() {
		return dealerid;
	}
				
	
	/**
	 * 设置：根经销商Id
	 */
	 
	public void setRootdealerid(String rootdealerid) {
		this.rootdealerid = rootdealerid;
	}
	
	/**
	 * 获取：根经销商Id
	 */
	public String getRootdealerid() {
		return rootdealerid;
	}
				
	
	/**
	 * 设置：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	 
	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}
	
	/**
	 * 获取：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	public Integer getCarstatus() {
		return carstatus;
	}
				
	
	/**
	 * 设置：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	 
	public void setDetailstatus(Integer detailstatus) {
		this.detailstatus = detailstatus;
	}
	
	/**
	 * 获取：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	public Integer getDetailstatus() {
		return detailstatus;
	}
				
	
	/**
	 * 设置：车架号
	 */
	 
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	
	/**
	 * 获取：车架号
	 */
	public String getVinnumber() {
		return vinnumber;
	}
				
	
	/**
	 * 设置：经销商名称
	 */
	 
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	
	/**
	 * 获取：经销商名称
	 */
	public String getDealername() {
		return dealername;
	}
				
	
	/**
	 * 设置：围栏名称
	 */
	 
	public void setFencename(String fencename) {
		this.fencename = fencename;
	}
	
	/**
	 * 获取：围栏名称
	 */
	public String getFencename() {
		return fencename;
	}
				
	
	/**
	 * 设置：设备工作状态(0正常1异常)
	 */
	 
	public void setDevicestatus(Integer devicestatus) {
		this.devicestatus = devicestatus;
	}
	
	/**
	 * 获取：设备工作状态(0正常1异常)
	 */
	public Integer getDevicestatus() {
		return devicestatus;
	}
				
	
	/**
	 * 设置：设备号主键
	 */
	 
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	
	/**
	 * 获取：设备号主键
	 */
	public String getDevicenumber() {
		return devicenumber;
	}
			
}
