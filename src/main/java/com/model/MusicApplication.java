package com.model;
import java.util.ArrayList;



//import javax.sound.midi.Track;

//import org.jfugue.pattern.Pattern;
//import org.jfugue.player.Player;
/**
 * This class manages the music application logic
 * @author Frost Byte
 */
public class MusicApplication {
    //----------------------------
    //fields
    //----------------------------
    private User user;                      //current logged in user
    private Song song;                      //singleton song list
    private SongList track;                 //not used yet
    private ArrayList<Song> songs;          //not used yet
    private ChooseInstrument instrument;    //not userd yet
    private UserList users;
    
  

    /**
     * Constructs a new MusicApplication instance
     */
    public MusicApplication() {
        track = SongList.getInstance();
    }

    /**
     * User Authentication
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
     * Logs out the current user and saves user data
     * @return true after saving the users data
     */
    public boolean logout() {
        UserList.getInstance().saveUsers();
        return true;
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
    public boolean register(String userName, String firstName, String lastName, String email, String password,
            Boolean isTeacher, String securityQuestion, String securityAnswer) {

        if (!isValidEmail(email)) {
            return false;
        }
        if (UserList.getInstance().userExist(userName)){
            return false;
        }
        UserList.getInstance().addUser(userName, firstName, lastName, email, password, isTeacher, securityQuestion, securityAnswer);
        UserList.getInstance().saveUsers();
        return true;    
    }


    //----------------------------
    // User Info / Updates
    //----------------------------

    // public boolean forgotPassword(String username){
    //     User user = UserList.getInstance().getUser(username);
    //     if (user == null){
    //         return false;
    //     }

    //     String tempPassword = UUID.randomUUID().toString().substring(0, 8);
    //     user.setPassword(tempPassword);
        
    //     UserList.getInstance().saveUsers();
    //     EmailSender.sendEmail(user.getEmail(), "Password Reset", "Your new password is: " + tempPassword);
    //     return true;
    // }


    public boolean changePassword(String username, String newPassword){
        User user = UserList.getInstance().getUser(username);
        if(user != null) {
            user.setPassword(newPassword);
            UserList.getInstance().saveUsers();
            return true;
        }
        return false;
    }


    public boolean changeUserName(String username, String newPassword){
        User user = UserList.getInstance().getUser(username);
        if(user != null) {
            return UserList.getInstance().updateUser(user, username, user.getEmail());
        }
        return false;//if user does not exist return false
    }


    public boolean changeEmail(String username, String newEmail){
        User user = UserList.getInstance().getUser(username);
        if(user != null) {
            return UserList.getInstance().updateUser(user, user.getUserName(), newEmail);
        }
        return false;//if user does not exist return false
    }



    /**
     * Retrieves a user object by their username
     * @param userName the user's username
     * @return the User object corresponding to the given username
     */
    public User getUser(String userName) {
        return UserList.getInstance().getUser(userName);

    }

   
    public User getCurrentUser() {
        return user;

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
     * This method checks to see if a username is already taken
     * 
     * @param userName the username to check
     * @return True (Available), False (Unavailable)
     */
    public boolean availableUsername(String userName) {
        return !UserList.getInstance().userExist(userName);
        
    }

    

    public User getUserByUsername(String username){
    return UserList.getInstance().getUser(username);
}


    public void updateUser(User user){
       
        UserList.getInstance().saveUsers();
    }




    //----------------------------
    // Song Management
    //----------------------------

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


   
    //----------------------------
    // Helpers
    //----------------------------

    /**
     * This method checks if the email is valid format
     * @param email the email to check
     * @return True (correct), False (need to fix format)
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

   

   

   
   

   
    

    

}
