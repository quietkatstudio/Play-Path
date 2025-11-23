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


    //Constructors
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

   
    // Getters
    public String getUserName() { return this.userName;}
    public String getLastName() { return this.lastName;}
    public String getEmail() {return this.email; }
    public String getFirstName() {return this.firstName;}
    public UUID getID() {return this.id;}
    public String getPassword() {return this.password;}
    public boolean getIsTeacher() {return this.isTeacher; }

    // Setters
    public void setUserName(String userName) {this.userName = userName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setIsTeadher(boolean isTeacher){this.isTeacher = isTeacher;}

   
    /**
     * 
     */
    public String toString(){
        return "username: "+ userName +
        ", first name: " + firstName +
        ", last name: " + lastName +
        ", password: " + password;
    }
}
