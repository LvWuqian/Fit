package org.csu.fit.service;

import com.alibaba.fastjson.JSONObject;

public interface RecipeService {

    public JSONObject getRecipeByClassId(String classId);
}
