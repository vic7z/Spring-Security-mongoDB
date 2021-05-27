package com.vic.springsecuritymongodb.Roles;

import com.google.common.collect.Sets;

import java.util.Set;

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
}
