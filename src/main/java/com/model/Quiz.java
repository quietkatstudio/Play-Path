package com.model;
import java.util.ArrayList;

/**
 * 
 * @author 
 */
public class Quiz {
    private String question;
    private ArrayList<String> options;
    private String answer;


    /**
     * 
     * @param question
     * @param options
     * @param answer
     */
    public Quiz(String question, ArrayList<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    /**
     * 
     * @return
     */
    public String getQuestion(){
        return question;
    }

    /**
     * 
     * @return
     */
    public ArrayList<String> getOptions(){
        return options;
    }

    /**
     * 
     * @return
     */
    public String getAnswer(){
        return answer;
    }
}
