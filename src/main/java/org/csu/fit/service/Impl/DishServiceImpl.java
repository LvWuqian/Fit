package org.csu.fit.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.domain.Dishes;
import org.csu.fit.service.DishService;
import org.csu.fit.utils.BaiduAPI.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Override
    public JSONArray getDishesByFilePath(String filePath) {
        String dishString = Dish.dish(filePath);
        JSONObject dishJson = JSONObject.parseObject(dishString);
        JSONArray dishArray = (JSONArray) dishJson.get("result");
        return dishArray;
    }
}
