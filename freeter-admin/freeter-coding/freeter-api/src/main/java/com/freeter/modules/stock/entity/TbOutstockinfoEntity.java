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
 * 特殊出库单表
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email 
 * @date 2018-08-08 13:53:29
 */
@TableName("tb_outstockinfo")
@ApiModel(value = "TbOutstockinfo")
public class TbOutstockinfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbOutstockinfoEntity() {
		
	}
	
	public TbOutstockinfoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(OS)
	 */
	
	private String id;
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
			
	@NotNull (message = "创建时间不能为空") 			
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
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
	/**
	 * 设置：主键(OS)
	 */
	
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
