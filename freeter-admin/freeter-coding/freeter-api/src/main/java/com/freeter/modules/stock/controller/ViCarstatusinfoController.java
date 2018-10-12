package com.freeter.modules.stock.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.annotation.Login;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.form.RequestMapToFilterForm;
import com.freeter.form.RequestPageForm;
import com.freeter.form.RulesForm;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.ArchesModel;
import com.freeter.modules.stock.entity.model.LatlngModel;
import com.freeter.modules.stock.entity.model.LocationModel;
import com.freeter.modules.stock.entity.model.ResultModel;
import com.freeter.modules.stock.entity.model.ResultMoreModel;
import com.freeter.modules.stock.entity.model.TbCarinfoFenceModel;
import com.freeter.modules.stock.entity.view.ArchesLocationsView;
import com.freeter.modules.stock.entity.view.ArchesMoreView;
import com.freeter.modules.stock.entity.view.ArchesView;
import com.freeter.modules.stock.entity.view.MapLocationView;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;
import com.freeter.modules.stock.service.ViCarstatusinfoService;
import com.freeter.utils.ExcelUtils;
import com.freeter.utils.PolygonUtil;
import com.freeter.utils.RequestUtil;
import com.freeter.utils.StatusConvert;
import com.freeter.utils.StringUtil;

import cn.hutool.db.sql.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 车辆监管接口
 * @author czz
 * @date 2018-08-13 16:31:38
 */
@RestController
@RequestMapping("vicarstatusinfo")
@Api(tags="车辆监管接口(金融公司)")
public class ViCarstatusinfoController {
	@Value("${url.location}")
	private String urlLocation;
	@Value("${url.address}")
	private String urlAddress;
	@Value("${url.arches}")
	private String urlArches;
	@Value("${url.baiduaddress}")
	private String urlbaiduaddress;
	@Value("${url.batchbaiduadress}")
	private String batchbaiduadress;
	
    @Autowired
    private ViCarstatusinfoService viCarstatusinfoService;
 
	 /**
     * 列表查询
     */
    @PostMapping("/list")
    @ApiOperation("列表查询")
    @Login
    public R page(@RequestBody RequestPageForm requestPageForm){
        EntityWrapper< ViCarstatusinfoEntity> ew = new EntityWrapper< ViCarstatusinfoEntity>();
        //解析数据，依据条件符号，组合查询条件
        for(RulesForm rulesForm : requestPageForm.getFilter().getRules()){
        	if(null!=rulesForm.getData() && "carstatus".equals(rulesForm.getField())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
	        		//车辆状态转详细状态
        			String detailsStatus = StatusConvert.StatusToDetail(rulesForm.getData());
	        		ew.in("detailstatus", detailsStatus);
        		}
        	}else if(null!=rulesForm.getData() && "eq".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.eq(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "cn".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.like(rulesForm.getField(), rulesForm.getData());
        		}
        	}
        }
//        ew.orderBy("receivetime", false);
     	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
    	PageUtils page = viCarstatusinfoService.queryPage(params, ew);

