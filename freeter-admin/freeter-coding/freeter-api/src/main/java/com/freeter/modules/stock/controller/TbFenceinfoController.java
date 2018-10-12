package com.freeter.modules.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.annotation.Login;
import com.freeter.common.utils.HttpContextUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.RequestPageForm;
import com.freeter.form.RequestPageJson;
import com.freeter.form.RulesForm;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarlocationEntity;
import com.freeter.modules.stock.entity.ViFlowstepEntity;
import com.freeter.modules.stock.entity.model.DistanceCarAndFence;
import com.freeter.modules.stock.entity.model.LatlngModel;
import com.freeter.modules.stock.entity.model.LocationModel;
import com.freeter.modules.stock.entity.model.ResultModel;
import com.freeter.modules.stock.entity.model.ResultMoreModel;
import com.freeter.modules.stock.entity.model.TbFenceinfoModel;
import com.freeter.modules.stock.entity.view.FenceCarInfoView;
import com.freeter.modules.stock.entity.view.PolygonView;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.modules.stock.service.ViCarlocationService;
import com.freeter.modules.stock.service.ViFlowstepService;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.GetDistanceByLatLng;
import com.freeter.utils.RequestUtil;
import com.freeter.utils.StatusConvert;
import com.freeter.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 围栏信息表 api接口
 * 
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-30 13:44:52
 */
@RestController
@RequestMapping("tbfenceinfo")
@Api(tags = "围栏信息表接口")
public class TbFenceinfoController {
	@Value("${url.batchlocation}")
	private String batchlocation;

	@Value("${url.batchbaiduadress}")
	private String batchbaiduadress;

	@Value("${url.orgbatchaddress}")
	private String orgbatchaddress;

	@Autowired
	private TbFenceinfoService tbFenceinfoService;

	@Autowired
	private ViCarlocationService viCarlocationService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private ViFlowstepService viFlowStepService;

	/**
	 * 信息
	 */
	@Login
	@PostMapping("/info")
	@ApiOperation(value = "查询", notes = "id查询围栏信息")
	public R info(@RequestBody Map<String, String> map) {
		String id = map.get("fenceId");
		TbFenceinfoView tbFenceinfo = tbFenceinfoService.selectTbFenceinfoById(id);
		// 将围栏信息转换为前端需要格式
		String fencepolygon = tbFenceinfo.getFencepolygon();
		String[] str = fencepolygon.split("\\(");
		String[] str2 = str[2].split("\\)");
		String[] str3 = str2[0].split("\\,");
		List<Map<String, Double>> list = new ArrayList<Map<String, Double>>();
		for (String point : str3) {
			String[] split = point.trim().split("\\s");
			Double lng = Double.valueOf(split[0]);
			Double lat = Double.valueOf(split[1]);
			Map<String, Double> hashMap = new HashMap<String, Double>();
			hashMap.put("lng", lng);
			hashMap.put("lat", lat);
			list.add(hashMap);
		}
		tbFenceinfo.setFencePoints(list);
		return R.ok().put("data", tbFenceinfo);
	}

	/**
	 * 添加
	 */
	@Login
	@PostMapping("/add")
	@ApiOperation(value = "添加", notes = "添加围栏信息")
	public R addFenceinfo(@RequestBody TbFenceinfoModel tbFencemodel, HttpServletRequest request) {
		// 验证前端传参是否为空
		ValidatorUtils.validateEntity(tbFencemodel);
		TbFenceinfoEntity tbFenceinfo = new TbFenceinfoEntity();
		tbFenceinfo.setFencepoints(tbFencemodel.getFencePoints());
		tbFenceinfo.setFenceaddr(tbFencemodel.getFenceAddr());
		tbFenceinfo.setFencename(tbFencemodel.getFenceName());
		// 新增围栏状态改为“审核通过”
		tbFenceinfo.setAuditstate(1);
		tbFenceinfo.setAudittype(0);
		String dealerId = tbFencemodel.getDealerId();
		// 获取验证过程另一个参数经销商id
		Map<String, Object> hashMap = tbFenceinfoService.getDealerById(dealerId);
		Long departId = (Long) (hashMap.get("DeptId"));
		tbFenceinfo.setDepartid(departId);
		String ownDealerId = (String) hashMap.get("RootDealerId");
		tbFenceinfo.setOwndealerid(ownDealerId);
		tbFenceinfo.setDealerid(dealerId);
		// 获取
		List<Map<String, Double>> fencepoint = tbFenceinfo.getFencepoints();
		// 转换前端传入围栏数据格式与数据库需要数据格式一致
		String fencepolygon = "POLYGON((";
		for (Map<String, Double> map : fencepoint) {

			Double lat = map.get("lat");
			Double lng = map.get("lng");
			fencepolygon = fencepolygon + lng + " " + lat + "," + " ";

		}
		fencepolygon = fencepolygon.trim().substring(0, fencepolygon.length() - 2) + "))";
		tbFenceinfo.setFencepolygon(fencepolygon);
		// 验证围栏是否符合要求
		String result = tbFenceinfoService.callFenceinfo(tbFenceinfo);
		if (result == null) {
			return R.error();
		}
		;
		// 保存围栏
		if (result.equals("0")) {
			tbFenceinfoService.saveTbFenceinfo(tbFenceinfo);

		} else {
			String[] split = result.split(",");

			if (split[0].equals("1")) {
				return R.error(Integer.parseInt(split[0]), "error");
			}
			;
			if (split[0].equals("2")) {
				return R.error(Integer.parseInt(split[0]), "error");
			}
			;
			if (split[0].equals("3")) {
				return R.error(Integer.parseInt(split[0]), "error");
			}
			;
		}
		return R.ok().put("fenceId", tbFenceinfo.getId());
	}

