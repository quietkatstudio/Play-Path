package com.model;

import java.util.ArrayList;

public class Measure {
    private String beatAmount;
    private String clef;
    private ArrayList<Note> notes;

    public Measure(String beatAmount, String clef, ArrayList<Note> notes) {
        this.beatAmount = beatAmount;
        this.clef = clef;
        this.notes = notes;
    }

    private Measure addMeasure(Measure measure) {
        return measure;
    }

    private void addNote() {
    }

    private String setBeatAmount(String beatAmount) {
        this.beatAmount = beatAmount;
        return this.beatAmount;
    }

    private String setClef(String clef) {
        this.clef = clef;
        return this.clef;
    }

    String getBeatAmount() {
        return this.beatAmount;
    }

    private String getClef() {
        return this.clef;
    }

    public  ArrayList<Note> getNoteList() {
        return this.notes;
    }
}
