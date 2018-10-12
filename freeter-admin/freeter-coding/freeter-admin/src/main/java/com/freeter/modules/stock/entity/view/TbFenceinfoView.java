package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.io.Serializable;
 

/**
 * 围栏信息表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 13:44:52
 */
@TableName("tb_fenceinfo")
@ApiModel(value = "TbFenceinfo")
public class TbFenceinfoView  implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键(FC)",hidden = true)
	private String id;
	@ApiModelProperty(value = "审核状态(0提交1审核通过2拒绝)")
	private Integer auditstate;
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	@ApiModelProperty(value = "是否启用(0禁用1启用)")
	private Integer isenable;
	/*@NotNull (message = "创建时间不能为空") */			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "创建时间")
	private Date createdat;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}
	public String getFencename() {
		return fencename;
	}
	public void setFencename(String fencename) {
		this.fencename = fencename;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
}
