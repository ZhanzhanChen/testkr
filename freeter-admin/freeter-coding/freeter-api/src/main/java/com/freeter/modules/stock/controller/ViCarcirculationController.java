package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.annotation.Login;
import com.freeter.modules.stock.entity.ViCarcirculationEntity;
import com.freeter.modules.stock.service.ViCarcirculationService;
import com.freeter.utils.ExcelUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *api接口
 * @author czz
 * @date 2018-08-22 15:41:00
 */
@RestController
@RequestMapping("vicarcirculation")
@Api(tags="车辆监管接口(金融公司)")
public class ViCarcirculationController {
    @Autowired
    private ViCarcirculationService viCarcirculationService;

	 /**
    * 列表
    */
   @PostMapping("/list")
   @ApiOperation("查看日志")
   @Login
   public R list(@RequestBody ViCarcirculationEntity carcir){
       EntityWrapper<ViCarcirculationEntity> ew = new EntityWrapper<ViCarcirculationEntity>();
       ew.eq("vinnumber", carcir.getVinnumber());
       ew.orderBy("actiontime", false);
       List<ViCarcirculationEntity> list = viCarcirculationService.selectList(ew);
       return R.ok().put("data", list);
   }
   
   @GetMapping("/exportexcel")
   @ApiOperation("导出日志")
   @Login
	public void exportexcel(HttpServletRequest request ,HttpServletResponse response) throws IOException {
   	EntityWrapper<ViCarcirculationEntity> ew = new EntityWrapper<ViCarcirculationEntity>();
   	Map<String, String[]> map = request.getParameterMap();
   	ew.eq("vinnumber", map.get("vinnumber")[0]);
   	ew.orderBy("actiontime", false);
   	List<ViCarcirculationEntity> list = viCarcirculationService.selectList(ew);
   	
   	HSSFWorkbook workbook = new HSSFWorkbook();
       HSSFSheet sheet = workbook.createSheet("日志表");
       String fileName = list.get(0).getVinnumber()+"(车架号)流程日志";//设置要导出的文件的名字
       
       //新增数据行，并且设置单元格数据
       int rowNum = 1;
       String[] headers = { "时间", "操作", "详情", "操作人"};
       //headers表示excel表中第一行的表头
       HSSFRow row = sheet.createRow(0);
       //在excel表中添加表头

       CellStyle style = workbook.createCellStyle();
       style.setAlignment(HorizontalAlignment.CENTER);
       
       for(int i=0;i<headers.length;i++){
           HSSFCell cell = row.createCell(i);
           HSSFRichTextString text = new HSSFRichTextString(headers[i]);
           cell.setCellStyle(style);
           cell.setCellValue(text);
       }

       //在表中存放查询到的数据放入对应的列
       for (ViCarcirculationEntity carcir : list) {
           HSSFRow row1 = sheet.createRow(rowNum);
           HSSFCell cell = row1.createCell(0);
           cell.setCellValue(carcir.getActiontime());
           HSSFCellStyle cellStyle = workbook.createCellStyle();
           HSSFDataFormat format= workbook.createDataFormat();
           cellStyle.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
           cell.setCellStyle(cellStyle);
           row1.createCell(1).setCellValue(carcir.getCircutype());
           row1.createCell(2).setCellValue(carcir.getRemark());
           row1.createCell(3).setCellValue(carcir.getOperator());
           rowNum++;
       }
       
       ExcelUtils.autoSizeColumns(sheet, headers.length+1);

       ExcelUtils.excelRespone(response,request,fileName,workbook);
	
   }
}
