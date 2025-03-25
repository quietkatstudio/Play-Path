package com.model;

import java.io.FileReader;
import java.io.IOException;
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

<<<<<<< HEAD
=======
    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();

        try {
            FileReader reader = new FileReader("json\\lessons.json");
            JSONParser parser = new JSONParser();
            JSONArray lessonsJson = (JSONArray) parser.parse(reader);

            for (int i = 0; i < lessonsJson.size(); i++) {
                JSONObject lessonJSON = (JSONObject) lessonsJson.get(i);
                lessons.add(parseLessonJSON(lessonJSON));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }

>>>>>>> f5a86188716117e0a1ab9af96c065d9b51033b3d
    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
<<<<<<< HEAD
            FileReader reader = new FileReader(SONG_FILE_NAME);
=======
            FileReader reader = new FileReader("json\\songs.json");
>>>>>>> f5a86188716117e0a1ab9af96c065d9b51033b3d
            JSONParser parser = new JSONParser();
            JSONArray songsJson = (JSONArray) parser.parse(reader);

            for (int i = 0; i < songsJson.size(); i++) {
                JSONObject songJSON = (JSONObject) songsJson.get(i);
<<<<<<< HEAD

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
=======
                songs.add(parseSongJSON(songJSON));
            }
>>>>>>> f5a86188716117e0a1ab9af96c065d9b51033b3d
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

<<<<<<< HEAD
=======
    private static Lesson parseLessonJSON(JSONObject jsonLesson) {
        UUID id = UUID.fromString((String) jsonLesson.get("id"));
        String title = (String) jsonLesson.get("title");
        String description = (String) jsonLesson.get("description");
        String content = (String) jsonLesson.get("content");

        ArrayList<Flashcard> flashcards = new ArrayList<>();
        JSONArray flashcardsArray = (JSONArray) jsonLesson.get("flashcards");
        for (int i = 0; i < flashcardsArray.size(); i++) {
            JSONObject flashcardJSON = (JSONObject) flashcardsArray.get(i);
            String term = (String) flashcardJSON.get("term");
            String definition = (String) flashcardJSON.get("definition");
            flashcards.add(new Flashcard(term, definition));
        }

        JSONObject quizJSON = (JSONObject) jsonLesson.get("quiz");
        String question = (String) quizJSON.get("question");
        JSONArray optionsArray = (JSONArray) quizJSON.get("options");
        ArrayList<String> options = new ArrayList<>();
        for (Object option : optionsArray) {
            options.add(option.toString());
        }
        String answer = (String) quizJSON.get("answer");
        Quiz quiz = new Quiz(question, options, answer);

        JSONObject songJSON = (JSONObject) jsonLesson.get("song");
        Song song = parseSongJSON(songJSON);

        return new Lesson(id, title, description, content, flashcards, quiz, song);
    }

    private static Song parseSongJSON(JSONObject jsonSong) {
        String title = (String) jsonSong.get("title");
        String author = (String) jsonSong.get("author");
        String genre = (String) jsonSong.get("genre");
        String duration = (String) jsonSong.get("duration");
        String tempo = (String) jsonSong.get("tempo");

        // Handle time signature, Long or Int value
        int defTimeSigNumer = (jsonSong.get("defTimeSigNumer") instanceof Long)
                ? ((Long) jsonSong.get("defTimeSigNumer")).intValue()
                : Integer.parseInt((String) jsonSong.get("defTimeSigNumer"));
        int defTimeSigDenom = (jsonSong.get("defTimeSigDenom") instanceof Long)
                ? ((Long) jsonSong.get("defTimeSigDenom")).intValue()
                : Integer.parseInt((String) jsonSong.get("defTimeSigDenom"));

        // Parse key signature, accepting JSONObject
        String defKeySigStr = (String) jsonSong.get("defKeySig");
        KeySig defKeySig = new KeySig(Keys.valueOf(defKeySigStr), "A", "B", "C", "D", "E", "F", "G");
        // Parse measures
        JSONObject measureJson = (JSONObject) jsonSong.get("measures");
        JSONArray measuresArray = (JSONArray) jsonSong.get("measures");
        if (measuresArray == null) {
            measuresArray = new JSONArray();
        }
        ArrayList<Measure> measuresArrayList = new ArrayList<>();
        for (Object measureObj : measuresArray) {
            if (measureObj instanceof JSONObject) {
                JSONObject measureJSON = (JSONObject) measureObj;
                Measure measure = new Measure(measureJSON);

                // Parse measure meta-data
                measure.setBeatAmount(Integer.parseInt((String) measureJSON.get("beatAmount")));
                measure.setClef((String) measureJSON.get("clef"));

                // Parse notes
                JSONArray notesArray = (JSONArray) measureJSON.get("notes");
                ArrayList<Note> notes = new ArrayList<>();
                for (Object noteObj : notesArray) {
                    if (noteObj instanceof JSONObject) {
                        JSONObject noteJSON = (JSONObject) noteObj;
                        Note note = new Note();
                        note.setPitch((Pitches) noteJSON.get("pitch"));
                        note.setAccidental((Accidentals) noteJSON.get("accidental"));
                        note.setOctave(Integer.parseInt((String) noteJSON.get("octave")));
                        note.setLength((String) noteJSON.get("length"));
                        notes.add(note);
                    }
                }
                measure.setNotes(notes);
                measuresArrayList.add(measure);
            }
        }

        return new Song(title, author, genre, duration, tempo, defTimeSigNumer, defTimeSigDenom, defKeySig,
                measuresArrayList);

    }

    // DataLoader Tests
>>>>>>> f5a86188716117e0a1ab9af96c065d9b51033b3d
    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

<<<<<<< HEAD
        ArrayList<Song> songs = DataLoader.getSongs();

=======
        System.out.println("Loading songs >>>");
        ArrayList<Song> songs = DataLoader.getSongs();
>>>>>>> f5a86188716117e0a1ab9af96c065d9b51033b3d
        for (Song song : songs) {
            System.out.println(song);
        }
    }

}
