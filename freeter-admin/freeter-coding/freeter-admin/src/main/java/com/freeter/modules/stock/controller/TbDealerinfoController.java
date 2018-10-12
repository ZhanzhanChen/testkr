package com.freeter.modules.stock.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.freeter.common.validator.ValidatorUtils;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.freeter.modules.stock.entity.model.TbDealerinfoModel;

import com.freeter.common.annotation.SysLog;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.service.TbDealerinfoService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 经销商信息
 *api接口
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-25 09:26:23
 */
@RestController
@RequestMapping("tbdealerinfo")
@Api(tags="经销商信息接口")
public class TbDealerinfoController {
    @Autowired
    private TbDealerinfoService tbDealerinfoService;
 
    
    /**
     * 
     * 查询经销商信息
     */
    @PostMapping("/list")
    @RequiresPermissions("tbdealerinfo:list")
    @ApiOperation(value="查询",notes="经销商信息查询")
    @SysLog("查询经销商信息")
    public R queryDealerinfoList(@RequestBody Map<String, String> params){
    	List<TbDealerinfoEntity> dealerList = tbDealerinfoService.selectDealerList(params);
        return R.ok().put("data",  dealerList);
        
    }
	
	
}
