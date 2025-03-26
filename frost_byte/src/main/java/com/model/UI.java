package com.model;

import java.util.Scanner;

public class UI { /*ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO FACADE */


    private SongList songs;
    private Scanner scanner;
    private MusicApplication application;
    public UI(){
        this.application = new MusicApplication();
    }
    public void scenario1(){
        /**
         * login alice,
         * alice searches for all songs by Traditional
         * alice sees Hot cross buns
         * alice picks Hot cross buns and plays the song
         * alice prints out the sheet music to text file 
         */


        //login
        String testUsername = "asmith";
        String testPassword = "securepass";
        System.out.println("Login:");
        System.out.println("Username: "+testUsername);
        System.out.println("PasswordS: "+testPassword);
        Boolean isLogin = application.login(testUsername,testPassword);
        if(isLogin){
            application.getUser(testUsername);
            System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName(testUsername));
            System.out.println("");
            System.out.println("Select an activity: Play song, edit song, Take lesson, log out");
            System.out.println("Play song");
            System.out.println("");
            //load songs from songlist, user selects a song, plays song
            System.out.println("Song list: ");
            System.out.println(application.displaySongs());
            System.out.println("Song selected: Hot Cross Buns");
            System.out.println();
            //someone play a the song please

    }
    else{
        System.out.println("Login unsuccessful");
    }
       // System.out.println(application.getSong("Hot Cross Buns"));
       // application.playSong("Hot Cross Buns");
    }


    public void scenario2(){
       //load song, edit song, play song
       //application.getAllSongs();
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

    }

    public void scenario3(){
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
        //register a new user
        //String userName, String firstName,String lastName, String email, String password, Boolean isTeacher
        System.out.println("Register user");
        application.register("username", "firstname", "lastname", "email", "password", true);
        application.login("username", "password");
        //login new user
    }

    public void run(){
        scenario1(); //login and play a song
    

    }
    
    private void displayMainMenu(){
        
    }
    public static void main(String[] args){
        UI ui = new UI();
        ui.run();
        
    }

}