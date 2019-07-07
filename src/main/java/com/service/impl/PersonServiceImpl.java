package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    //实例化对象
    @Autowired
    UserMapper userMapper;

    //重写查询的方法
    //返回一个map集合  ， 也可以使用json格式
    @Override
    public Map<String, String> login(HttpServletRequest request) {
        Map<String,String> map = new HashMap<String, String>();
        //用方法(userMapper)查询（getPersonByName)接收前端请求(request)数据(getParameter）
        Person byName = userMapper.getPersonByName(request.getParameter("name"));
        //判断用户名是否为空
        if(byName==null){
            //错误码
            //添加网页状态码
            map.put("code","0");
            //错误信息
            //添加网页信息
            map.put("msg","用户名错误");
        }else {
            //判断是否为空，密码是否一致
            if(byName.getPassword()!=null&&byName.getPassword().equals(request.getParameter("password"))){
               //网页状态码和信息
                map.put("code","200");
                map.put("msg","登录成功");
            }else {
                map.put("code","0");
                map.put("msg","密码错误");
            }
        }

        return map;
    }

    //重写添加数据的方法
    //判断用户名是否存在
    @Override
    public Map<String,String> add(Person person) {
       Map<String,String> map = new HashMap<>();

        // System.out.println(person);
        //根据方法(userMapper)查询到的结果(getPersonByName)再获取用户名(person.getName())
        Person personByName = userMapper.getPersonByName(person.getName());

        //判断用户名是否存在
            if (personByName!=null){
                //数据库存在已有用户名
                map.put("msg","用户名已存在");
                map.put("url","erro");

            }else{
                //数据库中没有此用户名，向数据库存入
                int insertPerson = userMapper.insertPerson(person);
                //添加成功会影响一行
                if (insertPerson>0){
                    map.put("msg","注册成功");
                    map.put("url","index");

                    //没有添加成功
                }else {
                    map.put("msg","注册失败");
                    map.put("url","erro");

                }
            }
        return map;
    }

}
