package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Data Loader Class. This class extends the DataConstants and reads through
 * each JSON file to return an ArrayList of Users.
 */
public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJson.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJson.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String userName = (String) personJSON.get(USER_USER_NAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String password = (String) personJSON.get(USER_PASSWORD);
                boolean isteacher = (Boolean) personJSON.get(USER_ACCOUNT_TYPE);

                users.add(new User(id, userName, firstName, lastName, email, isteacher, password));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

}
