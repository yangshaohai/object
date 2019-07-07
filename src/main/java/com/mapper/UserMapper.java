package com.mapper;

import com.pojo.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
     //@Select("select * from beauty")
     //查询的结果集
     Person getPersonByName(@Param(value = "name") String name);
     //存入的数据
     int insertPerson(Person person);
     //查找密码条件是用户名
    // String getPersonName(@Param(value = "password") String password);
}
