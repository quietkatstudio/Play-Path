package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The LessonList class manages the list of lessons and provides methods to add
 * and save lessons.
 */
public class LessonList {
    private static LessonList instance; // Singleton instance
    private static LessonList lessonList = new LessonList();
    private ArrayList<Lesson> lessons = new ArrayList<>();

    /**
     * Private constructor that loads lessons from the data source.
     * If no lessons are found, initializes an empty list.
     */
    private LessonList() {
        lessons = DataLoader.getLessons();
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
    }

    /**
     * Gets the singleton instance of the LessonList.
     * 
     * @return the LessonList instance
     */
    public static LessonList getInstance() {
        if (instance == null) {
            instance = new LessonList();
        }
        return instance;
    }

    /**
     * Adds a new lesson to the list and saves the updated list.
     *
     * @param title       the title of the lesson
     * @param description the description of the lesson
     * @param content     the content of the lesson
     * @param flashcards  the list of flashcards associated with the lesson
     * @param song        the song associated with the lesson
     */
    public void addLesson(String title, String description, String content, ArrayList<Flashcard> flashcards,
            String song) {
        // Create a new lesson with the provided details
        Lesson newLesson = new Lesson(UUID.randomUUID(), title, description, content, flashcards, null, song);
        lessons.add(newLesson);

        // Save the updated lessons list
        saveLessons();
    }

    /**
     * Saves the list of lessons to the file.
     */
    public void saveLessons() {
        // Save lessons using DataWriter class
        DataWriter.saveLessons(lessons);
    }

    /**
     * Gets the list of lessons.
     * 
     * @return the list of lessons
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public Lesson getLessonByTitle(String title) {
        for (Lesson lesson : lessons) {
            if (lesson.getTitle().equalsIgnoreCase(title)) {
                return lesson;
            }
        }
        return null;
    }
}
