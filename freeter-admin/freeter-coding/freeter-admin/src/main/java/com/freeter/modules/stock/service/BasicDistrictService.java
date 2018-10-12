package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.BasicDistrictEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



/**
 * 基础_行政区划表
 *
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-30 09:13:27
 */
public interface BasicDistrictService extends IService<BasicDistrictEntity> {

	List<BasicDistrictEntity> selectListByLevelNo(String levelno);
}

