//package com.service.impl;
//
//import com.service.EmailCodeService;
//import lombok.Value;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//import java.util.Random;
//
//@Service
//@PropertySource("classpath:config/config.properties")
//public class EmailCodeServiceImpl implements EmailCodeService {
//    @Autowired
//    HttpSession httpSession;
//    @Value("${emailHostName}")
//    private String emailHostName;
//    @Value("${emailCharset}")
//    private String emailCharset;
//    @Value("${emailFrom}")
//    private String emailFrom;
//    @Value("${emailName}")
//    private String emailName;
//    @Value("${emailCode}")
//    private String emailCode;
//    @Override
//    public JSONObject sendEmailCode(String emailName) throws EmailException {
//        HtmlEmail email = new HtmlEmail();
//        email.setHostName(emailHostName);//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
//        email.setCharset(emailCharset);//#发送的字符类型
//        email.addTo(emailName);//发送人的邮箱
//        email.setFrom(emailFrom,emailName);//设置发送邮箱和用户名
//        email.setAuthentication(emailFrom,emailCode);//设置发送邮箱和授权码
//        email.setSubject("测试");
//        //获取随机验证码
//        int max = 999999;
//        int min = 100000;
//        int floor = new Random().nextInt(max-min)+min;
//        httpSession.setAttribute("code",floor);//将验证码存入session
//        email.setMsg("您的邮箱验证码是："+floor);//设置邮件内容
//        String send = email.send();//发送
//        JSONObject json = new JSONObject();
//        json.put("status",200);
//        json.put("msg",send);
////        json.put("code",floor);
//        return json;
//    }
//
//    @Override
//    public Boolean validateEmailCode(String code) {
//        System.out.println(code);
//        System.out.println(httpSession.getAttribute("code"));
//        String code1 = String.valueOf(httpSession.getAttribute("code"));
//        if (code.equals(code1)) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//}
