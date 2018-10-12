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
 * 统计分析
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 18:04:27
 */
@TableName("rp_fcdatadaily")
@ApiModel(value = "RpFcdatadaily")
public class RpFcdatadailyEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RpFcdatadailyEntity() {
		
	}
	
	public RpFcdatadailyEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键",hidden = true)
	private Long id;
	
	/**
	 * 经销商Id
	 */
						
	@ApiModelProperty(value = "经销商Id")
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
	 * 车辆出库数量
	 */
						
	@ApiModelProperty(value = "车辆出库数量")
	private Integer caroutnum;
	
	/**
	 * 车辆售出数量
	 */
						
	@ApiModelProperty(value = "车辆售出数量")
	private Integer receivenum;
	
	/**
	 * 特殊入库数量
	 */
						
	@ApiModelProperty(value = "特殊入库数量")
	private Integer instocknum;
	
	/**
	 * 特殊出库数量
	 */
						
	@ApiModelProperty(value = "特殊出库数量")
	private Integer outstocknum;
	
	/**
	 * 违规出库报警数量
	 */
						
	@ApiModelProperty(value = "违规出库报警数量")
	private Integer viooutstocknum;
	
	/**
	 * 超时未入库报警数量
	 */
						
	@ApiModelProperty(value = "超时未入库报警数量")
	private Integer vioinstocknum;
	
	/**
	 * 离线报警数量
	 */
						
	@ApiModelProperty(value = "离线报警数量")
	private Integer offlinenum;
	
	/**
	 * 位移报警数量
	 */
						
	@ApiModelProperty(value = "位移报警数量")
	private Integer movenum;
	
	/**
	 * 碰撞报警数量
	 */
						
	@ApiModelProperty(value = "碰撞报警数量")
	private Integer knocknum;
	
	/**
	 * 非法拆除报警数量
	 */
						
	@ApiModelProperty(value = "非法拆除报警数量")
	private Integer teardownnum;
	
	/**
	 * 低电压报警数量
	 */
						
	@ApiModelProperty(value = "低电压报警数量")
	private Integer lowvolnum;
	
	/**
	 * 低电量报警数量
	 */
						
	@ApiModelProperty(value = "低电量报警数量")
	private Integer lowbatnum;
	
	/**
	 * 报表日期
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "报表日期")
	private Date checkdate;
	
	/**
	 * 统计时间
	 */
			
	@NotNull (message = "统计时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "统计时间")
	private Date inserttime;
	
	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：经销商Id
	 */
	public void setDepartid(Long departid) {
		this.departid = departid;
	}
	/**
	 * 获取：经销商Id
	 */
	public Long getDepartid() {
		return departid;
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
	 * 设置：车辆出库数量
	 */
	public void setCaroutnum(Integer caroutnum) {
		this.caroutnum = caroutnum;
	}
	/**
	 * 获取：车辆出库数量
	 */
	public Integer getCaroutnum() {
		return caroutnum;
	}
	/**
	 * 设置：车辆售出数量
	 */
	public void setReceivenum(Integer receivenum) {
		this.receivenum = receivenum;
	}
	/**
	 * 获取：车辆售出数量
	 */
	public Integer getReceivenum() {
		return receivenum;
	}
	/**
	 * 设置：特殊入库数量
	 */
	public void setInstocknum(Integer instocknum) {
		this.instocknum = instocknum;
	}
	/**
	 * 获取：特殊入库数量
	 */
	public Integer getInstocknum() {
		return instocknum;
	}
	/**
	 * 设置：特殊出库数量
	 */
	public void setOutstocknum(Integer outstocknum) {
		this.outstocknum = outstocknum;
	}
	/**
	 * 获取：特殊出库数量
	 */
	public Integer getOutstocknum() {
		return outstocknum;
	}
	/**
	 * 设置：违规出库报警数量
	 */
	public void setViooutstocknum(Integer viooutstocknum) {
		this.viooutstocknum = viooutstocknum;
	}
	/**
	 * 获取：违规出库报警数量
	 */
	public Integer getViooutstocknum() {
		return viooutstocknum;
	}
	/**
	 * 设置：超时未入库报警数量
	 */
	public void setVioinstocknum(Integer vioinstocknum) {
		this.vioinstocknum = vioinstocknum;
	}
	/**
	 * 获取：超时未入库报警数量
	 */
	public Integer getVioinstocknum() {
		return vioinstocknum;
	}
	/**
	 * 设置：离线报警数量
	 */
	public void setOfflinenum(Integer offlinenum) {
		this.offlinenum = offlinenum;
	}
	/**
	 * 获取：离线报警数量
	 */
	public Integer getOfflinenum() {
		return offlinenum;
	}
	/**
	 * 设置：位移报警数量
	 */
	public void setMovenum(Integer movenum) {
		this.movenum = movenum;
	}
	/**
	 * 获取：位移报警数量
	 */
	public Integer getMovenum() {
		return movenum;
	}
	/**
	 * 设置：碰撞报警数量
	 */
	public void setKnocknum(Integer knocknum) {
		this.knocknum = knocknum;
	}
	/**
	 * 获取：碰撞报警数量
	 */
	public Integer getKnocknum() {
		return knocknum;
	}
	/**
	 * 设置：非法拆除报警数量
	 */
	public void setTeardownnum(Integer teardownnum) {
		this.teardownnum = teardownnum;
	}
	/**
	 * 获取：非法拆除报警数量
	 */
	public Integer getTeardownnum() {
		return teardownnum;
	}
	/**
	 * 设置：低电压报警数量
	 */
	public void setLowvolnum(Integer lowvolnum) {
		this.lowvolnum = lowvolnum;
	}
	/**
	 * 获取：低电压报警数量
	 */
	public Integer getLowvolnum() {
		return lowvolnum;
	}
	/**
	 * 设置：低电量报警数量
	 */
	public void setLowbatnum(Integer lowbatnum) {
		this.lowbatnum = lowbatnum;
	}
	/**
	 * 获取：低电量报警数量
	 */
	public Integer getLowbatnum() {
		return lowbatnum;
	}
	/**
	 * 设置：报表日期
	 */
	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	/**
	 * 获取：报表日期
	 */
	public Date getCheckdate() {
		return checkdate;
	}
	/**
	 * 设置：统计时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：统计时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
}
