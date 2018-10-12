package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.RpFcdatadailyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 统计分析
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 18:04:27
 */
@ApiModel(value = "RpFcdatadailyModel")
public class RpFcdatadailyModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "统计时间") 
	private Date inserttime;
				
	
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
