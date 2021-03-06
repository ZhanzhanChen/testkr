package com.freeter.modules.sys.controller;

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
import com.freeter.modules.sys.entity.model.SysRoleModel;
import com.freeter.common.utils.MPUtil;

import com.freeter.modules.sys.entity.SysRoleEntity;
import com.freeter.modules.sys.service.SysRoleService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-20 16:56:09
 */
@RestController
@RequestMapping("sysrole")
@Api(tags="角色接口")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询角色")
    public R page(@RequestParam Map<String, Object> params,SysRoleModel sysRoleModel){
 
        EntityWrapper< SysRoleEntity> ew = new EntityWrapper< SysRoleEntity>();
        SysRoleEntity sysRole = new  SysRoleEntity(sysRoleModel);
     	ew.allEq(MPUtil.allEQMapPre( sysRole, "sysRole")); 
    	PageUtils page = sysRoleService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }

    /**
     * 信息
     */
    @GetMapping("/info/{roleId}")
    @ApiOperation("获取相应的角色")
    public R info(@PathVariable("roleId") Long roleId){
        SysRoleEntity sysRole = sysRoleService.selectById(roleId);

        return R.ok().put("sysRole", sysRole);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加角色数据")
    public R saveJson(@RequestBody SysRoleEntity sysRole){
    	ValidatorUtils.validateEntity(sysRole);
        sysRoleService.insert(sysRole);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加角色数据 （参数：表单格式）")
    public R saveForm(SysRoleEntity sysRole){
    	ValidatorUtils.validateEntity(sysRole);
        sysRoleService.insert(sysRole);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改角色数据（参数：json格式）")
    public R updateJson(@RequestBody SysRoleEntity sysRole){
        ValidatorUtils.validateEntity(sysRole);
        sysRoleService.updateAllColumnById(sysRole);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改角色数据（参数：表单格式）")
    public R updateForm(SysRoleEntity sysRole){
        ValidatorUtils.validateEntity(sysRole);
        sysRoleService.updateAllColumnById(sysRole);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除角色数据")
    public R delete(@RequestBody Long[] roleIds){
        sysRoleService.deleteBatchIds(Arrays.asList(roleIds));
        return R.ok();
    }

}
