package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;

/**
 * 
 * @author 
 */
public class Song {
    private UUID id;
    private String title;
    private String author;
    private String genre;
    private String duration;
    private String tempo;
    private int defTimeSigNumer;
    private int defTimeSigDenom;
    private KeySig defKeySig;
    private ArrayList<Measure> MeasureList;


    /**
     * 
     * @param title
     * @param author
     * @param genre
     * @param duration
     * @param tempo
     * @param defTimeSigNumer
     * @param defTimeSigDenom
     * @param defKey
     * @param MeasureList
     */
    public Song(UUID id,String title, String author, String genre, String duration, String tempo, int defTimeSigNumer,
            int defTimeSigDenom, KeySig defKey, ArrayList<Measure> MeasureList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
        this.tempo = tempo;
        this.defTimeSigNumer = defTimeSigNumer;
        this.defTimeSigDenom = defTimeSigDenom;
        this.defKeySig = defKey;
        this.MeasureList = MeasureList;
    }

    // private void compileMeasures(ArrayList<Measure> MeasureList) {
    // } Dont need

    public Song(UUID id, String title2, String artist, String genre2, String duration2, String tempo2,
            String defTimeSigNum, String defTimeSigDen, String defKey, JSONArray measures) {
        //TODO Auto-generated constructor stub
    }

    /*
    public Measure addMeasure() {
        return new Measure(defTimeSigDenom, author, false, null);
    } */

    public Song(String title2, String author2, String genre2, String duration2, String tempo2, int defTimeSigNumer2,
            int defTimeSigDenom2, KeySig defKeySig2, ArrayList<Measure> measureList2) {
        //TODO Auto-generated constructor stub
    }

    /**
     * 
     * @return
     */
    public Annotation addAnnotation() {
        return new Annotation(null, author);
    }

    /**
     * 
     */
    public void exportSong() {
        //datawriter
       // DataWriter.exportSong();
    }

    /**
     * 
     * @return
     */
    public Clef addClef() {
        return new Clef(null);
    }

    /**
     * 
     * @param timeSig
     */
    public void changeTimeSig(TimeSig timeSig) {
    }

    /**
     * 
     * @param keySig
     */
    public void changeKeySig(KeySig keySig) {
    }

    /**
     * 
     * @param title
     * @return
     */
    public String setTitle(String title) {
        this.title = title;
        return this.title;
    }

    /**
     * 
     * @param author
     * @return
     */
    public String setAuthor(String author) {
        this.author = author;
        return this.author;
    }

    /**
     * 
     * @param genre
     * @return
     */
    public String setGenre(String genre) {
        this.genre = genre;
        return this.genre;
    }

    /**
     * 
     * @param duration
     * @return
     */
    public String setDuration(String duration) {
        this.duration = duration;
        return this.duration;
    }


    /**
     * 
     * @param tempo
     * @return
     */
    public String setTempo(String tempo) {
        this.tempo = tempo;
        return this.tempo;
    }

    /**
     * 
     * @param defTimeSigNumer
     * @return
     */
    public int setDefTimeSigNumer(int defTimeSigNumer) {
        this.defTimeSigNumer = defTimeSigNumer;
        return this.defTimeSigNumer;
    }

    /**
     * 
     * @param defTimeSigDenom
     * @return
     */
    public int setDefTimeSigDenom(int defTimeSigDenom) {
        this.defTimeSigDenom = defTimeSigDenom;
        return this.defTimeSigDenom;
    }

    /**
     * \
     * @param defKeySig
     * @return
     */
    public KeySig setDefKeySig(KeySig defKeySig) {
        this.defKeySig = defKeySig;
        return this.defKeySig;
    }

    /**
     * 
     * @param MeasureList
     * @return
     */
    public ArrayList<Measure> setMeasureList(ArrayList<Measure> MeasureList) {
        this.MeasureList = MeasureList;
        return this.MeasureList;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 
     * @return
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * 
     * @return
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * 
     * @return
     */
    public String getDuration() {
        return this.duration;
    }

    /**
     * 
     * @return
     */
    public String getTempo() {
        return this.tempo;
    }

    /**
     * 
     * @return
     */
    public int getDefTimeSigNumer() {
        return this.defTimeSigNumer;
    }

    /**
     * 
     * @return
     */
    public int getDefTimeSigDenom() {
        return this.defTimeSigDenom;
    }

    /**
     * 
     * @return
     */
    public KeySig getDefKeySig() {
        return this.defKeySig;
    }

    /**
     * 
     * @return
     */
    public  ArrayList<Measure> getMeasureList() {
        return this.MeasureList;
    }

    public Measure getMeasure (ArrayList<Measure> MeasureList, int measureNum) {
        return MeasureList.get(measureNum);
    }
    
    public String toString(){
        return "Title: "+ getTitle() +" Author: "+ getAuthor();
    }
}
