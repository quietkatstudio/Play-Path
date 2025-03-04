package com.model;

import java.util.UUID;

/**
 * This class represents a user
 * @author 
 */
public class User {
    private UUID id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isTeacher;
    private String password;


    /**
     * Constructor for creating a new user
     * @param userName the users username
     * @param firstName the users first name
     * @param lastName the users last name
     * @param email the users email
     * @param isTeacher boolean that states if the user is a teacher
     * @param password the users password
     */
    public User(String userName, String firstName, String lastName, String email, boolean isTeacher, String password) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.password = password;
    }

    /**
     * Constructor for loading a user from the json file
     * @param id the users unique id
     * @param userName the users username
     * @param firstName the users first name
     * @param lastName the users last name
     * @param email the users email
     * @param isTeacher boolean that states if the user is a teacher
     * @param password the users password
     */
    public User(UUID id, String userName, String firstName, String lastName, String email, boolean isTeacher, String password) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isTeacher = isTeacher;
        this.password = password;
    }

    /**
     * This method checks if the given user is a teacher
     * @param user the user being checked
     * @return true if the user is a teacher
     */
    private boolean isTeacher(User user) {
        return isTeacher;
    }

    /**
     * Registers the user by adding them to the userList
     * @return true if the user was added and false if the user already exists
     */
    private boolean register() {
        UserList userList = UserList.getInstance();
        if(userList.getUser(this.userName) != null){
            return false;
        }
        userList.addUser(userName, firstName, lastName, email, password);
        return true;
    }

    /**
     * Logs in the user by checking if the username and the password match an existing user
     * @return true if the login was successful 
     */
    private boolean login() {
        UserList userList = UserList.getInstance();
        User existingUser = userList.getUser(this.userName);
        if(existingUser != null && existingUser.password.equals(this.password)){
            return true;
        }
        return false;
    }

    /**
     * The getter method for the users username
     * @return the users username
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * The getter method for the users first name
     * @return the users first name
     */
    public Object getFirstName() {
        return this.firstName;
    }

    /**
     * The getter method for the users last name
     * @return the users last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * The getter method for the users email
     * @return the users email
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * The getter method for the users id
     * @return the users id
     */
    public Object getID() {
        return this.id;
    }
    public String toString(){
        return "username: "+ userName + ", first name: " + firstName + ", last name: " + lastName;
    }

}
