package com.freeter.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.sys.dao.SysRoleDao;
import com.freeter.modules.sys.entity.SysRoleEntity;
import com.freeter.modules.sys.service.SysRoleService;
import com.freeter.modules.sys.entity.view.SysRoleView;


@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleEntity> page = this.selectPage(
                new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SysRoleEntity> wrapper) {
		  Page<SysRoleView> page =new Query<SysRoleView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}

    @Override
	public List<SysRoleView> selectListView(Wrapper<SysRoleEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SysRoleView selectView(Wrapper<SysRoleEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
