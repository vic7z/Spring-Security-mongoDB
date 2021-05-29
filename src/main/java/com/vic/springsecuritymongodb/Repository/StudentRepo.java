package com.vic.springsecuritymongodb.Repository;

import com.vic.springsecuritymongodb.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student,String> {
    Optional<Student> findStudentByName(String name);
}
