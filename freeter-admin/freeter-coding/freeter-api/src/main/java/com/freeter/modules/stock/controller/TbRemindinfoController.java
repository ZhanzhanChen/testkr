package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.FiltersForm;
import com.freeter.form.RequestMapToFilterForm;
import com.freeter.form.RequestPageForm;
import com.freeter.form.RulesForm;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
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
import com.freeter.modules.stock.entity.model.RemindinfoModel;
import com.freeter.modules.stock.entity.model.TbRemindinfoModel;
import com.freeter.modules.stock.entity.view.TbRemindinfoView;
import com.freeter.annotation.DataFilter;
import com.freeter.annotation.Login;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.service.TbRemindinfoService;
import com.freeter.utils.Constant;
import com.freeter.utils.ExcelUtils;
import com.freeter.utils.StatusConvert;
import com.freeter.utils.StringUtil;
import com.mysql.fabric.xmlrpc.base.Array;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 报警数量
 * @author czz
 * @date 2018-08-21 16:10:42
 */
@RestController
@RequestMapping("tbremindinfo")
@Api(tags="风险管理")
public class TbRemindinfoController {
    @Autowired
    private TbRemindinfoService tbRemindinfoService;
    
    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("金融公司列表查询")
    @Login
    public R page(@RequestBody RequestPageForm requestPageForm){
        EntityWrapper<TbRemindinfoEntity> ew = new EntityWrapper<TbRemindinfoEntity>();
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
        //日期数据存在filters
        if(null != requestPageForm.getFilters() && requestPageForm.getFilters().size()!=0){
			for(FiltersForm filters : requestPageForm.getFilters()){
				if(null != filters.getTerm()){
					if(StringUtil.isEmpty(filters.getTerm())){
						if("ge".equals(filters.getOp())){
							ew.ge(filters.getField(), filters.getTerm().trim()+" 00:00:00");
						}else if("le".equals(filters.getOp())){
							ew.le(filters.getField(), filters.getTerm().trim()+" 23:59:59");
						}
					}
				}
				
			}
        }
        ew.eq("isread", 0);
        ew.eq("Deleted", 0);
        ew.orderBy("RemindTime", false);
        ew.orderBy("lastupdate" , false);
     	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
    	PageUtils page = tbRemindinfoService.queryPage(params, ew);
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("count", page.getTotalCount());
    	map.put("data",  page.getList());
        return R.ok(map);
    }
    
