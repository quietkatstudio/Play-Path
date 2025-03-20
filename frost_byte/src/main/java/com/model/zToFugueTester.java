package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.Thread;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import java.io.File;
import java.io.IOException;
import org.jfugue.midi.MidiFileManager;
import javax.sound.midi.InvalidMidiDataException;

public class zToFugueTester {
    public static void main(String[] args) {
        try {
            Player player = new Player();
            getSongs();
            //player.playSong();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader reader = new FileReader("ztestSongs.json");
            JSONParser parser = new JSONParser();
            JSONArray songJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < songJson.size(); i++) {
                JSONObject songJSON = (JSONObject) songJson.get(i);
                String id = (String) songJSON.get("id");
                String title = (String) songJSON.get("title");
                String artist = (String) songJSON.get("artist");
                String genre = (String) songJSON.get("genre");
                String duration = (String) songJSON.get("duration");
                String tempo = (String) songJSON.get("tempo");
                String defTimeSigNum = (String) songJSON.get("defTimeSigNumer");
                String defTimeSigDen = (String) songJSON.get("defTimeSigDenom");
                String defKey = (String) songJSON.get("defKeySig");
                JSONArray measures = (JSONArray) songJSON.get("measureList");
                for (int j = 0; j < measures.size(); j++) {
                    JSONObject measure = (JSONObject) measures.get(j);
                    String beatAmount = (String) measure.get("beatAmount");
                    String clef = (String) measure.get("clef");
                    JSONArray notes = (JSONArray) measure.get("notes");
                    for (int r = 0; r < notes.size(); r++) {
                        JSONObject note = (JSONObject) notes.get(r);
                        String notePitch = (String) note.get("pitch");
                        String noteAccidetal = (String) note.get("accidental");
                        String noteOctave = (String) note.get("octave");
                        String noteLength = (String) note.get("length");
                    }
                }

                songs.add(new Song(id, title, artist, genre, duration, tempo, defTimeSigNum, defTimeSigDen, defKey, measures));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    private void buildNote(String pitch, String accidental, String octave, String length) {
        String newNote = pitch + accidental + octave + length;
    }
}

