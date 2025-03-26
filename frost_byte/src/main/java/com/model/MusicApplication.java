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
        return UserList.getInstance().login(userName,password);
       
    }

    // public Song getSongByTitle(String title){
    //     songs = SongList.getInstance();
    //     SongList.
    //     return song;
    // }
    // public Song getSongByAuthor(String author){
    //     song = SongList.getInstance().getSongByAuthor(author);
    //     return song;
    // }
    // public String DisplaySong(){
    //     return song.getTitle();
    // }
    public String displaySongs(){   
        return track.getSongTitles();

    }

    // private String login(String userName){
    // return " ";
    // }

    /**
     * 
     * @param user
     * @return
     */
    public void register(String userName, String firstName, String lastName, String email, String password,
            Boolean isTeacher) {
        // add user to the list to be saved in json
        users.addUser(userName, firstName, lastName, email, password, isTeacher);

    }

    

    public String getFirstName(String username){
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
