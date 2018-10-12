package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.ViFenceinalarmEntity;

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
 * @date 2018-08-21 16:11:39
 */
@ApiModel(value = "ViFenceinalarmModel")
public class ViFenceinalarmModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 所属金融机构Id
	 */
	
	@ApiModelProperty(value = "所属金融机构Id") 
	private Long deptid;
		
	/**
	 * 主键(DL)
	 */
	
	@ApiModelProperty(value = "主键(DL)") 
	private String dealerid;
		
	/**
	 * 经销商名称
	 */
	
	@ApiModelProperty(value = "经销商名称") 
	private String dealername;
		
	/**
	 * 设备号
	 */
	
	@ApiModelProperty(value = "设备号") 
	private String devicenumber;
		
	/**
	 * 围栏名称
	 */
	
	@ApiModelProperty(value = "围栏名称") 
	private String fencename;
		
	/**
	 * 报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)
	 */
	
	@ApiModelProperty(value = "报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)") 
	private Integer alarmtype;
		
	/**
	 * 是否已读(0未读1已读)
	 */
	
	@ApiModelProperty(value = "是否已读(0未读1已读)") 
	private Integer isread;
				
	
	/**
	 * 设置：所属金融机构Id
	 */
	 
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}
	
	/**
	 * 获取：所属金融机构Id
	 */
	public Long getDeptid() {
		return deptid;
	}
				
	
	/**
	 * 设置：主键(DL)
	 */
	 
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	
	/**
	 * 获取：主键(DL)
	 */
	public String getDealerid() {
		return dealerid;
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
	 * 设置：设备号
	 */
	 
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	
	/**
	 * 获取：设备号
	 */
	public String getDevicenumber() {
		return devicenumber;
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
	 * 设置：报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)
	 */
	 
	public void setAlarmtype(Integer alarmtype) {
		this.alarmtype = alarmtype;
	}
	
	/**
	 * 获取：报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)
	 */
	public Integer getAlarmtype() {
		return alarmtype;
	}
				
	
	/**
	 * 设置：是否已读(0未读1已读)
	 */
	 
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	
	/**
	 * 获取：是否已读(0未读1已读)
	 */
	public Integer getIsread() {
		return isread;
	}
			
}
