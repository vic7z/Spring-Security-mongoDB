package com.vic.springsecuritymongodb;

import com.vic.springsecuritymongodb.Model.Course;
import com.vic.springsecuritymongodb.Model.Student;
import com.vic.springsecuritymongodb.Model.User;
import com.vic.springsecuritymongodb.Repository.StudentRepo;
import com.vic.springsecuritymongodb.Repository.UserRepo;
import com.vic.springsecuritymongodb.Roles.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityMongoDbApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    public final PasswordEncoder passwordEncoder;

    public SpringSecurityMongoDbApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        userRepo.deleteAll();
//        userRepo.save(new User("vic",passwordEncoder.encode("pass"),true, ApplicationRole.ADMIN));
//        userRepo.save(new User("vin", passwordEncoder.encode("pass1"), true, ApplicationRole.STUDENT));
          studentRepo.save(new Student("vic",12,new ArrayList<Course>(){{
              add(new Course("12","hello"));

          }}
        )
        );
    }
}
