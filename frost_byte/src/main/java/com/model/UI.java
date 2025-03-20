package com.model;

import java.util.Scanner;

public class UI { /*ONLY USE THE FACADE, NO OTHER CLASSES. IF YOU NEED TO USE IT, ADD IT TO FACADE */



    private Scanner scanner;
    private MusicApplication application;
    public void scenario1(){
        //load song from songlist, play song
        //System.out.println("Song list: ");
        //application.loadSong();
        //application.playSong();
    }
    public void scenario2(){
        //login, take lesson, save the result

        //sara logins in
        //sara sees the titles and descriptions for all lessons
        //sara opens lesson 1
        //sara sees the content of lesson 1
        //sara goes through the flashcards
        //sara answers the question
        //sara plays a song

        System.out.println("Login:");
        /*if(application.login("asmith","securepass" )){
            System.out.println("Login successful");
            System.out.println("Welcome Alice");
        }*/
    }
    public void scenario3(){
       //load song, edit song, play song
    }
    public void scenario4(){
        //register a new user
        //login new user
    }

    public void run(){
        scenario1();
        scenario2();
        scenario3();
    }
    private void displayMainMenu(){
        
    }
    public static void main(String[] args){
        UI ui = new UI();
        ui.run();
        
    }

}