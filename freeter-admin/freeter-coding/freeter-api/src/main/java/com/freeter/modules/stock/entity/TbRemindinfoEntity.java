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
 * 消息提醒表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:10:42
 */
@TableName("tb_remindinfo")
@ApiModel(value = "TbRemindinfo")
public class TbRemindinfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbRemindinfoEntity() {
		
	}
	
	public TbRemindinfoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(AI)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(AI)",hidden = true)
	private String id;
	
	/**
	 * 金融机构Id
	 */
						
	@ApiModelProperty(value = "金融机构Id")
	private Long departid;
	
	/**
	 * 经销商Id
	 */
						
	@ApiModelProperty(value = "经销商Id")
	private String dealerid;
	
	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * OBD设备号
	 */
						
	@ApiModelProperty(value = "OBD设备号")
	private String devicenumber;
	
	/**
	 * 设备纬度
	 */
						
	@ApiModelProperty(value = "设备纬度")
	private BigDecimal devicelat;
	
	/**
	 * 设备经度
	 */
						
	@ApiModelProperty(value = "设备经度")
	private BigDecimal devicelng;
	
	/**
	 * 报警类型(1违规出库2低电压3无信号4非法拆除5震动6位移7碰撞8超时未入库)
	 */
						
	@ApiModelProperty(value = "报警类型(1违规出库2低电压3无信号4非法拆除5震动6位移7碰撞8超时未入库)")
	private Integer remindtype;
	
	/**
	 * 预警处理状态(0待处理1处理中2已处理3延期处理4其他)
	 */
						
	@ApiModelProperty(value = "预警处理状态(0待处理1处理中2已处理3延期处理4其他)")
	private Integer remindstatus;
	
	/**
	 * 预警时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "预警时间")
	private Date remindtime;
	
	/**
	 * 是否已读(0未读1已读)
	 */
						
	@ApiModelProperty(value = "是否已读(0未读1已读)")
	private Integer isread;
	
	/**
	 * 备注
	 */
						
	@ApiModelProperty(value = "备注")
	private String remark;
	
	/**
	 * 数据写入时间
	 */
			
	@NotNull (message = "数据写入时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "数据写入时间")
	private Date inserttime;
	
	/**
	 * 最后更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "最后更新时间")
	private Date lastupdate;
	
	/**
	 * 是否删除(0否1是)
	 */
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
	/**
	 * 设置：主键(AI)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(AI)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：金融机构Id
	 */
	public Long getDepartid() {
		return departid;
	}

	public void setDepartid(Long departid) {
		this.departid = departid;
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
	 * 设置：OBD设备号
	 */
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	/**
	 * 获取：OBD设备号
	 */
	public String getDevicenumber() {
		return devicenumber;
	}
	/**
	 * 设置：设备纬度
	 */
	public void setDevicelat(BigDecimal devicelat) {
		this.devicelat = devicelat;
	}
	/**
	 * 获取：设备纬度
	 */
	public BigDecimal getDevicelat() {
		return devicelat;
	}
	/**
	 * 设置：设备经度
	 */
	public void setDevicelng(BigDecimal devicelng) {
		this.devicelng = devicelng;
	}
	/**
	 * 获取：设备经度
	 */
	public BigDecimal getDevicelng() {
		return devicelng;
	}
	/**
	 * 设置：报警类型(1违规出库2低电压3无信号4非法拆除5震动6位移7碰撞8超时未入库)
	 */
	public void setRemindtype(Integer remindtype) {
		this.remindtype = remindtype;
	}
	/**
	 * 获取：报警类型(1违规出库2低电压3无信号4非法拆除5震动6位移7碰撞8超时未入库)
	 */
	public Integer getRemindtype() {
		return remindtype;
	}
	/**
	 * 设置：预警处理状态(0待处理1处理中2已处理3延期处理4其他)
	 */
	public void setRemindstatus(Integer remindstatus) {
		this.remindstatus = remindstatus;
	}
	/**
	 * 获取：预警处理状态(0待处理1处理中2已处理3延期处理4其他)
	 */
	public Integer getRemindstatus() {
		return remindstatus;
	}
	/**
	 * 设置：预警时间
	 */
	public void setRemindtime(Date remindtime) {
		this.remindtime = remindtime;
	}
	/**
	 * 获取：预警时间
	 */
	public Date getRemindtime() {
		return remindtime;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：数据写入时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：数据写入时间
	 */
	public Date getInserttime() {
		return inserttime;
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
