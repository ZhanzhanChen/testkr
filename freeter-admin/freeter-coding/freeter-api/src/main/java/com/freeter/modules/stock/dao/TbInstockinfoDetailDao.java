package com.freeter.modules.stock.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfodetailModel;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;

public interface TbInstockinfoDetailDao extends BaseMapper<TbInstockinfodetailEntity> {

	Integer saveInstockinfoDetail(TbInstockinfodetailModel instockinfodetailModel);

	List<TbInstockinfodetailEntity> selectinstockinfoDetailListByStatus(Pagination page,Map map);

	
}
