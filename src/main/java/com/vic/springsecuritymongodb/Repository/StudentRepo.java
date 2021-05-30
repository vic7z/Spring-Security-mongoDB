package com.vic.springsecuritymongodb.Repository;

import com.vic.springsecuritymongodb.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<Student,String> {
    @Query("{ 'name' : ?0 }")
    Optional<Student> findStudentByName(String name);
}
