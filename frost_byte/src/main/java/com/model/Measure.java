package com.model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Measure {
    private int beatAmount;
    private String clef;
    private ArrayList<Note> notes;
    private boolean isRepeat;

    static String f4 = "";
    static String e4 = "";
    static String d4 = "";
    static String c4 = "";
    static String b4 = "";
    static String a4 = "";
    static String g3 = "";
    static String f3 = "";
    static String e3 = "";
    static String d3 = "";
    static String c3 = "";
    static String b3 = "";
    static String a3 = "";
    static String g2 = "";

    public Measure(int beatAmount2, String clef, ArrayList<Note> notes) {
        this.beatAmount = beatAmount2;
        this.clef = clef;
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

    public ArrayList<Note> getNoteList() {
        return this.notes;
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

    /**
     * This method sets the note symbols & accidentals, groups the notes by pitch,
     * then formats them accordingly.
     * 
     * @param measure
     */
    public static void getNotePlacement(Measure measure) {

        for (Note note : measure.getNoteList()) {
            note.setSymbol("");

            String symbolWithAccidental = note.getSymbol();

            // Checks for A notes
            for (Note Anote : measure.getNoteList()) {
                if (Anote.getPitch() == Pitches.A) {
                    if (Anote.getOctave() == 3) {
                        a3 = a3 + " " + symbolWithAccidental + " ";
                    }
                    if (Anote.getOctave() == 4) {
                        a4 = a4 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    a3 += "    ";
                    a4 += "----";
                }
            }

            // Checks for B notes
            for (Note Bnote : measure.getNoteList()) {
                if (Bnote.getPitch() == Pitches.B) {
                    if (Bnote.getOctave() == 3) {
                        b3 = b3 + "-" + symbolWithAccidental + "-";
                    }
                    if (Bnote.getOctave() == 4) {
                        b4 = b4 + " " + symbolWithAccidental + " ";
                    }
                } else {
                    b3 += "----";
                    b4 += "    ";
                }
            }

            // Checks for C notes
            for (Note Cnote : measure.getNoteList()) {
                if (Cnote.getPitch() == Pitches.C) {
                    if (Cnote.getOctave() == 3) {
                        c3 = c3 + " " + symbolWithAccidental + " ";
                    }
                    if (Cnote.getOctave() == 4) {
                        c4 = c4 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    c3 += "    ";
                    c4 += "    ";
                }
            }

            // Checks for D notes
            for (Note Dnote : measure.getNoteList()) {
                if (Dnote.getPitch() == Pitches.D) {
                    if (Dnote.getOctave() == 3) {
                        d3 = d3 + " " + symbolWithAccidental + " ";
                    }
                    if (Dnote.getOctave() == 4) {
                        d4 = d4 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    d3 += "----";
                }
            }

            // Checks for E notes
            for (Note Enote : measure.getNoteList()) {
                if (Enote.getPitch() == Pitches.E) {
                    if (Enote.getOctave() == 3) {
                        e3 = e3 + " " + symbolWithAccidental + " ";
                    }
                    if (Enote.getOctave() == 4) {
                        e4 = e4 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    e3 += "    ";
                }
            }

            // Checks for F notes
            for (Note Fnote : measure.getNoteList()) {
                if (Fnote.getPitch() == Pitches.F) {
                    if (Fnote.getOctave() == 3) {
                        f3 = f3 + "-" + symbolWithAccidental + "-";
                    }
                    if (Fnote.getOctave() == 4) {
                        f4 = f4 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    f3 += "----";
                }
            }

            // Checks for G notes
            for (Note Gnote : measure.getNoteList()) {
                if (Gnote.getPitch() == Pitches.G) {
                    if (Gnote.getOctave() == 3) {
                        g2 = g2 + "-" + symbolWithAccidental + "-";
                    }
                    if (Gnote.getOctave() == 4) {
                        g3 = g3 + "-" + symbolWithAccidental + "-";
                    }
                } else {
                    g2 += "----";
                    g3 += "    ";
                }
            }
        }
    }

    public void setNotes(ArrayList<Note> notes2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNotes'");
    }
}
