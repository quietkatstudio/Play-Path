package com.model;
import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private UserList userList;
    UserList(){

    }
    public UserList getIntance(){
        return userList;
    }
    public void addUser(String firstName, String lastName){

    }
    public User getUser(String UserName){
        return userList.getUser(UserName);
    }
    public void saveUser(){
        
    }
}
