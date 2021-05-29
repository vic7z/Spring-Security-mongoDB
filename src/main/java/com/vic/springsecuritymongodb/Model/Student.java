package com.vic.springsecuritymongodb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "student")
@Data
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    private int Standard;
    private List<Course> courseList;

    public Student() {
        courseList=new ArrayList<>();
    }

    public Student(String name, int standard, List courseList) {
        this.name=name;
        this.Standard=standard;
        this.courseList=courseList;
    }
}
