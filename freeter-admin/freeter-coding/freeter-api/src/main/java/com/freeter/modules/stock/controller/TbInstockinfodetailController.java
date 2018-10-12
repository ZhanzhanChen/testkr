package com.freeter.modules.stock.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.service.TbInstockinfodetailService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 特殊入库明细表
 *api接口
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
@RestController
@RequestMapping("tbinstockinfodetail")
@Api(tags="特殊入库明细表接口")
public class TbInstockinfodetailController {
    @Autowired
    private TbInstockinfodetailService tbInstockinfodetailService;
 
    
    /**
   	 * 
   	 * 分页查询特殊入库信息表
   	 */
   	@PostMapping("/page")
   	/*@RequiresPermissions("tbdealerinfo:list")*/
   	@ApiOperation(value="查询",notes="特殊入库明细查询")
   	/*@SysLog("查询特殊入库明细信息")*/
   	public R queryInstockDetaliinfoByStatus(@RequestBody Map<String, String> map){
   		int currentPage=Integer.parseInt(map.get("currentPage"));
   		int num=Integer.parseInt(map.get("num"));
   		PageUtils page = tbInstockinfodetailService.selectinstockinfoDetailListByStatus(new Page(currentPage,num),map);
   	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
   	    
   	}
	 
	
	
}
