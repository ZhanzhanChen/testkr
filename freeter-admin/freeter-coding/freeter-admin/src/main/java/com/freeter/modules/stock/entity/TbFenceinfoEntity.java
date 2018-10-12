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

import org.springframework.data.geo.Polygon;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 围栏信息表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 13:44:52
 */
@TableName("tb_fenceinfo")
@ApiModel(value = "TbFenceinfo")
public class TbFenceinfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbFenceinfoEntity() {
		
	}
	
	public TbFenceinfoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(FC)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(FC)",hidden = true)
	private String id;
	
	/**
	 * 申请经销商Id
	 */
						
	@ApiModelProperty(value = "申请经销商Id")
	private String dealerid;
	
	/**
	 * 所属经销商Id
	 */
						
	@ApiModelProperty(value = "所属经销商Id")
	private String owndealerid;
	
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
	 * 围栏地址
	 */
						
	@ApiModelProperty(value = "围栏地址")
	private String fenceaddr;
	
	/**
	 * 审核类型(0新建1修改)
	 */
						
	@ApiModelProperty(value = "审核类型(0新建1修改)")
	private Integer audittype;
	
	/**
	 * 审核状态(0提交1审核通过2拒绝)
	 */
						
	@ApiModelProperty(value = "审核状态(0提交1审核通过2拒绝)")
	private Integer auditstate;
	
	/**
	 * 审核时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "审核时间")
	private Date audittime;
	
	/**
	 * 审核备注
	 */
						
	@ApiModelProperty(value = "审核备注")
	private String auditremark;
	
	/**
	 * 是否启用(0禁用1启用)
	 */
			
	@NotNull (message = "是否启用(0禁用1启用)不能为空") 				
	@ApiModelProperty(value = "是否启用(0禁用1启用)")
	private Integer isenable;
	
	/**
	 * 创建时间
	 */
			
	/*@NotNull (message = "创建时间不能为空") */			
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
	
	/**
	 * 设置：主键(FC)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(FC)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：申请经销商Id
	 */
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	/**
	 * 获取：申请经销商Id
	 */
	public String getDealerid() {
		return dealerid;
	}
	/**
	 * 设置：所属经销商Id
	 */
	public void setOwndealerid(String owndealerid) {
		this.owndealerid = owndealerid;
	}
	/**
	 * 获取：所属经销商Id
	 */
	public String getOwndealerid() {
		return owndealerid;
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
	
	public String getFencepolygon() {
		return fencepolygon;
	}

	public void setFencepolygon(String fencepolygon) {
		this.fencepolygon = fencepolygon;
	}

	/**
	 * 设置：围栏地址
	 */
	public void setFenceaddr(String fenceaddr) {
		this.fenceaddr = fenceaddr;
	}
	/**
	 * 获取：围栏地址
	 */
	public String getFenceaddr() {
		return fenceaddr;
	}
	/**
	 * 设置：审核类型(0新建1修改)
	 */
	public void setAudittype(Integer audittype) {
		this.audittype = audittype;
	}
	/**
	 * 获取：审核类型(0新建1修改)
	 */
	public Integer getAudittype() {
		return audittype;
	}
	/**
	 * 设置：审核状态(0提交1审核通过2拒绝)
	 */
	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}
	/**
	 * 获取：审核状态(0提交1审核通过2拒绝)
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
	 * 设置：审核备注
	 */
	public void setAuditremark(String auditremark) {
		this.auditremark = auditremark;
	}
	/**
	 * 获取：审核备注
	 */
	public String getAuditremark() {
		return auditremark;
	}
	/**
	 * 设置：是否启用(0禁用1启用)
	 */
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	/**
	 * 获取：是否启用(0禁用1启用)
	 */
	public Integer getIsenable() {
		return isenable;
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
