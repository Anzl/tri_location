package com.trilateration.domain;

import com.trilateration.algorithm.Trilateral;
import com.trilateration.bean.BaseStation;
import com.trilateration.bean.Coordinate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tri_location
 * @description: com.trilateration.domain
 * @author: Anzhaoliang
 * @create: 2021/7/22 13:26
 *
 * 得到Tag到A0,A1,A2,A3的距离
 **/
public class GetDistance {
    /*距离*/
    private double tagDistance;
    private Map<String, String> map;
    private Trilateral trilateral;
/*距离数组*/
    private double d[];

//        串口程序传入距离字符串
    public Map<String, String> getDistance(String string){
      /*  一条完整的数据
          mc 01 000000bc ffffffff ffffffff ffffffff 0920 6a 00040207 a0:0
          $T0,-56.55,-72.75
        */
//        string的数据:000000bc ffffffff ffffffff ffffffff
        String[] strs =string.split(" ");
        map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            if(strs[i].equals("ffffffff")){
                continue;
            }else {
                /*将收到的数据格式转化为10进制*/
                tagDistance=Integer.parseInt(strs[i],16);
//                System.out.println("A" + i + ":" + tagDistance);
                map.put("A" + i, tagDistance + "");
            }
        }
        trilateral = new Trilateral(map.entrySet());
        d = trilateral.Algorithem();
        BigDecimal b = new BigDecimal(d[0]/1000);
        BigDecimal bb = new BigDecimal(d[1]/1000);
        double TagX = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        double TagY = bb.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("********************************************");
        System.out.println("TagX：" + TagX + "m," + "TagY：" + TagY + "m");
        return map;

    }

}
