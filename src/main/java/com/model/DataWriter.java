package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The DataWriter class is responsible for converting Users, Songs, and Lessons
 * into JSON format and saving them to files.
 */
public class DataWriter extends DataConstants {

    /**
     * Saves the list of users to the JSON file specified by {@code USER_FILE_NAME}.
     */
    public static void saveUsers(List<User> users) {
        JSONArray jsonUsers = new JSONArray();
        for (User user : users) {
            jsonUsers.add(getUserJSON(user));
        }
        writeToFile(USER_FILE_NAME, jsonUsers);
    }

    /**
     * Saves the list of songs to the JSON file specified by {@code SONG_FILE_NAME}.
     */
    public static void saveSongs(List<Song> songs) {
        if (songs == null || songs.isEmpty()) {
            return;
        }
        JSONArray jsonSongs = new JSONArray();
        for (Song song : songs) {
            if (song != null) {
                jsonSongs.add(getSongJSON(song));
            }
        }
        writeToFile(SONG_FILE_NAME, jsonSongs);
    }

    /**
     * Saves the list of lessons to the JSON file specified by
     * {@code LESSON_FILE_NAME}.
     */
    public static void saveLessons(List<Lesson> lessons) {
        if (lessons == null || lessons.isEmpty()) {
            return;
        }
        JSONArray jsonLessons = new JSONArray();
        for (Lesson lesson : lessons) {
            jsonLessons.add(getLessonJSON(lesson));
        }
        writeToFile(LESSON_FILE_NAME, jsonLessons);
    }

    private static void writeToFile(String filename, JSONArray array) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(filename)) {
            file.write(gson.toJson(array));

            



            // file.write(array.toJSONString());
            // file.write(System.lineSeparator());
            // file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put(USER_ID, user.getID().toString());
        userJson.put(USER_USER_NAME, user.getUserName());
        userJson.put(USER_FIRST_NAME, user.getFirstName());
        userJson.put(USER_LAST_NAME, user.getLastName());
        userJson.put(USER_EMAIL, user.getEmail());
        userJson.put(USER_PASSWORD, user.getPassword());
        userJson.put(USER_ACCOUNT_TYPE, user.getIsTeacher());
        userJson.put(USER_SECURITY_QUESTION, user.getSecurityQuestion());
        userJson.put(USER_SECURITY_ANSWER, user.getSecurityAnswer());
        return userJson;
    }

    public static JSONObject getSongJSON(Song song) {
        JSONObject songJson = new JSONObject();
        // Required fields
        songJson.put(SONG_ID, song.getID().toString());
        songJson.put(SONG_TITLE, song.getTitle());
        songJson.put(SONG_ARTIST, song.getArtist());
        songJson.put(SONG_AUTHOR, song.getAuthor() != null ? song.getAuthor().toString() : null);
        songJson.put(SONG_GENRE, song.getGenre());
        songJson.put(SONG_DURATION, song.getDuration());
        songJson.put(SONG_TEMPO, song.getTempo());
        songJson.put(SONG_DEF_TIME_SIG_NUMER, song.getDefTimeSigNumer());
        songJson.put(SONG_DEF_TIME_SIG_DENOM, song.getDefTimeSigDenom());
        songJson.put(SONG_DEF_KEY_SIG, song.getDefKeySig() != null ? song.getDefKeySig().toString() : "Unknown");

        // Measures serialization - structured
        JSONArray measuresArray = new JSONArray();
        if (song.getMeasureList() != null) {
            for (Measure measure : song.getMeasureList()) {
                measuresArray.add(getMeasureJSON(measure));
            }
        }
        songJson.put(SONG_MEASURE_LIST, measuresArray);
        return songJson;
    }

    private static JSONObject getMeasureJSON(Measure measure) {
        JSONObject measureJson = new JSONObject();
        measureJson.put("beatAmount", measure.getBeatAmount());
        measureJson.put("clef", measure.getClef());
        // Notes
        JSONArray notesArray = new JSONArray();
        if (measure.getNoteList() != null) {
            for (Note note : measure.getNoteList()) {
                JSONObject noteJson = new JSONObject();
                noteJson.put("pitch", note.getPitch().toString());
                noteJson.put("accidental", note.getAccidental().toString());
                noteJson.put("octave", note.getOctave());
                noteJson.put("length", note.getLength());
                notesArray.add(noteJson);
            }
        }
        measureJson.put("notes", notesArray);
        return measureJson;
    }

    public static JSONObject getLessonJSON(Lesson lesson) {
        JSONObject lessonJson = new JSONObject();
        lessonJson.put(LESSON_ID, lesson.getID().toString());
        lessonJson.put(LESSON_TITLE, lesson.getTitle());
        lessonJson.put(LESSON_DESCRIPTION, lesson.getDescription());
        lessonJson.put(LESSON_CONTENT, lesson.getContent());
        // Flashcards
        JSONArray flashcardsArray = new JSONArray();
        if (lesson.getFlashcards() != null) {
            for (Flashcard flashcard : lesson.getFlashcards()) {
                JSONObject fcJson = new JSONObject();
                fcJson.put(FLASHCARD_TERM, flashcard.getTerm());
                fcJson.put(FLASHCARD_DEFINITION, flashcard.getDefinition());
                flashcardsArray.add(fcJson);
            }
        }
        lessonJson.put(LESSON_FLASHCARDS, flashcardsArray);
        // Quiz
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
        // Song
        lessonJson.put(LESSON_SONG, getSongJSON(lesson.getSong()));
        return lessonJson;
    }
}
