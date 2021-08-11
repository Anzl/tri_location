package com.trilateration.service;

import com.trilateration.domain.TagDistance;

/**
 * @program: tri_location
 * @description: com.trilateration.service
 * @author: Anzhaoliang
 * @create: 2021/7/22 10:45
 **/
public interface TagService {
    TagDistance getDistance(double A0,double A1,double A2,double A3);
}
