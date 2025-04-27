package com.model;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


//import javax.sound.midi.Track;

//import org.jfugue.pattern.Pattern;
//import org.jfugue.player.Player;
/**
 * This class is
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
     * Constructs a new MusicApplication instance
     */
    public MusicApplication() {
        track = SongList.getInstance();
    }

    /**
     * Authenticates a user by verifying their username and password
     * @param userName the user's username
     * @param password the user's password
     * @return true if login is successful, false otherwise
     */
    public boolean login(String userName, String password) {
        boolean logged_in = UserList.getInstance().login(userName, password);
        if (logged_in) {
            user = UserList.getInstance().getUser(userName);
        }
        return logged_in;

    }

    
     /**
     * Registers a new user in the system
     * @param userName the user's username
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param email the user's email
     * @param password the user's password
     * @param isTeacher true if they are a teacher, false if a student
     */
    public void register(String userName, String firstName, String lastName, String email, String password,
            Boolean isTeacher) {

        UserList.getInstance().addUser(userName, firstName, lastName, email, password, isTeacher);
    }

    /**
     * Retrieves the first name of a given user
     * @param username the user's username
     * @return the user's first name
     */
    public String getFirstName(String username) {
        return UserList.getInstance().getUser(username).getFirstName();
    }
    /**
     * Logs out the current user and saves user data
     * @return true after saving the users data
     */
    public boolean logout() {
        UserList.getInstance().saveUsers();
        return true;
    }

    /**
     * Retrieves a user object by their username
     * @param userName the user's username
     * @return the User object corresponding to the given username
     */
    public User getUser(String userName) {
        return UserList.getInstance().getUser(userName);

    }

     /**
     * This method checks to see if a username is already taken
     * 
     * @param userName the username to check
     * @return True (Available), False (Unavailable)
     */
    public boolean availableUsername(String userName) {
        boolean userExist = UserList.getInstance().userExist(userName);
        return userExist;
    }

    /**
     * Retrieves a song by its title
     * @param title the songs title
     * @return the song object if found, null otherwise
     */
    public Song getSongByTitle(String title) {

        return track.getSongByTitle(title);
    }

    /**
     * 
     * @param artist
     * @return
     */
    public ArrayList<Song> getSongsByArtist(String artist) {
        ArrayList<Song> display = track.getSongTitlesWithArtist(artist);
        return display;
    }

    /**
     * 
     * @return
     */
    public String displaySongs() {
        return track.getSongTitles();
    }

    /**
     * 
     * @param song
     */
    public void playSong(Song song) {
        track.playSong(song);
    }

   
   

    /**
     * 
     * @param song
     * @return
     */
    public Song makeSong(Song song) {
        return song;
    }

    /**
     * 
     */
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * waits 0 milleseconds
     */
    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0);//1000
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

    /**
     * waits 0 milleseconds
     */
    public void longSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0);//3000
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

    /**
     * Waits 0 milleseconds
     */
    public void shortSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0); //20
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

}
