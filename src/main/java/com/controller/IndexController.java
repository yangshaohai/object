package com.controller;

import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    PersonService personService;
    @Autowired
    Person person;
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
//        model.addAttribute("title", "登录页面");
//        model.addAttribute("e","loading...");
        person.setName(request.getParameter("name"));
        person.setEmil(request.getParameter("emil"));
        person.setPassword(request.getParameter("password"));
        person.setNumber(request.getParameter("number"));
        personService.add(person);
        return "index";
    }
    @RequestMapping("/boke")
    public String boke(Model model){
        return "boke";
    }
   /* @RequestMapping("/")
    public String*/



}
