package com.vic.springsecuritymongodb.Roles;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.vic.springsecuritymongodb.Roles.UserPermission.*;

public enum ApplicationRole {
   ADMIN(Sets.newHashSet(Student_Write,Student_Read,Course_Read,Course_Write)),
   STUDENT(Sets.newHashSet());

    private final Set<UserPermission> permissions;


    ApplicationRole(Set<UserPermission> permissions) {
        this.permissions=permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    @org.jetbrains.annotations.NotNull
    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities=this.getPermissions().stream()
                .map(permissions ->new SimpleGrantedAuthority(permissions.getUserPermission()))
                .collect(Collectors.toSet());
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return simpleGrantedAuthorities;
    }
}
