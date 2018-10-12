package com.freeter.modules.stock.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.freeter.common.validator.ValidatorUtils;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.modules.stock.entity.model.ViDevicebandlogModel;
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;

import com.freeter.modules.stock.entity.ViDevicebandlogEntity;
import com.freeter.modules.stock.service.ViDevicebandlogService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 *api接口
 * @author czz
 * @date 2018-08-20 19:27:39
 */
@RestController
@RequestMapping("videvicebandlog")
@Api(tags="车辆监管接口(金融公司)")
public class ViDevicebandlogController {
    @Autowired
    private ViDevicebandlogService viDevicebandlogService;

    /**
     * 信息
     */
    @PostMapping("/info")
    @ApiOperation("OBD所属查询")
    @Login
    public R info(@RequestBody ViDevicebandlogEntity log){
        EntityWrapper<ViDevicebandlogEntity> ew = new EntityWrapper<>();
        ew.eq("devicenumber", log.getDevicenumber());
        ViDevicebandlogEntity entity = viDevicebandlogService.selectOne(ew);
        return R.ok().put("data", entity);
    }

}
