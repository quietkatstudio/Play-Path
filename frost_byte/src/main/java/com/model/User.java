package com.model;

import java.util.UUID;

/**
 * 
 * @author 
 */
public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isTeacher;

    /**
     * 
     * @param userName
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param isTeacher
     */
    public User(String userName, String firstName, String lastName, String email, String password, boolean isTeacher) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.password = password;
    }


    /**
     * 
     * @param id
     * @param userName
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param isTeacher
     */
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

    /**
     * 
     * @param user
     * @return
     */
    private boolean isTeacher(User user) {
        return true;
    }

    /**
     * 
     */
    private void register() {

    }

    /**
     * 
     */
    private void login() {

    }

    /**
     * 
     * @return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * 
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     */
    public String getFirstName() {
        return this.firstName;
    }


    /**
     * 
     * @return
     */
    public UUID getID() {
        return this.id;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @return
     */
    public boolean getIsTeacher() {
        return this.isTeacher;
    }

    /**
     * 
     */
    public String toString(){
        return "username: "+ userName +"\n"+ ", first name: " +"\n"+ firstName + ", last name: " +"\n"+ lastName + ", password: " +"\n"+ password;
    }
}
