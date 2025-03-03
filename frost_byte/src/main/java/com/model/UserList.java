package com.model;

import java.util.ArrayList;

public class UserList {

    private static UserList userList = new UserList();
    private ArrayList<User> users = new ArrayList<>();

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        return userList;
    }

    public void addUser(String firstName, String lastName) {

    }

    /**
     * This method iterates through the userlist and returns the User with the
     * matching UserName
     * 
     * @param UserName
     * @return
     */
    public User getUser(String UserName) {
        for (User user : users) {
            if (user.getUserName().equals(UserName)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser() {
        DataWriter.saveUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
