package org.csu.fit.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.domain.DailyFood;
import org.csu.fit.domain.DailyFoodForChart;
import org.csu.fit.domain.DailyFoodForDAO;
import org.csu.fit.domain.User;
import org.csu.fit.persistence.UserMapper;
import org.csu.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public DailyFood getDailyFood(String date) {
        DailyFood dailyFood = new DailyFood();
        DailyFoodForDAO dailyFoodForDAO = userMapper.getDailyFoodForDAOByDate(date);
        dailyFood.setDate(date);
        dailyFood.setBreakfastCa(dailyFoodForDAO.getBreakfastCa());
        dailyFood.setLunchCa(dailyFoodForDAO.getLunchCa());
        dailyFood.setDinnerCa(dailyFoodForDAO.getDinnerCa());
        dailyFood.setOthersCa(dailyFoodForDAO.getOthersCa());
        String[] breakfasts = dailyFoodForDAO.getBreakfast().split(",");
        dailyFood.setBreakfast(breakfasts);
        String[] lunchs = dailyFoodForDAO.getLunch().split(",");
        dailyFood.setLunch(lunchs);
        String[] dinners = dailyFoodForDAO.getDinner().split(",");
        dailyFood.setDinner(dinners);
        String[] others = dailyFoodForDAO.getOthers().split(",");
        dailyFood.setOthers(others);

        return dailyFood;
    }

    @Override
    public List<DailyFoodForChart> getAllDailyFood() {
        List<DailyFoodForDAO> dailyFoodForDAOS = userMapper.getAllDailyFood();
        List<DailyFoodForChart> dailyFoodForCharts = new ArrayList<>();

        dailyFoodForDAOS.forEach(item->{
            DailyFoodForChart dailyFoodForChart = new DailyFoodForChart();
            dailyFoodForChart.setBreakfastCa(item.getBreakfastCa());
            dailyFoodForChart.setLunchCa(item.getLunchCa());
            dailyFoodForChart.setDinnerCa(item.getDinnerCa());
            dailyFoodForChart.setOthersCa(item.getOthersCa());
            dailyFoodForChart.setYear(item.getDate().substring(0,4));
            dailyFoodForChart.setMonth(item.getDate().substring(4,6));
            dailyFoodForChart.setDay(item.getDate().substring(6));
            dailyFoodForCharts.add(dailyFoodForChart);
        });
        return dailyFoodForCharts;
    }

    @Override
    public void insertDailyFood(JSONObject dailyFood) {
        List<String> breakfasts = (ArrayList<String>)dailyFood.get("breakfast");
        List<String> lunchs = (ArrayList<String>)dailyFood.get("lunch");
        List<String> dinners = (ArrayList<String>)dailyFood.get("dinner");
        List<String> otherss = (ArrayList<String>)dailyFood.get("others");
        String breakfast = "";
        for(int i = 0; i < breakfasts.size(); i++){
            breakfast += breakfasts.get(i) + ",";
        }
        breakfast = breakfast.substring(0, breakfast.length()-1);
        String lunch = "";
        for(int i = 0; i < lunchs.size(); i++){
            lunch += lunchs.get(i) + ",";
        }
        lunch = lunch.substring(0, lunch.length()-1);
        String dinner = "";
        for(int i = 0; i < dinners.size(); i++){
            dinner += dinners.get(i) + ",";
        }
        dinner = dinner.substring(0, dinner.length()-1);
        String others = "";
        for(int i = 0; i < otherss.size(); i++){
            others += otherss.get(i) + ",";
        }
        others = others.substring(0, others.length()-1);

        DailyFoodForDAO dailyFoodForDAO = new DailyFoodForDAO();
        dailyFoodForDAO.setDate(dailyFood.getString("date"));
        dailyFoodForDAO.setBreakfast(breakfast);
        dailyFoodForDAO.setLunch(lunch);
        dailyFoodForDAO.setDinner(dinner);
        dailyFoodForDAO.setOthers(others);
        dailyFoodForDAO.setBreakfastCa(12);
        dailyFoodForDAO.setLunchCa(32);
        dailyFoodForDAO.setDinnerCa(41);
        dailyFoodForDAO.setOthersCa(55);
        userMapper.insertDailyFood(dailyFoodForDAO);

    }
}
