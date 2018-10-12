package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.BasicDistrictEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;


/**
 * 基础_行政区划表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 09:13:27
 */
public interface BasicDistrictDao extends BaseMapper<BasicDistrictEntity> {
	
	List<BasicDistrictEntity> selectListByLevelNo(String levelno);
}
