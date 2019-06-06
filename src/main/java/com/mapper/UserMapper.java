package com.mapper;

import com.pojo.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
     //@Select("select * from beauty")
     List<Person> getPerson();
     int insertPerson(Person person);
}
