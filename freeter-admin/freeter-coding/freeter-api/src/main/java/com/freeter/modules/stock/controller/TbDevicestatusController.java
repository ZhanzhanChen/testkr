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


import com.freeter.modules.stock.entity.TbDevicestatusEntity;
import com.freeter.modules.stock.service.TbDevicestatusService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 设备状态表
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 16:54:34
 */
@RestController
@RequestMapping("tbdevicestatus")
@Api(tags="设备状态表接口")
public class TbDevicestatusController {
    @Autowired
    private TbDevicestatusService tbDevicestatusService;

}
