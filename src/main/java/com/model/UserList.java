package com.model;

import java.util.ArrayList;

/**
 * This is a singleton class that manages the list of users
 * 
 * @author
 */
public class UserList {

    private static UserList userList = new UserList();
    private ArrayList<User> users = new ArrayList<>();
    private static User currentUser = null;

    /**
     * This method constructs the users list using the user json file
     */
    private UserList() {
        users = DataLoader.getUsers();
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    /**
     * Returns the singleton instance of userlist
     * 
     * @return the userlist instance
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public boolean userExist(String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

     public boolean emailExist(String email) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
   
   
    public boolean login(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * This method adds a new user to the Array List UserList
     * 
     * @param userName  the users username
     * @param firstName the users first name
     * @param lastName  the users last name
     * @param email     the users email
     * @param password  the users password
     */
    public void addUser(String userName, String firstName, String lastName, String email, String password,
            boolean isTeacher) {
        User newUser = new User(userName, firstName, lastName, email, password, isTeacher);
        users.add(newUser);
        // saveUsers();

    }

    /**
     * This method iterates through the userlist and returns the User with the
     * matching UserName
     * 
     * @param UserName the users username
     * @return the user
     */
    public User getUser(String UserName) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(UserName)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUser(User user, String newUserName, String newEmail){
        if(!user.getUserName().equalsIgnoreCase(newUserName) && userExist(newUserName)){
            return false;
        }
        if (!user.getEmail().equalsIgnoreCase(newEmail) && emailExist(newEmail)){
            return false;
        }
        user.setUserName(newUserName);
        user.setEmail(newEmail);
        saveUsers();
        return true;
    }


    /**
     * This method saves the user list to the data writer
     */
    public void saveUsers() {
        getUsers();
        DataWriter.saveUsers(users);
    }

    /**
     * This method gets the full list of users
     * 
     * @return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
}
