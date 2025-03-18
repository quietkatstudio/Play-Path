package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This is the DataWriter class that calls the singleton UserList, creates a
 * JSONArray, and then writes to the JSON file.
 */
public class DataWriter extends DataConstants {

    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {

        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID().toString());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_ACCOUNT_TYPE, user.getIsTeacher());

        return userDetails;
    }

    // DataWriter Test
    // Note: Maybe need to add logic remove older JSON entries that have matching
    // UUIDs
    public static void main(String[] args) {
        UserList users = UserList.getInstance();
        users.getUsers().add(new User("jdoe", "John", "Doe", "jdoe@example.com", "password123", true));
        users.getUsers().add(new User("asmith", "Alice", "Smith", "asmith@example.com", "securepass", false));
        System.out.println("Saving users >>>");
        DataWriter.saveUsers();
        System.out.println("Users saved!");
    }

}
