package com.freeter.utils;

import java.util.List;

import com.freeter.modules.stock.entity.view.PolygonView;

public class GetDistanceByLatLng {
private static double EARTH_RADIUS = 6378.137;    
    
    private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    
    /**   
     * 通过经纬度获取距离(单位：米)   
     * @param lat1   
     * @param lng1   
     * @param lat2   
     * @param lng2   
     * @return   
     */    
    public static double getDistance2(PolygonView PolygonView,PolygonView PolygonView2) {
        Double lat1 = Double.valueOf(PolygonView.getLat());
        Double lat2 = Double.valueOf(PolygonView2.getLat());
        Double lng1 = Double.valueOf(PolygonView.getLat());
        Double lng2 = Double.valueOf(PolygonView2.getLat());
        double radLat1 = rad(lat1);    
        double radLat2 = rad(lat2);    
        double a = radLat1 - radLat2;    
        double b = rad(lng1) - rad(lng2);    
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;    
        s = s*1000;    
        return s;    
    }    


    public static double getDistance(PolygonView PolygonView,PolygonView PolygonView2){
    	Double lat1 = Double.valueOf(PolygonView.getLat());
        Double lat2 = Double.valueOf(PolygonView2.getLat());
        Double lng1 = Double.valueOf(PolygonView.getLng());
        Double lng2 = Double.valueOf(PolygonView2.getLng());
        lat1 = (Math.PI/180)*lat1;
        lat2 = (Math.PI/180)*lat2;
        lng1 = (Math.PI/180)*lng1;
        lng2 = (Math.PI/180)*lng2;
        //地球半径
        double R = 6371;
        //两点间距离 km，如果想要米的话，结果*1000
        double d =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lng2-lng1))*R;
        return d*1000;
        
    }

    

}
