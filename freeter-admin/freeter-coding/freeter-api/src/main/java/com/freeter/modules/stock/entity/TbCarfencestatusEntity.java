package com.freeter.modules.stock.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 车辆围栏状态信息
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-28 11:13:34
 */
@TableName("tb_carfencestatus")
@ApiModel(value = "TbCarfencestatus")
public class TbCarfencestatusEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbCarfencestatusEntity() {
		
	}
	
	public TbCarfencestatusEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 自增主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "自增主键",hidden = true)
	private Long id;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 设备号
	 */
						
	@ApiModelProperty(value = "设备号")
	private String devicenumber;
	
	/**
	 * 围栏Id
	 */
						
	@ApiModelProperty(value = "围栏Id")
	private String fenceid;
	
	/**
	 * 围栏名称
	 */
						
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	
	/**
	 * 上次所在围栏Id
	 */
						
	@ApiModelProperty(value = "上次所在围栏Id")
	private String lastfenceid;
	
	/**
	 * 上次所在围栏名称
	 */
						
	@ApiModelProperty(value = "上次所在围栏名称")
	private String lastfencename;
	
	/**
	 * 围栏状态(0不在围栏1在围栏)
	 */
						
	@ApiModelProperty(value = "围栏状态(0不在围栏1在围栏)")
	private Integer fencestatus;
	
	/**
	 * 触发时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "触发时间")
	private Date actiontime;
	
	/**
	 * 定位方式(0GPS1基站)
	 */
						
	@ApiModelProperty(value = "定位方式(0GPS1基站)")
	private Integer locationtype;
	
	/**
	 * 最后更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "最后更新时间")
	private Date lastupdate;
	
	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getId() {
		return id;
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
	 * 设置：围栏Id
	 */
	public void setFenceid(String fenceid) {
		this.fenceid = fenceid;
	}
	/**
	 * 获取：围栏Id
	 */
	public String getFenceid() {
		return fenceid;
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
	 * 设置：上次所在围栏Id
	 */
	public void setLastfenceid(String lastfenceid) {
		this.lastfenceid = lastfenceid;
	}
	/**
	 * 获取：上次所在围栏Id
	 */
	public String getLastfenceid() {
		return lastfenceid;
	}
	/**
	 * 设置：上次所在围栏名称
	 */
	public void setLastfencename(String lastfencename) {
		this.lastfencename = lastfencename;
	}
	/**
	 * 获取：上次所在围栏名称
	 */
	public String getLastfencename() {
		return lastfencename;
	}
	/**
	 * 设置：围栏状态(0不在围栏1在围栏)
	 */
	public void setFencestatus(Integer fencestatus) {
		this.fencestatus = fencestatus;
	}
	/**
	 * 获取：围栏状态(0不在围栏1在围栏)
	 */
	public Integer getFencestatus() {
		return fencestatus;
	}
	/**
	 * 设置：触发时间
	 */
	public void setActiontime(Date actiontime) {
		this.actiontime = actiontime;
	}
	/**
	 * 获取：触发时间
	 */
	public Date getActiontime() {
		return actiontime;
	}
	/**
	 * 设置：定位方式(0GPS1基站)
	 */
	public void setLocationtype(Integer locationtype) {
		this.locationtype = locationtype;
	}
	/**
	 * 获取：定位方式(0GPS1基站)
	 */
	public Integer getLocationtype() {
		return locationtype;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Date getLastupdate() {
		return lastupdate;
	}
}
