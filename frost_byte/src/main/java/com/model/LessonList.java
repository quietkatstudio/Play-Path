package com.model;
import java.util.ArrayList;

/**
 * 
 * @author 
 */
public class LessonList {
    private static LessonList lessonList = new LessonList();
    private ArrayList<Lesson> lessons = new ArrayList<>();

    /**
     * 
     */
    private LessonList(){
       // lessons = DataLoader.getLessons();
        if (lessons == null){
            lessons = new ArrayList<>();
        }
    }

    /**
     * 
     * @param title
     * @param description
     * @param content
     * @param flashcards
     * @param song
     */
    public void addLesson(String title, String description, String content, ArrayList<
    Flashcard> flashcards, Song song){
       // lessons.add(newLesson);
        //saveLessons();
    }

    /**
     * 
     */
    public void saveLessons(){
      //  DataWriter.saveLessons();
    }
}
