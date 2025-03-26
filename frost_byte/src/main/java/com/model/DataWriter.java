package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The DataWriter class is responsible for converting Users, Songs, and Lessons
 * into JSON format and saving them to files.
 */
public class DataWriter extends DataConstants {

    /**
     * Saves the list of users to the JSON file specified by {@code USER_FILE_NAME}.
     *
     * @return true if the users were saved successfully; false otherwise.
     */
    public static boolean saveUsers() {
        UserList userListInstance = UserList.getInstance();
        ArrayList<User> users = userListInstance.getUsers();
        JSONArray jsonUsers = new JSONArray();
        

        for (User user : users) {
            jsonUsers.add(getUserJSON(user));
        }
        int size = jsonUsers.size();
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {

            file.write("[");
            for (int i = 0; i < size; i++) {
                file.write(jsonUsers.get(i).toString());
                // If it's not the last user, add a comma and new line
                if (i < size - 1) {
                    file.write("," + System.lineSeparator());
                } else {
                    // Add a new line after the last entry (no comma)
                    file.write(System.lineSeparator());
                }
            }
            
            // for (Object jsonUser : jsonUsers) {
            // file.write(jsonUser.toString()+ ","+System.lineSeparator());
            // }
            file.write("]");
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saves the list of songs to the JSON file specified by {@code SONG_FILE_NAME}.
     *
     * @return true if the songs were saved successfully; false otherwise.
     */
    public static boolean saveSongs() {
        // Get the songs (if there are any)
        ArrayList<Song> songs = DataLoader.getSongs();

        // If there are no songs, skip saving
        if (songs == null || songs.isEmpty()) {
            return false; // No songs to save
        }

        JSONArray jsonSongs = new JSONArray();

        for (Song song : songs) {
            if (song != null) { // Ensure the song is not null before processing
                jsonSongs.add(getSongJSON(song));
            }
        }

        try (FileWriter file = new FileWriter(SONG_FILE_NAME)) {
            file.write(jsonSongs.toJSONString());
            file.write(System.lineSeparator());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saves the list of lessons to the JSON file specified by
     * {@code LESSON_FILE_NAME}.
     *
     * @param lessons the list of lessons to save
     * @return true if the lessons were saved successfully; false otherwise.
     */
    public static boolean saveLessons(ArrayList<Lesson> lessons) {
        JSONArray jsonLessons = new JSONArray();
        for (Lesson lesson : lessons) {
            jsonLessons.add(getLessonJSON(lesson));
        }

        try (FileWriter file = new FileWriter(LESSON_FILE_NAME)) {
            file.write(jsonLessons.toJSONString());
            file.write(System.lineSeparator());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Converts a User object to its JSON representation.
     *
     * @param user the User to be converted.
     * @return a JSONObject representing the user.
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put(USER_ID, user.getID().toString());
        userJson.put(USER_USER_NAME, user.getUserName());
        userJson.put(USER_FIRST_NAME, user.getFirstName());
        userJson.put(USER_LAST_NAME, user.getLastName());
        userJson.put(USER_EMAIL, user.getEmail());
        userJson.put(USER_PASSWORD, user.getPassword());
        userJson.put(USER_ACCOUNT_TYPE, user.getIsTeacher());
        return userJson;
    }

    /**
     * Converts a Song object to its JSON representation.
     *
     * @param song the Song to be converted.
     * @return a JSONObject representing the song.
     */
    public static JSONObject getSongJSON(Song song) {
        // If the song is null, return an empty song JSON object
        if (song == null) {
            return new JSONObject();
        }

        JSONObject songJson = new JSONObject();
        songJson.put(SONG_TITLE, song.getTitle());
        songJson.put(SONG_ARTIST, song.getArtist());
        songJson.put(SONG_AUTHOR, song.getAuthor());
        songJson.put(SONG_GENRE, song.getGenre());
        songJson.put(SONG_DURATION, song.getDuration());
        songJson.put(SONG_TEMPO, song.getTempo());
        songJson.put(SONG_DEF_TIME_SIG_NUMER, song.getDefTimeSigNumer());
        songJson.put(SONG_DEF_TIME_SIG_DENOM, song.getDefTimeSigDenom());

        // Check if key signature is null before calling toString()
        if (song.getDefKeySig() != null) {
            songJson.put(SONG_DEF_KEY_SIG, song.getDefKeySig().toString());
        } else {
            songJson.put(SONG_DEF_KEY_SIG, "Unknown"); // Default value if null
        }

        // Check if measureList is null and initialize if necessary
        JSONArray measuresArray = new JSONArray();
        if (song.getMeasureList() != null) {
            for (Measure measure : song.getMeasureList()) {
                JSONObject measureJson = new JSONObject();
                measureJson.put("measure", measure.toString());
                measuresArray.add(measureJson);
            }
        }
        songJson.put(SONG_MEASURE_LIST, measuresArray);

        return songJson;
    }

    /**
     * Converts a Lesson object to its JSON representation.
     *
     * @param lesson the Lesson to be converted.
     * @return a JSONObject representing the lesson.
     */
    public static JSONObject getLessonJSON(Lesson lesson) {
        JSONObject lessonJson = new JSONObject();
        lessonJson.put(LESSON_ID, lesson.getID().toString());
        lessonJson.put(LESSON_TITLE, lesson.getTitle());
        lessonJson.put(LESSON_DESCRIPTION, lesson.getDescription());
        lessonJson.put(LESSON_CONTENT, lesson.getContent());

        // Check if flashcards is null and initialize if necessary
        JSONArray flashcardsArray = new JSONArray();
        if (lesson.getFlashcards() != null) {
            for (Flashcard flashcard : lesson.getFlashcards()) {
                JSONObject flashcardJson = new JSONObject();
                flashcardJson.put(FLASHCARD_TERM, flashcard.getTerm());
                flashcardJson.put(FLASHCARD_DEFINITION, flashcard.getDefinition());
                flashcardsArray.add(flashcardJson);
            }
        }
        lessonJson.put(LESSON_FLASHCARDS, flashcardsArray);

        // Convert quiz
        Quiz quiz = lesson.getQuiz();
        if (quiz != null) {
            JSONObject quizJson = new JSONObject();
            quizJson.put(QUIZ_QUESTION, quiz.getQuestion());

            JSONArray optionsArray = new JSONArray();
            for (String option : quiz.getOptions()) {
                optionsArray.add(option);
            }
            quizJson.put(QUIZ_OPTIONS, optionsArray);
            quizJson.put(QUIZ_ANSWER, quiz.getAnswer());
            lessonJson.put(LESSON_QUIZ, quizJson);
        } else {
            lessonJson.put(LESSON_QUIZ, null);
        }

        // Assuming the lesson's song is represented as a string.
        lessonJson.put(LESSON_SONG, lesson.getSong());

        return lessonJson;
    }
} 