	/**
	 * 
	 * 分页查询围栏
	 */
	@Login
	@PostMapping("/list")
	@ApiOperation(value = "查询", notes = "围栏信息查询")
	public R queryFenceinfo(@RequestBody RequestPageForm requestPageForm) {
		EntityWrapper<TbFenceinfoEntity> ew = new EntityWrapper<TbFenceinfoEntity>();
		for (RulesForm rulesForm : requestPageForm.getFilter().getRules()) {
			if (null != rulesForm.getData() && "eq".equals(rulesForm.getOp())) {
				if (null != rulesForm.getData()) {
					ew.eq(rulesForm.getField(), rulesForm.getData());
				}
			} else if (null != rulesForm.getData() && "cn".equals(rulesForm.getOp())) {
				if (null != rulesForm.getData()) {
					ew.like(rulesForm.getField(), rulesForm.getData());
				}
			}
		}

		Map<String, Object> params = new HashMap<>();
		params.put("pagesize", requestPageForm.getPageSize());
		params.put("pageindex", requestPageForm.getPageIndex());
		PageUtils page = tbFenceinfoService.selectFenceinfoList(params, ew);
		return R.ok().put("data", page.getList()).put("count", page.getTotalCount());

	}

	/**
	 * 
	 * 分页查询围栏
	 */
	@Login
	@PostMapping("/dealerlist")
	@ApiOperation(value = "查询", notes = "经销商信息查询")
	public R queryFenceinfo(@RequestBody RequestPageJson requestPageJson, HttpServletRequest request) {
		Long userId = (Long) request.getAttribute("userId");
		Map<String, String> hashMap = tbFenceinfoService.getDealerIdByUserId(userId);
		Map<String, Object> hashmap = tbFenceinfoService.getDealerLevelByUserId(userId);
		int levelCode = (int) hashmap.get("LevelCode");
		String rootDealerId = hashMap.get("RootDealerId");
		Map map = requestPageJson.get();
		if (levelCode == 1) {
			map.put("ownDealerId", rootDealerId);
		}
		if (levelCode == 2) {
			map.put("dealerId", hashMap.get("Id"));
		}
		PageUtils page = tbFenceinfoService.selectFenceinfoList(
				new Page<TbFenceinfoView>(requestPageJson.getPageIndex(), requestPageJson.getPageSize()), map);
		return R.ok().put("data", page.getList()).put("count", page.getTotalCount());

	}

	/**
	 * 
	 * 启用禁用围栏
	 */
	@Login
	@PostMapping("/open")
	@ApiOperation(value = "启用禁用", notes = "启用禁用围栏")
	public R disableFence(@RequestBody Map<String, String> map) {

		return tbFenceinfoService.disableTbFenceinfo(map);

	}

	/**
	 * 
	 * 禁用围栏
	 */
	@Login
	@PostMapping("/close")
	@ApiOperation(value = "禁用", notes = "禁用围栏")
	public R ableFence(@RequestBody Map<String, String> map) {

		return tbFenceinfoService.ableTbFenceinfo(map);

	}

