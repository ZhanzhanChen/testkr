package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TbOutstockinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 特殊出库单表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author ipx
 * @email 
 * @date 2018-08-08 13:53:29
 */
@ApiModel(value = "TbOutstockinfoModel")
public class TbOutstockinfoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/**
	 * 主键(FC)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(FC)",hidden = true)
	private String outstockid;
	
	private Long departid;
	

	public Long getDepartid() {
		return departid;
	}

	public void setDepartid(Long departid) {
		this.departid = departid;
	}

	public String getOutstockid() {
		return outstockid;
	}

	public void setOutstockid(String outstockid) {
		this.outstockid = outstockid;
	}

	

	public List<TbOutstockinfodetailModel> getData() {
		return data;
	}

	public void setData(List<TbOutstockinfodetailModel> data) {
		this.data = data;
	}



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
	 * 出库数量
	 */
	
	@ApiModelProperty(value = "出库数量") 
	private Integer outstocknum;
		
	/**
	 * 出库时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "出库时间") 
	private Date outstocktime;
		
	/**
	 * 预计回库时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "预计回库时间") 
	private Date returnstocktime;
		
	/**
	 * 特殊出库原因
	 */
	
	@ApiModelProperty(value = "特殊出库原因") 
	private Long outstockreason;
		
	/**
	 * 目标地点
	 */
	
	@ApiModelProperty(value = "目标地点") 
	private String destinationaddr;
		
	/**
	 * 审核状态(0提交1同意2拒绝)
	 */
	
	@ApiModelProperty(value = "审核状态(0提交1同意2拒绝)") 
	private Integer auditstate;
		
	/**
	 * 审核时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "审核时间") 
	private Date audittime;
		
	/**
	 * 审核详细意见
	 */
	
	@ApiModelProperty(value = "审核详细意见") 
	private String auditremark;
		
	/**
	 * 备注
	 */
	
	@ApiModelProperty(value = "备注") 
	private String remark;
		
	/**
	 * 创建时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "创建时间") 
	private Date createdat;
		
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
	
	@ApiModelProperty(value = "是否删除(0否1是)") 
	private Integer deleted;
				
	
	private List<TbOutstockinfodetailModel> data;
	
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
	 * 设置：出库数量
	 */
	 
	public void setOutstocknum(Integer outstocknum) {
		this.outstocknum = outstocknum;
	}
	
	/**
	 * 获取：出库数量
	 */
	public Integer getOutstocknum() {
		return outstocknum;
	}
				
	
	/**
	 * 设置：出库时间
	 */
	 
	public void setOutstocktime(Date outstocktime) {
		this.outstocktime = outstocktime;
	}
	
	/**
	 * 获取：出库时间
	 */
	public Date getOutstocktime() {
		return outstocktime;
	}
				
	
	/**
	 * 设置：预计回库时间
	 */
	 
	public void setReturnstocktime(Date returnstocktime) {
		this.returnstocktime = returnstocktime;
	}
	
	/**
	 * 获取：预计回库时间
	 */
	public Date getReturnstocktime() {
		return returnstocktime;
	}
				
	
	/**
	 * 设置：特殊出库原因
	 */
	 
	public void setOutstockreason(Long outstockreason) {
		this.outstockreason = outstockreason;
	}
	
	/**
	 * 获取：特殊出库原因
	 */
	public Long getOutstockreason() {
		return outstockreason;
	}
				
	
	/**
	 * 设置：目标地点
	 */
	 
	public void setDestinationaddr(String destinationaddr) {
		this.destinationaddr = destinationaddr;
	}
	
	/**
	 * 获取：目标地点
	 */
	public String getDestinationaddr() {
		return destinationaddr;
	}
				
	
	/**
	 * 设置：审核状态(0提交1同意2拒绝)
	 */
	 
	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}
	
	/**
	 * 获取：审核状态(0提交1同意2拒绝)
	 */
	public Integer getAuditstate() {
		return auditstate;
	}
				
	
	/**
	 * 设置：审核时间
	 */
	 
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}
	
	/**
	 * 获取：审核时间
	 */
	public Date getAudittime() {
		return audittime;
	}
				
	
	/**
	 * 设置：审核详细意见
	 */
	 
	public void setAuditremark(String auditremark) {
		this.auditremark = auditremark;
	}
	
	/**
	 * 获取：审核详细意见
	 */
	public String getAuditremark() {
		return auditremark;
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
	 * 设置：创建时间
	 */
	 
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedat() {
		return createdat;
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
