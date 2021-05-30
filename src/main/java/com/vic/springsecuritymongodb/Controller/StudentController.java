package com.vic.springsecuritymongodb.Controller;

import com.vic.springsecuritymongodb.Model.Course;
import com.vic.springsecuritymongodb.Model.Student;
import com.vic.springsecuritymongodb.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final AppService appService;

    @Autowired
    public StudentController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(path = "/student/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        return this.appService.getAllStudents();
    }

    @GetMapping(path = "/admin/id/{id}")
    public ResponseEntity<Student> getstudentById(@PathVariable String id){
       return this.appService.getstudentById(id);
    }
    @GetMapping(path = "/admin/name/{name}")
    public ResponseEntity<Student> getStudent(@PathVariable String name){
        return this.appService.getStudent(name);
    }

    @PostMapping(value = "/admin/add")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        return this.appService.addStudent(student);
    }

    @PutMapping(value = "/admin/update/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return this.appService.updateStudent( student);
    }

    @DeleteMapping(value = "/admin/id/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        return this.appService.deleteStudent(id);
    }

    @GetMapping("/admin/course/{id}")
    public ResponseEntity<List<Course>> getCourseById(@PathVariable String id){
        return this.appService.getCourseById(id);
    }


//    @GetMapping("/")
//    public String home() {
//        return ("<h1>Welcome</h1>");
//    }
//
//    @GetMapping("/studentr")
//    public String user() {
//        return ("<h1>Welcome student</h1>");
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return ("<h1>Welcome Admin</h1>");
//    }
}
