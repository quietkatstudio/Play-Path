package com.model;

import java.util.ArrayList;

/**
 * Provides a facade for managing users, songs,
 * and interactions within the music application.
 * @author Frost Byte
 */
public class MusicApplication {
    private User user;
    private Song song;
    private SongList track;
    private ArrayList<Song> songs;
    private ChooseInstrument instrument;
    private UserList users;
    
    /**
     * Constructs a new MusicApplication instance.
     */
    public MusicApplication() {
        track = new SongList(songs);  
    }

    
    /**
     * Attempts to log in a user with the given username and password
     * @param userName the users username
     * @param password the users password
     * @return true if the login is successful, else is false
     */
    public boolean login(String userName, String password){
        boolean logged_in = UserList.getInstance().login(userName,password);
        if (logged_in) {
            user = UserList.getInstance().getUser(userName);
        }
        return UserList.getInstance().login(userName,password);
       
    }

    /**
     * Logs out the current user and saves user data.
     * @return True after logging out
     */
     public boolean logout(){
           UserList.getInstance().saveUsers();
           return true;
    
     }

    /**
     * Retrieves a User object by username
     * @param userName The user's username
     * @return The User object if found, null otherwise
     */
    public User getUser(String userName){
        User loggedin_user = UserList.getInstance().getUser(userName);
        return loggedin_user;

    }

    /**
     * Retrieves a Song object by its title
     * @param title The title of the song
     * @return The Song object if found, null otherwise
     */
    public Song getSongByTitle(String title){
        songs = track.getInstance();
        return track.getSongByTitle(title);
        
    }

    /**
     * Retrieves all songs by a specified artist
     * @param artist The name of the artist
     * @return A string containing the song titles by the artist
     */
    public String getSongsByArtist(String artist){
        songs = track.getInstance();
        String display;
        display = track.getSongTitlesWithArtist(songs, artist);
        return display;
    }
    
    /**
     * Displays all songs
     * @return A string containing all song titles
     */
    public String displaySongs(){   
        songs = track.getInstance();
        String display;
        display = track.getSongTitles(songs);
        return display;
    }

    /**
     * Play the song that has given the title
     * @param title The songs title
     */
    public void playSong(String title){
        track.playSong(title);
    }

   
    /**
     * Checks if a username is available for registration
     * @param userName the user's username
     * @return false if the username already exists, true otherwise
     */
    public boolean safeToregister(String userName) {
        boolean userExist = UserList.getInstance().userExist(userName); //if false that means they need to change the username
        return userExist;

    }

    /**
     * Registers a new user in the system
     * @param userName the user's username
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param email the user's email
     * @param password  the user's password
     * @param isTeacher true if they are a teacher, false if they are a student
     */
    public void register(String userName, String firstName, String lastName, String email, String password, Boolean isTeacher){
        
        UserList.getInstance().addUser(userName, firstName, lastName, email, password, isTeacher);
    }
    

    /**
     * Retrieves the first name of a user by their username
     * @param username the user's username
     * @return the users first name
     */
    public String getFirstName(String username) {
        return UserList.getInstance().getUser(username).getFirstName();
    }

    /**
     * 
     * @param song
     * @return
     */
    public Song makeSong(Song song) {
        return song;
    }

}
