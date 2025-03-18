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

    // private void compileMeasures(ArrayList<Measure> MeasureList) {
    // } Dont need

    private Measure addMeasure() {
        return new Measure(defTimeSigDenom, author, false, null);
    }

    private Annotation addAnnotation() {
        return new Annotation(null, author);
    }

    private void exportSong() {
        //datawriter
       // DataWriter.exportSong();
    }

    private Clef addClef() {
        return new Clef(null);
    }

    private void changeTimeSig(TimeSig timeSig) {
    }

    private void changeKeySig(KeySig keySig) {
    }

    private String setTitle(String title) {
        this.title = title;
        return this.title;
    }

    private String setAuthor(String author) {
        this.author = author;
        return this.author;
    }

    private String setGenre(String genre) {
        this.genre = genre;
        return this.genre;
    }

    private String setDuration(String duration) {
        this.duration = duration;
        return this.duration;
    }

    private String setTempo(String tempo) {
        this.tempo = tempo;
        return this.tempo;
    }

    private int setDefTimeSigNumer(int defTimeSigNumer) {
        this.defTimeSigNumer = defTimeSigNumer;
        return this.defTimeSigNumer;
    }

    private int setDefTimeSigDenom(int defTimeSigDenom) {
        this.defTimeSigDenom = defTimeSigDenom;
        return this.defTimeSigDenom;
    }

    private KeySig setDefKeySig(KeySig defKeySig) {
        this.defKeySig = defKeySig;
        return this.defKeySig;
    }

    private ArrayList<Measure> setMeasureList(ArrayList<Measure> MeasureList) {
        this.MeasureList = MeasureList;
        return this.MeasureList;
    }

    private String getTitle() {
        return this.title;
    }

    private String getAuthor() {
        return this.author;
    }

    private String getGenre() {
        return this.genre;
    }

    private String getDuration() {
        return this.duration;
    }

    private String getTempo() {
        return this.tempo;
    }

    private int getDefTimeSigNumer() {
        return this.defTimeSigNumer;
    }

    private int getDefTimeSigDenom() {
        return this.defTimeSigDenom;
    }

    private KeySig getDefKeySig() {
        return this.defKeySig;
    }

    private ArrayList<Measure> getMeasureList() {
        return this.MeasureList;
    }
}
