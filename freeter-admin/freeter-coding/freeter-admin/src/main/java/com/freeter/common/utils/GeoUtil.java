package com.freeter.common.utils;

import org.springframework.data.geo.Point;

/**
 * 坐标系转换
 * @author Administrator
 *
 */
public class GeoUtil {

    public final static double PI     = 3.1415926535897932384626;
    public final static double AXIS   = 6378245.0;             //
    private final static double OFFSET = 0.00669342162296594323; // (a^2 - b^2) / a^2
    private final static double X_PI   = PI * 3000.0 / 180.0;
	
	/**
     * 地球坐标转百度坐标
     * @param earthLat
     * @param earthLon
     * @return
     */
    public static Point convertEarth2Baidu(double earthLat, double earthLon) {
        return convertMars2Baidu(convertEarth2Mars(earthLat, earthLon));
    }
    
    /**
     * 火星坐标转百度坐标
     * @param point
     * @return
     */
    public static Point convertMars2Baidu(Point point) {
        return convertMars2Baidu(point.getX(), point.getY());
    }
    
    /**
     * 火星坐标转百度坐标
     * 
     * @param mars_lat
     * @param mars_lon
     * @return
     */
    public static Point convertMars2Baidu(double marsLat, double marsLon) {
        double[] p = GeoUtil.gcj2BD09(marsLat, marsLon);
        return new Point(p[1],p[0]);
    }
    
    // GCJ-02=>BD09 火星坐标系=>百度坐标系
    public static double[] gcj2BD09(double glat, double glon) {
        double x = glon;
        double y = glat;
        double[] latlon = new double[2];
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        latlon[0] = z * Math.sin(theta) + 0.006;
        latlon[1] = z * Math.cos(theta) + 0.0065;
        return latlon;
    }
    
    /**
     * 从地球坐标转换为火星坐标,例如:苹果坐标转高德坐标
     * 
     * @param earthLat
     * @param earthLon
     * @return
     */
    public static Point convertEarth2Mars(double earthLat, double earthLon) {
        double[] p = GeoUtil.wgs2GCJ(earthLat, earthLon);
        return new Point(p[1], p[0]);
    }
    
    // WGS84=》GCJ02 地球坐标系=>火星坐标系
    public static double[] wgs2GCJ(double wgLat, double wgLon) {
        double[] latlon = new double[2];
        if (outOfChina(wgLat, wgLon)) {
            latlon[0] = wgLat;
            latlon[1] = wgLon;
            return latlon;
        }
        double[] deltaD = delta(wgLat, wgLon);
        latlon[0] = wgLat + deltaD[0];
        latlon[1] = wgLon + deltaD[1];
        return latlon;
    }
    
    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347) return true;
        if (lat < 0.8293 || lat > 55.8271) return true;
        return false;
    }
    
    public static double[] delta(double wgLat, double wgLon) {
        double[] latlng = new double[2];
        double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
        double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
        double radLat = wgLat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - OFFSET * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((AXIS * (1 - OFFSET)) / (magic * sqrtMagic) * PI);
        dLon = (dLon * 180.0) / (AXIS / sqrtMagic * Math.cos(radLat) * PI);
        latlng[0] = dLat;
        latlng[1] = dLon;
        return latlng;
    }
    
    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }
    
    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }
}
