package com.trilateration.bean;

/**
 * @program: tri_location
 * @description: com.trilateration.entity
 * @author: Anzhaoliang
 * @create: 2021/7/19 9:02
 *   基站bean
 **/

public class BaseStation {
//    private static final long serialVersionUID = 1L;
    /*基站id*/
    private String baseId;
    /*基站坐标*/
    private Double xAxis;

    private Double yAxis;

    private Double zAxis;

    public BaseStation() {
    }

    public BaseStation(String baseId, Double xAxis, Double yAxis, Double zAxis) {
        this.baseId = baseId;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
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

}
