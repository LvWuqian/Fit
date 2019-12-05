package org.csu.fit.controller;

import com.zhenzi.sms.ZhenziSmsClient;
import org.csu.fit.domain.User;
import org.csu.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class UserController {

    private String apiUrl = "https://sms_developer.zhenzikj.com";
    private String appId = "102520";
    private String appSecret = "93979f4d-10c7-44ec-b0ca-3ad6e2913a92";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendValidation")
    @ResponseBody
    public String sendSms(HttpServletRequest request, String phone, HttpSession httpSession) {
        //生成6位验证码
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //httpSession.setAttribute("verifyCode",verifyCode);

        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        try {
            String result = client.send(phone, "您的验证码为"+ verifyCode + "，该码有效期为5分钟，只能使用一次！");
            System.out.println(verifyCode+result);
            return verifyCode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(String username, String password){
        return userService.login(username, password);
    }

}
