package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 特殊出库明细
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
@ApiModel(value = "TbOutstockinfodetailModel")
public class TbOutstockinfodetailModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 出库单Id
	 */
	
	@ApiModelProperty(value = "Id") 
	private String id;
	
	
	@ApiModelProperty(value = "出库单Id") 
	private String outstockid;
	/**
	 * 车架号
	 */
	
	@ApiModelProperty(value = "车架号") 
	private String vinnumber;
		
	public String getOutstockid() {
		return outstockid;
	}

	public void setOutstockid(String outstockid) {
		this.outstockid = outstockid;
	}

	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)") 
	private Integer carstatus;
		
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)") 
	private Integer detailstatus;
	
	public Integer getDetailstatus() {
		return detailstatus;
	}

	public void setDetailstatus(Integer detailstatus) {
		this.detailstatus = detailstatus;
	}

	/**
	 * 围栏名称
	 */
	
	@ApiModelProperty(value = "围栏名称") 
	private String fenceid;
		
	/**
	 * 围栏名称
	 */
	
	@ApiModelProperty(value = "围栏名称") 
	private String fencename;
		
	/**
	 * 数据更新时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "数据更新时间") 
	private Date inserttime;
		
	/**
	 * 是否删除(0否1是)
	 */
	
	@ApiModelProperty(value = "是否删除(0否1是)") 
	private Integer deleted;
				
	
	/**
	 * 设置：出库单Id
	 */
	 
	
				
	
	/**
	 * 设置：车架号
	 */
	 
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：车架号
	 */
	public String getVinnumber() {
		return vinnumber;
	}
				
	
	/**
	 * 设置：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	 
	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}
	
	/**
	 * 获取：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	public Integer getCarstatus() {
		return carstatus;
	}
				
	
	/**
	 * 设置：围栏名称
	 */
	 
	public void setFenceid(String fenceid) {
		this.fenceid = fenceid;
	}
	
	/**
	 * 获取：围栏名称
	 */
	public String getFenceid() {
		return fenceid;
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
				
	
	/**
	 * 设置：数据更新时间
	 */
	 
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	
	/**
	 * 获取：数据更新时间
	 */
	public Date getInserttime() {
		return inserttime;
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
