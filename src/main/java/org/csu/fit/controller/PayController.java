package org.csu.fit.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.csu.fit.domain.AppPayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PayController {

    @PostMapping("/payByAlipay")
    @ResponseBody
    public void payByAlipay(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        AppPayConfig appPayConfig = new AppPayConfig();
        AlipayClient alipayClient = new DefaultAlipayClient(appPayConfig.getURL(),appPayConfig.getAPPID(), appPayConfig.getAPP_PRIVATE_KEY(), appPayConfig.getFORMAT(), appPayConfig.getCHARSET(), appPayConfig.getALIPAY_PUBLIC_KEY(), appPayConfig.getSIGN_TYPE()); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("pay-status.html");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        int num = (int)(Math.random()*10000+5);
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+num+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":\""+"2999"+"\"," +
                "    \"subject\":\""+"健身课程"+"\"," +
                "    \"body\":\""+"10001"+"\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setHeader("Access-Control-Allow-Origin","*");
        httpResponse.setContentType("text/html;charset=" + appPayConfig.getCHARSET());
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
