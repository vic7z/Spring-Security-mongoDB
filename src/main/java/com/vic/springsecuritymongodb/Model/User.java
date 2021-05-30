package com.vic.springsecuritymongodb.Model;


import com.vic.springsecuritymongodb.Roles.ApplicationRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private Boolean isActive;
    private ApplicationRole Role;

    public User(String name, String password, Boolean isActive, ApplicationRole role) {
        this.name = name;
        this.password = password;
        this.isActive = isActive;
        Role = role;
    }
}
