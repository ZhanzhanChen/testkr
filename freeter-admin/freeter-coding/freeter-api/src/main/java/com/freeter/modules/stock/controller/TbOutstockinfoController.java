package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.RequestPageForm;
import com.freeter.form.RequestPageJson;
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
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfoModel;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.modules.stock.service.TbOutstockinfoService;
import com.freeter.utils.ExcelUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 特殊出库单表
 *api接口
 * @author ipx
 * @email 
 * @date 2018-08-08 13:53:29
 */
@RestController
@RequestMapping("tboutstockinfo")
@Api(tags="特殊出库单表接口")
public class TbOutstockinfoController {
    @Autowired
    private TbOutstockinfoService tbOutstockinfoService;
    @Autowired
    private TbFenceinfoService tbFenceinfoService;
	/**
     * 
     * 根据id查询特殊入库明细信息
     */
    @Login
    @PostMapping("/info")
    @ApiOperation(value="根据id查询特殊出库明细信息",notes="根据id查询特殊出库明细信息")
    public R queryOutstockinfoById(@RequestBody Map<String, String> map){
    	List<TbOutstockinfoView> list=tbOutstockinfoService.selectoutstockinfoListById(map);
        return R.ok().put("data", list);
    }
	
    /**
     * 添加
     */
    @Login
    @PostMapping("/save")
    @ApiOperation(value="添加特殊出库信息",notes="添加特殊出库信息")
    public R addOutstockinfo(@RequestBody TbOutstockinfoModel outstockinfoModel,HttpServletRequest request){
    	Long userId=(Long)request.getAttribute("userId");
    	System.out.println(userId);
    	Map<String, String> hashMap = tbFenceinfoService.getDealerIdByUserId(userId);
    	Map<String, Long> hashmap = tbFenceinfoService.getDeptIdByUserId(userId);
    	Long departId = hashmap.get("dept_id");
    	System.out.println(departId);
    	String dealerId = hashMap.get("Id");
    	String dealername=hashMap.get("Name");
    	outstockinfoModel.setAuditstate(0);
    	outstockinfoModel.setDepartid(departId);
    	outstockinfoModel.setDealerid(dealerId);
    	outstockinfoModel.setDealername(dealername);
    	return tbOutstockinfoService.saveTbOutstockinfo(outstockinfoModel);
    }
    
    
    /**
     * 
     * 审核特殊入库申请
     */
    @Login
    @PostMapping("/audit")
    @ApiOperation(value="审核特殊出库申请",notes="审核特殊出库申请")
    public R auditInstockinfo(@RequestBody Map<String,String> map){
    	return tbOutstockinfoService.auditOutstockinfo(map);
     	
    }
    
    /**
	 * 
	 * 金融机构分页查询特殊入库信息列表
	 */
    @Login
	@PostMapping("/deptPage")
	@ApiOperation(value="金融公司特殊入库信息查询",notes="金融公司特殊入库信息查询")
	public R queryDeptOutstockinfo(@RequestBody RequestPageForm requestPageForm){
    	EntityWrapper<TbOutstockinfoEntity> ew = new EntityWrapper<TbOutstockinfoEntity>();
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
		PageUtils page = tbOutstockinfoService.selectoutstockinfoList(params, ew);
	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
	}
    
    @Login
   	@PostMapping("/dealerPage")
   	@ApiOperation(value="经销商特殊出库信息查询",notes="经销商特殊出库信息查询")
   	public R queryDealerOutstockinfo(@RequestBody RequestPageForm requestPageForm){
       	EntityWrapper<TbOutstockinfoEntity> ew = new EntityWrapper<TbOutstockinfoEntity>();
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
   		PageUtils page = tbOutstockinfoService.selectoutstockinfoList(params, ew);
   	    return R.ok().put("data",  page.getList()).put("count", page.getTotalCount());
   	    
   	}
    
    @Login
    @GetMapping("/exportexcel")
    @ApiOperation("导出excel")
    public void downloadAllClassmate(HttpServletRequest request ,HttpServletResponse response) throws IOException {
    	
    	String auditstate = (String) request.getParameter("0.data");
    	EntityWrapper<TbOutstockinfoEntity> ew = new EntityWrapper<TbOutstockinfoEntity>();
    	if(auditstate!=null) {
    		ew.eq("auditstate",auditstate);
    	}
    	Map<String,String> map = new HashMap<>();
    	List<TbOutstockinfoView> list = tbOutstockinfoService.selectoutstockList(map,ew);
    	
    	HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "特殊出库";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;
        String[] headers = { "审核状态", "经销商名称", "申请时间", "入库数量", "出库时间", "预计回库时间", "目标地点", "出库原因", "联系方式"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        
        //在表中存放查询到的数据放入对应的列
        for (TbOutstockinfoView outstockinfo : list) {
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(outstockinfo.getOutstockauditstate());
            row1.createCell(1).setCellValue(outstockinfo.getDealername());
            row1.createCell(2).setCellValue(formatter.format(outstockinfo.getCreatedat()));
            row1.createCell(3).setCellValue(outstockinfo.getOutstocknum());
            row1.createCell(4).setCellValue(formatter.format(outstockinfo.getOutstocktime()));
            row1.createCell(5).setCellValue(formatter.format(outstockinfo.getReturnstocktime()));
            row1.createCell(6).setCellValue(outstockinfo.getDestinationaddr());
            Long outstockreason = outstockinfo.getOutstockreason();
            String str="";
            if(outstockreason==0) {
            	str="临时展示";
            	
            }
            if(outstockreason==1) {
            	str="车辆加装";
            	
            }
            if(outstockreason==2) {
            	str="车辆维修";
            	
            }
            if(outstockreason==3) {
            	str="其他";
            	
            }
            row1.createCell(7).setCellValue(str);
            row1.createCell(8).setCellValue(outstockinfo.getManagertel());
            rowNum++;
        }
        ExcelUtils.autoSizeColumns(sheet, headers.length+1);
        
        ExcelUtils.excelRespone(response,request,fileName,workbook);
    }
    

}
