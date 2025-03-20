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
    public Lesson(UUID id, String title, String description, String content, ArrayList<Flashcard> flashcards, Quiz quiz, Song song){
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
     * @param title the lessons name
     * @param description a description of the lesson
     * @param content the lesson
     * @param flashcards holds the list of flashcards
     * @param quiz the multiple choice question
     * @param song the song played during lesson
     */
    public Lesson(String title, String description, String content, ArrayList<Flashcard> flashcards, Quiz quiz, Song song){
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
    public UUID getID(){
        return id;
    }

    /**
     * 
     * @return the title of the lesson
     */
    public String getTitle(){
        return title;
    }

    /**
     * 
     * @return the description
     */
    public String getDescription(){
        return description;
    }

    /**
     * 
     * @return content string
     */
    public String getContent(){
        return content;
    }

    /**
     * 
     * @return the flashcards
     */
    public ArrayList<Flashcard> getFlashcards(){
        return flashcards;
    }
    public boolean hasNext(){
        while(currentFlashcardIndex < flashcards.size() && (flashcards.get(currentFlashcardIndex)!= null)){
            currentFlashcardIndex++;
        }
        return false;
    }
    public Flashcard nextFlashCard(){
        //currentFlashcardIndex++;
        return flashcards.get(currentFlashcardIndex++);
    }

    /*public boolean hasNext(){
       
        while((position < flights.size()) && (flights.get(position) != null)){
            if((flights.get(position).sameLoc(from, to))){
                return true;
            }
            position++;
        }
        return false;
    }

    /**
     * returns the next flight that matches the specific route
     * @return the next matching flight
     
    public Flight next(){
        return flights.get(position++);
    }
    */








    /**
     * 
     * @return the quiz
     */
    public Quiz getQuiz(){
        return quiz;
    }

    /**
     * Returns the song
     */
    public Song getSong(){
        return song;
    }
 }
