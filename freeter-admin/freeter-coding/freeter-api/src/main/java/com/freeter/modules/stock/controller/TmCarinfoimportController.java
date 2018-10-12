package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.freeter.annotation.Login;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TmCarinfoimportEntity;
import com.freeter.modules.stock.entity.view.TmCarinfoimportWrongView;
import com.freeter.modules.stock.service.TmCarinfoimportService;
import com.freeter.modules.sys.service.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 发车信息导入临时表
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-14 17:31:11
 */
@RestController
@RequestMapping("tmcarinfoimport")
@Api(tags="车辆监管接口(金融公司)")
public class TmCarinfoimportController {
    @Autowired
    private TmCarinfoimportService tmCarinfoimportService;
    @Autowired
    private SysUserService sysUserService;
 
    @PostMapping("/importexcel")
    @ApiOperation("导入Excel")
    @Login
	public R importExcel(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }
    	
        String fileName = file.getOriginalFilename();
    	List<TmCarinfoimportEntity> list = new ArrayList<TmCarinfoimportEntity>();
    	
    	boolean isExcel2003 = true;
    	if(fileName.matches("^.+\\.(?i)(xlsx)$")){
    		isExcel2003 = false;
    	}
    	
    	InputStream is = file.getInputStream();
    	Workbook workbook = null;
    	if(isExcel2003){
    		workbook =new HSSFWorkbook(is);
    	}else{
    		workbook = new XSSFWorkbook(is);
    	}
    	Sheet sheet = workbook.getSheetAt(0);
    	
    	if(null==sheet){
    		return R.error("文件为空");
    	}
    	String userId = request.getAttribute("userId").toString();
    	Long deptId = sysUserService.queryRoleNameByUserId(Long.valueOf(request.getAttribute("userId").toString())).get(0).getDeptid();
    	
    	for(int r=1; r <= sheet.getLastRowNum(); r++){
    		Row row = sheet.getRow(r);
    		
    		if(null == row){
    			continue;
    		}
    		TmCarinfoimportEntity tc = new TmCarinfoimportEntity();
    		tc.setRowno(row.getRowNum());
    		Cell cell = null == row.getCell(0)?null:row.getCell(0);
    		if(null != cell){
    			cell.setCellType(CellType.STRING);
    			tc.setVinnumber(cell.getStringCellValue().toString());
    		}
    		cell = null == row.getCell(1)?null:row.getCell(1);
    		if(null != cell){
    			cell.setCellType(CellType.STRING);
    			tc.setDealername(row.getCell(1).getStringCellValue().toString());
    		}
    		tc.setDepartid(deptId);
    		tc.setUserid(Long.valueOf(userId));
    		list.add(tc);
    	}
    	List<TmCarinfoimportWrongView> twList = tmCarinfoimportService.importExcel(list);
    	
    	Map<String, Object> map = new HashMap<>();
    	//错误数据不为空返回数据，错误数据为空返回导入成功数量
    	if(null != twList && !twList.isEmpty()){
    		map.put("data", twList);
    		return R.error(1,"fail",map);
    	} else {
    		map.put("count",list.size());
    		return R.ok(map);
    	}
	}

}
