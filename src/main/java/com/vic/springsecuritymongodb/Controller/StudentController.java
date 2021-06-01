package com.vic.springsecuritymongodb.Controller;

import com.vic.springsecuritymongodb.Model.Course;
import com.vic.springsecuritymongodb.Model.Student;
import com.vic.springsecuritymongodb.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT')")
    public ResponseEntity<List<Student>> getAllStudent(){
        return this.appService.getAllStudents();
    }

    @GetMapping(path = "/admin/id/{id}")
    @PreAuthorize("hasAuthority('student:read')")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
       return this.appService.getstudentById(id);
    }
    @GetMapping(path = "/admin/name/{name}")
    @PreAuthorize("hasAuthority('student:read')")
    public ResponseEntity<Student> getStudent(@PathVariable String name){
        return this.appService.getStudent(name);
    }

    @PostMapping(value = "/admin/add")
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        return this.appService.addStudent(student);
    }

    @PutMapping(value = "/admin/update/")
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return this.appService.updateStudent( student);
    }

    @DeleteMapping(value = "/admin/id/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        return this.appService.deleteStudent(id);
    }

    @GetMapping("/admin/course/{id}")
    @PreAuthorize("hasAuthority('course:read')")
    public ResponseEntity<List<Course>> getCourseById(@PathVariable String id){
        return this.appService.getCourseById(id);
    }


}