    	Map<String, Object> map = new HashMap<>();
    	map.put("count", page.getTotalCount());
    	map.put("data",  page.getList());
        return R.ok(map);
    }
    
    /**
     * 导出excel
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/exportexcel")
    @ApiOperation("导出excel")
    @Login
    public void exportexcel(HttpServletRequest request ,HttpServletResponse response) throws IOException {
    	EntityWrapper<ViCarstatusinfoEntity> ew = new EntityWrapper<ViCarstatusinfoEntity>();
    	Map<String, String[]> map = request.getParameterMap();
    	List<RulesForm> rulesList = RequestMapToFilterForm.mapToFilterForm(map);
    	
    	for(int i=0; i<rulesList.size(); i++){
			RulesForm rulesForm = new RulesForm();
			rulesForm = rulesList.get(i);
        	if(null!=rulesForm.getData() &&"carstatus".equals(rulesForm.getField())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
	        		String detailsStatus = StatusConvert.StatusToDetail(rulesForm.getData());
	        		ew.in("detailstatus", detailsStatus);
        		}
        	}else if(null!=rulesForm.getData() &&"eq".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.eq(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "cn".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.like(rulesForm.getField(), rulesForm.getData());
        		}
        	}
		}
//    	ew.orderBy("receivetime", false);
    	Map<String, String> param = new HashMap<>();
    	List<ViCarstatusinfoEntity> list = viCarstatusinfoService.querylist(param, ew);
    	
    	HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "车辆状态";//设置要导出的文件的名字
        
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "车辆状态", "详细状态", "车架号", "经销商名称", "围栏名称", "OBD工作状态", "OBD设备号"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (ViCarstatusinfoEntity userinfo : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(StatusConvert.carStatus(userinfo.getCarstatus()));
            row1.createCell(1).setCellValue(StatusConvert.carDetailStatus(userinfo.getDetailstatus()));
            row1.createCell(2).setCellValue(userinfo.getVinnumber());
            row1.createCell(3).setCellValue(userinfo.getDealername());
            row1.createCell(4).setCellValue(null == userinfo.getFencename()?"":userinfo.getFencename());
            row1.createCell(5).setCellValue(null == userinfo.getDevicestatus()?"":StatusConvert.ODBStatus(userinfo.getDevicestatus()));
            row1.createCell(6).setCellValue(null == userinfo.getDevicenumber()?"":userinfo.getDevicenumber());
            rowNum++;
        }
        
        ExcelUtils.autoSizeColumns(sheet, headers.length+1);

        ExcelUtils.excelRespone(response,request,fileName,workbook);
    }
    /**
     * 查看详情
     * @param status
     * @return
     */
    @PostMapping("/info")
    @ApiOperation("查看详情")
    @Login
    public R info(@RequestBody ViCarstatusinfoEntity status){
    	
    	EntityWrapper<ViCarstatusinfoEntity> ew = new EntityWrapper<>();
    	ew.eq("vinnumber", status.getVinnumber());
    	ViCarstatusinfoEntity entity = viCarstatusinfoService.selectOneByVinnumber(ew);
    	ViCarstatusinfoView view = new ViCarstatusinfoView(entity);
    	if(null != entity.getFencepolygon()){
    		view.setPolygon(PolygonUtil.polygonConvert(entity.getFencepolygon()));
    	}
    	Map<String, Object> map = new HashMap<>();
    	map.put("data", view);
    	return R.ok(map);
    }
    
    /**
     * 地图坐标详情
     * @param status
     * @return
     */
    @PostMapping("/location")
    @ApiOperation("地图坐标详情")
    @Login
    public R location(@RequestBody ViCarstatusinfoEntity status){
    	String url=urlLocation;
    	Map<String, Object> param = new HashMap<>();
    	param.put("vin", status.getVinnumber());
    	
    	//获取坐标信息
    	JSONObject jsStr = RequestUtil.sendPostRequest(url, param);
    	//转换json数据
    	ResultModel<LocationModel> resultModel = (ResultModel<LocationModel>)JSONObject.toJavaObject(jsStr, ResultModel.class);
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages());
    	}
    	JSONObject jsLocation = JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	LocationModel locationModel = (LocationModel)JSONObject.toJavaObject(jsLocation, LocationModel.class);
    	
    	//赋值
    	MapLocationView view = new MapLocationView();
    	view.setDeviceNumber(locationModel.getImei());
    	view.setBatteryPCT(locationModel.getBattery());
    	view.setLocationType(StatusConvert.Locationtype(locationModel.getLocateMode()));
    	view.setLocationTime(locationModel.getGpsTimestamp());
    	view.setCheckTime(locationModel.getLastTimestamp());
    	
    	url= urlAddress;
    	param.remove("vin");
    	param.put("lat", locationModel.getLat());
    	param.put("lng", locationModel.getLng());
    	
    	//坐标转地址
    	jsStr = RequestUtil.sendPostRequest(url, param);
    	//转换json数据
    	resultModel = (ResultModel<LocationModel>)JSONObject.toJavaObject(jsStr, ResultModel.class);
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages());
    	}
    	jsLocation = JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	locationModel = (LocationModel)JSONObject.toJavaObject(jsLocation, LocationModel.class);
