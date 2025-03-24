package com.model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public Measure addMeasure(Measure measure) {
        return measure;
    }

    public int setBeatAmount(int beatAmount) {
        this.beatAmount = beatAmount;
        return this.beatAmount;
    }

    public String setClef(String clef) {
        this.clef = clef;
        return this.clef;
    }

    public boolean setIsRepeat(boolean isRepeat) {
        this.isRepeat = isRepeat;
        return this.isRepeat;
    }

    public int getBeatAmount() {
        return this.beatAmount;
    }

    public String getClef() {
        return this.clef;
    }

    public boolean getIsRepeat() {
        return this.isRepeat;
    }

    public Measure(JSONObject measureJSON) {
        this.beatAmount = ((Long) measureJSON.get("beatAmount")).intValue();
        this.clef = (String) measureJSON.get("clef");
        this.isRepeat = (boolean) measureJSON.get("isRepeat");

        this.notes = new ArrayList<>();
        JSONArray notesArray = (JSONArray) measureJSON.get("notes");
        for (Object noteObj : notesArray) {
            JSONObject noteJSON = (JSONObject) noteObj;
            this.notes.add(new Note(noteJSON));
        }
    }

    public void setNotes(ArrayList<Note> notes2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNotes'");
    }
}
