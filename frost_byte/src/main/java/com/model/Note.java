package com.model;

import java.util.ArrayList;

public class Note {
    private Pitches pitch;
    private String length;
    private Accidentals accidental;
    private int dot;
    private int octave;

    public Note(Pitches pitch, String lenfth, Accidentals accidental, int dot,
            int octave) {
        this.pitch = pitch;
        this.length = length;
        this.accidental = accidental;
        this.dot = dot;
        this.octave = octave;
    }

    private void setPitch(Pitches pitch) {
        this.pitch = pitch;
    }

    private void setLength(String length) {
        this.length = length;
    }
    private void setAccidental(Accidentals accidental) {
        this.accidental = accidental;
    }

    private void setDot(int dot) {
        this.dot = dot;
    }

    private void setOctave(int octave) {
        this.octave = octave;
    }

    private Pitches getPitch() {
        return this.pitch;
    }

    private String getLength() {
        return this.length;
    }

    private Accidentals getAccidental() {
        return this.accidental;
    }

    private int getDot() {
        return this.dot;
    }

    private int getOctave() {
        return this.octave;
    }
}
