package org.csu.fit.controller;

import com.alibaba.fastjson.JSONArray;
import org.csu.fit.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping("/dish")
    public JSONArray getDishes(){
        return dishService.getDishesByFilePath("/Users/lvwuqian/Desktop/hongshaorou.jpeg");
    }

}
