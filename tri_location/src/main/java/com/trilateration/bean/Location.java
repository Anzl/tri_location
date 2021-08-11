package com.trilateration.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: tri_location
 * @description: com.trilateration.bean
 * @author: Anzhaoliang
 * @create: 2021/7/22 15:50
 *
 * 定位的结果bean
 **/
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;

    /*x轴坐标*/
    private Double xAxis;

    /*y轴坐标*/
    private Double yAxis;

    /*z轴坐标*/
    private Double zAxis;

    /*时间戳*/
    private Timestamp timeStamp;

    public Location(Double xAxis, Double yAxis,Double zAxis, Timestamp timeStamp) {
        super();
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.timeStamp = timeStamp;
    }

    public Location() {
        super();
    }

    public Double getxAxis() {
        return xAxis;
    }

    public void setxAxis(Double xAxis) {
        this.xAxis = xAxis;
    }

    public Double getyAxis() {
        return yAxis;
    }

    public void setyAxis(Double yAxis) {
        this.yAxis = yAxis;
    }

    public Double getzAxis() {
        return zAxis;
    }

    public void setzAxis(Double zAxis) {
        this.zAxis = zAxis;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }


}
