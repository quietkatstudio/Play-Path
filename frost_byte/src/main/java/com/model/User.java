package com.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isTeacher;

    public User(String userName, String firstName, String lastName, String email, String password, boolean isTeacher) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.password = password;
    }

    public User(UUID id, String userName, String firstName, String lastName, String email, String password,
            boolean isTeacher) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.password = password;
    }

    private boolean isTeacher(User user) {
        return true;
    }

    private void register() {

    }

    private void login() {

    }

    public String getUserName() {
        return this.userName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Object getFirstName() {
        return this.firstName;
    }

    public Object getID() {
        return this.id;
    }

}
