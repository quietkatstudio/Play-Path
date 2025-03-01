package com.model;

import java.util.ArrayList;

public class SongList {
    private ArrayList<User> users;
    private SongList songList;

    private SongList() {
    }

    public SongList getInstance() {
        return songList;
    }

    public Song addSong(String title, String author, String genre,
     String duration, String tempo, int defTimeSigNumer, int defTimeSigDenom,
     KeySig defKeySig, ArrayList<Measure> MeasureList) {
        return new Song(title, author, genre, duration, tempo, defTimeSigNumer,
         defTimeSigDenom, defKeySig, MeasureList);
    }

    public Song getSong(String title) {
        return songList.getSong(title);
    }

    public void saveSong() {
    }
}
