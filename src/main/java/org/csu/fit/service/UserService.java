package org.csu.fit.service;

import com.alibaba.fastjson.JSONObject;
import org.csu.fit.domain.DailyFood;
import org.csu.fit.domain.DailyFoodForChart;
import org.csu.fit.domain.DailyFoodForDAO;
import org.csu.fit.domain.User;

import java.util.List;

public interface UserService {
    public User login(String username, String password);
    public DailyFood getDailyFood(String date);
    public List<DailyFoodForChart> getAllDailyFood();
    public void insertDailyFood(JSONObject dailyFood);
}
