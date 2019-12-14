package org.csu.fit.utils.RecipeAPI;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class Byclass {

    public static final String APPKEY = "75d339101469006e";// 你的appkey
    public static final String URL = "https://api.jisuapi.com/recipe/byclass";
    //public static final int classid = 2;// 分类id(二级id)
    //public static final int start = 0;
    public static final int num = 10;

    public static String Get(String classId) {
        String result = null;
        int start = (int)(Math.random()*10+1);
        String url = URL + "?classid=" + classId + "&start=" + start + "&num=" + num + "&appkey=" + APPKEY;

        try {
            result = RecipeHttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                String num = resultarr.getString("num");
                System.out.println(num);
                if (resultarr.get("list") != null) {
                    JSONArray list = resultarr.getJSONArray("list");
                    for (int j = 0; j < list.size(); j++) {
                        JSONObject list_ = (JSONObject) list.get(j);
                        String id = list_.getString("id");
                        String classid = list_.getString("classid");
                        String name = list_.getString("name");
                        String peoplenum = list_.getString("peoplenum");
                        String preparetime = list_.getString("preparetime");
                        String cookingtime = list_.getString("cookingtime");
                        String content = list_.getString("content");
                        String pic = list_.getString("pic");
                        String tag = list_.getString("tag");
                        System.out.println(id + " " + classid + " " + name + " " + peoplenum + " " + preparetime + " "
                                + cookingtime + " " + content + " " + pic + " " + tag);
                        if (list_.get("material") != null) {
                            JSONArray material = list_.getJSONArray("material");
                            for (int i = 0; i < material.size(); i++) {
                                JSONObject obj = (JSONObject) material.get(i);
                                String mname = obj.getString("mname");
                                String type = obj.getString("type");
                                String amount = obj.getString("amount");
                                System.out.println(mname + " " + type + " " + amount);
                            }
                        }
                        if (list_.get("process") != null) {
                            JSONArray process = list_.getJSONArray("process");
                            for (int i = 0; i < process.size(); i++) {
                                JSONObject obj = (JSONObject) process.get(i);
                                String pcontent = obj.getString("pcontent");
                                String pic_ = obj.getString("pic");
                                System.out.println(pcontent + " " + pic_);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Get();
//    }
}