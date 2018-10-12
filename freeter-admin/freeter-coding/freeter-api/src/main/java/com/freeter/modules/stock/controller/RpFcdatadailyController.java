package com.freeter.modules.stock.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.RequestMapToFilterForm;
import com.freeter.form.RequestPageForm;
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
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.RpFcdatadailyEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.RpFcdatadailyModel;
import com.freeter.modules.stock.service.RpFcdatadailyService;
import com.freeter.utils.ExcelUtils;
import com.freeter.utils.StatusConvert;
import com.freeter.utils.StringUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 统计分析
 *api接口
 * @author czz
 * @date 2018-08-28 18:04:27
 */
@RestController
@RequestMapping("rpfcdatadaily")
@Api(tags="统计分析接口")
public class RpFcdatadailyController {
    @Autowired
    private RpFcdatadailyService rpFcdatadailyService;
 
	 /**
     * 列表
     */
    @PostMapping("/page")
    @ApiOperation("查询列表")
    @Login
    public R page(@RequestBody RequestPageForm requestPageForm){
        EntityWrapper<RpFcdatadailyEntity> ew = new EntityWrapper<RpFcdatadailyEntity>();
        //解析数据，依据条件符号，组合查询条件
        for(RulesForm rulesForm : requestPageForm.getFilter().getRules()){
        	if(null!=rulesForm.getData() && "eq".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.eq(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "cn".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.like(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "ge".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.ge(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "le".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.le(rulesForm.getField(), rulesForm.getData());
        		}
        	}
        }
//        ew.orderBy("DealerName", true);
        
     	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
    	PageUtils page = rpFcdatadailyService.queryPage(params, ew);
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("count", page.getTotalCount());
    	map.put("data",  page.getList());
        return R.ok(map);
    }
    
    @GetMapping("/exportexcel")
    @ApiOperation("导出excel")
    @Login
    public void exportexcel(HttpServletRequest request ,HttpServletResponse response) throws IOException {
    	EntityWrapper<RpFcdatadailyEntity> ew = new EntityWrapper<RpFcdatadailyEntity>();
    	Map<String, String[]> map = request.getParameterMap();
    	List<RulesForm> rulesList = RequestMapToFilterForm.mapToFilterForm(map);
    	
    	for(int i=0; i<rulesList.size(); i++){
			RulesForm rulesForm = new RulesForm();
			rulesForm = rulesList.get(i);
        	if(null!=rulesForm.getData() &&"eq".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.eq(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "cn".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.like(rulesForm.getField(), rulesForm.getData());
        		}
        	}
		}
//    	ew.orderBy("DealerName", true);
    	
    	Map<String, Object> param = new HashMap<>();
    	List<RpFcdatadailyEntity> list = rpFcdatadailyService.querylist(param,ew);
    	
    	HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "统计分析";//设置要导出的文件的名字
        
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"经销商名称", "车辆出库量", "车辆售出量", "特殊入库量", "特殊出库量", "超时未入库报警量", "违规出库报警量", 
        		"离线报警量", "位移报警量", "碰撞报警量", "非法拆除报警量", "低电压报警量", "低电量报警量"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (RpFcdatadailyEntity info : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(info.getDealername());
            row1.createCell(1).setCellValue(info.getCaroutnum());
            row1.createCell(2).setCellValue(info.getReceivenum());
            row1.createCell(3).setCellValue(info.getInstocknum());
            row1.createCell(4).setCellValue(info.getOutstocknum());
            row1.createCell(6).setCellValue(info.getVioinstocknum());
            row1.createCell(5).setCellValue(info.getViooutstocknum());
            row1.createCell(7).setCellValue(info.getOfflinenum());
            row1.createCell(8).setCellValue(info.getMovenum());
            row1.createCell(9).setCellValue(info.getKnocknum());
            row1.createCell(10).setCellValue(info.getTeardownnum());
            row1.createCell(11).setCellValue(info.getLowvolnum());
            row1.createCell(12).setCellValue(info.getLowbatnum());
            rowNum++;
        }
        
        ExcelUtils.autoSizeColumns(sheet, headers.length+1);
        
        ExcelUtils.excelRespone(response,request,fileName,workbook);
    }

}
