package org.csu.fit.controller;

import com.alibaba.fastjson.JSONArray;
import org.csu.fit.config.OssConfiguration;
import org.csu.fit.domain.Dishes;
import org.csu.fit.service.DishService;
import org.csu.fit.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UploadController {
    @Autowired
    private DishService dishService;
    @Autowired
    private IFileService fileService;
    @Autowired
    private OssConfiguration ossConfiguration;

    @PostMapping("/dish/{userId}")
    public List<Dishes> dishRecognise(@PathVariable("userId") int userId, @RequestParam("picture") MultipartFile file){
        try {
            if(file != null){
                String filename = file.getOriginalFilename();
                if (!"".equals(filename.trim())){
                    System.out.println("file size:" + file.getSize());
                    String uploadUrl = ossConfiguration.getPREFIX() + fileService.uploadPicture(file);
                    if(uploadUrl != null){

                        JSONArray resList = dishService.getDishesByFilePath(uploadUrl);

                        List<Dishes> ansList = new ArrayList<>();
                        for(int i = 0; i < resList.size(); i ++){
                            Dishes dishes = new Dishes();
                            dishes.setTargetImage_url(uploadUrl);
                            dishes.setName(resList.getJSONObject(i).getString("name"));
                            dishes.setImage_url(resList.getJSONObject(i).getJSONObject("baike_info").getString("image_url"));
                            dishes.setBaike_url(resList.getJSONObject(i).getJSONObject("baike_info").getString("baike_url"));
                            dishes.setCalorie(resList.getJSONObject(i).getFloat("calorie"));
                            dishes.setDescription(resList.getJSONObject(i).getJSONObject("baike_info").getString("description"));
                            dishes.setProbability(resList.getJSONObject(i).getFloat("probability"));

                            ansList.add(dishes);
                        }
                        return ansList;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
