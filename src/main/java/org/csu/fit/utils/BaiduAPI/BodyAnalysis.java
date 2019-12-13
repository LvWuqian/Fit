package org.csu.fit.utils.BaiduAPI;

import java.net.URLEncoder;

/**
 * 人体关键点识别
 */
public class BodyAnalysis {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String body_analysis(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/body_analysis";
        try {
            // 本地文件路径
            //String filePath = "/Users/lvwuqian/Desktop/zhoujielun.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getBodyAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        //BodyAnalysis.body_analysis();
//        String bodyString = body_analysis("/Users/lvwuqian/Desktop/pang.jpg");
//        JSONObject bodyJson = JSONObject.parseObject(bodyString);
//        JSONArray bodyArray = (JSONArray) bodyJson.get("person_info");
//        JSONObject body = bodyArray.getJSONObject(0);
//        JSONObject body_parts = body.getJSONObject("body_parts");
//        Float left_hip_x = Float.parseFloat(body_parts.getJSONObject("left_hip").getString("x"));
//        Float left_hip_y = Float.parseFloat(body_parts.getJSONObject("left_hip").getString("y"));
//        Float right_hip_x = Float.parseFloat(body_parts.getJSONObject("right_hip").getString("x"));
//        Float right_hip_y = Float.parseFloat(body_parts.getJSONObject("right_hip").getString("y"));
//        Float left_shoulder_x = Float.parseFloat(body_parts.getJSONObject("left_shoulder").getString("x"));
//        Float left_shoulder_y = Float.parseFloat(body_parts.getJSONObject("left_shoulder").getString("y"));
//        Float right_shoulder_x = Float.parseFloat(body_parts.getJSONObject("right_shoulder").getString("x"));
//        Float right_shoulder_y = Float.parseFloat(body_parts.getJSONObject("right_shoulder").getString("y"));
//        Float left_eye_x = Float.parseFloat(body_parts.getJSONObject("left_eye").getString("x"));
//        Float left_eye_y = Float.parseFloat(body_parts.getJSONObject("left_eye").getString("y"));
//        Float right_eye_x = Float.parseFloat(body_parts.getJSONObject("right_eye").getString("x"));
//        Float right_eye_y = Float.parseFloat(body_parts.getJSONObject("right_eye").getString("y"));
//        System.out.println(left_hip_x + "  " + left_hip_y + "  " + right_hip_x + "  " + right_hip_y + "  " + left_shoulder_x + "  " + left_shoulder_y + "  " + right_shoulder_x + "  " + right_shoulder_y + "  ");
//        Double hip = Math.sqrt(Math.pow(left_hip_x - right_hip_x, 2) + Math.pow(left_hip_y - right_hip_y, 2));
//        Double shoulder = Math.sqrt(Math.pow(left_shoulder_x - right_shoulder_x, 2) + Math.pow(left_shoulder_y - right_shoulder_y, 2));
//        Double eye = Math.sqrt(Math.pow(left_eye_x - right_eye_x, 2) + Math.pow(left_eye_y - right_eye_y, 2));
//        Double resultScore = (hip / eye + shoulder / eye) * 10;
//        System.out.println(resultScore);
//    }
}