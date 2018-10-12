package com.freeter.modules.stock.controller;

import java.util.Arrays;
import java.util.HashMap;
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
import com.freeter.modules.stock.entity.model.ViFenceinalarmModel;
import com.freeter.annotation.DataFilter;
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.ViFenceinalarmEntity;
import com.freeter.modules.stock.service.ViFenceinalarmService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 *api接口
 * @author czz
 * @date 2018-08-21 16:11:39
 */
@RestController
@RequestMapping("vifenceinalarm")
@Api(tags="车辆监管接口(金融公司)")
public class ViFenceinalarmController {
    @Autowired
    private ViFenceinalarmService viFenceinalarmService;

    /**
     * 入库通知数量--未添加数据权限
     */
//    @PostMapping("/count")
//    @ApiOperation("入库通知数量")
//    @Login
    public R count(){
    	EntityWrapper<ViFenceinalarmEntity> ew = new EntityWrapper<>();
    	ew.eq("isread", 0);
        int count = viFenceinalarmService.selectCount(ew);
        return R.ok().put("count", count);
    }

    /**
     * 入库通知列表
     */
//    @PostMapping("/list")
//    @ApiOperation("入库通知列表")
//    @Login
    public R list(){
    	EntityWrapper<ViFenceinalarmEntity> ew = new EntityWrapper<>();
    	ew.eq("isread", 0);
        List<ViFenceinalarmEntity> list = viFenceinalarmService.selectList(ew);
        return R.ok().put("data", list);
    }
    
    //@PostMapping("/clean")
    //@ApiOperation("清空入库通知")
    //@Login
    public R clean(){
    	
    	boolean flag = viFenceinalarmService.clean();
    	if(flag){
    		return R.ok();
    	}else{
    		return R.error();
    	}
    }
    
    /**
     * 经销商入库通知数量
     */
    @PostMapping("/dealercount")
    @ApiOperation("经销商入库通知数量")
    @Login
    public R dealercount(){
    	Map<String, Object> map= new HashMap<>();
        int count = viFenceinalarmService.selectNoticeCount(map);
        return R.ok().put("count", count);
    }

    /**
     * 经销商入库通知列表
     */
    @PostMapping("/dealerlist")
    @ApiOperation("经销商入库通知列表")
    @Login
    public R dealerlist(){
    	Map<String, Object> map= new HashMap<>();
        List<ViFenceinalarmEntity> list = viFenceinalarmService.selectDealerList(map);
        return R.ok().put("data", list);
    }
    
    /**
     * 经销商清空入库通知
     * @return
     */
    @PostMapping("/dealerclean")
    @ApiOperation("经销商清空入库通知")
    @Login
    public R dealerclean(){
    	Map<String, Object> map= new HashMap<>();
    	boolean flag = viFenceinalarmService.dealerClean(new HashMap<>());
    	if(flag){
    		return R.ok();
    	}else{
    		return R.error("清空入库通知错误");
    	}
    }
    
}
