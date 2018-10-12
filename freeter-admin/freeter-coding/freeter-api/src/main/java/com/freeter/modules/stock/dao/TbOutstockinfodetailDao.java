package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfodetailModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfodetailModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;


/**
 * 特殊出库明细
 * 
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
public interface TbOutstockinfodetailDao extends BaseMapper<TbOutstockinfodetailEntity> {
		
	Integer saveOutstockinfoDetail(TbOutstockinfodetailModel outstockDetail);
}
