package com.controller;

import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * controller是实现跳转的功能和传值功能块
 * */

@Controller
public class IndexController {
    //自动注入server接口的并实例化接口
    @Autowired
    PersonService personService;
    //自动注入实体类的接口并实现实体类
    @Autowired
    Person person;
    //需要链接需要跳转的页面路径
    @RequestMapping("/index")
    //
    public String index(Model model, HttpServletRequest request){
//        model.addAttribute("title", "登录页面");
//        model.addAttribute("e","loading...");
        //页面提交过来的值
        person.setName(request.getParameter("name"));
        person.setEmil(request.getParameter("emil"));
        person.setPassword(request.getParameter("password"));
        person.setNumber(request.getParameter("number"));
        //将传输的数据传到server层
        Map<String, String> add = personService.add(person);
        System.out.println(add);
        model.addAttribute("msg",add.get("msg"));
        return  add.get("url");
    }

//这里是从登录注册页面跳转到博客页面,登录成功
    @RequestMapping("/boke")
    //HttpServletRequest request  请求的数据
    public String boke(Model model,HttpServletRequest request){
        //System.out.println(personService.login(request));
        //返回的是一个map集合
        Map<String, String> login = personService.login(request);
        //判断状态码
        if ("0".equals(login.get("code"))){
            model.addAttribute("msg",login.get("msg"));
            return "erro";
        }
        return "boke";
    }
  @RequestMapping("/houtai")
   public String houtai(){
        return "houtai";
  }

    @RequestMapping("/login")
    public String login(){
        System.out.println(123);
        return "login";
    }




}
