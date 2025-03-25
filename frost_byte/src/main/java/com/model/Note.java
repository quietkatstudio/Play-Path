package com.model;

import java.util.ArrayList;

public class Note {
    private String pitch;
    private String length;
    private Accidentals accidental;
    //private int dot;
    private String octave;

    public Note(String pitch, Accidentals accidental, String octave,
    String length) {
        this.pitch = pitch;
        this.length = length;
        this.accidental = accidental;
        this.octave = octave;
    }

    void setPitch(String pitch) {
        this.pitch = pitch;
    }

    void setLength(String length) {
        this.length = length;
    }
    void setAccidental(Accidentals accidental) {
        this.accidental = accidental;
    }

    void setOctave(String octave) {
        this.octave = octave;
    }

    String getPitch() {
        return this.pitch;
    }

    String getLength() {
        return this.length;
    }

    Accidentals getAccidental() {
        return this.accidental;
    }

    String getOctave() {
        return this.octave;
    }
}
