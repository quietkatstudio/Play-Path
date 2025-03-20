package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 * @author
 */
public class Lesson {
    private UUID id;
    private String title;
    private String description;
    private String content;
    private ArrayList<Flashcard> flashcards;
    private Quiz quiz;
    private Song song;
    private int currentFlashcardIndex;

    /**
     * 
     * @param id
     * @param title
     * @param description
     * @param content
     * @param flashcards
     * @param quiz
     * @param song
     */
    public Lesson(UUID id, String title, String description, String content, ArrayList<Flashcard> flashcards, Quiz quiz,
            Song song) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.song = song;
        this.quiz = quiz;
        this.currentFlashcardIndex = 0;

    }

    /**
     * 
     * @param title       the lessons name
     * @param description a description of the lesson
     * @param content     the lesson
     * @param flashcards  holds the list of flashcards
     * @param quiz        the multiple choice question
     * @param song        the song played during lesson
     */
    public Lesson(String title, String description, String content, ArrayList<Flashcard> flashcards, Quiz quiz,
            Song song) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.content = content;
        this.song = song;
        this.quiz = quiz;

    }

    /**
     * 
     * @return the lessons id
     */
    public UUID getID() {
        return this.id;
    }

    /**
     * 
     * @return the title of the lesson
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @return content string
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 
     * @return the flashcards
     */
    public ArrayList<Flashcard> getFlashcards() {
        return this.flashcards;
    }

    /**
     * 
     * @return the quiz
     */
    public Quiz getQuiz() {
        return this.quiz;
    }

    /**
     * Returns the song
     */
    public Song getSong() {
        return this.song;
    }
}
