package com.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Note {
    private Pitches pitch;
    private String length;
    private Accidentals accidental;
    private int dot;
    private int octave;

    public Note() {
        this.pitch = null;
        this.length = "";
        this.accidental = null;
        this.dot = 0;
        this.octave = 0;
    }

    public Note(Pitches pitch, String length, Accidentals accidental, int dot,
            int octave) {
        this.pitch = pitch;
        this.length = length;
        this.accidental = accidental;
        this.octave = octave;
    }

    public void setPitch(Pitches pitch) {
        this.pitch = pitch;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setAccidental(Accidentals accidental) {
        this.accidental = accidental;
    }

    public void setDot(int dot) {
        this.dot = dot;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public Pitches getPitch() {
        return this.pitch;
    }

    public String getLength() {
        return this.length;
    }

    public Accidentals getAccidental() {
        return this.accidental;
    }

    public int getDot() {
        return this.dot;
    }

    public int getOctave() {
        return this.octave;
    }

    public Note(JSONObject noteJSON) {
        this.pitch = Pitches.valueOf((String) noteJSON.get("pitch"));
        this.length = (String) noteJSON.get("length");
        this.accidental = Accidentals.valueOf((String) noteJSON.get("accidental"));
        this.dot = ((Long) noteJSON.get("dot")).intValue();
        this.octave = ((Long) noteJSON.get("octave")).intValue();
    }
}
