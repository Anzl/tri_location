package com.trilateration.controller;

import com.trilateration.domain.GetDistance;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: tri_location
 * @description: com.trilateration.controller
 * @author: Anzhaoliang
 * @create: 2021/7/22 10:22
 * 访问端口：http://localhost:8081/DistanceList
 **/
@RestController
@RequestMapping(value = {"/DistanceList"},method = {RequestMethod.POST})
public class DistanceController {
    private Map<String, String> tagDistance;

    @ResponseBody
    @RequestMapping(
            value = {"local"},
            method = {RequestMethod.POST}
    )
    private Map<String, String> getDistance(@RequestParam(value = "disString",required =false) String disString){

        GetDistance td = new GetDistance();
        tagDistance = td.getDistance(disString);
        return tagDistance;
    }


}
