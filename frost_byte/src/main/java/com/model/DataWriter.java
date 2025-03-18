package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
        userList.add(new User(UUID.randomUUID(),"Kai", "Kai", "Watts", "kaiwatts06@gmail.comaaaa", true, "password123!"));
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

        return userDetails;
    }

    public static void saveSongs() {
        // Hardcode some songs for testing purposes
        ArrayList<Song> songList = new ArrayList<>();
        
        // Create an empty measure list (or add dummy measures if needed)
        ArrayList<Measure> measures = new ArrayList<>();
        // For example, if Measure has a proper constructor, you might add:
        // measures.add(new Measure(4, "Artist", false, null));
        
        // Create two sample songs
        songList.add(new Song("Song One", "Artist One", "Rock", "3:45", "120", 4, 4, new KeySig("C"), measures));
        songList.add(new Song("Song Two", "Artist Two", "Jazz", "4:20", "100", 3, 4, new KeySig("F"), measures));
        
        JSONArray jsonSongs = new JSONArray();
        for (Song song : songList) {
            jsonSongs.add(getSongJSON(song));
        }

        try (FileWriter file = new FileWriter("json\\songs.json")) {
            file.write(jsonSongs.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject getSongJSON(Song song) {
        JSONObject songDetails = new JSONObject();
        songDetails.put("title", song.getTitle());
        songDetails.put("author", song.getAuthor());
        songDetails.put("genre", song.getGenre());
        songDetails.put("duration", song.getDuration());
        songDetails.put("tempo", song.getTempo());
        songDetails.put("defTimeSigNumer", song.getDefTimeSigNumer());
        songDetails.put("defTimeSigDenom", song.getDefTimeSigDenom());
        songDetails.put("defKeySig", song.getDefKeySig().toString());
        
        JSONArray measuresArray = new JSONArray();
        // Convert each Measure in the song's MeasureList to JSON.
        for (Measure m : song.getMeasureList()) {
            JSONObject measureJSON = new JSONObject();
            // For simplicity, using m.toString(); you can refine this as needed.
            measureJSON.put("measure", m.toString());
            measuresArray.add(measureJSON);
        }
        songDetails.put("measures", measuresArray);
        return songDetails;
    }
    


    public static void main(String[] args) {
        DataWriter.saveUsers();
        DataWriter.saveSongs();
    }



}
