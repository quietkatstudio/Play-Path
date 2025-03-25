package com.model;

import java.util.Scanner;

public class UI { /*ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO FACADE */


    private SongList songs;
    private Scanner scanner;
    private MusicApplication application;
    public void scenario1(){
        /**
         * login fred, but dont display it
         * fred searches for all songs by Tom Petty
         * he sees I won't back down, Mary Janes's Last Dance, Free Fallin
         * fred picks free falling and plays the song
         * free prints out the sheet music to text file 
         */


        //login
        System.out.println("Login:");
        if(application.login("asmith","securepass" )){  //.login  returns a boolean if the load was successful
             System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName("asmith"));
        }
        //System.out.println("Select an activity: Play song, edit song, Take lesson, log out");
        //System.out.println("Play song");
        //load songs from songlist, user selects a song, plays song
        //System.out.println("Song list: ");
        //application.loadSong();
        //System.out.println(getSongs());
        //System.out.println("Song selected: ________");
        //application.playSong(" ");
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
        /*
         * key notes: add a search ability
         *
         */
        /**
         * login fred, but dont display it
         * fred searches for all songs by Tom Petty
         * he sees I won't back down, Mary Janes's Last Dance, Free Fallin
         * fred picks free falling and plays the song
         * free prints out the sheet music to text file 
         */


       // scenario2(); //login and take a lesson
        //scenario3(); //make a new song
        /**
         * show her in the user json 
         * login the sister, fellicia
         * create a new song called A horses journey
         * add 2 measures
         * each has a set of notes
         * play the song
         * log out
         * login as fredrick
         * search for her new song
         * play it
         * 
         */


        //scenario4(); //register a new user, log in

        /**
         * 
         * fred tries to make a new account using fredrickson
         * the system rejects him
         * Video: show json file
         * fred changes the username to ffred
         * the system accepts him
         * fred logs out
         * fred logins in 
         * the system accepts him
         * Video: show json file
         * 
         *         */
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
