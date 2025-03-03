package com.model;

import java.util.ArrayList;

public class Note {
    private Pitches pitch;
    private int valueNum;
    private int valueDenom;
    private Accidentals accidental;
    private int dot;
    private ArrayList<Articulations> articulations;
    private boolean isRest;

    public Note(Pitches pitch, int valueNum, int valueDenom, Accidentals accidental, int dot,
            ArrayList<Articulations> articulations, boolean isRest) {
        this.pitch = pitch;
        this.valueNum = valueNum;
        this.valueDenom = valueDenom;
        this.accidental = accidental;
        this.dot = dot;
        this.articulations = articulations;
        this.isRest = isRest;
    }

    private void setPitch(Pitches pitch) {
        this.pitch = pitch;
    }

    private void setValueNum(int valueNum) {
        this.valueNum = valueNum;
    }

    private void setValueDenom(int valueDenom) {
        this.valueDenom = valueDenom;
    }

    private void setAccidental(Accidentals accidental) {
        this.accidental = accidental;
    }

    private void setDot(int dot) {
        this.dot = dot;
    }

    private void addArticulation(Articulations articulation) {
        this.articulations.add(articulation);
    }

    private void setIsRest(boolean isRest) {
        this.isRest = isRest;
    }

    private Pitches getPitch() {
        return this.pitch;
    }

    private int getValueNum() {
        return this.valueNum;
    }

    private int getValueDenom() {
        return this.valueDenom;
    }

    private Accidentals getAccidental() {
        return this.accidental;
    }

    private int getDot() {
        return this.dot;
    }

    private ArrayList<Articulations> getArticulations() {
        return this.articulations;
    }

    private boolean getIsRest() {
        return this.isRest;
    }
}
