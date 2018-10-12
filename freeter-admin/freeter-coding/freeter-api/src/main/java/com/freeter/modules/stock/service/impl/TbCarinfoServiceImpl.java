package com.freeter.modules.stock.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.DateUtils;
import com.freeter.common.utils.HttpContextUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.TbCarinfoDao;
import com.freeter.modules.stock.entity.TbAlarminfoEntity;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbCarfencestatusEntity;
import com.freeter.modules.stock.entity.TbCarinfoEntity;
import com.freeter.modules.stock.entity.TbDevicestatusEntity;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.ViFlowstepEntity;
import com.freeter.modules.stock.entity.model.TbCarModel;
import com.freeter.modules.stock.entity.model.TbCarinfoFenceModel;
import com.freeter.modules.stock.entity.view.TbCarinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.service.TbAlarminfoService;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.service.TbCarfencestatusService;
import com.freeter.modules.stock.service.TbCarinfoService;
import com.freeter.modules.stock.service.TbDevicestatusService;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.modules.stock.service.TbRemindinfoService;
import com.freeter.modules.stock.service.ViCarstatusinfoService;
import com.freeter.modules.stock.service.ViFlowstepService;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;
import com.freeter.utils.StatusConvert;

@Service("tbCarinfoService")
public class TbCarinfoServiceImpl extends ServiceImpl<TbCarinfoDao, TbCarinfoEntity> implements TbCarinfoService {

