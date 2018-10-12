package com.freeter.modules.stock.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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
public interface TmCarinfoimportDao extends BaseMapper<TmCarinfoimportEntity> {
	
    List<TmCarinfoimportWrongView> importCarInfo(@Param("imdeptid") Long imdeptid, @Param("userid") Long userid);
    
    List<TmCarinfoimportWrongView> importCarInfo(Map<String, Object> map);
    
    List<TmCarinfoimportView> selectListView(@Param("ew") Wrapper<TmCarinfoimportEntity> wrapper);
}
