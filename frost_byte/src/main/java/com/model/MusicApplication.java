package com.model;

import java.util.ArrayList;

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
        track = new SongList(songs);
    }

    public boolean login(String userName, String password) {
        boolean logged_in = UserList.getInstance().login(userName, password);
        if (logged_in) {
            user = UserList.getInstance().getUser(userName);
        }
        return UserList.getInstance().login(userName, password);

    }

    public boolean logout() {
        UserList.getInstance().saveUsers();
        return true;
        // boolean loggin_in = UserList.getInstance().logout(userName);
        // if
    }

    public User getUser(String userName) {
        User loggedin_user = UserList.getInstance().getUser(userName);
        return loggedin_user;

    }

    public Song getSongByTitle(String title) {
        songs = track.getInstance();
        return track.getSongByTitle(title);

    }

    public ArrayList<Song> getSongsByArtist(String artist) {
        songs = track.getInstance();
        ArrayList<Song> display;
        display = track.getSongTitlesWithArtist(songs, artist);
        return display;
    }

    public String displaySongs() {
        songs = track.getInstance();
        String display;
        display = track.getSongTitles(songs);
        return display;
    }

    public void playSong(Song chosenSong) {
        try {
            Player player = new Player();
            Pattern songPattern = new Pattern();
            songPattern.setTempo(Integer.parseInt(chosenSong.getTempo()));
            songPattern.setInstrument("Tuba");
            for (Measure measures : chosenSong.getMeasureList()) {
                for (Note note : measures.getNoteList()) {
                    songPattern.add(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave() + note.getLength());
                }
                measures.getNotePlacement(measures);
            }
            player.play(songPattern);
        } catch (Exception e) {
        }
    }

    public boolean availableUsername(String userName) {
        boolean userExist = UserList.getInstance().userExist(userName); // if false that means they need to change the
                                                                        // username
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
