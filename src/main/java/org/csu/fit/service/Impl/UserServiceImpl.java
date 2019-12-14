package org.csu.fit.service.Impl;

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
}
