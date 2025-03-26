package com.model;

import java.util.Scanner;

public class UI { /*ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO FACADE */


    private SongList songs;
    private Scanner scanner;
    private MusicApplication application;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLACK = "\u001B[30m";
    public UI(){
        this.application = new MusicApplication();
    }

    public void scenario1(){
        boolean loggedin = false;
        System.out.println("Would you like to register or log in?");
        System.out.println(ANSI_GREEN);
        System.out.println("Register");
        System.out.println(ANSI_BLACK);
        System.out.println("Give a username");
        System.out.println(ANSI_GREEN);
        System.out.println("Username: NeonWave");
      //need to implement a looping system later on
        System.out.println(ANSI_BLACK);
        if(application.safeToregister("NeonWave")){
            //wont be safe to regiser
        }
        else{
            System.out.println("This username already exists");
        }
        System.out.println(ANSI_GREEN);
        System.out.println("Username: ShadowWave");
        System.out.println(ANSI_BLACK);
        if(application.safeToregister("ShadowWave")){
            //should be safe to regiser
            System.out.println("Username is safe");
            System.out.println("Please enter the required information");
            System.out.println(ANSI_GREEN);
            System.out.println("Username: ShadowWave");
            System.out.println("First name: Shawn");
            System.out.println("Last name: Black");
            System.out.println("email: blackshadow@example.com");
            System.out.println("password: ridingwaves");
            System.out.println(ANSI_BLACK);
            System.out.println("Would you like to be a teacher?");
            System.out.println(ANSI_GREEN);
            System.out.println("No");
            System.out.println(ANSI_BLACK);

            application.register("ShadowWave", "Shawn", "Black", "blackshadow@example.com", "ridingwaves", false);
            loggedin = true;
        }
        else{
            System.out.println("This username already exists");
        }
        if(loggedin){
            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.println(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if(application.logout()){
                loggedin = false;
                System.out.println("GoodBye!");
            }
            
        }
        //login
        String testUsername = "ShadowWave";
        String testPassword = "ridingwaves";
        System.out.println("Login:");
        System.out.println("Username: "+testUsername);
        System.out.println("PasswordS: "+testPassword);
        Boolean isLogin = application.login(testUsername,testPassword);
        if(isLogin){
            System.out.println("Login successful");
            System.out.println("Welcome "+application.getFirstName(testUsername));
        }



        
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
        songs.playSong("Hot Cross Buns");
 
     }
    public void scenario3(){ 
        //login
        String testUsername = "NeonWave";
        String testPassword = "AncientTome";
      //  System.out.println("Login:");
       // System.out.println("Username: "+testUsername);
      //  System.out.println("PasswordS: "+testPassword);
        // Boolean isLogin = application.login(testUsername,testPassword);
        // if(isLogin){
        //     application.getUser(testUsername);
        //     System.out.println("Login successful");
        //     System.out.println("Welcome " + application.getFirstName(testUsername));
        //     System.out.println("");
        //     System.out.println("Select an activity: Play song, edit song, Take lesson, log out, search for song");

            application.playSong("Hot Cross Buns");
            // System.out.println("Search for song");
            // System.out.println("");
            // //load songs from songlist, user selects a song, plays song
            // System.out.println("Song list: ");
            // System.out.println("Retrieval : "+application.getSongByTitle("Hot Cross Buns").getTitle());
            
            // //System.out.println(application.displaySongs());
            
            // System.out.println("");
            // System.out.println("Song selected: Hot Cross Buns");
            // System.out.println();
            // //someone play a the song please

    // }
    // else{
    //     System.out.println("Login unsuccessful");
    // }
       // System.out.println(application.getSong("Hot Cross Buns"));
       // application.playSong("Hot Cross Buns");
    }


       
    

    public void run(){
        scenario2(); //login and play a song
        //scenario3();
        //scenario3();

    }
    
    private void displayMainMenu(){
        
    }
    public static void main(String[] args){
        UI ui = new UI();
        ui.run();
        
    }

}