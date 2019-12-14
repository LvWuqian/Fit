package org.csu.fit.controller;

import com.alibaba.fastjson.JSONObject;
import org.csu.fit.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe/{classId}")
    public JSONObject getRecipe(@PathVariable("classId") String classId){
        return recipeService.getRecipeByClassId(classId);
    }
}
