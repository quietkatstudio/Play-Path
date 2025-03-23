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
            ArrayList<Song> songs = getSongs();
            for (Song song : songs) {
                if (song.getTitle().equals("Hot Cross Buns")) {
                    //playSong(song);
                    //playMeasure(song, 2);
                    editMeasure(song, 1, 1, "C", "n", "4", "q");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            FileReader reader = new FileReader("C:\\Users\\Ryan\\Documents\\frost_byte\\frost_byte\\src\\main\\java\\com\\model\\ztestSongs.json");
            JSONParser parser = new JSONParser();
            JSONArray songJson = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < songJson.size(); i++) {
                JSONObject songJSON = (JSONObject) songJson.get(i);
                UUID id = UUID.fromString((String) songJSON.get("id"));
                String title = (String) songJSON.get("title");
                String artist = (String) songJSON.get("artist");
                String genre = (String) songJSON.get("genre");
                String duration = (String) songJSON.get("duration");
                String tempo = (String) songJSON.get("tempo");
                int defTimeSigNum = Integer.parseInt((String) songJSON.get("defTimeSigNumer"));
                int defTimeSigDen = Integer.parseInt((String) songJSON.get("defTimeSigDenom"));
                String defKeyString = (String) songJSON.get("defKeySig");
                JSONArray measuresJSON = (JSONArray) songJSON.get("measureList");
                /*System.out.println(title);
                System.out.println(artist);
                System.out.println(genre);
                System.out.println(duration);
                System.out.println(tempo);
                System.out.println(defTimeSigNum);
                System.out.println(defTimeSigDen);
                System.out.println(defKeyString);
                System.out.println();*/
                ArrayList<Measure> measures = new ArrayList<Measure>();
                for (int j = 0; j < measuresJSON.size(); j++) {
                    JSONObject measureJSON = (JSONObject) measuresJSON.get(j);
                    String beatAmount = (String) measureJSON.get("beatAmount");
                    String clef = (String) measureJSON.get("clef");
                    /*System.out.println(beatAmount);
                    System.out.println(clef);
                    System.out.println();*/
                    JSONArray notes = (JSONArray) measureJSON.get("notes");

                    ArrayList<Note> noteList = new ArrayList<Note>();
                    for (int r = 0; r < notes.size(); r++) {
                        JSONObject note = (JSONObject) notes.get(r);
                        String notePitch = (String) note.get("pitch");
                        String noteAccidetal = (String) note.get("accidental");
                        String noteOctave = (String) note.get("octave");
                        String noteLength = (String) note.get("length");
                        Note newNote = new Note(notePitch, noteAccidetal, noteOctave, noteLength);
                        noteList.add(newNote);
                        /*System.out.print(notePitch);
                        System.out.print(noteAccidetal);
                        System.out.print(noteOctave);
                        System.out.println(noteLength);
                        System.out.println();*/
                    }
                    Measure measure = new Measure(beatAmount, clef, noteList);
                    measures.add(measure);
                }

                songs.add(new Song(id, title, artist, genre, duration, tempo, defTimeSigNum, defTimeSigDen, defKeyString, measures));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }

    public static void playSong(Song song) {
        Player player = new Player();
        Pattern songPattern = new Pattern();
        songPattern.setInstrument("Tuba");
        for (Measure measures : song.getMeasureList()) {
            for (Note note : measures.getNoteList()) {
                songPattern.add(note.getPitch().toString() + note.getAccidental() + note.getOctave() + note.getLength() + " ");
            }
        }
        player.play(songPattern);
    }

    public static void playMeasure(Song song, int meaNum) {
        int numMeasures = 0;
        int measureNum = meaNum--;
        for (Measure measures : song.getMeasureList()) {
            numMeasures++;
        }
        if (measureNum >= numMeasures || measureNum < 0) {
            System.out.println("Measure number out of bounds");
            return;
        }
        Player player = new Player();
        Pattern measurePattern = new Pattern();
        measurePattern.setInstrument("Tuba");
        ArrayList<Measure> Measures = song.getMeasureList();
        Measure measure = Measures.get(measureNum);
        for (Note note : measure.getNoteList()) {
            measurePattern.add(note.getPitch().toString() + note.getAccidental() + note.getOctave() + note.getLength() + " ");
        }
        player.play(measurePattern);
    }

    public static void editMeasure(Song song, int meaNum, int noNum, String notePitch, String noteAccidental, String noteOctave, String noteLength) {
        int numMeasures = 0;
        int measureNum = meaNum - 1;
        int numNotes = 0;
        int noteNum = noNum - 1;
        for (Measure measures : song.getMeasureList()) {
            numMeasures++;
        }
        if (measureNum >= numMeasures || measureNum < 0) {
            System.out.println("Measure number out of bounds");
            return;
        } else {
                for (Measure measures : song.getMeasureList()) {
                    for (Note note : measures.getNoteList()) {
                    numNotes++;
                }
                if (noteNum >= numNotes || noteNum < 0) {
                    System.out.println("Note number out of bounds");
                    return;
                }
                }
                
            }
        
        Player player = new Player();
        Pattern measurePattern = new Pattern();
        measurePattern.setInstrument("Tuba");
        ArrayList<Measure> Measures = song.getMeasureList();
        Measure measure = Measures.get(measureNum);
        ArrayList<Note> notes = measure.getNoteList();
        Note note = notes.get(noteNum);
        note.setPitch(notePitch);
        note.setAccidental(noteAccidental);
        note.setOctave(noteOctave);
        note.setLength(noteLength);
        notes.set(noteNum, note);
        for (Note Note : measure.getNoteList()) {
            measurePattern.add(Note.getPitch().toString() + Note.getAccidental() + Note.getOctave() + Note.getLength() + " ");
        }
        player.play(measurePattern);
        System.out.println(measurePattern);
        
    }
}

