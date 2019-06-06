package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class Person {
    private Integer id;
    private String name;
    private String password;
    private String emil;
    private String number;
}
