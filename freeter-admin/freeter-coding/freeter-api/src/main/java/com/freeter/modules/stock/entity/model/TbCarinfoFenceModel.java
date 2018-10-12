package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.util.List;

import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;

/**
 * 标签入库model
 * @author Administrator
 *
 */
public class TbCarinfoFenceModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 围栏ID
	 */
	public String id;
	/**
	 * 围栏名称
	 */
	public String fencename;
	/**
	 * 车辆状态
	 */
	public Integer carstatus;
	/**
	 * 数据列表
	 */
	public List<ViCarstatusinfoEntity> data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFencename() {
		return fencename;
	}

	public void setFencename(String fencename) {
		this.fencename = fencename;
	}

	public Integer getCarstatus() {
		return carstatus;
	}

	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}

	public List<ViCarstatusinfoEntity> getData() {
		return data;
	}

	public void setData(List<ViCarstatusinfoEntity> data) {
		this.data = data;
	}
	
	
}
