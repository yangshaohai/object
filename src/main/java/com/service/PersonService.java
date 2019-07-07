package com.service;

import com.pojo.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface PersonService {
    //查询的结果方法
    Map<String,String> login(HttpServletRequest request);
    //传值到数据库的方法
    Map<String,String> add(Person person);


}
