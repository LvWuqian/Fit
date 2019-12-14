package org.csu.fit.utils.RecipeAPI;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Detail {

    public static final String APPKEY = "75d339101469006e";// 你的appkey
    public static final String URL = "https://api.jisuapi.com/recipe/detail";
    //public static final int id = 5;

    public static JSONObject Get(String recipeId) {
        String result = null;

        String url = URL + "?id=" + recipeId + "&appkey=" + APPKEY;

        try {
            result = RecipeHttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                String id = resultarr.getString("id");
                String classid = resultarr.getString("classid");
                String name = resultarr.getString("name");
                String peoplenum = resultarr.getString("peoplenum");
                String preparetime = resultarr.getString("preparetime");
                String cookingtime = resultarr.getString("cookingtime");
                String content = resultarr.getString("content");
                String pic = resultarr.getString("pic");
                String tag = resultarr.getString("tag");
                System.out.println(id + " " + classid + " " + name + " " + peoplenum + " " + preparetime + " "
                        + cookingtime + " " + content + " " + pic + " " + tag);
                if (resultarr.get("material") != null) {
                    JSONArray material = resultarr.getJSONArray("material");
                    for (int i = 0; i < material.size(); i++) {
                        JSONObject obj = (JSONObject) material.get(i);
                        String mname = obj.getString("mname");
                        String type = obj.getString("type");
                        String amount = obj.getString("amount");
                        System.out.println(mname + " " + type + " " + amount);
                    }
                }
                if (resultarr.get("process") != null) {
                    JSONArray process = resultarr.getJSONArray("process");
                    for (int i = 0; i < process.size(); i++) {
                        JSONObject obj = (JSONObject) process.get(i);
                        String pcontent = obj.getString("pcontent");
                        String pic_ = obj.getString("pic");
                        System.out.println(pcontent + " " + pic_);
                    }
                }
                return resultarr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Get("5");
//    }
}

