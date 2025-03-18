package com.model;

/**
 * Flashcard holds the term and definition
 * @author 
 */
public class Flashcard {
    private String term;
    private String definition;

    /**
     * 
     * @param term
     * @param definition
     */
    public Flashcard(String term, String definition){
        this.term = term;
        this.definition = definition;
    }

    /**
     * 
     * @return 
     */
    public String getTerm(){
        return term;
    }

    /**
     * 
     * @return
     */
    public String getDefinition(){
        return definition;
    }
}
