package org.csu.fit.service;

import com.alibaba.fastjson.JSONArray;
import org.csu.fit.domain.Dishes;

import java.util.List;

public interface DishService {
    public JSONArray getDishesByFilePath(String filePath);
}