    @GetMapping("/exportexcel")
    @ApiOperation("金融公司风险管理导出excel")
    @Login
    public void exportexcel(HttpServletRequest request ,HttpServletResponse response) throws IOException {
    	EntityWrapper<TbRemindinfoEntity> ew = new EntityWrapper<TbRemindinfoEntity>();
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
        	}else if(null!=rulesForm.getDatas() && "bt".equals(rulesForm.getOp())){
        		if(rulesForm.getDatas().length!=0){
        			if(StringUtil.isEmpty(rulesForm.getDatas()[0])){
        				ew.ge(rulesForm.getField(), rulesForm.getDatas()[0].trim()+" 00:00:00");
        			}
        			if(StringUtil.isEmpty(rulesForm.getDatas()[1])){
        				ew.le(rulesForm.getField(), rulesForm.getDatas()[1].trim()+" 23:59:59");
        			}
        		}
        	}
    	}
    	ew.eq("isread", 0);
    	ew.orderBy("remindtime", false);
    	ew.orderBy("lastupdate" , false);
    	Map<String, String> param = new HashMap<>();
    	List<TbRemindinfoView> list = tbRemindinfoService.selectListView(param,ew);
    	
    	
    	HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "报警信息";//设置要导出的文件的名字
        
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "处理状态", "经销商名称", "车架号", "OBD设备号", "报警类型", "报警时间", "备注"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (TbRemindinfoEntity info : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(StatusConvert.RemindOperatorType(info.getRemindstatus()));
            row1.createCell(1).setCellValue(null == info.getDealername()?null:info.getDealername());
            row1.createCell(2).setCellValue(info.getVinnumber());
            row1.createCell(3).setCellValue(null == info.getDevicenumber()?null : info.getDevicenumber());
            row1.createCell(4).setCellValue(StatusConvert.RemindType(info.getRemindtype()));
            HSSFCell cell = row1.createCell(5);
            if(null == info.getRemindtime()){
            	cell.setCellValue("");
            }else{
	            cell.setCellValue(info.getRemindtime());
	            HSSFCellStyle cellStyle = workbook.createCellStyle();
	            HSSFDataFormat format= workbook.createDataFormat();
	            cellStyle.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
	            cell.setCellStyle(cellStyle);
            }
            row1.createCell(6).setCellValue(null == info.getRemark()?null:info.getRemark());
            rowNum++;
        }
        
        ExcelUtils.autoSizeColumns(sheet, headers.length+1);
        
        ExcelUtils.excelRespone(response,request,fileName,workbook);
    }
    
    @PostMapping("/handle")
    @ApiOperation("金融公司报警处理")
    @Login
    public R handle(@RequestBody TbRemindinfoEntity tbRemindinfoEntity){
    	boolean flag = tbRemindinfoService.handle(tbRemindinfoEntity);
    	if(flag){
    		return R.ok();
    	}else{
    		return R.error("操作失败");
    	}
    }
    
    @PostMapping("/batchhandle")
    @ApiOperation("金融公司报警处理")
    @Login
    public R batchhandle(@RequestBody RemindinfoModel remindinfoModel){
    	List<TbRemindinfoEntity> list = remindinfoModel.getSelectedList();
    	int remindstatus = remindinfoModel.getRemindstatus();
    	String remark = remindinfoModel.getRemark();
    	List<TbRemindinfoEntity> arraylist = new ArrayList();
    	for (TbRemindinfoEntity tbRemindinfoEntity : list) {
			TbRemindinfoEntity remindinfoEntity = new TbRemindinfoEntity<>();
			remindinfoEntity.setId(tbRemindinfoEntity.getId());
			remindinfoEntity.setRemindstatus(remindstatus);
			remindinfoEntity.setRemark(remark);
			arraylist.add(remindinfoEntity);
		}
    	boolean flag = tbRemindinfoService.batchhandle(arraylist);
    	return R.ok();	
    }
    
    /**
     * 列表
     */
    @PostMapping("/dealerlist")
    @ApiOperation("经销商列表查询")
    @Login
    public R dealerpage(@RequestBody RequestPageForm requestPageForm){
        EntityWrapper<TbRemindinfoEntity> ew = new EntityWrapper<TbRemindinfoEntity>();
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
        ew.eq("isread", 0);
        ew.orderBy("RemindTime", false);
        ew.orderBy("lastupdate" , false);
     	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
    	PageUtils page = tbRemindinfoService.queryPage(params, ew);
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("count", page.getTotalCount());
    	map.put("data",  page.getList());
        return R.ok(map);
    }
    
    /**
     * 报警数量
     */
    @PostMapping("/count")
    @ApiOperation(tags="车辆监管接口(金融公司)",value = "报警数量")
    @Login
    @DataFilter(subDept = true, user = false)
    public R count(Map<String, Object> params){
    	EntityWrapper<TbRemindinfoEntity> ew = new EntityWrapper<>();
    	ew.eq("RemindStatus", 0);
    	ew.eq("isread", 0);
        int count = tbRemindinfoService.selectCount(ew.
        		addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER)));
        return R.ok().put("count", count);
    }

    /**
     * 当前时间半个小时内报警数量
     */
    @PostMapping("/periodcount")
    @ApiOperation(tags="车辆监管接口(金融公司)",value = "半个小时内报警数量")
    @Login
    @DataFilter(subDept = true, user = false)
    public R periodcount(Map<String, Object> params){
    	EntityWrapper<TbRemindinfoEntity> ew = new EntityWrapper<>();
    	ew.eq("isread", 0);
    	
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.MINUTE, -30);
    	ew.ge("remindtime", sf.format(calendar.getTime()));
    	
    	int count = tbRemindinfoService.selectCount(ew.
        		addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER)));
        return R.ok().put("count", count);
    }
    
}
