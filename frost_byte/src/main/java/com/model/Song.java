package com.model;

import java.util.ArrayList;
import java.util.UUID;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;

// import java.lang.Thread;
// import org.jfugue.player.Player;
// import org.jfugue.pattern.Pattern;
// import org.jfugue.theory.Chord;
// import org.jfugue.theory.ChordProgression;
// import java.io.File;
// import java.io.IOException;
// import org.jfugue.midi.MidiFileManager;
// import javax.sound.midi.InvalidMidiDataException;
/**
 * 
 * @author
 */
public class Song {
    private UUID id;
    private String title;
    private String artist;
    private UUID author;
    private String genre;
    private String duration;
    private String tempo;
    private int defTimeSigNumer;
    private int defTimeSigDenom;
    private KeySig defKeySig;
    private ArrayList<Measure> measureList;

    /**
     * Constructor for Song class.
     * 
     * @param id              the UUID of the song.
     * @param title
     * @param artist
     * @param author
     * @param genre
     * @param duration
     * @param tempo
     * @param defTimeSigNumer
     * @param defTimeSigDenom
     * @param defKey
     * @param measureLi
     */
    public Song(UUID id, String title, String artist, UUID author, String genre, String duration, String tempo,
            int defTimeSigNumer,
            int defTimeSigDenom, KeySig defKey, ArrayList<Measure> measureList) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
        this.tempo = tempo;
        this.defTimeSigNumer = defTimeSigNumer;
        this.defTimeSigDenom = defTimeSigDenom;
        this.defKeySig = defKey;
        this.measureList = measureList;
    }

    /**
     * addMeasure Method adds a new measure object to the Arraylist<Measure>
     * measures.
     * 
     * @param measure
     */
    public void addMeasure(Measure measure) {
        measureList.add(measure);
    }

    /**
     * 
     * @return
     */
    public Annotation addAnnotation() {
        return new Annotation(null, artist);
    }

    /**
     * 
     */
    public void exportSong() {
        // datawriter
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
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @param artist
     * @return
     */
    public void setArtist(UUID author) {
        this.author = author;
    }

    /**
     * 
     * @param author
     * @return
     */
    public void setAuthor(String artist) {
        this.artist = artist;
    }

    /**
     * 
     * @param genre
     * @return
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * 
     * @param duration
     * @return
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 
     * @param tempo
     * @return
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    /**
     * 
     * @param defTimeSigNumer
     * @return
     */
    public void setDefTimeSigNumer(int defTimeSigNumer) {
        this.defTimeSigNumer = defTimeSigNumer;
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
     * 
     * @param defKeySig
     * @return
     */
    public void setDefKeySig(KeySig defKeySig) {
        this.defKeySig = defKeySig;
    }

    /**
     * 
     * @param MeasureList
     * @return
     */
    public void setMeasureList(ArrayList<Measure> measureList) {
        this.measureList = measureList;

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
    public UUID getAuthor() {
        return this.author;
    }

    /**
     * 
     * @return
     */
    public String getArtist() {
        return this.artist;
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
    public ArrayList<Measure> getMeasureList() {
        return measureList;
    }

    public Measure getMeasure(ArrayList<Measure> measureList, int measureNum) {
        return measureList.get(measureNum);
    }

    public String toString() {
        return "Title: " + getTitle() + " Author: " + getAuthor();
    }
}
