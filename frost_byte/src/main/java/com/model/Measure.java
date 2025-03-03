package com.model;

import java.util.ArrayList;

public class Measure {
    private int beatAmount;
    private String clef;
    private boolean isRepeat;
    private ArrayList<Note> notes;

    public Measure(int beatAmount, String clef, boolean isRepeat, ArrayList<Note> notes) {
        this.beatAmount = beatAmount;
        this.clef = clef;
        this.isRepeat = isRepeat;
        this.notes = notes;
    }

    private Measure addMeasure(Measure measure) {
        return measure;
    }

    private void addNote() {
    }

    private int setBeatAmount(int beatAmount) {
        this.beatAmount = beatAmount;
        return this.beatAmount;
    }

    private String setClef(String clef) {
        this.clef = clef;
        return this.clef;
    }

    private boolean setIsRepeat(boolean isRepeat) {
        this.isRepeat = isRepeat;
        return this.isRepeat;
    }

    private int getBeatAmount() {
        return this.beatAmount;
    }

    private String getClef() {
        return this.clef;
    }

    private boolean getIsRepeat() {
        return this.isRepeat;
    }
}
