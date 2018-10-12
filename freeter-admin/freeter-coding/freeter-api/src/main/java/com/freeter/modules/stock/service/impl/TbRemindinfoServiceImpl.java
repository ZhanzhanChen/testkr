package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.HttpContextUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.TbRemindinfoDao;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbDevicestatusEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViFlowstepEntity;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.service.TbDevicestatusService;
import com.freeter.modules.stock.service.TbRemindinfoService;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;
import com.freeter.utils.StatusConvert;
import com.freeter.utils.StringUtil;
import com.freeter.modules.stock.entity.view.TbRemindinfoView;


@Service("tbRemindinfoService")
public class TbRemindinfoServiceImpl extends ServiceImpl<TbRemindinfoDao, TbRemindinfoEntity> implements TbRemindinfoService {

	@Autowired
	private TbDevicestatusService tbDevicestatusService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private TbCarcirculationService tbCarcirculationService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbRemindinfoEntity> page = this.selectPage(
                new Query<TbRemindinfoEntity>(params).getPage(),
                new EntityWrapper<TbRemindinfoEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    @DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbRemindinfoEntity> wrapper) {
		  Page<TbRemindinfoView> page =new Query<TbRemindinfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,
	        		wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	@DataFilter(subDept = true, user = false)
	public List<TbRemindinfoView> selectListView(Map<String, String> map,EntityWrapper<TbRemindinfoEntity> ew) {
		return baseMapper.selectListView(ew.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
	}

	@Override
	public TbRemindinfoView selectView(Wrapper<TbRemindinfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	@DataFilter(subDept = true, user = false)
   	public Boolean updateAllIsread(Map<String, Object> map){
		TbRemindinfoEntity remind = new TbRemindinfoEntity<>();
 		remind.setIsread(1);
 		int value = baseMapper.update(remind, 
 				new EntityWrapper<TbRemindinfoEntity>().addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
		return value > 0?true:false;
	}
	
	@Override
	@Transactional
	public Boolean handle(TbRemindinfoEntity entity){
		//查询报警信息
		TbRemindinfoEntity info = baseMapper.selectById(entity.getId());
		//查询未处理报警数量
		EntityWrapper<TbRemindinfoEntity> ewp = new EntityWrapper<>();
		ewp.ne("remindstatus", 2);
		ewp.eq("vinnumber", info.getVinnumber());
		int count = baseMapper.selectCount(ewp);
		
		//remark为空时，插入空格,更新时覆盖原先的数据
		if(!StringUtil.isEmpty(entity.getRemark())){
			entity.setRemark(" ");
		}
		//更新报警表处理状态
		int value = baseMapper.updateById(entity);
		
		boolean flag = false;
		TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
		
		if(entity.getRemindstatus() == 2 && count == 1){//报警处理，只有一条报警记录时，更新设备状态
			EntityWrapper<TbDevicestatusEntity> ew = new EntityWrapper<TbDevicestatusEntity>();
			ew.eq("devicenumber", info.getDevicenumber());
			ew.eq("devicestatus", 1);
			List<TbDevicestatusEntity> list = tbDevicestatusService.selectList(ew);
			//更新设备表状态
			if (null != list && list.size() != 0) {
				TbDevicestatusEntity devicestatus = new TbDevicestatusEntity();
				devicestatus.setDevicestatus(0);
				flag = tbDevicestatusService.update(devicestatus, ew);
			}
			tbCarcirculationEntity.setCircutype(3);
		} else if (entity.getRemindstatus() == 2) {//报警处理
			tbCarcirculationEntity.setCircutype(3);
		} else if (entity.getRemindstatus() == 3) {//延时处理
			tbCarcirculationEntity.setCircutype(17);
		} else if (entity.getRemindstatus() == 1) {//报警处理中
			tbCarcirculationEntity.setCircutype(18);
		}
		//写日志
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		tbCarcirculationEntity.setVinnumber(info.getVinnumber());
		tbCarcirculationEntity.setRemark(null == entity.getRemark() || entity.getRemark().length() == 0 ? "" : entity.getRemark());
		tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
		tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
		flag = tbCarcirculationService.insert(tbCarcirculationEntity);
		
		return flag;
	}
	
	@Override
	@Transactional
	public Boolean batchhandle(List<TbRemindinfoEntity> list){
		//查询报警信息
		List<String> arrayList = new ArrayList<>();
		List<TbCarcirculationEntity> tbCarcirculationEntityList = new ArrayList<>();
		for (TbRemindinfoEntity tbRemindinfoEntity : list) {
			String str = tbRemindinfoEntity.getId();
			arrayList.add(str);
			if(!StringUtil.isEmpty(tbRemindinfoEntity.getRemark())){
				tbRemindinfoEntity.setRemark(" ");
			}
		}
		boolean b = this.updateBatchById(list);
		List<TbRemindinfoEntity> tbRemindinfoList = baseMapper.selectBatchIds(arrayList); 
		// 查询用户信息
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		Long operateid=Long.valueOf(userId);
		String operator=sysUserService.selectById(userId).getUsername();
		// 保存流程日志
		for (TbRemindinfoEntity tbRemindinfoEntity : tbRemindinfoList) {
			TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
			tbCarcirculationEntity.setRemark(null == tbRemindinfoEntity.getRemark() || tbRemindinfoEntity.getRemark().length() == 0 ? "" : tbRemindinfoEntity.getRemark());
		    tbCarcirculationEntity.setVinnumber(tbRemindinfoEntity.getVinnumber());
		    tbCarcirculationEntity.setOperateid(operateid);
			tbCarcirculationEntity.setOperator(operator);
		    if (tbRemindinfoEntity.getRemindstatus() == 2) {//报警处理
				tbCarcirculationEntity.setCircutype(3);
			} else if (tbRemindinfoEntity.getRemindstatus() == 3) {//延时处理
				tbCarcirculationEntity.setCircutype(17);
			} else if (tbRemindinfoEntity.getRemindstatus() == 1) {//报警处理中
				tbCarcirculationEntity.setCircutype(18);
			}
		    tbCarcirculationEntityList.add(tbCarcirculationEntity);
		}
		tbCarcirculationService.insertBatch(tbCarcirculationEntityList);
		// 更新设备状态
		Set<String> set = new HashSet<String>();
		for (TbRemindinfoEntity tbRemindinfoEntity : tbRemindinfoList) {
			set.add(tbRemindinfoEntity.getDevicenumber());
		}
		List<TbDevicestatusEntity> devicestatusList = new ArrayList<>();
		for (String str : set) {
			EntityWrapper<TbRemindinfoEntity> ewp = new EntityWrapper<>();
			ewp.ne("remindstatus",2);
			ewp.eq("devicenumber",str);
			int count = baseMapper.selectCount(ewp);
			if (count==0) {
				TbDevicestatusEntity devicestatus = new TbDevicestatusEntity();
				devicestatus.setDevicestatus(0);
				devicestatus.setDevicenumber(str);
				devicestatusList.add(devicestatus);	
			}	
		}
		if(devicestatusList.size()!=0) {
		tbDevicestatusService.updateBatchById(devicestatusList);
		}
		return true;
	}
	
	@Override
	@Transactional
	public List<TbCarcirculationEntity> handleRemindByVin(List<String> list, List<ViFlowstepEntity> listFlow, SysUserEntity sysUserEntity){
		List<TbCarcirculationEntity> remindcarcirlist = new ArrayList<>();
		EntityWrapper<TbRemindinfoEntity> enWrapper = new EntityWrapper<TbRemindinfoEntity>();
		enWrapper.in("vinnumber", list);
		enWrapper.ne("RemindStatus", 2);
		List<TbRemindinfoEntity> listRemind = baseMapper.selectList(enWrapper);
		if(null != listRemind && !listRemind.isEmpty()){
			//获取查询的车架号
			Set<String> set = listRemind.stream().map(TbRemindinfoEntity::getVinnumber).collect(Collectors.toSet());
			//记录日志
			for(String str : set){
				TbCarcirculationEntity carcir= new TbCarcirculationEntity<>();
				carcir.setVinnumber(str);
				carcir.setCircutype(StatusConvert.detailStatusNoToCircutypeNo(listFlow.get(0).getActionno().intValue()));
				carcir.setRemark("车辆改变为" + StatusConvert.carDetailStatus(listFlow.get(0).getActionno().intValue()) + "状态,解除报警.");
				carcir.setOperateid(sysUserEntity.getUserId());
				carcir.setOperator(sysUserEntity.getUsername());
				remindcarcirlist.add(carcir);
			}
			//更新报警信息表
			TbRemindinfoEntity remindinfoEntity = new TbRemindinfoEntity<>();
			remindinfoEntity.setRemindstatus(2);
			remindinfoEntity.setDeleted(1);
			EntityWrapper<TbRemindinfoEntity> ewupdate = new EntityWrapper<TbRemindinfoEntity>();
			ewupdate.in("vinnumber", set);
			ewupdate.ne("RemindStatus", 2);
			ewupdate.ne("RemindType", 10);
			ewupdate.eq("deleted", 0);
			baseMapper.update(remindinfoEntity, ewupdate);
			//获取查询报警的设备号
			set = listRemind.stream().map(TbRemindinfoEntity::getDevicenumber).collect(Collectors.toSet());
			//查询有设备未拆除的报警并排除
			EntityWrapper<TbRemindinfoEntity> ewselect = new EntityWrapper<TbRemindinfoEntity>();
			ewselect.in("vinnumber", set);
			ewselect.eq("RemindType", 10);
			ewupdate.eq("deleted", 0);
			List<TbRemindinfoEntity> typelist = selectList(enWrapper);
			Set<String> typeset = new HashSet<>();
			if(null != typelist && !typelist.isEmpty()){
				  typeset = typelist.stream().map(TbRemindinfoEntity::getDevicenumber).collect(Collectors.toSet());
				  set.removeAll(typeset);
			}
			//更新设备状态
			if(null != set && !set.isEmpty()){
				EntityWrapper<TbDevicestatusEntity> ewdevice = new EntityWrapper<TbDevicestatusEntity>();
				ewdevice.in("devicenumber", set);
				ewdevice.eq("devicestatus", 0);
				TbDevicestatusEntity devicestatus = new TbDevicestatusEntity();
				devicestatus.setDevicestatus(0);
				tbDevicestatusService.update(devicestatus, ewdevice);
			}
		}
		return remindcarcirlist;
	}
	
}
	

