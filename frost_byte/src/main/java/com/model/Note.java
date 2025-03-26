package com.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Note {
    private Pitches pitch;
    private String length;
    private Accidentals accidental;
    private int dot;
    private int octave;
    private String noteSymbol;

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
        this.dot = dot;
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

    public void setSymbol(String symbol) {
        this.noteSymbol = symbol;
    }

    /**
     * This getter method returns a String that is the combination of the note's
     * unicode character & the accidental character
     * 
     * @return String
     */
    public String getSymbol() {
        // Unicode handling
        String unicodeSymbol = "";
        if (this.length.equals("w")) {
            unicodeSymbol = "𝅝";
        } else if (this.length.equals("h")) {
            unicodeSymbol = "𝅗𝅥";
        } else if (this.length.equals("q")) {
            unicodeSymbol = "𝅘𝅥";
        } else if (this.length.equals("e")) {
            unicodeSymbol = "𝅘𝅥𝅮";
        } else if (this.length.equals("s")) {
            unicodeSymbol = "𝅘𝅥𝅯";
        } else if (this.length.equals("t")) {
            unicodeSymbol = "𝅘𝅥𝅰";
        } else if (this.length.equals("x")) {
            unicodeSymbol = "𝅘𝅥𝅱";
        } else if (this.length.equals("o")) {
            unicodeSymbol = "𝅘𝅥𝅲";
        } else {
            unicodeSymbol = "𝅘𝅥";
        }

        // Accidental handling
        String accidentalSymbol = "";
        if (this.accidental == Accidentals.SHARP) {
            accidentalSymbol = "#";
        } else if (this.accidental == Accidentals.FLAT) {
            accidentalSymbol = "♭";
        } else if (this.accidental == Accidentals.NATURAL) {
            accidentalSymbol = " ";
        }

        return unicodeSymbol + accidentalSymbol;
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
