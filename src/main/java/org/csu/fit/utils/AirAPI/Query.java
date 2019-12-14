package org.csu.fit.utils.AirAPI;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.csu.fit.utils.RecipeAPI.RecipeHttpUtil;

import java.net.URLEncoder;


public class Query {

    public static final String APPKEY = "75d339101469006e";// 浣犵殑appkey
    public static final String URL = "https://api.jisuapi.com/aqi/query";
    //public static final String city = "杭州";// utf-8

    public static JSONObject Get(String City) throws Exception  {
        String result = null;
        String url = URL + "?appkey=" + APPKEY + "&city=" + URLEncoder.encode(City,"utf-8");

        try {
            result = RecipeHttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                String cityid = resultarr.getString("cityid");
                String city = resultarr.getString("city");
                String so2 = resultarr.getString("so2");
                String so224 = resultarr.getString("so224");
                String no2 = resultarr.getString("no2");
                String no224 = resultarr.getString("no224");
                String co = resultarr.getString("co");
                String co24 = resultarr.getString("co24");
                String o3 = resultarr.getString("o3");
                String o38 = resultarr.getString("o38");
                String o324 = resultarr.getString("o324");
                String pm10 = resultarr.getString("pm10");
                String pm1024 = resultarr.getString("pm1024");
                String pm2_5 = resultarr.getString("pm2_5");
                String pm2_524 = resultarr.getString("pm2_524");
                String iso2 = resultarr.getString("iso2");
                String ino2 = resultarr.getString("ino2");
                String ico = resultarr.getString("ico");
                String io3 = resultarr.getString("io3");
                String io38 = resultarr.getString("io38");
                String ipm10 = resultarr.getString("ipm10");
                String ipm2_5 = resultarr.getString("ipm2_5");
                String aqi = resultarr.getString("aqi");
                String primarypollutant = resultarr.getString("primarypollutant");
                String quality = resultarr.getString("quality");
                String timepoint = resultarr.getString("timepoint");
                System.out.println(cityid + " " + city + " " + so2 + " " + so224 + " " + no2 + " " + no224 + " " + co
                        + " " + co24 + " " + o3 + " " + o38 + " " + o324 + " " + pm10 + " " + pm1024 + " " + pm2_5 + " "
                        + pm2_524 + " " + iso2 + " " + ino2 + " " + ico + " " + io3 + " " + io38 + " " + ipm10 + " "
                        + ipm2_5 + " " + aqi + " " + primarypollutant + " " + quality + " " + timepoint);
                if (resultarr.get("aqiinfo") != null) {
                    JSONObject aqiinfo = resultarr.getJSONObject("aqiinfo");
                    String level = aqiinfo.getString("level");
                    String color = aqiinfo.getString("color");
                    String affect = aqiinfo.getString("affect");
                    String measure = aqiinfo.getString("measure");
                    System.out.println(level + " " + color + " " + affect + " " + measure);
                }
                if (resultarr.get("position") != null) {
                    JSONArray position = resultarr.getJSONArray("position");
                    for (int i = 0; i < position.size(); i++) {
                        JSONObject obj = (JSONObject) position.get(i);
                        String positionname = obj.getString("positionname");
                        String so2_ = obj.getString("so2");
                        String so224_ = obj.getString("so224");
                        String no2_ = obj.getString("no2");
                        String no224_ = obj.getString("no224");
                        String co_ = obj.getString("co");
                        String co24_ = obj.getString("co24");
                        String o3_ = obj.getString("o3");
                        String o38_ = obj.getString("o38");
                        String o324_ = resultarr.getString("o324");
                        String pm10_ = resultarr.getString("pm10");
                        String pm1024_ = resultarr.getString("pm1024");
                        String pm2_5_ = resultarr.getString("pm2_5");
                        String pm2_524_ = resultarr.getString("pm2_524");
                        String iso2_ = resultarr.getString("iso2");
                        String ino2_ = resultarr.getString("ino2");
                        String ico_ = resultarr.getString("ico");
                        String io3_ = resultarr.getString("io3");
                        String io38_ = resultarr.getString("io38");
                        String ipm10_ = resultarr.getString("ipm10");
                        String ipm2_5_ = resultarr.getString("ipm2_5");
                        String aqi_ = resultarr.getString("aqi");
                        String primarypollutant_ = resultarr.getString("primarypollutant");
                        String quality_ = resultarr.getString("quality");
                        String timepoint_ = resultarr.getString("timepoint");
                        System.out.println(positionname + " " + so2_ + " " + so224_ + " " + no2_ + " " + no224_ + " "
                                + co_ + " " + co24_ + " " + o3_ + " " + o38_ + " " + o324_ + " " + pm10_ + " " + pm1024_
                                + " " + pm2_5_ + " " + pm2_524_ + " " + iso2_ + " " + ino2_ + " " + ico_ + " " + io3_
                                + " " + io38_ + " " + ipm10_ + " " + ipm2_5_ + " " + aqi_ + " " + primarypollutant_
                                + " " + quality_ + " " + timepoint_);
                    }
                }
                return resultarr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        Query.Get();
//    }
}
