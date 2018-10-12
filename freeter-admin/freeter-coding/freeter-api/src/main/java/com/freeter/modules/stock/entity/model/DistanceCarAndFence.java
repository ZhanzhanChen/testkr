package com.freeter.modules.stock.entity.model;

import java.util.List;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarlocationEntity;
import com.freeter.modules.stock.entity.view.FenceCarInfoView;

public class DistanceCarAndFence {
	/**
	 * 车辆信息
	 */
	List<FenceCarInfoView> carinfoByDistance;
	/**
	 * 围栏信息
	 */
	List<TbFenceinfoEntity> fenceinfoByDistance;
	
	public List<FenceCarInfoView> getCarinfoByDistance() {
		return carinfoByDistance;
	}
	public void setCarinfoByDistance(List<FenceCarInfoView> carinfoByDistance) {
		this.carinfoByDistance = carinfoByDistance;
	}
	public List<TbFenceinfoEntity> getFenceinfoByDistance() {
		return fenceinfoByDistance;
	}
	public void setFenceinfoByDistance(List<TbFenceinfoEntity> fenceinfoByDistance) {
		this.fenceinfoByDistance = fenceinfoByDistance;
	}
	

}
