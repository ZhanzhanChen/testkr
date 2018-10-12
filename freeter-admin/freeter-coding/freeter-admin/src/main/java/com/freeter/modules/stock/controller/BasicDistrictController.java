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

import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.BasicDistrictEntity;
import com.freeter.modules.stock.service.BasicDistrictService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 基础_行政区划表
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 09:13:27
 */
@RestController
@RequestMapping("basicdistrict")
@Api(tags="基础_行政区划表接口")
public class BasicDistrictController {
    @Autowired
    private BasicDistrictService basicDistrictService;
 
	 
    /**
     * 信息
     */
    @GetMapping("/info/{levelno}")
    @ApiOperation("获取相应的基础_行政区划表")
    public R info(@PathVariable("levelno") String levelno){
        List<BasicDistrictEntity> basicDistrict = basicDistrictService.selectListByLevelNo(levelno);

        return R.ok().put("basicDistrict", basicDistrict);
    }

    
}
