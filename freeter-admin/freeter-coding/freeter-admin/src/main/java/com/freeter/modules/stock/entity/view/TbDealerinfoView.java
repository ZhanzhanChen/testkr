package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbDealerinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 经销商信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-25 09:26:23
 */
@TableName("tb_dealerinfo")
@ApiModel(value = "TbDealerinfo")
public class TbDealerinfoView  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String name;
	
	/**
	 * 经销商等级(字典表)
	 */
						
	@ApiModelProperty(value = "经销商等级(字典表)")
	private String grade;
	@ApiModelProperty(value = "省份名称")
	private String proname;
	
	
	
	
						
	@ApiModelProperty(value = "")
	private String recordaddr;
	
	/**
	 * 库存车辆数量
	 */
						
	@ApiModelProperty(value = "库存车辆数量")
	private Integer stocknum;

	/**
	 * 管理人员名称
	 */
						
	@ApiModelProperty(value = "管理人员名称")
	private String managername;
	
	/**
	 * 管理人员联系方式
	 */
						
	@ApiModelProperty(value = "管理人员联系方式")
	private String managertel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getRecordaddr() {
		return recordaddr;
	}

	public void setRecordaddr(String recordaddr) {
		this.recordaddr = recordaddr;
	}

	public Integer getStocknum() {
		return stocknum;
	}

	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagertel() {
		return managertel;
	}

	public void setManagertel(String managertel) {
		this.managertel = managertel;
	}
	
	
}
