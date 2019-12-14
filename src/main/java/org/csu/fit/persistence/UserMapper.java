package org.csu.fit.persistence;

import org.csu.fit.domain.DailyFoodForDAO;
import org.csu.fit.domain.User;

import java.util.List;

public interface UserMapper {

    User getUserByUsernameAndPassword(String username, String password);
    DailyFoodForDAO getDailyFoodForDAOByDate(String date);
    List<DailyFoodForDAO> getAllDailyFood();
    void insertDailyFood(DailyFoodForDAO dailyFoodForDAO);
}
