package com.model;

import java.util.ArrayList;

public class Song {
    private String title;
    private String author;
    private String genre;
    private String duration;
    private String tempo;
    private int defTimeSigNumer;
    private int defTimeSigDenom;
    private KeySig defKeySig;
    private ArrayList<Measure> MeasureList;

    public Song(String title, String author, String genre, String duration, String tempo, int defTimeSigNumer,
            int defTimeSigDenom, KeySig defKeySig, ArrayList<Measure> MeasureList) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
        this.tempo = tempo;
        this.defTimeSigNumer = defTimeSigNumer;
        this.defTimeSigDenom = defTimeSigDenom;
        this.defKeySig = defKeySig;
        this.MeasureList = MeasureList;
    }

<<<<<<< HEAD
    private void compileMeasures(ArrayList<Measure> MeasureList) {
        
    }
=======
    // private void compileMeasures(ArrayList<Measure> MeasureList) {
    // } Dont need
>>>>>>> 95655ad7e5bee3577a85e52ddcde593102b6cb77

    public Measure addMeasure() {
        return new Measure(defTimeSigDenom, author, false, null);
    }

    public Annotation addAnnotation() {
        return new Annotation(null, author);
    }

    public void exportSong() {
        //datawriter
       // DataWriter.exportSong();
    }

    public Clef addClef() {
        return new Clef(null);
    }

    public void changeTimeSig(TimeSig timeSig) {
    }

    public void changeKeySig(KeySig keySig) {
    }

    public String setTitle(String title) {
        this.title = title;
        return this.title;
    }

    public String setAuthor(String author) {
        this.author = author;
        return this.author;
    }

    public String setGenre(String genre) {
        this.genre = genre;
        return this.genre;
    }

    public String setDuration(String duration) {
        this.duration = duration;
        return this.duration;
    }

    public String setTempo(String tempo) {
        this.tempo = tempo;
        return this.tempo;
    }

    public int setDefTimeSigNumer(int defTimeSigNumer) {
        this.defTimeSigNumer = defTimeSigNumer;
        return this.defTimeSigNumer;
    }

    public int setDefTimeSigDenom(int defTimeSigDenom) {
        this.defTimeSigDenom = defTimeSigDenom;
        return this.defTimeSigDenom;
    }

    public KeySig setDefKeySig(KeySig defKeySig) {
        this.defKeySig = defKeySig;
        return this.defKeySig;
    }

    public ArrayList<Measure> setMeasureList(ArrayList<Measure> MeasureList) {
        this.MeasureList = MeasureList;
        return this.MeasureList;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getTempo() {
        return this.tempo;
    }

    public int getDefTimeSigNumer() {
        return this.defTimeSigNumer;
    }

    public int getDefTimeSigDenom() {
        return this.defTimeSigDenom;
    }

    public KeySig getDefKeySig() {
        return this.defKeySig;
    }

    public  ArrayList<Measure> getMeasureList() {
        return this.MeasureList;
    }
}
