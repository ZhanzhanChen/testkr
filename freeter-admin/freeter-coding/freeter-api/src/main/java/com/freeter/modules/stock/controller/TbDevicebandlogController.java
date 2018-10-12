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
import com.freeter.modules.stock.entity.model.TbDevicebandlogModel;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbDevicebandlogEntity;
import com.freeter.modules.stock.service.TbDevicebandlogService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 设备状态表
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 14:53:27
 */
@RestController
@RequestMapping("tbdevicebandlog")
@Api(tags="设备状态表接口")
public class TbDevicebandlogController {
    @Autowired
    private TbDevicebandlogService tbDevicebandlogService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询设备状态表")
    public R page(@RequestParam Map<String, Object> params,TbDevicebandlogModel tbDevicebandlogModel){
 
        EntityWrapper< TbDevicebandlogEntity> ew = new EntityWrapper< TbDevicebandlogEntity>();
        TbDevicebandlogEntity tbDevicebandlog = new  TbDevicebandlogEntity( tbDevicebandlogModel);
     	ew.allEq(MPUtil.allEQMapPre( tbDevicebandlog, "tbDevicebandlog")); 
    	PageUtils page = tbDevicebandlogService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }

}