	/**
	 * 
	 * 查询两公里内围栏和车辆
	 */
	@Login
	@PostMapping("/findFenceAndCar")
	@ApiOperation(value = "查询两公里内围栏和车辆", notes = "查询两公里内围栏和车辆")
	public R findFenceAndCar(@RequestBody Map<String, String> map) {
		// 查询围栏
		String dealerid = map.get("id");
		String lat = map.get("lat");
		String lng = map.get("lng");
		PolygonView polygonView = new PolygonView();
		polygonView.setLat(lat);
		polygonView.setLng(lng);
		List<TbFenceinfoEntity> fenceinfoByDistance = tbFenceinfoService.selectFenceinfoByDistance(dealerid,
				polygonView);
		// 获取流程开始和结束状态
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		SysUserEntity sysUserEntity = sysUserService.selectById(userId);
		EntityWrapper<ViFlowstepEntity> ewflow = new EntityWrapper<ViFlowstepEntity>();
		ewflow.eq("departid", sysUserEntity.getDeptId());
		ewflow.eq("flag", 2);
		List<ViFlowstepEntity> listFlow = viFlowStepService.selectList(ewflow);
		// 查询车辆
		EntityWrapper<ViCarlocationEntity> ew = new EntityWrapper<>();
		ew.eq("dealerid", dealerid);
		ew.ne("carstatus", 0);
		ew.ne("carstatus", listFlow.get(0).getActionno());
		List<ViCarlocationEntity> list = viCarlocationService.selectList(ew);

		// 返回数据
		List<FenceCarInfoView> carInfoViewsList = new ArrayList<FenceCarInfoView>();

		if (null != list && !list.isEmpty()) {
			List<LocationModel> locationModelList = new ArrayList<LocationModel>();
			Set<String> vinset = list.stream().map(ViCarlocationEntity::getVinnumber).collect(Collectors.toSet());
			Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("vin", vinset);
			// 获取vin码车辆定位信息
			JSONObject js = RequestUtil.sendPostRequest(batchlocation, hashMap);
			ResultModel<List<LocationModel>> resultModel = (ResultModel<List<LocationModel>>) JSONObject
					.toJavaObject(js, ResultModel.class);
			if (resultModel.isSuccess()) {
				locationModelList = JSONArray.parseArray(resultModel.getData().toString(), LocationModel.class);
			}

			if (null != locationModelList && !locationModelList.isEmpty()) {
				// 获取原始坐标
				List<LatlngModel> points = new ArrayList();
				for (int i = 0; i < locationModelList.size(); i++) {
					LatlngModel model = new LatlngModel();
					model.setLat(locationModelList.get(i).getLat());
					model.setLng(locationModelList.get(i).getLng());
					model.setSort(i + 1);
					points.add(model);
				}
				Map<String, Object> param = new HashMap<>();
				param.put("points", points);
				// 原始坐标转百度
				js = RequestUtil.sendPostRequest(batchbaiduadress, param);
				ResultMoreModel resultLat = (ResultMoreModel) JSONObject.toJavaObject(js, ResultMoreModel.class);
				List<LatlngModel> latlngList = new ArrayList<>(resultLat.getData());
				// 原始坐标转地址
				js = RequestUtil.sendPostRequest(orgbatchaddress, param);
				resultModel = (ResultModel<List<LocationModel>>) JSONObject.toJavaObject(js, ResultModel.class);
				List<LocationModel> addressList = JSONArray.parseArray(resultModel.getData().toString(), LocationModel.class);

				// 获取返回数据
				for (int i = 0; i < locationModelList.size(); i++) {
					if(StringUtil.isEmpty(locationModelList.get(i).getFrameNumber())){
						FenceCarInfoView view = new FenceCarInfoView();
						view.setVinnumber(locationModelList.get(i).getFrameNumber());
						view.setIsWire(StatusConvert.Locationtype(locationModelList.get(i).getLocateMode()));
						view.setLocationTime(locationModelList.get(i).getGpsTimestamp());
						view.setCheckTime(locationModelList.get(i).getLastTimestamp());
						for (int j = 0; j < latlngList.size(); j++) {
							if (latlngList.get(j).getSort() == i + 1 && latlngList.get(j).getLat().intValue() != 0 
									&& latlngList.get(j).getLng().intValue() != 0 ) {
								// 计算是否在2公里范围内
								PolygonView polygon = new PolygonView();
								polygon.setLat(String.valueOf(latlngList.get(j).getLat()));
								polygon.setLng(String.valueOf(latlngList.get(j).getLng()));
								double distance = GetDistanceByLatLng.getDistance(polygonView, polygon);
								if (distance < 2000) {
									view.setLat(latlngList.get(j).getLat());
									view.setLng(latlngList.get(j).getLng());
									view.setAddress(addressList.get(j).getAddress());
									carInfoViewsList.add(view);
									break;
								}
							}
						}
					}
				}
			}
		}

		DistanceCarAndFence carAndFence = new DistanceCarAndFence();
		carAndFence.setCarinfoByDistance(carInfoViewsList);
		carAndFence.setFenceinfoByDistance(fenceinfoByDistance);
		return R.ok().put("carAndFence", carAndFence);
	}

}