//    	jsLocation = JSONObject.parseObject(JSON.toJSONString(locationModel.getPoint()));
//    	LatlngModel point = (LatlngModel)JSONObject.toJavaObject(jsLocation,LatlngModel.class);
    	view.setLat(locationModel.getPoint().getLat());
    	view.setLng(locationModel.getPoint().getLng());
    	view.setAddress(locationModel.getAddress());
    	
    	return R.ok().put("data", view);
    }
    
    /**
     * 百度坐标查询地址
     * @param latlngModel
     * @return
     */
    @PostMapping("/queryAdress")
    @ApiOperation("百度坐标查询地址")
    @Login
    public R queryAdress(@RequestBody LatlngModel latlngModel){
    	Map<String, Object> param = new HashMap<>();
    	param.put("lat", latlngModel.getLat());
    	param.put("lng", latlngModel.getLng());
    	JSONObject jsStr = RequestUtil.sendPostRequest(urlAddress, param);
    	ResultModel<LocationModel> resultModel = (ResultModel<LocationModel>)JSONObject.toJavaObject(jsStr, ResultModel.class);
    	
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages());
    	}
    	jsStr = JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	LocationModel locationModel = (LocationModel)JSONObject.toJavaObject(jsStr, LocationModel.class);
    	
    	return R.ok().put("data", locationModel.getAddress());
    }

    /**
     * 轨迹回放
     * @param archesModel
     * @return
     */
    @PostMapping("/arches")
    @ApiOperation("轨迹回放")
    @Login
    public R queryArches(@RequestBody ArchesModel archesModel){
    	Map<String, Object> map = new HashMap<>();
    	map.put("VIN", archesModel.getVin());
    	map.put("StartDateTime", archesModel.getStarttime());
    	map.put("EndDateTime", archesModel.getEndtime());
    	map.put("MaxValues", archesModel.getMax());
    	
    	//调用接口获取轨迹数据
    	JSONObject js = RequestUtil.sendPostRequest(urlArches, map);
    	ResultModel<ArchesView> resultModel = (ResultModel<ArchesView>)JSONObject.toJavaObject(js, ResultModel.class);
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages().contains("no data")?"没有轨迹数据":resultModel.getAllMessages());
    	}
    	js=JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	//返回前端实体
    	ArchesView archesView = (ArchesView)JSONObject.toJavaObject(js, ArchesView.class);
    	
    	List<LatlngModel> points = new ArrayList();
    	for(int i=0; i< archesView.getLocations().size(); i++){
    		LatlngModel model = new LatlngModel();
    		model.setLat(archesView.getLocations().get(i).getLat());
    		model.setLng(archesView.getLocations().get(i).getLng());
    		model.setSort(i+1);
    		points.add(model);
    	}
    	Map<String, Object> param = new HashMap<>();
    	param.put("points", points);
    	
    	//调用接口轨迹坐标转换
    	js = RequestUtil.sendPostRequest(batchbaiduadress, param);
    	ResultMoreModel resultLat = (ResultMoreModel)JSONObject.toJavaObject(js, ResultMoreModel.class);
    	if(!resultLat.isSuccess()){
    		return R.error("坐标转换异常.");
    	}
    	
    	for(LatlngModel model : resultLat.getData()){
    		int i = model.getSort();
    		archesView.getLocations().get(i-1).setLat(model.getLat());
    		archesView.getLocations().get(i-1).setLng(model.getLng());
    	}

    	return R.ok().put("data", archesView);
    }
    
	 /**
     * 经销商列表查询
     */
    @PostMapping("/dealerlist")
    @ApiOperation(tags="车辆监管接口(经销商)",value="经销商列表查询")
    @Login
    public R dealerpage(@RequestBody RequestPageForm requestPageForm){
        EntityWrapper< ViCarstatusinfoEntity> ew = new EntityWrapper< ViCarstatusinfoEntity>();
        //解析数据，依据条件符号，组合查询条件
        for(RulesForm rulesForm : requestPageForm.getFilter().getRules()){
        	if(null!=rulesForm.getData() && "carstatus".equals(rulesForm.getField())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			String detailsStatus = StatusConvert.StatusToDetail(rulesForm.getData());
	        		ew.in("detailstatus", detailsStatus);
        		}
        	}else if(null!=rulesForm.getData() && "eq".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.eq(rulesForm.getField(), rulesForm.getData());
        		}
        	}else if(null!=rulesForm.getData() && "cn".equals(rulesForm.getOp())){
        		if(StringUtil.isEmpty(rulesForm.getData())){
        			ew.like(rulesForm.getField(), rulesForm.getData());
        		}
        	}
        }
        
     	Map<String, Object> params = new HashMap<>();
     	params.put("pagesize", requestPageForm.getPageSize());
     	params.put("pageindex", requestPageForm.getPageIndex());
    	PageUtils page = viCarstatusinfoService.queryPageDealer(params, ew);
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("count", page.getTotalCount());
    	map.put("data",  page.getList());
        return R.ok(map);
    }
    
    /**
     * 查询围栏列表
     * @return
     */
    @PostMapping("/fencelist")
    @ApiOperation("围栏列表")
    @Login
    public R queryFenceByAgence(@RequestBody TbCarinfoFenceModel tbCarinfoFenceModel){
    	EntityWrapper<TbFenceinfoEntity> ew = new EntityWrapper<>();
    	ew.eq("isenable", 1);
    	ew.eq("deleted", 0);
    	ew.andNew("dealerid = {0}", tbCarinfoFenceModel.getData().get(0).getDealerid());
    	ew.or("owndealerid = {0}", tbCarinfoFenceModel.getData().get(0).getDealerid());
//    	ew.eq("dealerid", tbCarinfoFenceModel.getData().get(0).getDealerid());
//    	ew.or();
//    	ew.eq("owndealerid", tbCarinfoFenceModel.getData().get(0).getDealerid());
    	List<TbFenceinfoEntity> list = viCarstatusinfoService.queryFenceinfoList(new HashMap<>(),ew);
    	return R.ok().put("data", list);
    }
    
    
    /**
     * 地图坐标详情
     * @param status
     * @return
     */
    @PostMapping("/locationinfo")
    @ApiOperation("地图坐标详情")
    @Login
    public R locationlot(@RequestBody ViCarstatusinfoEntity status){
    	String url=urlLocation;
    	Map<String, Object> param = new HashMap<>();
    	param.put("vin", status.getVinnumber());
    	Map<String, Object> map = new HashMap<>();
    	map.put("Vinnumber", status.getVinnumber());
    	List<ViCarstatusinfoEntity> selectByMap = viCarstatusinfoService.selectByMap(map);
    	ViCarstatusinfoEntity viCarstatusinfoEntity = selectByMap.get(0);
    	int carstatus = viCarstatusinfoEntity.getCarstatus();
    	String carStatus = StatusConvert.carDetailStatus(carstatus);	
    	//获取坐标信息
    	JSONObject jsStr = RequestUtil.sendPostRequest(url, param);
    	//转换json数据
    	ResultModel<LocationModel> resultModel = (ResultModel<LocationModel>)JSONObject.toJavaObject(jsStr, ResultModel.class);
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages());
    	}
    	JSONObject jsLocation = JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	LocationModel locationModel = (LocationModel)JSONObject.toJavaObject(jsLocation, LocationModel.class);
    	
    	//赋值
    	MapLocationView view = new MapLocationView();
    	view.setCarStatus(carStatus);
    	view.setVinnumber(status.getVinnumber());
    	view.setDeviceNumber(locationModel.getImei());
    	view.setBatteryPCT(locationModel.getBattery());
    	view.setLocationType(StatusConvert.Locationtype(locationModel.getLocateMode()));
    	view.setLocationTime(locationModel.getGpsTimestamp());
    	view.setCheckTime(locationModel.getLastTimestamp());
    	
    	url= urlAddress;
    	param.remove("vin");
    	param.put("lat", locationModel.getLat());
    	param.put("lng", locationModel.getLng());
    	
    	//坐标转地址
    	jsStr = RequestUtil.sendPostRequest(url, param);
    	//转换json数据
    	resultModel = (ResultModel<LocationModel>)JSONObject.toJavaObject(jsStr, ResultModel.class);
    	if(!resultModel.isSuccess()){
    		return R.error(resultModel.getAllMessages());
    	}
    	jsLocation = JSONObject.parseObject(JSON.toJSONString(resultModel.getData()));
    	locationModel = (LocationModel)JSONObject.toJavaObject(jsLocation, LocationModel.class);
//    	jsLocation = JSONObject.parseObject(JSON.toJSONString(locationModel.getPoint()));
//    	LatlngModel point = (LatlngModel)JSONObject.toJavaObject(jsLocation,LatlngModel.class);
    	view.setLat(locationModel.getPoint().getLat());
    	view.setLng(locationModel.getPoint().getLng());
    	view.setAddress(locationModel.getAddress());
    	
    	return R.ok().put("data", view);
    }
    
}
