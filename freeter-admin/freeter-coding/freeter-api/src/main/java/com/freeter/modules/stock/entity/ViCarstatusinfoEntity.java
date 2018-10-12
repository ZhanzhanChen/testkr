package com.freeter.modules.stock.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.utils.StatusConvert;

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
 * VIEW
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-22 11:31:16
 */
@TableName("vi_carstatusinfo")
@ApiModel(value = "ViCarstatusinfo")
public class ViCarstatusinfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ViCarstatusinfoEntity() {
		
	}
	
	public ViCarstatusinfoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(TC)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(TC)",hidden = true)
	private String id;
	
	/**
	 * 所属金融机构Id
	 */
						
	@ApiModelProperty(value = "所属金融机构Id")
	private Long departid;
	
	/**
	 * 所属经销商Id
	 */
						
	@ApiModelProperty(value = "所属经销商Id")
	private String dealerid;
	
	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	
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
	 * 围栏ID
	 */
						
	@ApiModelProperty(value = "围栏ID")
	private String fenceid;
	
	/**
	 * 围栏名称
	 */
						
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	
	/**
	 * 围栏区域信息
	 */
						
	@ApiModelProperty(value = "围栏区域信息")
	private String fencepolygon;
	
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
	 * 签收时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "签收时间")
	private Date receivetime;
	
	/**
	 * 最后更新时间
	 */
			
	@NotNull (message = "最后更新时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "最后更新时间")
	private Date lastupdate;
	
	/**
	 * 设置：主键(TC)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(TC)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：所属金融机构Id
	 */
	public void setDepartid(Long departid) {
		this.departid = departid;
	}
	/**
	 * 获取：所属金融机构Id
	 */
	public Long getDepartid() {
		return departid;
	}
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
	 * 设置：车辆状态明细(0未入库1在库2出库)
	 */
	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}
	/**
	 * 获取：车辆状态明细(0未入库1在库2出库)
	 */
	public Integer getCarstatus() {
		carstatus = StatusConvert.DetailToStatus(this.detailstatus);
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
	 * 设置：
	 */
	public void setFenceid(String fenceid) {
		this.fenceid = fenceid;
	}
	/**
	 * 获取：
	 */
	public String getFenceid() {
		return fenceid;
	}
	/**
	 * 设置：
	 */
	public void setFencename(String fencename) {
		this.fencename = fencename;
	}
	/**
	 * 获取：
	 */
	public String getFencename() {
		return fencename;
	}
	/**
	 * 设置：围栏区域信息
	 */
	public void setFencepolygon(String fencepolygon) {
		this.fencepolygon = fencepolygon;
	}
	/**
	 * 获取：围栏区域信息
	 */
	public String getFencepolygon() {
		return fencepolygon;
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
	/**
	 * 设置：签收时间
	 */
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	/**
	 * 获取：签收时间
	 */
	public Date getReceivetime() {
		return receivetime;
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
