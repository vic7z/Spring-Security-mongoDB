package com.vic.springsecuritymongodb.Roles;

public enum UserPermission {
    Student_Write("student:write"),
    Student_Read("student:read"),
    Course_Write("course:write"),
    Course_Read("course:read");

    private String userPermission;
    UserPermission(String userPermission) {
        this.userPermission=userPermission;
    }

    public String getUserPermission() {
        return userPermission;
    }
}
