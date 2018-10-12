package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.ReqestFilterJson;
import com.freeter.form.RequestMapToFilterForm;
import com.freeter.form.RequestPageForm;
import com.freeter.form.RequestPageJson;
import com.freeter.form.RulesForm;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbCarinfoEntity;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.service.TbCarinfoService;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.modules.stock.service.TbInstockinfoService;
import com.freeter.utils.ExcelUtils;
import com.freeter.utils.StatusConvert;

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
@RequestMapping("tbinstockinfo")
@Api(tags="特殊入库信息表接口")
public class TbInstockinfoController {
    @Autowired
    private TbInstockinfoService tbInstockinfoService;
    @Autowired
    private TbFenceinfoService tbFenceinfoService;
  
    /**
     * 添加
     */
    @Login
    @PostMapping("/save")
    @ApiOperation(value="添加",notes="添加特殊入库信息")
    public R addInstockinfo(@RequestBody TbInstockinfoModel instockinfoModel,HttpServletRequest request){
    	Long userId=(Long)request.getAttribute("userId");
    	System.out.println(userId);
    	Map<String, String> hashMap = tbFenceinfoService.getDealerIdByUserId(userId);
    	Map<String, Long> hashmap = tbFenceinfoService.getDeptIdByUserId(userId);
    	Long departId = hashmap.get("dept_id");
    	String dealerId = hashMap.get("Id");
    	String dealername=hashMap.get("Name");
    	instockinfoModel.setDepartid(departId);
    	instockinfoModel.setDealerid(dealerId);
    	instockinfoModel.setDealername(dealername);
    	instockinfoModel.setAuditstate(0);
    	return tbInstockinfoService.saveTbInstockinfo(instockinfoModel);
    	
    	
    }
    
    
    /**
     * 根据用户取经销商名称
     */
    @Login
    @PostMapping("/findDealer")
    @ApiOperation(value="添加",notes="添加特殊入库信息")
    public R findDealerinfo(HttpServletRequest request){
    	Long userId=(Long)request.getAttribute("userId");
    	System.out.println(userId);
    	Map<String, String> hashMap = tbFenceinfoService.getDealerIdByUserId(userId);
    	String dealerId = hashMap.get("Id");
    	String dealername=hashMap.get("Name");
    	return R.ok().put("dealername", dealername);
    	
    	
    }
    
    

    @Login
	@PostMapping("/deptPage")
	@ApiOperation(value="金融公司特殊入库信息查询",notes="金融公司特殊入库信息查询")
	public R queryDeptInstockinfo(@RequestBody RequestPageForm requestPageForm){
    	EntityWrapper<TbInstockinfoEntity> ew = new EntityWrapper<TbInstockinfoEntity>();
    	//解析数据，依据条件符号，组合查询条件
        for(RulesForm rulesForm : requestPageForm.getFilter().getRules()){
        	if(null!=rulesForm.getData() && "auditstate".equals(rulesForm.getField())){
        		if(null != rulesForm.getData()){
	        		
        			ew.eq("auditstate", rulesForm.getData());
        		}
        	
        	}
        }
        Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
		PageUtils page = tbInstockinfoService.selectinstockinfoList(params, ew);
	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
	    
	}
    
    @Login
	@PostMapping("/dealerPage")
	@ApiOperation(value="金融公司特殊入库信息查询",notes="金融公司特殊入库信息查询")
	public R queryDealerInstockinfo(@RequestBody RequestPageForm requestPageForm){
    	EntityWrapper<TbInstockinfoEntity> ew = new EntityWrapper<TbInstockinfoEntity>();
    	//解析数据，依据条件符号，组合查询条件
        for(RulesForm rulesForm : requestPageForm.getFilter().getRules()){
        	if(null!=rulesForm.getData() && "auditstate".equals(rulesForm.getField())){
        		if(null != rulesForm.getData()){
	        		
        			ew.eq("auditstate", rulesForm.getData());
        		}
        	
        	}
        }
        Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
		PageUtils page = tbInstockinfoService.selectinstockinfoList(params, ew);
	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
	    
	}
	/**
     * 
     * 根据id查询特殊入库明细信息
     */
    @Login
    @PostMapping("/info")
    @ApiOperation(value="查询",notes="根据id查询特殊入库明细信息")
    public R queryInstockinfoById(@RequestBody Map<String, String> map){
    	List<TbInstockinfoView> list=tbInstockinfoService.selectinstockinfoListById(map);
        return R.ok().put("data", list);
        
    }
    

	/**
     * 
     * 导出特殊入库列表
     */
    @GetMapping("/exportexcel")
    @ApiOperation("导出excel")
    @Login
    public void downloadAllClassmate(HttpServletRequest request ,HttpServletResponse response) throws IOException {
    	
    	String auditstate = (String) request.getParameter("0.data");
    	EntityWrapper<TbInstockinfoEntity> ew = new EntityWrapper<TbInstockinfoEntity>();
    	if(auditstate!=null) {
    		ew.eq("auditstate",auditstate);
    	}
    	Map<String,String> map = new HashMap<>();
    	List<TbInstockinfoView> list = tbInstockinfoService.selectinstockList(map, ew);
    	HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "特殊入库";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "审核状态", "经销商名称", "申请时间", "入库数量", "预计入库时间", "特殊入库原因"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        
        //在表中存放查询到的数据放入对应的列
        for (TbInstockinfoView instockinfo : list) {
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(instockinfo.getInstockauditstate());
            row1.createCell(1).setCellValue(instockinfo.getDealername());
            row1.createCell(2).setCellValue(formatter.format(instockinfo.getCreatedat()));
            row1.createCell(3).setCellValue(instockinfo.getInstocknum());
            row1.createCell(4).setCellValue(formatter.format(instockinfo.getInstocktime()));
            row1.createCell(5).setCellValue(instockinfo.getReason());
            
            rowNum++;
        }
        ExcelUtils.autoSizeColumns(sheet, headers.length+1);
        
        ExcelUtils.excelRespone(response,request,fileName,workbook);
    }
    
    
    /**
     * 
     * 审核特殊入库申请
     */
	@Login
	@PostMapping("/audit")
	@ApiOperation(value="审核",notes="审核特殊入库申请")
	public R auditInstockinfo(@RequestBody Map<String,String> map){
		return tbInstockinfoService.auditInstockinfo(map);
	 	
	}
    
}