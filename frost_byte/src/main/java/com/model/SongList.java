package com.model;

import java.util.ArrayList;

/**
 * 
 * @author 
 */
public class SongList {
    private ArrayList<User> users;
    private SongList songs;

    /**
     * 
     */
    private SongList(SongList songs) {
        this.songs = songs;
    }

    /**
     * 
     * @return
     */
    public SongList getInstance() {
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
    public Song addSong(String title, String author, String genre,
     String duration, String tempo, int defTimeSigNumer, int defTimeSigDenom,
     KeySig defKeySig, ArrayList<Measure> MeasureList) {
        return new Song(title, author, genre, duration, tempo, defTimeSigNumer,
         defTimeSigDenom, defKeySig, MeasureList);
    }

    /**
     * 
     * @param title
     * @return
     */
    public Song getSong(String title) {
        return songs.getSong(title);
    }

    /**
     * 
     */
    public void saveSong() {
    }
}
