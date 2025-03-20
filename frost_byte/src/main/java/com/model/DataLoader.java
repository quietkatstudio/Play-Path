package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Data Loader Class. This class extends the DataConstants and reads through
 * each JSON file to return ArrayLists of Users and Songs.
 */
public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJson = (JSONArray) parser.parse(reader);

            for (int i = 0; i < peopleJson.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJson.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String userName = (String) personJSON.get(USER_USER_NAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String password = (String) personJSON.get(USER_PASSWORD);
                Boolean isTeacher = (Boolean) personJSON.get(USER_ACCOUNT_TYPE);
                

                users.add(new User(id, userName, firstName, lastName, email, password, isTeacher));
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray songsJson = (JSONArray) parser.parse(reader);

            for (int i = 0; i < songsJson.size(); i++) {
                JSONObject songJSON = (JSONObject) songsJson.get(i);

                // Read basic song details from JSON.
                String title = (String) songJSON.get(SONG_TITLE);
                String author = (String) songJSON.get(SONG_AUTHOR);
                String genre = (String) songJSON.get(SONG_GENRE);
                String duration = (String) songJSON.get(SONG_DURATION);
                String tempo = (String) songJSON.get(SONG_TEMPO);
                int defTimeSigNumer = Integer.parseInt(songJSON.get(SONG_DEF_TIME_SIG_NUMER).toString());
                int defTimeSigDenom = Integer.parseInt(songJSON.get(SONG_DEF_TIME_SIG_DENOM).toString());
                
                // Assuming defKeySig is stored as a String and KeySig has a constructor that accepts it.
                String keySigStr = (String) songJSON.get(SONG_DEF_KEY_SIG);
                KeySig defKeySig = new KeySig(keySigStr);

                // Process measure list
                ArrayList<Measure> measureList = new ArrayList<>();
                JSONArray measuresJson = (JSONArray) songJSON.get(SONG_MEASURE_LIST);
                if (measuresJson != null) {
                    for (int j = 0; j < measuresJson.size(); j++) {
                        JSONObject measureJSON = (JSONObject) measuresJson.get(j);
                        
                        int beatAmount = Integer.parseInt(measureJSON.get(MEASURE_BEAT_AMOUNT).toString());
                        String clef = (String) measureJSON.get(MEASURE_CLEF);
                        boolean isRepeat = Boolean.parseBoolean(measureJSON.get(MEASURE_IS_REPEAT).toString());
                        
                        // For simplicity, we'll assume notes are not being loaded. 
                        // You can expand this to read a JSONArray of notes if needed.
                        ArrayList<Note> notes = new ArrayList<>();
                        
                        measureList.add(new Measure(beatAmount, clef, isRepeat, notes));
                    }
                }

                // Create a new Song object with the parsed details.
                Song song = new Song(title, author, genre, duration, tempo, 
                                     defTimeSigNumer, defTimeSigDenom, defKeySig, measureList);
                songs.add(song);
            }

            return songs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        ArrayList<Song> songs = DataLoader.getSongs();

        for (Song song : songs) {
            System.out.println(song);
        }
    }

}
