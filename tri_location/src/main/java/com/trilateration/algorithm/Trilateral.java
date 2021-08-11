package com.trilateration.algorithm;

import com.trilateration.algorithm.impl.Dealer;
import com.trilateration.bean.BaseStation;
import com.trilateration.bean.Coordinate;
import com.trilateration.bean.Location;
import com.trilateration.domain.GetDistance;

import java.math.BigDecimal;
import java.util.*;

/**
 * @program: tri_location
 * @description: com.trilateration.algorithm
 * @author: Anzhaoliang
 * @create: 2021/7/23 9:19
 *
 * 三边定位算法
 **/
public class Trilateral{

    /**
     *
     * @param recvStr  接收到的来自串口程序的测距数据
     * @param dealMethod 对测距数据的处理方式 0 对测距数据不进行非视距误差纠正 1 对测距数据进行误差纠正
     * @param baseLowBound 进行标签解算所需要的最少基站数量
     * @return 返回一个关于基站的坐标和相关测距的二维数组 每一行数据的数据结构形式为 基站的x,y,z坐标,标签与基站的测量距离,相对应的基站名称
     */
    private Set<Map.Entry<String, String>> recvStr;
    private BaseStation A0;
    private BaseStation A1;
    private BaseStation A2;

    private static final int NO_ERROR_CORRECTED=0;
    private static final int ERROR_CORRECTED=1;

//    private BaseStation[] baseStation = new BaseStation[3];
//    private List<BaseStation> baseStationList = new ArrayList<>();

    public Trilateral() {
    }

    public Trilateral(Set<Map.Entry<String, String>> entrySet) {
        this.recvStr = entrySet;
    }


    /*设置基站坐标*/
//    public List<BaseStation> setBaseStationLocation(BaseStation[] baseStation,List<BaseStation> baseStationList){
//
//        /*A0坐标*/
//        baseStation[0].setBaseId("A0");
//        baseStation[0].setxAxis(0.00);
//        baseStation[0].setyAxis(0.00);
//        baseStation[0].setzAxis(2.00);
//
//        /*A1坐标*/
//        baseStation[1].setBaseId("A1");
//        baseStation[1].setxAxis(3.00);
//        baseStation[1].setyAxis(0.00);
//        baseStation[1].setzAxis(2.00);
//        /*A2坐标*/
//        baseStation[2].setBaseId("A2");
//        baseStation[2].setxAxis(1.50);
//        baseStation[2].setyAxis(3.32);
//        baseStation[2].setzAxis(2.00);
//        /*A3坐标*/
////        baseStation[3].setBaseId("A3");
////        baseStation[3].setxAxis(0.00);
////        baseStation[3].setyAxis(0.00);
////        baseStation[3].setzAxis(2.00);
//        baseStationList.add(baseStation[0]);
//        baseStationList.add(baseStation[1]);
//        baseStationList.add(baseStation[2]);
//        return baseStationList;
//
//    }
    public void print(){
        for (Map.Entry<String, String> me : recvStr) {
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key + ", " + value);
            System.out.println("str的长度是：" + recvStr.size());
        }
    }
    /*计算标签坐标*/
    public double[] Algorithem(){
        Coordinate tagCoordinate = null;
        /*存放标签到基站距离的字符串数组*/
        String[] tagDistance = new String[3];
        int i = 0;
        double x1,y1,x2,y2,x3,y3;
        for (Map.Entry<String, String> me : recvStr) {
            tagDistance[i++] = me.getValue();
        }
        /*基站A0的坐标(x1,y1)*/
        A0 = new BaseStation("A0",0.00,0.00,740.00);
        A1 = new BaseStation("A1",720.00,0.00,740.00);
        A2 = new BaseStation("A2",470.00,930.00,740.00);

        x1 = A0.getxAxis();
        y1 = A0.getyAxis();
        /*基站A1的坐标(x2,y2)*/
        x2 = A1.getxAxis();
        y2 = A1.getyAxis();
        /*基站A2的坐标(x3,y3)*/
        x3 = A2.getxAxis();
        y3 = A2.getyAxis();
//        System.out.println("x3=" + x3 + "," + "y3=" + y3 + "," + "Tag与A0距离d1:" + tagDistance[2]);
//        System.out.println("x1=" + x1 + "," + "y1=" + y1 + "," + "Tag与A1距离d2:" + tagDistance[0]);
//        System.out.println("x2=" + x2 + "," + "y2=" + y2 + "," + "Tag与A2距离d3:" + tagDistance[1]);
        /*计算标签坐标*/
        double []d={0.0,0.0};
        double a11 = 2*(x1-x3);
        double a12 = 2*(y1-y3);
        double b1 = Math.pow(x1,2)-Math.pow(x3,2) +Math.pow(y1,2)-Math.pow(y3,2) + Math.pow(Double.parseDouble(tagDistance[1]),2)-Math.pow(Double.parseDouble(tagDistance[2]),2);
        double a21 = 2*(x2-x3);
        double a22 = 2*(y2-y3);
        double b2 = Math.pow(x2,2)-Math.pow(x3,2) +Math.pow(y2,2)-Math.pow(y3,2) +Math.pow(Double.parseDouble(tagDistance[1]),2)-Math.pow(Double.parseDouble(tagDistance[0]),2);
        d[0]=(b1*a22-a12*b2)/(a11*a22-a12*a21);
        d[1]=(a11*b2-b1*a21)/(a11*a22-a12*a21);
        return d;
    }




}
