package com.model;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Track;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

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
        track = SongList.getInstance();
    }

    public boolean login(String userName, String password) {
        boolean logged_in = UserList.getInstance().login(userName, password);
        if (logged_in) {
            user = UserList.getInstance().getUser(userName);
        }
        return logged_in;

    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0);//1000
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
    public void longSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0);//3000
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
    public void shortSleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(0); //20
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }
    public boolean logout() {
        UserList.getInstance().saveUsers();
        return true;
    }

    public User getUser(String userName) {
        return UserList.getInstance().getUser(userName);

    }

    public Song getSongByTitle(String title) {

        return track.getSongByTitle(title);
    }

    public ArrayList<Song> getSongsByArtist(String artist) {
        ArrayList<Song> display = track.getSongTitlesWithArtist(artist);
        return display;
    }

    public String displaySongs() {
        return track.getSongTitles();
    }

    public void playSong(Song song) {
        track.playSong(song);
    }

    /**
     * This method checks to see if a username is already taken
     * 
     * @param userName
     * @return True (Available), False (Unavailable)
     */
    public boolean availableUsername(String userName) {
        boolean userExist = UserList.getInstance().userExist(userName);
        return userExist;
    }

    public void register(String userName, String firstName, String lastName, String email, String password,
            Boolean isTeacher) {

        UserList.getInstance().addUser(userName, firstName, lastName, email, password, isTeacher);
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
