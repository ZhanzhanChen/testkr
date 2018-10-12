package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TbCarinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆信息表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author ipx
 * @email 
 * @date 2018-08-17 11:25:30
 */
@ApiModel(value = "TbCarinfoModel")
public class TbCarinfoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车架号
	 */
	
	@ApiModelProperty(value = "车架号") 
	private String vinnumber;
		
	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)") 
	private Integer carstatus;
		
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
	 * 经销商Code
	 */
	
	@ApiModelProperty(value = "经销商Code") 
	private String dealercode;
		
	/**
	 * 经销商名称
	 */
	
	@ApiModelProperty(value = "经销商名称") 
	private String dealername;
		
	/**
	 * 签收时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "签收时间") 
	private Date receivetime;
		
	/**
	 * 还款时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "还款时间") 
	private Date repaytime;
		
	/**
	 * 车辆数据导入时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "车辆数据导入时间") 
	private Date inserttime;
		
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
	 * 设置：经销商Code
	 */
	 
	public void setDealercode(String dealercode) {
		this.dealercode = dealercode;
	}
	
	/**
	 * 获取：经销商Code
	 */
	public String getDealercode() {
		return dealercode;
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
	 * 设置：还款时间
	 */
	 
	public void setRepaytime(Date repaytime) {
		this.repaytime = repaytime;
	}
	
	/**
	 * 获取：还款时间
	 */
	public Date getRepaytime() {
		return repaytime;
	}
				
	
	/**
	 * 设置：车辆数据导入时间
	 */
	 
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	
	/**
	 * 获取：车辆数据导入时间
	 */
	public Date getInserttime() {
		return inserttime;
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
