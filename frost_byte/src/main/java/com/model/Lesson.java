package com.model;
import java.util.ArrayList;
import java.util.UUID;

import com.Flashcard;

public class Lesson {
    private UUID id;
    private String title;
    private String description;
    private String content;
    private ArrayList<Flashcard> flashcards;
    //private ArrayList<Quiz> quiz;
    private Song song;
    public Lesson(UUID id, String title, String description, String content, ArrayList<Flashcard> flashcards, Song song){
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        
    }
    public UUID getID(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getContent(){
        return content;
    }
    public ArrayList<Flashcard> getFlashcards(){
        return flashcards;
    }
    // public Quiz getQuiz(){
    //     return quiz;
    // }
    public Song getSong(){
        return song;
    }
 }
