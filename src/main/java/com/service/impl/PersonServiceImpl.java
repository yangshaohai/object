package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> getPerson() {
        return null;
    }
    @Autowired
    UserMapper userMapper;
    @Override
    public int add(Person person) {
        System.out.println(person);
        return userMapper.insertPerson(person);
//        return 0;
    }
}
