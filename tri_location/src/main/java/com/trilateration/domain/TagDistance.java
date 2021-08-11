package com.trilateration.domain;

import java.io.Serializable;

/**
 * @program: tri_location
 * @description: com.trilateration.domin
 * @author: Anzhaoliang
 * @create: 2021/7/22 10:35
 **/
public class TagDistance implements Serializable {

    /**
     * 标签到A0,A1,A2,A3的距离
     * */
    private double TagA0;
    private double TagA1;
    private double TagA2;
    private double TagA3;

    public TagDistance() {
    }

    public TagDistance(double tagA0, double tagA1, double tagA2, double tagA3) {
        TagA0 = tagA0;
        TagA1 = tagA1;
        TagA2 = tagA2;
        TagA3 = tagA3;
    }

    public double getTagA0() {
        return TagA0;
    }

    public void setTagA0(double tagA0) {
        TagA0 = tagA0;
    }

    public double getTagA1() {
        return TagA1;
    }

    public void setTagA1(double tagA1) {
        TagA1 = tagA1;
    }

    public double getTagA2() {
        return TagA2;
    }

    public void setTagA2(double tagA2) {
        TagA2 = tagA2;
    }

    public double getTagA3() {
        return TagA3;
    }

    public void setTagA3(double tagA3) {
        TagA3 = tagA3;
    }

    public double getTagAll(double tagA0, double tagA1, double tagA2, double tagA3){
        return tagA0 + tagA1 + tagA2 + tagA3;
    }
}
