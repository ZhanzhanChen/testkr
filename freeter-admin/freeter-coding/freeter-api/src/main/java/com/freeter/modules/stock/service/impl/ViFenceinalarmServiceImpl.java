package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.ViFenceinalarmDao;
import com.freeter.modules.stock.entity.TbAlarminfoEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViFenceinalarmEntity;
import com.freeter.modules.stock.service.TbAlarminfoService;
import com.freeter.modules.stock.service.TbRemindinfoService;
import com.freeter.modules.stock.service.ViFenceinalarmService;
import com.freeter.utils.Constant;
import com.freeter.modules.stock.entity.view.ViFenceinalarmView;


@Service("viFenceinalarmService")
public class ViFenceinalarmServiceImpl extends ServiceImpl<ViFenceinalarmDao, ViFenceinalarmEntity> implements ViFenceinalarmService {

	@Autowired
	private TbAlarminfoService alarService;
	@Autowired
	private TbRemindinfoService remindService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ViFenceinalarmEntity> page = this.selectPage(
                new Query<ViFenceinalarmEntity>(params).getPage(),
                new EntityWrapper<ViFenceinalarmEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViFenceinalarmEntity> wrapper) {
		  Page<ViFenceinalarmView> page =new Query<ViFenceinalarmView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}

    @Override
	public List<ViFenceinalarmView> selectListView(Wrapper<ViFenceinalarmEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ViFenceinalarmView selectView(Wrapper<ViFenceinalarmEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	@Override
	@Transactional
	public Boolean clean(){
		TbAlarminfoEntity alar = new TbAlarminfoEntity();
		alar.setIsread(1);
	 	boolean flag = alarService.update(alar, null);
	 	boolean fg= false;
	 	if(flag){
	 		TbRemindinfoEntity remind = new TbRemindinfoEntity<>();
	 		remind.setIsread(1);
	 		fg= remindService.update(remind, null);
	 	}
	 	return fg;
	}
	
	@Override
	@DataFilter(subDept = true, user = false)
	public Integer selectNoticeCount(Map<String, Object> map){
		EntityWrapper<ViFenceinalarmEntity> ew = new EntityWrapper<>();
		ew.eq("isread", 0);
		
		return baseMapper.selectCount(ew.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
	}
	
	@Override
	@Transactional
	public Boolean dealerClean(Map<String, Object> map){
		EntityWrapper<ViFenceinalarmEntity> ew = new EntityWrapper<ViFenceinalarmEntity>();
		ew.eq("isread", 0);
		ew.eq("AlarmType", 1);
		List<Object> list = baseMapper.selectObjs(ew.
				addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
		Map<String, List<Object>> m = new HashMap<>();
		m.put("id", list);
		boolean flag = alarService.updateAllIsread(m);
//		boolean fg= false;
//		if(flag){
//			fg = remindService.updateAllIsread(map);
//		}
		return flag;
   	}
   	
	@Override
	@DataFilter(subDept = true, user = false)
	public List<ViFenceinalarmEntity> selectDealerList(Map<String, Object> map){
		EntityWrapper<ViFenceinalarmEntity> ew = new EntityWrapper<>();
    	ew.eq("isread", 0);
        List<ViFenceinalarmEntity> list = baseMapper.selectList(
        		ew.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
        return list;
	}
}
