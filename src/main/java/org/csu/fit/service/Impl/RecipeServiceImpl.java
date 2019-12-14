package org.csu.fit.service.Impl;

import org.csu.fit.service.RecipeService;
import org.csu.fit.utils.RecipeAPI.Byclass;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.utils.RecipeAPI.Detail;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Override
    public JSONObject getRecipeByClassId(String classId) {
        JSONObject result = JSONObject.parseObject(Byclass.Get(classId));
        return result;
    }

    @Override
    public JSONObject getRecipeById(String id) {
        JSONObject result = Detail.Get(id);
        return result;
    }
}
