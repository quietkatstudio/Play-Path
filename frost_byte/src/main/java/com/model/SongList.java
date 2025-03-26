package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.player.Player;

/**
 * 
 * @author 
 */
public class SongList {
   // private static SongList songList = new SongList();
    private static ArrayList<Song> songs; // = new ArrayList<>();
    private ArrayList<User> users;
    //private ArrayList<Song> songs;
    

    /**
     * 
     */
    public SongList(ArrayList<Song> songs_) {
        songs_ = DataLoader.getSongs();
        if (songs_ == null) {
            songs_ = new ArrayList<>();
        }
        songs_ = DataLoader.getSongs();
        
       
    }

    

    /**
     * 
     * @return
     */
    public static ArrayList<Song> getInstance() {
        if (songs == null) {
            songs = new ArrayList<>();
            songs = DataLoader.getSongs();
        }
        return songs;
    }

    



    /**
     * 
     * @param title
     * @param author
     * @param genre
     * @param duration
     * @param tempo
     * @param defTimeSigNumer
     * @param defTimeSigDenom
     * @param defKeySig
     * @param MeasureList
     * @return
     */
    public Song addSong(UUID id,
                        String title,
                        String artist, 
                        UUID author, 
                        String genre,
                        String duration,
                        String tempo, 
                        int defTimeSigNumer, 
                        int defTimeSigDenom,
                        KeySig defKeySig, 
                        ArrayList<Measure> MeasureList) {

        return new Song(id, title, artist, author, genre, duration, tempo, defTimeSigNumer, defTimeSigDenom, defKeySig, MeasureList);
    }

    /**
     * 
     * @param title
     * @return
     */
    public Song getSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                return songs.get(i); //returns the specific song that matches the title
            }
        }
        return null; 
     
        
    }

    public String getSongTitles(ArrayList<Song> songs){
        String songTitles = "";
        for (int i=0; i< songs.size(); i++){
            songTitles = songTitles+ "\n" +(songs.get(i).getTitle());
        }
        return songTitles;
    }  
    public String getSongTitlesWithArtist(String artist){
        String songTitles = "";
        for (int i=0; i< songs.size(); i++){
            if (songs.get(i).getArtist().equals(artist)) {
                songTitles = songTitles+ "\n" +(songs.get(i).getTitle());
            } 
        }
        return songTitles;
    }  

    public Song getSongByAuthor(String author) {
        for (Song song : songs) {
            if (song.getAuthor().equals(author)) {
                return song;
            }
        }
        return null;
        
    }

   

    public void saveSongs() {
        DataWriter.saveSongs();
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void playSong(String title){
        try {
            Player player = new Player();
            songs = getSongs();
            for (int i=0; i< songs.size(); i++){
                if (songs.get(i).getTitle().contains(title)) {
                    playSong(songs.get(i));
                } 
            }
        } catch (Exception e) {
        }
    }
    
}
