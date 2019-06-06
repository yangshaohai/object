package com.service;

import com.pojo.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getPerson();
    int add(Person person);


}