	@Autowired
	private TbCarcirculationService tbCarcirculationService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ViFlowstepService viFlowStepService;
	@Autowired
	private TbRemindinfoService tbRemindinfoService;
	@Autowired
	private TbCarfencestatusService tbCarfencestatusService;
	@Autowired
	private ViCarstatusinfoService viCarstatusinfoService;
	@Autowired
	private TbAlarminfoService tbAlarminfoService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TbCarinfoEntity> page = this.selectPage(new Query<TbCarinfoEntity>(params).getPage(),
				new EntityWrapper<TbCarinfoEntity>());
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbCarinfoEntity> wrapper) {
		Page<TbCarinfoView> page = new Query<TbCarinfoView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, wrapper));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
	}

	@Override
	public List<TbCarinfoView> selectListView(Wrapper<TbCarinfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbCarinfoView selectView(Wrapper<TbCarinfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public Integer insertEntityList(@Param("list") List<TbCarinfoEntity> list) {
		return baseMapper.insertEntityList(list);
	}

	@Override
	@Transactional
	public Boolean updateCarStatus(List<ViCarstatusinfoEntity> tbCarinfoList) {
		EntityWrapper<TbCarinfoEntity> ew = new EntityWrapper<TbCarinfoEntity>();
		List<String> vblist = tbCarinfoList.stream().map(ViCarstatusinfoEntity::getVinnumber)
				.collect(Collectors.toList());
		TbCarinfoEntity ewcar = new TbCarinfoEntity<>();
		ewcar.setCarstatus(tbCarinfoList.get(0).getDetailstatus());
		ew.in("vinnumber", vblist);
		// 更新车辆状态
		boolean flag = update(ewcar, ew);

		if (flag) {
			HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
			String userId = request.getAttribute("userId").toString();
			SysUserEntity sysUserEntity = sysUserService.selectById(userId);
			// 获取结束状态
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("departid", sysUserEntity.getDeptId());
			map.put("flag", 2);
			List<ViFlowstepEntity> listFlow = viFlowStepService.selectByMap(map);
			int finishStatus = listFlow.get(0).getActionno().intValue();
			// 处理报警表的日志
			List<TbCarcirculationEntity> remindcarcirlist = new ArrayList<>();
			// 处理有报警的vin码
			if (null != listFlow && finishStatus == tbCarinfoList.get(0).getDetailstatus()) {
				remindcarcirlist = tbRemindinfoService.handleRemindByVin(vblist, listFlow, sysUserEntity);
			}

			// 记录日志
			List<TbCarcirculationEntity> list = new ArrayList<>();
			for (int i = 0; i < tbCarinfoList.size(); i++) {
				TbCarcirculationEntity tbCarcirculationEntity = new TbCarcirculationEntity<>();
				tbCarcirculationEntity.setVinnumber(tbCarinfoList.get(i).getVinnumber());
				tbCarcirculationEntity.setCircutype(
						StatusConvert.detailStatusNoToCircutypeNo(tbCarinfoList.get(0).getDetailstatus()));
				tbCarcirculationEntity.setRemark(
						"车辆变为" + StatusConvert.carDetailStatus(tbCarinfoList.get(0).getDetailstatus()) + "状态");
				tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
				tbCarcirculationEntity.setOperator(sysUserEntity.getUsername());
				list.add(tbCarcirculationEntity);
			}

			remindcarcirlist.addAll(list);
			tbCarcirculationService.insertBatch(remindcarcirlist, remindcarcirlist.size());
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateCarStockIn(TbCarinfoFenceModel tbCarinfoFenceModel) {
		// 所有标记入库vin码
		List<String> vblist = tbCarinfoFenceModel.getData().stream().map(ViCarstatusinfoEntity::getVinnumber)
				.collect(Collectors.toList());
		// 更新车辆状态carinfo表
		EntityWrapper<TbCarinfoEntity> ew = new EntityWrapper<TbCarinfoEntity>();
		ew.in("vinnumber", vblist);
		TbCarinfoEntity ewcar = new TbCarinfoEntity<>();
		ewcar.setCarstatus(tbCarinfoFenceModel.getCarstatus());
		boolean flag = update(ewcar, ew);
		ew = null;

		// 查询需要更新的vin码
		EntityWrapper<TbCarfencestatusEntity> wp = new EntityWrapper<>();
		wp.in("vinnumber", vblist);
		wp.setSqlSelect("vinnumber");
		List<Object> updateCarfenceList = tbCarfencestatusService.selectObjs(wp);

		// 根据围栏ID查询围栏信息
		EntityWrapper<TbFenceinfoEntity> ewfenceinfo = new EntityWrapper<TbFenceinfoEntity>();
		ewfenceinfo.eq("id", tbCarinfoFenceModel.getId());
		List<TbFenceinfoEntity> listFence = viCarstatusinfoService.queryFenceinfoList(new HashMap<>(), ewfenceinfo);

		// 新增的车辆围栏状态表数据
		List<TbCarfencestatusEntity> carfencestatuslist = new ArrayList<>();
		for (int i = 0; i < tbCarinfoFenceModel.getData().size(); i++) {
			if (null != updateCarfenceList && !updateCarfenceList.isEmpty()) {
				if (!updateCarfenceList.contains(tbCarinfoFenceModel.getData().get(i).getVinnumber())) {
					TbCarfencestatusEntity entity = new TbCarfencestatusEntity<>();
					entity.setVinnumber(tbCarinfoFenceModel.getData().get(i).getVinnumber());
					entity.setDevicenumber(tbCarinfoFenceModel.getData().get(i).getDevicenumber());
					entity.setFenceid(listFence.get(0).getId());
					entity.setFencename(listFence.get(0).getFencename());
					entity.setFencestatus(1);
					entity.setLocationtype(0);
					entity.setActiontime(new Date());
					carfencestatuslist.add(entity);
				}
			} else {
				TbCarfencestatusEntity entity = new TbCarfencestatusEntity<>();
				entity.setVinnumber(tbCarinfoFenceModel.getData().get(i).getVinnumber());
				entity.setDevicenumber(tbCarinfoFenceModel.getData().get(i).getDevicenumber());
				entity.setFenceid(listFence.get(0).getId());
				entity.setFencename(listFence.get(0).getFencename());
				entity.setFencestatus(1);
				entity.setLocationtype(0);
				entity.setActiontime(new Date());
				carfencestatuslist.add(entity);
			}
		}
		if (null != carfencestatuslist && !carfencestatuslist.isEmpty()) {
			tbCarfencestatusService.insertBatch(carfencestatuslist, carfencestatuslist.size());
		}
		
		// 更新车辆围栏状态表数据
		if(null != updateCarfenceList && !updateCarfenceList.isEmpty()){
			EntityWrapper<TbCarfencestatusEntity> ewfence = new EntityWrapper<>();
			ewfence.in("vinnumber", updateCarfenceList);
			TbCarfencestatusEntity carfence = new TbCarfencestatusEntity<>();
			carfence.setFencename(listFence.get(0).getFencename());
			carfence.setFenceid(listFence.get(0).getId());
			carfence.setFencestatus(1);
			tbCarfencestatusService.update(carfence, ewfence);
		}
		
		if (flag) {
			HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
			String userId = request.getAttribute("userId").toString();
			SysUserEntity sysUserEntity = sysUserService.selectById(userId);
			// 操作流程列表
			List<TbCarcirculationEntity> carcirlist = new ArrayList<>();
			// 入库通知列表
			List<TbAlarminfoEntity> alarmlist = new ArrayList<>();
			for (int i = 0; i < tbCarinfoFenceModel.getData().size(); i++) {
				// 记录操作流程日志
				TbCarcirculationEntity tbCarcirculationEntity = new TbCarcirculationEntity<>();
				tbCarcirculationEntity.setVinnumber(tbCarinfoFenceModel.getData().get(i).getVinnumber());
				tbCarcirculationEntity
						.setCircutype(StatusConvert.detailStatusNoToCircutypeNo(tbCarinfoFenceModel.getCarstatus()));
				tbCarcirculationEntity
						.setRemark("车辆变为" + StatusConvert.carDetailStatus(tbCarinfoFenceModel.getCarstatus()) + "状态");
				tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
				tbCarcirculationEntity.setOperator(sysUserEntity.getUsername());
				carcirlist.add(tbCarcirculationEntity);
				// 记录入库通知
				TbAlarminfoEntity tbAlarminfoEntity = new TbAlarminfoEntity<>();
				tbAlarminfoEntity.setDealerid(tbCarinfoFenceModel.getData().get(i).getDealerid());
				tbAlarminfoEntity.setFenceid(tbCarinfoFenceModel.getId());
				tbAlarminfoEntity.setVinnumber(tbCarinfoFenceModel.getData().get(i).getVinnumber());
				tbAlarminfoEntity.setDevicenumber(tbCarinfoFenceModel.getData().get(i).getDevicenumber());
				tbAlarminfoEntity.setAlarmtype(1);
				tbAlarminfoEntity.setAlarmtime(new Date());
				tbAlarminfoEntity.setIsread(0);
				tbAlarminfoEntity.setDeleted(0);
				alarmlist.add(tbAlarminfoEntity);
			}
			tbAlarminfoService.insertBatch(alarmlist, alarmlist.size());
			tbCarcirculationService.insertBatch(carcirlist, carcirlist.size());
			return true;
		} else {
			return false;
		}
	}

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils selectCarinfoListByStatus(Map<String, Object> params, Wrapper<TbCarModel> wrapper) {
		Page<TbCarModel> page = new Query<TbCarModel>(params).getPage();
		page.setRecords(baseMapper.selectCarinfoListByStatus(page, wrapper
				.addFilterIfNeed(null != params.get(Constant.SQL_FILTER), (String) params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
	}

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils selectCarOutstockinfoListByStatus(Map<String, Object> params, Wrapper<TbCarModel> wrapper) {
		Page<TbCarModel> page = new Query<TbCarModel>(params).getPage();
		page.setRecords(baseMapper.selectCarOutstockinfoListByStatus(page, wrapper
				.addFilterIfNeed(null != params.get(Constant.SQL_FILTER), (String) params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
	}
}
