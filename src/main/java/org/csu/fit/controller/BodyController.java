package org.csu.fit.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BodyController {

    @Autowired
    private BodyService bodyService;

    @GetMapping("/bodyScore")
    public double getBodyScore(){
       return bodyService.getBodyScore("/Users/lvwuqian/Desktop/pang.jpg");
    }
}
