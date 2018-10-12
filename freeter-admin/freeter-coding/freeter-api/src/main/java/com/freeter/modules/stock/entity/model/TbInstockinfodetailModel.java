package com.freeter.modules.stock.entity.model;

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
 * 特殊入库明细表
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_instockinfodetail")
@ApiModel(value = "TbInstockinfodetail")
public class TbInstockinfodetailModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	

	/**
	 * 主键(ID)
	 */
	
	@TableId					
	@ApiModelProperty(value = "主键(ID)",hidden = true)
	private String id;
	
	
						
	@ApiModelProperty(value = "入库单Id")
	private String instockid;
	
						
	public String getInstockid() {
		return instockid;
	}

	public void setInstockid(String instockid) {
		this.instockid = instockid;
	}

	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	
						
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)")
	private Integer detailstatus;
	
	
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "签收时间")
	private Date receivetime;
	
		
	@NotNull (message = "写入时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "写入时间")
	private Date inserttime;
	
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVinnumber() {
		return vinnumber;
	}

	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}

	

	

	public Integer getDetailstatus() {
		return detailstatus;
	}

	public void setDetailstatus(Integer detailstatus) {
		this.detailstatus = detailstatus;
	}

	public Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}

	public Date getInserttime() {
		return inserttime;
	}

	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	
}
