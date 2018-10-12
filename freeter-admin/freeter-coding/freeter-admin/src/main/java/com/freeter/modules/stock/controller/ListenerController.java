package com.freeter.modules.stock.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.freeter.common.utils.DateUtils;
import com.freeter.common.utils.GeoUtil;
import com.freeter.modules.stock.entity.TbDevicelocalizationEntity;
import com.freeter.modules.stock.entity.TmAlarminfoEntity;
import com.freeter.modules.stock.entity.TmDeviceinfoEntity;
import com.freeter.modules.sys.entity.SysDeptEntity;
import com.freeter.modules.sys.service.SysDeptService;

@Controller
@RequestMapping("/kafkalistener")
public class ListenerController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysDeptService sysDeptService;
	
	//@KafkaListener(topics = "test",containerFactory = "kafkaListenerContainerFactory")
	@RequestMapping("/wiredloc")
//	@RequiresPermissions("kafkalistener:wiredloc")
	public void consumerWired(List<ConsumerRecord<?,?>> records , Acknowledgment ack){
		logger.info("Wired_loc records size is :"+records.size()+" in all ");
//		StringBuffer tmpStr=null;
		List<TbDevicelocalizationEntity> entityList=new ArrayList<>();
	    try {
            for (ConsumerRecord<?,?> record : records) {
            	logger.info("KAFKA obd_WIRE: "+record.value().toString());
            	
//            	StringBuffer tmpStr=new StringBuffer(record.value().toString());
//            	TbDevicelocalizationEntity tbDeviceEntity=new TbDevicelocalizationEntity();
//            	
//            	if(tmpStr.length()!=0){
//            		//json格式化
//                	tmpStr.delete(0, 1);
//                	tmpStr.delete(tmpStr.length()-1, tmpStr.length());
//                	Map map=(Map)JSON.parseObject(tmpStr.toString());
//                	Map mapExt=(Map)JSON.parseObject(map.get("ext").toString());
//                	
//                	tbDeviceEntity.setVinnumber(mapExt.get("framenumber").toString());
//                	tbDeviceEntity.setDevicenumber(map.get("imei").toString());
//                	//坐标系转换
//                	Point point = GeoUtil.
//                			convertEarth2Baidu(Double.valueOf(map.get("lng").toString()), Double.valueOf(map.get("lat").toString()));
//                	
//                	tbDeviceEntity.setDevicelng(BigDecimal.valueOf(point.getX()));
//                	tbDeviceEntity.setDevicelat(BigDecimal.valueOf(point.getY()));
//                	tbDeviceEntity.setLocationtype(Integer.valueOf(map.get("loctype").toString()));
//                	tbDeviceEntity.setLocationtime(DateUtils.UTCCastDate(map.get("t")));
//                	tbDeviceEntity.setIswireless(Integer.valueOf(map.get("wiretype").toString()));
//                	
//                }
//            	entityList.add(tbDeviceEntity);
            	//tbDevicelocalizationService.insertTbDeviceLocByBatch(entityList);
            	SysDeptEntity sysDeptEntity = new SysDeptEntity();
            	sysDeptEntity.setName("kafkaTest");
            	sysDeptService.insert(sysDeptEntity);

            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ack.acknowledge();//手动提交偏移量
	    }
	}
	
//	@KafkaListener(topics = "obd_warn",containerFactory = "kafkaListenerContainerFactory")
	public void consumerWarn(List<ConsumerRecord<?,?>> records , Acknowledgment ack){
		logger.info("Warn records size is :"+records.size()+" in all ");
		
		List<TmAlarminfoEntity> entityList=new ArrayList<>();
		
	    try {
            for (ConsumerRecord<?,?> record : records) {
            	logger.info("KAFKA obd_WARN: "+record.value().toString());
            	
            	StringBuffer tmpStr=new StringBuffer(record.value().toString());
            	TmAlarminfoEntity alarminfoEntity=new TmAlarminfoEntity();
            	
            	if(tmpStr.length()!=0){
            		//json格式化
                	tmpStr.delete(0, 1);
                	tmpStr.delete(tmpStr.length()-1, tmpStr.length());
                	Map map=(Map)JSON.parseObject(tmpStr.toString());
                	Map mapExt=(Map)JSON.parseObject(map.get("ext").toString());
                	
                	alarminfoEntity.setVinnumber(mapExt.get("framenumber").toString());
                	alarminfoEntity.setDevicenumber(map.get("imei").toString());
                	//坐标系转换
                	Point point = GeoUtil.
                			convertEarth2Baidu(Double.valueOf(map.get("lng").toString()), Double.valueOf(map.get("lat").toString()));
                	alarminfoEntity.setDevicelng(BigDecimal.valueOf(point.getX()));
                	alarminfoEntity.setDevicelat(BigDecimal.valueOf(point.getY()));
                	
                	alarminfoEntity.setAlarmtype(Integer.valueOf(map.get("wtype").toString()));
                	alarminfoEntity.setAlarmtime(DateUtils.UTCCastDate(map.get("t")));
                }
            	entityList.add(alarminfoEntity);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ack.acknowledge();//手动提交偏移量
	    }
	}
	
	//@KafkaListener(topics = "obd_wired_hb",containerFactory = "kafkaListenerContainerFactory")
	public void consumerWarnHB(List<ConsumerRecord<?,?>> records , Acknowledgment ack){
		logger.info("wired_hb records size is :"+records.size()+" in all ");
		
		List<TmDeviceinfoEntity> entityList=new ArrayList<>();
		
	    try {
            for (ConsumerRecord<?,?> record : records) {
            	logger.info("KAFKA wired_hb: "+record.value().toString());
            	
            	StringBuffer tmpStr=new StringBuffer(record.value().toString());
            	TmDeviceinfoEntity deviceinfoEntity=new TmDeviceinfoEntity();
            	
            	if(tmpStr.length()!=0){
            		//json格式化
                	tmpStr.delete(0, 1);
                	tmpStr.delete(tmpStr.length()-1, tmpStr.length());
                	Map map=(Map)JSON.parseObject(tmpStr.toString());
                	Map mapExt=(Map)JSON.parseObject(map.get("ext").toString());
                	
                	//电压转换单位
                	BigDecimal bd=new BigDecimal(1000);
                	BigDecimal bdVol=new BigDecimal(map.get("vol").toString());
                	
                	deviceinfoEntity.setVinnumber(mapExt.get("framenumber").toString());
                	deviceinfoEntity.setDevicenumber(map.get("imei").toString());
                	deviceinfoEntity.setIswireless(Integer.valueOf(map.get("wiretype").toString()));
                	deviceinfoEntity.setVoltage(bd.divide(bdVol, 2, BigDecimal.ROUND_HALF_UP));
                	deviceinfoEntity.setBatterypct(new BigDecimal(map.get("bat").toString()));
                }
            	entityList.add(deviceinfoEntity);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        ack.acknowledge();//手动提交偏移量
	    }
	}

}
