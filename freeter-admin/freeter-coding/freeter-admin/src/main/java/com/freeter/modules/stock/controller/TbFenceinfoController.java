package com.freeter.modules.stock.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.freeter.common.validator.ValidatorUtils;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Polygon;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.common.annotation.DataFilter;
import com.freeter.common.annotation.SysLog;
import com.freeter.common.utils.MPUtil;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 围栏信息表
 *api接口
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-30 13:44:52
 */
@RestController
@RequestMapping("tbfenceinfo")
@Api(tags="围栏信息表接口")
public class TbFenceinfoController {
    @Autowired
    private TbFenceinfoService tbFenceinfoService;
 
    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value="查询",notes="查询围栏信息")
    @DataFilter(subDept = true, user = false)
    public R info(@PathVariable("id") String id){
        TbFenceinfoEntity tbFenceinfo = tbFenceinfoService.selectTbFenceinfoById(id);
        return R.ok().put("tbFenceinfo", tbFenceinfo);
    }

   /* *//**
     * 保存
     *//*
    @PostMapping("/save")
    @RequiresPermissions("tbfenceinfo:save")
    @ApiOperation(value="添加",notes="添加围栏信息")
    @SysLog("添加围栏信息")
    public R addDealerinfo(@RequestBody TbFenceinfoEntity tbFenceinfo){
    	
    	ValidatorUtils.validateEntity(tbFenceinfo);
    	int fenceinfo = tbFenceinfoService.saveTbFenceinfo(tbFenceinfo);
    	if (fenceinfo==0) {
    		return R.error();
			
		} else {
			return R.ok();
		}
        
    }*/
    /**
     * 添加
     */
    @PostMapping("/save")
   /* @RequiresPermissions("tbfenceinfo:save")*/
    @ApiOperation(value="添加",notes="添加围栏信息")
    @SysLog("添加围栏信息")
    public R addDealerinfo(@RequestBody TbFenceinfoEntity tbFenceinfo){
    	
    	
    	String dealerid = tbFenceinfo.getDealerid();
    	String fencepolygon = tbFenceinfo.getFencepolygon();
    	Map<String,String> map=new HashMap<String,String>();
    	map.put("dealerid",dealerid);
    	map.put("fencepolygon",fencepolygon);
    	/*map.put("result",null);*/
    	String result = tbFenceinfoService.callFenceinfo(map);
    	String first = result.substring(0, 1);
    	if(first.equals(0)) {return R.ok(); }else {return R.error();}
    		
    	
    	
    	/*ValidatorUtils.validateEntity(tbFenceinfo);
    	int fenceinfo = tbFenceinfoService.saveTbFenceinfo(tbFenceinfo);
    	if (fenceinfo==0) {
    		return R.error();
			
		} else {
			return R.ok();
		}
        
    }*/
    }
    
    
    /**
     * 
     * 分页查询围栏信息
     */
    @PostMapping("/page")
    /*@RequiresPermissions("tbdealerinfo:list")*/
    @ApiOperation(value="查询",notes="经销商信息查询")
    @SysLog("查询围栏列表信息")
    public R queryFenceinfo(@RequestBody Map<String, String> map){
    	int currentPage=Integer.parseInt(map.get("currentPage"));
    	int num=Integer.parseInt(map.get("num"));
    	PageUtils page = tbFenceinfoService.selectFenceinfoList(new Page(currentPage,num),map);
        return R.ok().put("data",  page.getList()).put("totalcount", page.getTotalCount());
        
    }
	
    
}
