package com.freeter.modules.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.annotation.Login;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.form.RequestPageJson;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbCarModel;
import com.freeter.modules.stock.entity.model.TbCarinfoFenceModel;
import com.freeter.modules.stock.service.TbCarinfoService;
import com.freeter.modules.stock.service.TbFenceinfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 车辆信息表
 *api接口
 * @author ipx
 * @email  
 * @date 2018-08-07 20:24:56
 */
@RestController
@RequestMapping("tbcarinfo")
@Api(tags="车辆信息表接口")
public class TbCarinfoController {
    @Autowired
    private TbCarinfoService tbCarinfoService;
    @Autowired
    private TbFenceinfoService tbFenceinfoService;
    /**
   	 * 
   	 * 分页查询已签收车辆
   	 */
    @Login
   	@PostMapping("/instockCarPage")
   	@ApiOperation(value="查询",notes="查询已签收车辆")
   	public R queryInstockCarinfoByStatus(@RequestBody RequestPageJson requestPageJson){
    	Map map = requestPageJson.get();
    	String vinnumber = (String) map.get("vinnumber");
    	EntityWrapper<TbCarModel> ew = new EntityWrapper<TbCarModel>();
    	if(vinnumber!=null) {
    		ew.eq("vinnumber",vinnumber);
    		
    	}
    	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageJson.getPageSize());
     	params.put("pageindex",requestPageJson.getPageIndex());
   		PageUtils page = tbCarinfoService.selectCarinfoListByStatus(params, ew);
   	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
   	    
   	}
    
    /**
   	 * 
   	 * 分页查询在库车辆
   	 */
    @Login
   	@PostMapping("/outstockCarPage")	
   	@ApiOperation(value="查询",notes="查询在库车辆")
   	public R queryOutstockCarinfoByStatus(@RequestBody RequestPageJson requestPageJson,HttpServletRequest request){
    	Map map = requestPageJson.get();
    	String vinnumber = (String) map.get("vinnumber");
    	EntityWrapper<TbCarModel> ew = new EntityWrapper<TbCarModel>();
    	if(vinnumber!=null) {
    		ew.eq("vinnumber",vinnumber);
    		
    	}
    	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageJson.getPageSize());
     	params.put("pageindex",requestPageJson.getPageIndex());
   		PageUtils page = tbCarinfoService.selectCarOutstockinfoListByStatus(params, ew);
   	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
   	    
   	}
 
    @PostMapping("/updatestatus")
    @ApiOperation(value="标记售出",notes="标记售出")
    @Login
    public R updateCarStatus(@RequestBody Map<String, List<ViCarstatusinfoEntity>> map){
    	List<ViCarstatusinfoEntity> list = new ArrayList<ViCarstatusinfoEntity>(map.get("data"));
//    	for(int i = 0; i < map.get("data").size(); i++){
//    		ViCarstatusinfoEntity entity = new ViCarstatusinfoEntity<>();
//    		entity.setVinnumber(map.get("data").get(i).getVinnumber());
//    		list.add(entity);
//    	}
//    	list.addAll(map.get("data"));
    	list.get(0).setDetailstatus(3);
        boolean flag = tbCarinfoService.updateCarStatus(list);
        if(flag){
        	return R.ok();
        }else{
        	return R.error("操作失败");
        }
    }
    
    @PostMapping("/updatecarin")
    @ApiOperation(value="标记签收",notes="标记签收")
    @Login
    public R updateCarStatusIn(@RequestBody Map<String, List<ViCarstatusinfoEntity>> map){
    	List<ViCarstatusinfoEntity> list = new ArrayList<>();
    	list = map.get("data");
    	list.get(0).setDetailstatus(1);
        boolean flag = tbCarinfoService.updateCarStatus(list);
        if(flag){
        	return R.ok();
        }else{
        	return R.error("操作失败");
        }
    }
    
    @PostMapping("/updatestockin")
    @ApiOperation(value="标记入库",notes="标记入库")
    @Login
    public R updateStockIn(@RequestBody TbCarinfoFenceModel tbCarinfoFenceModel){
    	tbCarinfoFenceModel.setCarstatus(4);
        boolean flag = tbCarinfoService.updateCarStockIn(tbCarinfoFenceModel);
        if(flag){
        	return R.ok();
        }else{
        	return R.error("操作失败");
        }
    }
    
    @PostMapping("/updatepayment")
    @ApiOperation(value="标记还款",notes="标记还款")
    @Login
    public R updatePayment(@RequestBody Map<String, List<ViCarstatusinfoEntity>> map){
    	List<ViCarstatusinfoEntity> list = new ArrayList<ViCarstatusinfoEntity>(map.get("data"));
    	list.get(0).setDetailstatus(10);
        boolean flag = tbCarinfoService.updateCarStatus(list);
        if(flag){
        	return R.ok();
        }else{
        	return R.error("操作失败");
        }
    }
}
