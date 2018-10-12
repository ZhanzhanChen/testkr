package com.freeter.modules.stock.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.modules.stock.dao.TmCarinfoimportDao;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbCarinfoEntity;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.TmCarinfoimportEntity;
import com.freeter.modules.stock.entity.view.TmCarinfoimportView;
import com.freeter.modules.stock.entity.view.TmCarinfoimportWrongView;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.service.TbCarinfoService;
import com.freeter.modules.stock.service.TbDealerinfoService;
import com.freeter.modules.stock.service.TmCarinfoimportService;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.StringUtil;


@Service("tmCarinfoimportService")
public class TmCarinfoimportServiceImpl extends ServiceImpl<TmCarinfoimportDao, TmCarinfoimportEntity> implements TmCarinfoimportService {

	@Autowired
	private TbDealerinfoService tbDealerinfoService;
	@Autowired
	private TbCarinfoService tbCarinfoService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private TbCarcirculationService tbCarcirculationService;
	
	@Override
	@Transactional
	public List<TmCarinfoimportWrongView> importExcel(List<TmCarinfoimportEntity> entityList){
		//carinfo表
		List<TbCarinfoEntity> tbcarinfoList= new ArrayList<TbCarinfoEntity>();
		//错误列表返回
		List<TmCarinfoimportWrongView> importWrongList = new ArrayList<>();
		//日志表
		List<TbCarcirculationEntity> tbCarcirculationList= new ArrayList<>();
		//所有经销商名称
		EntityWrapper<TbDealerinfoEntity> ewDealer = new EntityWrapper<>();
		ewDealer.setSqlSelect("name");
		List<Object> dealerList = tbDealerinfoService.selectObjs(ewDealer);
		//车辆信息所有车架号
		EntityWrapper<TbCarinfoEntity> ewCar = new EntityWrapper<>();
		ewCar.setSqlSelect("vinnumber");
		List<Object> carinfoVinList = tbCarinfoService.selectObjs(ewCar);
		//导入车架号重复号码
		List<String> importVinList=entityList.stream().map(TmCarinfoimportEntity::getVinnumber).collect(Collectors.toList());
		Set<String> set = new HashSet<>(importVinList);
		Collection rs = CollectionUtils.disjunction(importVinList, set);
		importVinList = new ArrayList<>(rs);
		
		for(TmCarinfoimportEntity car : entityList){
			TmCarinfoimportWrongView wrongView = new TmCarinfoimportWrongView();
			wrongView.setDealerName(car.getDealername());
			wrongView.setRowno(car.getRowno());
			wrongView.setVinNumber(car.getVinnumber());
			String remark = "";
			//判断错误数据
			if(!StringUtil.isEmpty(car.getVinnumber())){
				remark = remark.concat("车架号不能为空");
			} else if(!StringUtil.isVinNumber(car.getVinnumber())){
				remark = StringUtil.isEmpty(remark) ? remark.concat(",车架号为17位包含数字和字母") : remark.concat("车架号为17位包含数字和字母");
			} else {
				if(importVinList.contains(car.getVinnumber())){
					remark = StringUtil.isEmpty(remark) ? remark.concat(",车架号重复") : remark.concat("车架号重复");
				}
				if(carinfoVinList.contains(car.getVinnumber())){
					remark = StringUtil.isEmpty(remark) ? remark.concat(",车架号已经存在") : remark.concat("车架号已经存在");
				}
			}
			if(!dealerList.contains(car.getDealername())){
				remark = StringUtil.isEmpty(remark) ? remark.concat(",经销商不存在") : remark.concat("经销商不存在");
			}
			if(StringUtil.isEmpty(remark)){
				wrongView.setRemark("错误原因：".concat(remark));
				importWrongList.add(wrongView);
			}
			
			if(null != importWrongList && !importWrongList.isEmpty()){
				continue;
			} else {
				EntityWrapper<TbDealerinfoEntity> ew = new EntityWrapper<>();
				ew.eq("name", car.getDealername());
				TbDealerinfoEntity dealer = tbDealerinfoService.selectView(ew);
				//carinfo表
				TbCarinfoEntity tbCarinfoEntity = new TbCarinfoEntity();
				tbCarinfoEntity.setVinnumber(car.getVinnumber());
				tbCarinfoEntity.setCarstatus(0);
				tbCarinfoEntity.setDepartid(dealer.getDeptid());
				tbCarinfoEntity.setDealerid(dealer.getId());
				tbCarinfoEntity.setDealercode(dealer.getCode());
				tbCarinfoEntity.setDealername(dealer.getName());
				tbcarinfoList.add(tbCarinfoEntity);
				//日志表
				SysUserEntity sysUserEntity = sysUserService.selectById(car.getUserid());
				TbCarcirculationEntity tbCarcirculationEntity = new TbCarcirculationEntity<>();
				tbCarcirculationEntity.setVinnumber(car.getVinnumber());
				tbCarcirculationEntity.setCircutype(0);
				tbCarcirculationEntity.setOperateid(car.getUserid());
				tbCarcirculationEntity.setOperator(sysUserService.selectById(car.getUserid()).getUsername());
				tbCarcirculationList.add(tbCarcirculationEntity);
				
			}
		}

		//错误数据为空插入数据
		if(null == importWrongList || importWrongList.isEmpty()){
			tbCarcirculationService.insertBatch(tbCarcirculationList, tbCarcirculationList.size());
			tbCarinfoService.insertEntityList(tbcarinfoList);
		}
		
		return importWrongList;
	}
	
	@Override
	public List<TmCarinfoimportView> selectListView(Wrapper<TmCarinfoimportEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}
}
