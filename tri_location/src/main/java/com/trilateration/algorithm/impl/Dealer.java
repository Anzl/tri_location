package com.trilateration.algorithm.impl;

import com.trilateration.bean.Location;
import com.trilateration.domain.GetDistance;

/**
 * @program: tri_location
 * @description: com.trilateration.algorithm.impl
 * @author: Anzhaoliang
 * @create: 2021/7/23 9:20
 **/
public interface Dealer {
    /**
     * 求定位终端坐标
     *
     * @param  map  接收到的一组基站组成的字符串(格式为“id,rssi;id,rssi........id,rssi;terminalID”)
     * @return  返回定位结果对象
     */
    public Location getLocation(GetDistance map);
}
