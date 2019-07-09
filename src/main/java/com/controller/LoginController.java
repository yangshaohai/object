package com.controller;

import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    PersonService personService;
    @RequestMapping("/login")
    public String index(Model model, HttpServletRequest request){
        //返回的是一个map集合
        Map<String, String> login = personService.login(request);
            if("0".equals(login)){
                model.addAttribute("msg",login.get("msg"));
                return "erro";
            }
        return "index2";

    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/album")
    public String album(){
        return "album";
    }
    @RequestMapping("/details")
    public String details(){
        return "details";
    }
    @RequestMapping("/leacots")
    public String leacots(){
        return "leacots";
    }
    @RequestMapping("/whisper")
    public String whisper(){
        return "whisper";
    }

}
