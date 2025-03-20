package com.model;

import java.util.Scanner;

public class UI { /*ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO FACADE */


    private SongList songs;
    private Scanner scanner;
    private MusicApplication application;
    public void scenario1(){
        //login
        //System.out.println("Login:");
        //if(application.login("asmith","securepass" )){
       //     System.out.println("Login successful");
       //     System.out.println("Welcome " + application.getFirstname);
       // }
        
        //load song from songlist, play song
        //System.out.println("Song list: ");
        //application.loadSong();
        //application.playSong();
    }



    public void scenario2(){
        //login, take lesson, save the result

        //sara logins in
        // System.out.println("Login:");
        // if(application.login("asmith","securepass" )){
        //     System.out.println("Login successful");
        //     System.out.println("Welcome Alice");
        // }
        // sara sees the titles and descriptions for all lessons
        //application.displayLessonOptions();
        
        //sara opens lesson 1
        //application.selectLesson("1");

        //sara sees the content of lesson 1
        //System.out.println("Title: "+ application.getTitle());
        //System.out.println("Description: " + application.getDescription());
        //System.out.println("Content: " + application.getContent());
        

        //sara goes through the flashcards
        //read flashcard
        //System.out.println("Term: " + application.getTerm());
        //System.out.println()

        //sara answers the question
        //System.out.println("Question: " + application.getQuestion());

        //sara plays a song

        

    }



    public void scenario3(){
       //load song, edit song, play song
       //application.getAllSongs();
    }
    public void scenario4(){
        //register a new user
        //String userName, String firstName,String lastName, String email, String password, Boolean isTeacher
        System.out.println("Register user");
        application.register("username", "firstname", "lastname", "email", "password", true);
        application.login("username", "password");
        //login new user
    }

    public void run(){
        scenario1(); //login and play a song
        scenario2(); //login and take a lesson
        scenario3(); //edit a song and play the song
        scenario4(); //register a new user, log in
    }
    private void displayMainMenu(){
        
    }
    public static void main(String[] args){
        UI ui = new UI();
        ui.run();
        
    }

}

//register a new user    happens in scernario 4
    //json . login

//play a song
//lessons or question

//create a new song
    //show its in json
    //play song

//connection between songs and people

//show all the songs that i've authored
