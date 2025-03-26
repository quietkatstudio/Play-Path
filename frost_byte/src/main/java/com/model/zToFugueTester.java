package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
        public static void main(String[] args) {
            try {
                Player player = new Player();
                ArrayList<Song> songs = getSongs();
                for (Song song : songs) {
                    if (song.getTitle().contains("Cruel")) {
                        playSong(song);
                        //playMeasure(song, 2);
                        //editMeasure(song, 1, 1, "C", "n", "4", "q");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    
        public static ArrayList<Song> getSongs() {
            ArrayList<Song> songs = new ArrayList<Song>();
    
            try {
                FileReader reader = new FileReader("frost_byte\\src\\main\\java\\com\\model\\ztestSongs.json");
                JSONParser parser = new JSONParser();
                JSONArray songJson = (JSONArray) new JSONParser().parse(reader);
    
                for (int i = 0; i < songJson.size(); i++) {
                    JSONObject songJSON = (JSONObject) songJson.get(i);
                    UUID id = UUID.fromString((String) songJSON.get("id"));
                    String title = (String) songJSON.get("title");
                    UUID author = UUID.fromString((String) songJSON.get("author"));
                    String artist = (String) songJSON.get("artist");
                    String genre = (String) songJSON.get("genre");
                    String duration = (String) songJSON.get("duration");
                    String tempo = (String) songJSON.get("tempo");
                    int defTimeSigNum = Integer.parseInt((String) songJSON.get("defTimeSigNumer"));
                    int defTimeSigDen = Integer.parseInt((String) songJSON.get("defTimeSigDenom"));
                     // Parse key signature, accepting JSONObject
                    String defKeySigStr = (String) songJSON.get("defKeySig");
                    KeySig defKeySig = new KeySig(Keys.valueOf(defKeySigStr), "A", "B", "C", "D", "E", "F", "G");
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
                        int beatAmount = Integer.parseInt((String)measureJSON.get("beatAmount"));
                        String clef = (String) measureJSON.get("clef");
                        /*System.out.println(beatAmount);
                        System.out.println(clef);
                        System.out.println();*/
                        JSONArray notes = (JSONArray) measureJSON.get("notes");
    
                        ArrayList<Note> noteList = new ArrayList<Note>();
                        for (int r = 0; r < notes.size(); r++) {
                            JSONObject noteJSON = (JSONObject) notes.get(r);
                            Note note = new Note();
                            String tempPitch = (String) noteJSON.get("pitch");
                            Pitches notePitch = Pitches.valueOf(tempPitch);
                            note.setPitch(notePitch);
                            String tempAccidental = (String) noteJSON.get("accidental");
                            tempAccidental = tempAccidental.toUpperCase();
                            Accidentals noteAccidetal = Accidentals.valueOf(tempAccidental);
                            note.setAccidental(noteAccidetal);
                            note.setOctave(Integer.parseInt((String) noteJSON.get("octave")));
                            note.setLength((String) noteJSON.get("length"));
                            noteList.add(note);
                            /*System.out.print(notePitch);
                            System.out.print(noteAccidetal);
                            System.out.print(noteOctave);
                            System.out.println(noteLength);
                            System.out.println();*/
                        }
                        Measure measure = new Measure(beatAmount, clef, noteList);
                        measures.add(measure);
                    }
    
                    songs.add(new Song(id, title, artist, author, genre, duration, tempo, defTimeSigNum, defTimeSigDen, defKeySig, measures));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return songs;
        }
    
        public static void playSong(Song song) {
            Player player = new Player();
            Pattern songPattern = new Pattern();
            songPattern.setTempo(Integer.parseInt(song.getTempo()));
            songPattern.setInstrument("Tuba");
            for (Measure measures : song.getMeasureList()) {
                f4 = "";
                e4 = "";
                d4 = "";
                c4 = "";
                b4 = "";
                a4 = "";
                g3 = "";
                f3 = "";
                e3 = "";
                d3 = "";
                c3 = "";
                b3 = "";
                a3 = "";
                g2 = "";
                for (Note note : measures.getNoteList()) {
                    songPattern.add(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave() + note.getLength());
                    //System.out.print(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave() + note.getLength() + " ");
                }
                getNotePlacement(measures);
                System.out.println();
                System.out.println(c4);
                System.out.println(b4);
                System.out.println(a4 + "|");
                System.out.println(g3 + "|");
                System.out.println(f3 + "|");
                System.out.println(e3 + "|");
                System.out.println(d3 + "|");
                System.out.println(c3 + "|");
                System.out.println(b3 + "|");
                System.out.println(a3 + "|");
                System.out.println(g2 + "|");
                System.out.println();
                //System.out.println("|\n");
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
                measurePattern.add(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave() + note.getLength() + " ");
            }
            player.play(measurePattern);
        }
    
        public static void editMeasure(Song song, int meaNum, int noNum, Pitches notePitch, Accidentals noteAccidental, int noteOctave, String noteLength) {
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
    
        /*public static void getNotePlacementMap(Measure measure) {
            String a1 = "";
            String g1 = "";
            String f = "";
            String e = "";
            String d = "";
            String c = "";
            String b = "";
            String a2 = "";
            String g2 = "";
            Map<Pitches, StringBuilder> pitchMap = new HashMap<>() {{
                put(Pitches.A, new StringBuilder()); put(Pitches.G, new StringBuilder()); put(Pitches.F, new StringBuilder());
                put(Pitches.E, new StringBuilder()); put(Pitches.D, new StringBuilder()); put(Pitches.C, new StringBuilder());
                put(Pitches.B, new StringBuilder());
            }};
            
            Map<String, String> lengthMap = Map.of(
                "w", "W", "h", "H", "q", "Q",
                "i", "I", "s", "S", "t", "T", "x", "X"
            );
            
            for (Note note : measure.getNoteList()) {
                if (!pitchMap.containsKey(note.getPitch())) continue;
            
                StringBuilder pitchLine = pitchMap.get(note.getPitch());
                String lengthSymbol = lengthMap.getOrDefault(note.getLength(), "");
            
                if (lengthSymbol.isEmpty()) continue;
            
                String accidentalSymbol = switch (note.getAccidental()) {
                    case NATURAL, N -> "n";
                    case SHARP, S -> "#";
                    case FLAT, B -> "b";
                    default -> "";
                };
            
                pitchLine.append(lengthSymbol).append(accidentalSymbol).append(" ");
            }
            
            //System.out.println("a2: " + pitchMap.get(Pitches.A));
            System.out.println("b : " + pitchMap.get(Pitches.B));
            System.out.println("c : " + pitchMap.get(Pitches.C));
            System.out.println("d : " + pitchMap.get(Pitches.D));
            System.out.println("e : " + pitchMap.get(Pitches.E));
            System.out.println("f : " + pitchMap.get(Pitches.F));
            System.out.println("g1: " + pitchMap.get(Pitches.G));
            System.out.println("a1: " + pitchMap.get(Pitches.A));
            //System.out.println("g2: " + pitchMap.get(Pitches.G));
        }
    }*/
    
        public static void getNotePlacement(Measure measure) {
            //Checks for A notes
            for (Note Anote : measure.getNoteList()) {
                if(Anote.getPitch() == Pitches.A) {
                    if(Anote.getOctave() == 3) {
                        a3 = a3 + " " + Anote.getLength().toUpperCase() + Anote.getAccidental().toString().toLowerCase() + " ";
                    }
                    if(Anote.getOctave() == 4) {
                        a4 = a4 + "-"+ Anote.getLength().toUpperCase() + Anote.getAccidental().toString().toLowerCase() + "-";
                    }
                } else {
                    a3 += "    ";
                    a4 += "----";
                }
            }     
            // Checks for B notes
            for (Note Bnote : measure.getNoteList()) {
                if (Bnote.getPitch() == Pitches.B) {
                    if(Bnote.getOctave() == 3) {
                        b3 = b3 + "-" + Bnote.getLength().toUpperCase() + Bnote.getAccidental().toString().toLowerCase() + "-";
                }
                if(Bnote.getOctave() == 4) {
                    b4 = b4 + " "+ Bnote.getLength().toUpperCase() + Bnote.getAccidental().toString().toLowerCase() + " ";
                }
            } else {
                b3 += "----";
                b4 += "    ";
            }
        }
        // Checks for C notes
for (Note Cnote : measure.getNoteList()) {
    if (Cnote.getPitch() == Pitches.C) {
        if(Cnote.getOctave() == 3) {
            c3 = c3 + " " + Cnote.getLength().toUpperCase() + Cnote.getAccidental().toString().toLowerCase() + " ";
        }
        if(Cnote.getOctave() == 4) {
            c4 = c4 + "-"+ Cnote.getLength().toUpperCase() + Cnote.getAccidental().toString().toLowerCase() + "-";
        }
    } else {
            c3 += "    ";
            c4 += "    ";
    }
}

// Checks for D notes
for (Note Dnote : measure.getNoteList()) {
    if (Dnote.getPitch() == Pitches.D) {
        if(Dnote.getOctave() == 3) {
            d3 = d3 + " " + Dnote.getLength().toUpperCase() + Dnote.getAccidental().toString().toLowerCase() + " ";
        }
        if(Dnote.getOctave() == 4) {
            d4 = d4 + "-"+ Dnote.getLength().toUpperCase() + Dnote.getAccidental().toString().toLowerCase() + "-";
        }
    } else {
            d3 += "----";
        }
}
// Checks for E notes
for (Note Enote : measure.getNoteList()) {
    if (Enote.getPitch() == Pitches.E) {
        if(Enote.getOctave() == 3) {
            e3 = e3 + " " + Enote.getLength().toUpperCase() + Enote.getAccidental().toString().toLowerCase() + " ";
        }
        if(Enote.getOctave() == 4) {
            e4 = e4 + "-"+ Enote.getLength().toUpperCase() + Enote.getAccidental().toString().toLowerCase() + "-";
        }
    } else {
            e3 += "    ";
    }
}

// Checks for F notes
for (Note Fnote : measure.getNoteList()) {
    if (Fnote.getPitch() == Pitches.F) {
        if(Fnote.getOctave() == 3) {
            f3 = f3 + "-" + Fnote.getLength().toUpperCase() + Fnote.getAccidental().toString().toLowerCase() + "-";
        }
        if(Fnote.getOctave() == 4) {
            f4 = f4 + "-"+ Fnote.getLength().toUpperCase() + Fnote.getAccidental().toString().toLowerCase() + "-";
        }
    } else {
            f3 += "----";
    }
}

// Checks for G notes
for (Note Gnote : measure.getNoteList()) {
    if (Gnote.getPitch() == Pitches.G) {
        if(Gnote.getOctave() == 3) {
            g2 = g2 + "-" + Gnote.getLength().toUpperCase() + Gnote.getAccidental().toString().toLowerCase() + "-";
        }
        if(Gnote.getOctave() == 4) {
            g3 = g3 + "-"+ Gnote.getLength().toUpperCase() + Gnote.getAccidental().toString().toLowerCase() + "-";
        }
    } else {
            g2 += "----";
            g3 += "    ";
    }
    
}
    }

}
