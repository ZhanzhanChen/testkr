package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.RequestMapToFilterForm;
import com.freeter.form.RulesForm;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.modules.stock.entity.model.TbCarcirculationModel;
import com.freeter.modules.stock.entity.model.TbCarcirculationPageModel;
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.utils.StatusConvert;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 车辆流转表
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
@RestController
@RequestMapping("tbcarcirculation")
@Api(tags="车辆监管接口(金融公司)")
public class TbCarcirculationController {
    @Autowired
    private TbCarcirculationService tbCarcirculationService;
 
}
