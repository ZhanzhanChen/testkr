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
import com.freeter.modules.stock.entity.model.TbOutstockinfodetailModel;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;
import com.freeter.modules.stock.service.TbOutstockinfodetailService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 特殊出库明细
 *api接口
 * @author ipx
 * @email
 * @date 2018-08-07 20:24:56
 */
@RestController
@RequestMapping("tboutstockinfodetail")
@Api(tags="特殊出库明细接口")
public class TbOutstockinfodetailController {
    @Autowired
    private TbOutstockinfodetailService tbOutstockinfodetailService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询特殊出库明细")
    public R page(@RequestParam Map<String, Object> params,TbOutstockinfodetailModel tbOutstockinfodetailModel){
 
        EntityWrapper< TbOutstockinfodetailEntity> ew = new EntityWrapper< TbOutstockinfodetailEntity>();
        TbOutstockinfodetailEntity tbOutstockinfodetail = new  TbOutstockinfodetailEntity( tbOutstockinfodetailModel);
     	ew.allEq(MPUtil.allEQMapPre( tbOutstockinfodetail, "tbOutstockinfodetail")); 
    	PageUtils page = tbOutstockinfodetailService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }
	
    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的特殊出库明细")
    public R info(@PathVariable("id") String id){
        TbOutstockinfodetailEntity tbOutstockinfodetail = tbOutstockinfodetailService.selectById(id);

        return R.ok().put("tbOutstockinfodetail", tbOutstockinfodetail);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加特殊出库明细数据")
    public R saveJson(@RequestBody TbOutstockinfodetailEntity tbOutstockinfodetail){
    	ValidatorUtils.validateEntity(tbOutstockinfodetail);
        tbOutstockinfodetailService.insert(tbOutstockinfodetail);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加特殊出库明细数据 （参数：表单格式）")
    public R saveForm(TbOutstockinfodetailEntity tbOutstockinfodetail){
    	ValidatorUtils.validateEntity(tbOutstockinfodetail);
        tbOutstockinfodetailService.insert(tbOutstockinfodetail);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改特殊出库明细数据（参数：json格式）")
    public R updateJson(@RequestBody TbOutstockinfodetailEntity tbOutstockinfodetail){
        ValidatorUtils.validateEntity(tbOutstockinfodetail);
        tbOutstockinfodetailService.updateAllColumnById(tbOutstockinfodetail);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改特殊出库明细数据（参数：表单格式）")
    public R updateForm(TbOutstockinfodetailEntity tbOutstockinfodetail){
        ValidatorUtils.validateEntity(tbOutstockinfodetail);
        tbOutstockinfodetailService.updateAllColumnById(tbOutstockinfodetail);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除特殊出库明细数据")
    public R delete(@RequestBody String[] ids){
        tbOutstockinfodetailService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
