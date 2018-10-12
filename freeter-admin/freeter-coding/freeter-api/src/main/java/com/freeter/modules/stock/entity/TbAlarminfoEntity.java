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
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 预警日志表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 17:41:59
 */
@TableName("tb_alarminfo")
@ApiModel(value = "TbAlarminfo")
public class TbAlarminfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbAlarminfoEntity() {
		
	}
	
	public TbAlarminfoEntity(T t) {
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
	 * 经销商Id
	 */
						
	@ApiModelProperty(value = "经销商Id")
	private String dealerid;
	
	/**
	 * 围栏Id
	 */
						
	@ApiModelProperty(value = "围栏Id")
	private String fenceid;
	
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
	 * 设备经度
	 */
						
	@ApiModelProperty(value = "设备经度")
	private BigDecimal devicelat;
	
	/**
	 * 设备纬度
	 */
						
	@ApiModelProperty(value = "设备纬度")
	private BigDecimal devicelng;
	
	/**
	 * 报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)
	 */
						
	@ApiModelProperty(value = "报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞8低电量)")
	private Integer alarmtype;
	
	/**
	 * 报警时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "报警时间")
	private Date alarmtime;
	
	/**
	 * 是否已读(0未读1已读)
	 */
						
	@ApiModelProperty(value = "是否已读(0未读1已读)")
	private Integer isread;
	
	/**
	 * 是否待处理(0否1是)
	 */
						
	@ApiModelProperty(value = "是否待处理(0否1是)")
	private Integer ispending;
	
	/**
	 * 写入时间
	 */
			
	@NotNull (message = "写入时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "写入时间")
	private Date inserttime;
	
	/**
	 * 是否删除(0否1是)
	 */
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
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
	 * 设置：经销商Id
	 */
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	/**
	 * 获取：经销商Id
	 */
	public String getDealerid() {
		return dealerid;
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
	 * 设置：设备经度
	 */
	public void setDevicelat(BigDecimal devicelat) {
		this.devicelat = devicelat;
	}
	/**
	 * 获取：设备经度
	 */
	public BigDecimal getDevicelat() {
		return devicelat;
	}
	/**
	 * 设置：设备纬度
	 */
	public void setDevicelng(BigDecimal devicelng) {
		this.devicelng = devicelng;
	}
	/**
	 * 获取：设备纬度
	 */
	public BigDecimal getDevicelng() {
		return devicelng;
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
	 * 设置：报警时间
	 */
	public void setAlarmtime(Date alarmtime) {
		this.alarmtime = alarmtime;
	}
	/**
	 * 获取：报警时间
	 */
	public Date getAlarmtime() {
		return alarmtime;
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
	/**
	 * 获取：是否待处理(0否1是)
	 */
	public Integer getIspending() {
		return ispending;
	}
	/**
	 * 设置：是否待处理(0否1是)
	 */
	public void setIspending(Integer ispending) {
		this.ispending = ispending;
	}

	/**
	 * 设置：写入时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：写入时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
	/**
	 * 设置：是否删除(0否1是)
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：是否删除(0否1是)
	 */
	public Integer getDeleted() {
		return deleted;
	}
}
