package com.model;

import java.util.ArrayList;

/**
 * 
 * @author
 */
public class MusicApplication {
    private User user;
    private Song song;
    private SongList track;
    private ArrayList<Song> songs;
    private ChooseInstrument instrument;
    private UserList users;
    
    public MusicApplication() {
        track = new SongList(songs);  
    }

    
    //teacher example
    public boolean login(String userName, String password){
        boolean logged_in = UserList.getInstance().login(userName,password);
        if (logged_in) {
            user = UserList.getInstance().getUser(userName);
        }
        return UserList.getInstance().login(userName,password);
       
    }

    // public boolean logout(String userName){
    //     boolean loggin_in = UserList.getInstance().logout(userName);
    //     if
    // }
    public User getUser(String userName){
        User loggedin_user = UserList.getInstance().getUser(userName);
        return loggedin_user;

    }
    // public Song getSongByTitle(String title){
    //     songs = track.getInstance();
    //     SongList.
    //     return song;
    // }
    public String getSongsByArtist(String artist){
        songs = track.getInstance();
        String display;
        display = track.getSongTitlesWithArtist(artist);
        return display;
    }
    // public String DisplaySong(){
    //     return song.getTitle();
    // }
    public String displaySongs(){   
        songs = track.getInstance();
        String display;
        display = track.getSongTitles(songs);
        return display;
    }

    // private String login(String userName){
    // return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */

    //  public boolean login(String userName, String password){
    //     boolean logged_in = UserList.getInstance().login(userName,password);
    //     if (logged_in) {
    //         user = UserList.getInstance().getUser(userName);
    //     }
    //     return UserList.getInstance().login(userName,password);
       
    // }

    public boolean safeToregister(String userName) {
        boolean userExist = UserList.getInstance().userExist(userName); //if false that means they need to change the username
        return userExist;

    }
    public void register(String userName, String firstName, String lastName, String email, String password, Boolean isTeacher){
        users.addUser(userName, firstName, lastName, email, password, isTeacher);
    }
    

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
