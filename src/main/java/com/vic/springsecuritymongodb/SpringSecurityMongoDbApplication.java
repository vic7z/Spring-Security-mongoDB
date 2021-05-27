package com.vic.springsecuritymongodb;

import com.vic.springsecuritymongodb.Model.User;
import com.vic.springsecuritymongodb.Repository.UserRepo;
import com.vic.springsecuritymongodb.Roles.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityMongoDbApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // userRepo.save(new User("vic","pass",true, ApplicationRole.ADMIN));
        userRepo.save(new User("vin","pass1",true, ApplicationRole.STUDENT));

    }
}
