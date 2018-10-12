package com.freeter.utils;

/**
 * 车辆状态转换
 * @author Administrator
 *
 */
public class StatusConvert {

	/**
	 * 车辆详细状态数字转中文
	 * @param status
	 * @return
	 */
	public static String carDetailStatus(int status) {
		switch (status) {
			case 0:
				return "在途"; 
			case 1:
				return "已签收";
			case 2:
				return "特殊入库";
			case 3:
				return "已售出";
			case 4:
				return "车辆在库";
			case 5:
				return "正常出库";
			case 6:
				return "特殊出库";
			case 7:
				return "异常出库";
			case 8:
				return "超时未入库";
			case 9:
				return "超时未还款";
			case 10:
				return "已还款";
			default:
				return null;
			}
	}
	
	/**
	 * 车辆状态转业务流程NoToNo
	 * @param detailStatus
	 * @return
	 */
	public static Integer detailStatusNoToCircutypeNo(int detailStatus){
		switch (detailStatus) {
			case 1:
				return 1;
			case 3:
				return 21;
			case 4:
				return 24;
			case 8:
				return 4;
			case 9:
				return 23;
			case 10:
				return 2;
			default:
				return -1;
		}
	}
	
	/**
	 * 车辆状态数字转中文
	 * @param status
	 * @return
	 */
	public static String carStatus(int status) {
		switch (status) {
		case 0:
			return "未入库";
		case 1:
			return "在库";
		case 2:
			return "出库";
		case 3:
			return "出售";
		default:
			return null;
		}
	}
	
	/**
	 * 设备状态数字转中文
	 * @param status
	 * @return
	 */
	public static String ODBStatus(int status) {
		switch (status) {
		case 0:
			return "正常";
		case 1:
			return "异常";
		default:
			return null;
		}
	}
	
	/**
	 * 车辆状态转车辆详细状态
	 * @param status
	 * @return
	 */
	public static String StatusToDetail(String status) {
		String inStr="";
		if(status.equals("0")){
			inStr="0,1,2,8";
		}else if(status.equals("1")){
			inStr="4";
		}else if(status.equals("2")){
			inStr = "5,6,7";
		}else if(status.equals("3")){
			inStr = "3,9,10";
		}
		
		return inStr;
	}
	
	/**
	 * 车辆详细状态转车辆状态
	 * @param status
	 * @return
	 */
	public static Integer DetailToStatus(int status) {
		int inStr=0;
		if(status == 0 || status == 1 || status == 2 || status == 8){
			inStr = 0;
		}else if(status == 4){
			inStr = 1;
		}else if(status == 5 || status == 6 ||status == 7){
			inStr = 2;
		}else if(status == 3 || status == 9 || status == 10){
			inStr = 3;
		}
		
		return inStr;
	}
	
	/**
	 * 定位类型转换
	 * @param status
	 * @return
	 */
	public static String Locationtype(int status){
		switch (status) {
		case 0:
			return "GPS"; 
		case 1:
			return "基站";
		case 2:
			return "WIFI";
		case 3:
			return "北斗";
		case 4:
			return "GPS 北斗混合定位";
		default:
			return null;
		}
	}
	
	/**
	 * 报警类型状态转换
	 * @param status
	 * @return
	 */
	public static String RemindType(int status){
		//1违规出库2低电压3无信号4非法拆除5震动6位移7碰撞8超时未入库)
		switch (status) {
		case 1:
			return "违规出库";
		case 2:
			return "低电压";
		case 3:
			return "无信号";
		case 4:
			return "非法拆除";
		case 5:
			return "震动";
		case 6:
			return "位移";
		case 7:
			return "碰撞";
		case 8:
			return "超时未入库";
		case 9:
			return "低电量";
		case 10:
			return "售出未拆除设备";
		case 11:
			return "超时未还款";
		default:
			return null;
		}
	}
	
	/**
	 * 报警处理状态
	 * @param status
	 * @return
	 */
	public static String RemindOperatorType(int status){
		//0待处理1处理中2已处理3延期处理4其他
		switch (status) {
		case 0:
			return "待处理"; 
		case 1:
			return "处理中";
		case 2:
			return "已处理";
		case 3:
			return "延期处理";
		case 4:
			return "其他";
		default:
			return null;
		}
	}
	
	/**
	 * 业务流程类型状态数字转中文
	 * @param status
	 * @return
	 */
	public static String CircuTypeNoToCN(int status){
		//业务流程(0车辆数据导入1签收2还款(解除绑定)3解除报警4超时未入库5违规出库6特殊入申请7特殊入审批8特殊出申请
		//9特殊出审批10低电压11低电量12碰撞13位移14离线15拆除16震动17报警延时处理18报警处理中 19 车辆售出 20 车辆在库 21超时未还款 22 已还款)
		switch (status) {
		case 0:
			return "车辆数据导入";
		case 1:
			return "签收";
		case 2:
			return "已还款";
		case 3:
			return "解除报警";
		case 4:
			return "超时未入库";
		case 5:
			return "违规出库";
		case 6:
			return "特殊入申请";
		case 7:
			return "特殊入审批";
		case 8:
			return "特殊出申请";
		case 9:
			return "特殊出审批";
		case 10:
			return "低电压";
		case 11:
			return "低电量";
		case 12:
			return "碰撞";
		case 13:
			return "位移";
		case 14:
			return "离线";
		case 15:
			return "拆除";
		case 16:
			return "震动";
		case 17:
			return "报警延时处理";
		case 18:
			return "报警处理中";
		case 19:
			return "特殊入库拒绝";
		case 20:
			return "特殊出库拒绝";
		case 21:
			return "车辆售出";
		case 22:
			return "车辆在库 ";
		case 23:
			return "超时未还款";
		case 24:
			return "标记入库";
		default:
			return null;
		}
	}
}
