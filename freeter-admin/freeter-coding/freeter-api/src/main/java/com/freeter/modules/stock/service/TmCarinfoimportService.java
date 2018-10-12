package com.freeter.modules.stock.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.modules.stock.entity.TmCarinfoimportEntity;
import com.freeter.modules.stock.entity.view.TmCarinfoimportView;
import com.freeter.modules.stock.entity.view.TmCarinfoimportWrongView;


/**
 * 发车信息导入临时表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-14 17:31:11
 */
public interface TmCarinfoimportService extends IService<TmCarinfoimportEntity> {

	List<TmCarinfoimportWrongView> importExcel(List<TmCarinfoimportEntity> tc);
	
	List<TmCarinfoimportView> selectListView(Wrapper<TmCarinfoimportEntity> wrapper);
}

