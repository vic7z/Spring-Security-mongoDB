package com.vic.springsecuritymongodb.Service;

import com.vic.springsecuritymongodb.Model.Course;
import com.vic.springsecuritymongodb.Model.Student;
import com.vic.springsecuritymongodb.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private final StudentRepo studentRepo;

    public AppService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentRepo.findAll();
        if(students.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.ok(students);
        }
    }

    public ResponseEntity<Student> getstudentById(String id){
        Student student=studentRepo.findById(id).orElse(null);
        if(student!=null){
            return ResponseEntity.ok(student);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    public ResponseEntity<List<Course>> getCourseById(String id){
        Student student=studentRepo.findById(id).orElse(null);
        if(student!=null){
            return ResponseEntity.ok(student.getCourseList());
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
