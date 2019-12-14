package org.csu.fit.controller;

import com.alibaba.fastjson.JSONObject;
import org.csu.fit.domain.DailyFood;
import org.csu.fit.domain.DailyFoodForChart;
import org.csu.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DailyFoodController {

    @Autowired
    private UserService userService;

    @GetMapping("/dailyfood/{date}")
    public DailyFood getDailyFoodByDate(@PathVariable("date") String date){
        return userService.getDailyFood(date);
    }

    @GetMapping("/alldailyfood")
    public List<DailyFoodForChart> getAllDailyFood(){
        return userService.getAllDailyFood();
    }

    @PostMapping("/adddailyfood")
    public void insertDailyFood(@RequestBody JSONObject dailyfood){
        userService.insertDailyFood(dailyfood);
    }
}
