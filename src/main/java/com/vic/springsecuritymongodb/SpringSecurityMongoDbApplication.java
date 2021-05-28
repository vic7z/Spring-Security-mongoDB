package com.vic.springsecuritymongodb;

import com.vic.springsecuritymongodb.Model.User;
import com.vic.springsecuritymongodb.Repository.UserRepo;
import com.vic.springsecuritymongodb.Roles.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityMongoDbApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
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
        userRepo.deleteAll();
        userRepo.save(new User("vic",passwordEncoder.encode("pass"),true, ApplicationRole.ADMIN));
        userRepo.save(new User("vin", passwordEncoder.encode("pass1"), true, ApplicationRole.STUDENT));

    }
}
