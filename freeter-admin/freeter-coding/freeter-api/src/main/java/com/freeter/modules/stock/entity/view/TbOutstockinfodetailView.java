package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
 

/**
 * 特殊出库明细
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author ipx
 * @email 171998110@qq.com
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_outstockinfodetail")
@ApiModel(value = "TbOutstockinfodetail")
public class TbOutstockinfodetailView  implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键(OS)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(OS)",hidden = true)
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
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	
	/**
	 * 车状态
	 */
						
	@ApiModelProperty(value = "车状态")
	private String carstatus;
	
	/**
	 * 车状态详情
	 */
						
	@ApiModelProperty(value = "车状态详情")
	private String detailstatus;
	public String getVinnumber() {
		return vinnumber;
	}
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	
	
	
	
	public String getCarstatus() {
		return carstatus;
	}
	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}
	public String getDetailstatus() {
		return detailstatus;
	}
	public void setDetailstatus(String detailstatus) {
		this.detailstatus = detailstatus;
	}
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
	 * 联系电话
	 */
	private String managertel;
	 
	public String getManagertel() {
		return managertel;
	}
	public void setManagertel(String managertel) {
		this.managertel = managertel;
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
	

}
