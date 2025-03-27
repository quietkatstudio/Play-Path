package com.model;

import java.util.ArrayList;
import java.util.Scanner;

import org.jfugue.player.Player;

public class UI {

    private SongList songs;
    private Scanner scanner;
    private MusicApplication application;
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLACK = "\u001B[30m";

    public UI() {
        this.application = new MusicApplication();
    }

    public void scenario2() {
        
        System.out.println("What would you like to do?");
        System.out.println("Play song, edit song, take lesson, log out, search for song");
        System.out.println(ANSI_GREEN);
        System.out.println("Search for song");
        System.out.println(ANSI_BLACK);
        System.out.println("Enter artist name:");
        System.out.println(ANSI_GREEN);
        System.out.println("Traditional");
        System.out.println(ANSI_BLACK);
        ArrayList<Song> songs = application.getSongsByArtist("Tradtional");
        for (Song song : songs) {
            System.out.println(song.getTitle());
        }
        System.out.println("Select a song to play");
        System.out.println(ANSI_GREEN);
        System.out.println("Hot Cross Buns");
        System.out.println(ANSI_BLACK);
        Song chosenSong = application.getSongByTitle("Hot Cross Buns");

        Player player = new Player();
        application.playSong(chosenSong);

    }

    public void scenario3() {
        /**
         * show neonwave in the users.json
         * show that there is no song called a horses journey
         * log in neonwave
         * create a new song called "A horses journey"
         * add 2 measures each with notes
         * play song
         * log out neonwave
         * show the json files
         * song should be tied to neonwave
         * 
         * sign in as asmith
         * search for song using a horses journey
         * play
         * */ 
        String testUsername1 = "NeonWave";
        String testPassword1 = "AncientTome";

        String testUsername2 = "asmith";
        String testPassword2 = "SurfVibes";


        application.clear();
        System.out.println("Login:");
        application.sleep();
        System.out.print(ANSI_GREEN);
        System.out.println("Username: "+testUsername1);
        application.sleep();
        System.out.println("Password: "+testPassword1);
        application.sleep();
        
        System.out.print(ANSI_BLACK);
        Boolean isLoggedin = application.login(testUsername1,testPassword1);
        if(isLoggedin){
            application.getUser(testUsername1);
            System.out.println("Login successful");
            application.sleep();
            System.out.println("Welcome " + application.getFirstName(testUsername1));
            application.longSleep();
            //application.clear();
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            
            System.out.print("Main Menu");
            application.shortSleep();
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            System.out.println("");
            application.sleep();
            System.out.println("Select an activity: Play song, edit song, Take lesson, log out, search for song, Make song");
            application.sleep();
            System.out.print(ANSI_GREEN);
            System.out.println("Make song");
            application.sleep();
            System.out.print(ANSI_BLACK);
            System.out.println("What would you like to name it?");
            application.sleep();
            System.out.print(ANSI_GREEN);
            System.out.println("A horses journey");
            application.sleep();
            System.out.print(ANSI_BLACK);
            application.longSleep();
           // application.clear();
            System.out.println("Edit mode");
            application.sleep();
            System.out.println("Making song named A horses journey.....");
            

            //moved out of editing mode
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            
            System.out.print("Main Menu");
            application.shortSleep();
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            System.out.println("");
            
            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.println("search for song");
            System.out.println("Would you like to search by title or see your own songs?");
            System.out.println("See my songs");
           
            //display songs by user id?
            System.out.println("Which song do you want to play?");
            System.out.println("A horses journey");


            //play


            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");


            System.out.print(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                isLoggedin = false;
                System.out.println("GoodBye!");
            }

        }



        System.out.println("Login:");
        application.sleep();
        System.out.print(ANSI_GREEN);
        System.out.println("Username: "+testUsername2);
        application.sleep();
        System.out.println("Password: "+testPassword2);
        application.sleep();


        System.out.print(ANSI_BLACK);
        Boolean isLoggedin2 = application.login(testUsername2,testPassword2);
        if(isLoggedin2){
            application.getUser(testUsername1);
            System.out.println("Login successful");
            application.sleep();
            System.out.println("Welcome " + application.getFirstName(testUsername2));
            application.longSleep();
            //application.clear();
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            
            System.out.print("Main Menu");
            application.shortSleep();
            for(int i=0; i<30; i++){
                System.out.print("-");
                application.shortSleep();
            }
            System.out.println("");
            application.sleep();
            System.out.println("Select an activity: Play song, edit song, Take lesson, log out, search for song, Make song");
            application.sleep();
            
            
          
            System.out.println("search for song");
            System.out.println("Would you like to search by title or see your own songs?");
            System.out.println("Search by title");
           
            //display songs by user id?
            System.out.println("Which song do you want to play?");
            System.out.println("A horses journey");


            //play


            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");


            System.out.print(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                isLoggedin = false;
                System.out.println("GoodBye!");
            }

        }












         // System.out.println("");
        // //load songs from songlist, user selects a song, plays song
        // System.out.println("Song list: ");
        // System.out.println("Retrieval : "+application.getSongByTitle("Hot Cross
        // Buns").getTitle());
        // application.playSong("Hot Cross Buns");
        // //System.out.println(application.displaySongs());

        // System.out.println("");
        // System.out.println("Song selected: Hot Cross Buns");
        // System.out.println();
        // //someone play a the song please



        
        // System.out.println(application.getSong("Hot Cross Buns"));
        // application.playSong("Hot Cross Buns");
    }

    public void scenario1() {
        boolean loggedin = false;
        System.out.println("Would you like to register or log in?");
        System.out.println(ANSI_GREEN);
        System.out.println("Register");
        System.out.println(ANSI_BLACK);
        System.out.println("Give a username");
        System.out.println(ANSI_GREEN);
        System.out.println("Username: NeonWave");
        System.out.println(ANSI_BLACK);
        if (!application.availableUsername("NeonWave")) {
            System.out.println("This username already exists");
        }
        System.out.println(ANSI_GREEN);
        System.out.println("Username: ShadowWave");
        System.out.println(ANSI_BLACK);
        if (application.availableUsername("ShadowWave")) {
            // should be safe to regiser
            System.out.println("Username is available");
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
        } else {
            System.out.println("This username already exists");
        }
        if (loggedin) {
            System.out.println("What would you like to do?");
            System.out.println("Play song, edit song, Take lesson, log out, search for song, logout");
            System.out.println(ANSI_GREEN);
            System.out.println("logout");
            System.out.println(ANSI_BLACK);
            if (application.logout()) {
                loggedin = false;
                System.out.println("GoodBye!");
            }

        }
        // login
        String testUsername = "ShadowWave";
        String testPassword = "ridingwaves";
        System.out.println("Login:");
        System.out.println("Username: " + testUsername);
        System.out.println("PasswordS: " + testPassword);
        Boolean isLogin = application.login(testUsername, testPassword);
        if (isLogin) {
            System.out.println("Login successful");
            System.out.println("Welcome " + application.getFirstName(testUsername));
        }

    }

    public void run() {
        //scenario2(); 
        scenario3();
        // scenario1();

    }

    private void displayMainMenu() {

    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();

    }

}