package org.csu.fit.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.service.BodyService;
import org.csu.fit.utils.BaiduAPI.BodyAnalysis;
import org.springframework.stereotype.Service;

@Service
public class BodyServiceImpl implements BodyService {

    @Override
    public double getBodyScore(String filePath) {
        String bodyString = BodyAnalysis.body_analysis(filePath);
        JSONObject bodyJson = JSONObject.parseObject(bodyString);
        JSONArray bodyArray = (JSONArray) bodyJson.get("person_info");
        JSONObject body = bodyArray.getJSONObject(0);
        JSONObject body_parts = body.getJSONObject("body_parts");
        Float left_hip_x = Float.parseFloat(body_parts.getJSONObject("left_hip").getString("x"));
        Float left_hip_y = Float.parseFloat(body_parts.getJSONObject("left_hip").getString("y"));
        Float right_hip_x = Float.parseFloat(body_parts.getJSONObject("right_hip").getString("x"));
        Float right_hip_y = Float.parseFloat(body_parts.getJSONObject("right_hip").getString("y"));
        Float left_shoulder_x = Float.parseFloat(body_parts.getJSONObject("left_shoulder").getString("x"));
        Float left_shoulder_y = Float.parseFloat(body_parts.getJSONObject("left_shoulder").getString("y"));
        Float right_shoulder_x = Float.parseFloat(body_parts.getJSONObject("right_shoulder").getString("x"));
        Float right_shoulder_y = Float.parseFloat(body_parts.getJSONObject("right_shoulder").getString("y"));
        Float left_eye_x = Float.parseFloat(body_parts.getJSONObject("left_eye").getString("x"));
        Float left_eye_y = Float.parseFloat(body_parts.getJSONObject("left_eye").getString("y"));
        Float right_eye_x = Float.parseFloat(body_parts.getJSONObject("right_eye").getString("x"));
        Float right_eye_y = Float.parseFloat(body_parts.getJSONObject("right_eye").getString("y"));
        System.out.println(left_hip_x + "  " + left_hip_y + "  " + right_hip_x + "  " + right_hip_y + "  " + left_shoulder_x + "  " + left_shoulder_y + "  " + right_shoulder_x + "  " + right_shoulder_y + "  ");
        Double hip = Math.sqrt(Math.pow(left_hip_x - right_hip_x, 2) + Math.pow(left_hip_y - right_hip_y, 2));
        Double shoulder = Math.sqrt(Math.pow(left_shoulder_x - right_shoulder_x, 2) + Math.pow(left_shoulder_y - right_shoulder_y, 2));
        Double eye = Math.sqrt(Math.pow(left_eye_x - right_eye_x, 2) + Math.pow(left_eye_y - right_eye_y, 2));
        Double resultScore = (hip / eye + shoulder / eye) * 10;
        System.out.println(resultScore);
        return resultScore;
    }
}
