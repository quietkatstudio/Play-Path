package com.model;

import java.util.ArrayList;

public class Note {
    private String pitch;
    private String length;
    private String accidental;
    //private int dot;
    private String octave;

    public Note(String pitch, String length, String accidental,
            String octave) {
        this.pitch = pitch;
        this.length = length;
        this.accidental = accidental;
        this.octave = octave;
    }

    private void setPitch(String pitch) {
        this.pitch = pitch;
    }

    private void setLength(String length) {
        this.length = length;
    }
    private void setAccidental(String accidental) {
        this.accidental = accidental;
    }

    private void setOctave(String octave) {
        this.octave = octave;
    }

    String getPitch() {
        return this.pitch;
    }

    String getLength() {
        return this.length;
    }

    String getAccidental() {
        return this.accidental;
    }

    String getOctave() {
        return this.octave;
    }
}
