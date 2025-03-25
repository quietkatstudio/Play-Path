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

                songs.add(new Song(id, title, artist, genre, duration, tempo, defTimeSigNum, defTimeSigDen, defKeySig, measures));
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
            for (Note note : measures.getNoteList()) {
                songPattern.add(note.getPitch().toString() + note.getAccidental().toString() + note.getOctave() + note.getLength() + " ");
                getNotePlacement(measures);
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
        String f4 = "";
        String e4 = "";
        String d4 = "";
        String c4 = "";
        String b4 = "";
        String a4 = "";
        String g3 = "";
        String f3 = "";
        String e3 = "";
        String d3 = "";
        String c3 = "";
        String b3 = "";
        String a3 = "";
        String g2 = "";
        //Checks for A notes
        for (Note Anote : measure.getNoteList()) {
            if(Anote.getPitch() == Pitches.C) {
                if(Anote.getAccidental() == Accidentals.NATURAL || Anote.getAccidental() == Accidentals.N) {
                    if(Anote.getLength().equals("w")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Wn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Wn-";
                        }
                    } else if(Anote.getLength().equals("h")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Hn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Hn-";
                        }
                    } else if(Anote.getLength().equals("q")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Qn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Qn-";
                        }
                    } else if(Anote.getLength().equals("i")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-In-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-In-";
                        }
                    } else if(Anote.getLength().equals("s")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Sn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Sn-";
                        }
                    } else if(Anote.getLength().equals("t")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Tn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Tn-";
                        }
                    } else if(Anote.getLength().equals("x")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Xn-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Xn-";
                        }
                    }
                } else if(Anote.getAccidental() == Accidentals.SHARP || Anote.getAccidental() == Accidentals.S) {
                    if(Anote.getLength().equals("w")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-W#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-W#-";
                        }
                    } else if(Anote.getLength().equals("h")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-H#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-H#-";
                        }
                    } else if(Anote.getLength().equals("q")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Q#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Q#-";
                        }
                    } else if(Anote.getLength().equals("i")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-I#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-I#-";
                        }
                    } else if(Anote.getLength().equals("s")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-S#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-S#-";
                        }
                    } else if(Anote.getLength().equals("t")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-T#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-T#-";
                        }
                    } else if(Anote.getLength().equals("x")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-X#-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-X#-";
                        }
                    }
                } else if(Anote.getAccidental() == Accidentals.FLAT || Anote.getAccidental() == Accidentals.B) {
                    if(Anote.getLength().equals("w")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Wb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Wb-";
                        }
                    } else if(Anote.getLength().equals("h")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Hb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Hb-";
                        }
                    } else if(Anote.getLength().equals("q")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Qb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Qb-";
                        }
                    } else if(Anote.getLength().equals("i")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Ib-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Ib-";
                        }
                    } else if(Anote.getLength().equals("s")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Sb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Sb-";
                        }
                    } else if(Anote.getLength().equals("t")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Tb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Tb-";
                        }
                    } else if(Anote.getLength().equals("x")) {
                        if(Anote.getOctave() == 3) {
                            a3 = a3 + "-Xb-";
                        }
                        if(Anote.getOctave() == 4) {
                            a4 = a4 + "-Xb-";
                        }
                    }
                } else {
                    a3 = a3 + "----";
                }
        }
        // Checks for B notes
        for (Note Bnote : measure.getNoteList()) {
            if (Bnote.getPitch() == Pitches.B) {
                if (Bnote.getAccidental() == Accidentals.NATURAL || Bnote.getAccidental() == Accidentals.N) {
                    if (Bnote.getLength().equals("w")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Wn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Wn-";
                        }
                    } else if (Bnote.getLength().equals("h")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Hn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Hn-";
                        }
                    } else if (Bnote.getLength().equals("q")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Qn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Qn-";
                        }
                    } else if (Bnote.getLength().equals("i")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-In-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-In-";
                        }
                    } else if (Bnote.getLength().equals("s")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Sn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Sn-";
                        }
                    } else if (Bnote.getLength().equals("t")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Tn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Tn-";
                        }
                    } else if (Bnote.getLength().equals("x")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Xn-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Xn-";
                        }
                    }
                } else if (Bnote.getAccidental() == Accidentals.SHARP || Bnote.getAccidental() == Accidentals.S) {
                    if (Bnote.getLength().equals("w")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-W#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-W#-";
                        }
                    } else if (Bnote.getLength().equals("h")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-H#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-H#-";
                        }
                    } else if (Bnote.getLength().equals("q")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Q#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Q#-";
                        }
                    } else if (Bnote.getLength().equals("i")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-I#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-I#-";
                        }
                    } else if (Bnote.getLength().equals("s")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-S#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-S#-";
                        }
                    } else if (Bnote.getLength().equals("t")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-T#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-T#-";
                        }
                    } else if (Bnote.getLength().equals("x")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-X#-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-X#-";
                        }
                    }
                } else if (Bnote.getAccidental() == Accidentals.FLAT || Bnote.getAccidental() == Accidentals.B) {
                    if (Bnote.getLength().equals("w")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Wb-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Wb-";
                        }
                    } else if (Bnote.getLength().equals("h")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Hb-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Hb-";
                        }
                    } else if (Bnote.getLength().equals("q")) {
                        if (Bnote.getOctave() == 3) {
                            b3 += "-Qb-";
                        }
                        if (Bnote.getOctave() == 4) {
                            b4 += "-Qb-";
                        }
                    }
                } else {
                    b3 += "----";
                }
            }
        }
        // Checks for C notes
for (Note Cnote : measure.getNoteList()) {
    if (Cnote.getPitch() == Pitches.C) {
        if (Cnote.getAccidental() == Accidentals.NATURAL || Cnote.getAccidental() == Accidentals.N) {
            if (Cnote.getLength().equals("w")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Wn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Wn-";
                }
            } else if (Cnote.getLength().equals("h")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Hn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Hn-";
                }
            } else if (Cnote.getLength().equals("q")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Qn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Qn-";
                }
            } else if (Cnote.getLength().equals("i")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-In-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-In-";
                }
            } else if (Cnote.getLength().equals("s")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Sn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Sn-";
                }
            } else if (Cnote.getLength().equals("t")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Tn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Tn-";
                }
            } else if (Cnote.getLength().equals("x")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Xn-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Xn-";
                }
            }
        } else if (Cnote.getAccidental() == Accidentals.SHARP || Cnote.getAccidental() == Accidentals.S) {
            if (Cnote.getLength().equals("w")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-W#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-W#-";
                }
            } else if (Cnote.getLength().equals("h")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-H#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-H#-";
                }
            } else if (Cnote.getLength().equals("q")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Q#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Q#-";
                }
            } else if (Cnote.getLength().equals("i")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-I#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-I#-";
                }
            } else if (Cnote.getLength().equals("s")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-S#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-S#-";
                }
            } else if (Cnote.getLength().equals("t")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-T#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-T#-";
                }
            } else if (Cnote.getLength().equals("x")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-X#-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-X#-";
                }
            }
        } else if (Cnote.getAccidental() == Accidentals.FLAT || Cnote.getAccidental() == Accidentals.B) {
            if (Cnote.getLength().equals("w")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Wb-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Wb-";
                }
            } else if (Cnote.getLength().equals("h")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Hb-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Hb-";
                }
            } else if (Cnote.getLength().equals("q")) {
                if (Cnote.getOctave() == 3) {
                    c3 += "-Qb-";
                }
                if (Cnote.getOctave() == 4) {
                    c4 += "-Qb-";
                }
            }
        } else {
            c3 += "----";
        }
    }
}

// Checks for D notes
for (Note Dnote : measure.getNoteList()) {
    if (Dnote.getPitch() == Pitches.D) {
        if (Dnote.getAccidental() == Accidentals.NATURAL || Dnote.getAccidental() == Accidentals.N) {
            if (Dnote.getLength().equals("w")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Wn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Wn-";
                }
            } else if (Dnote.getLength().equals("h")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Hn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Hn-";
                }
            } else if (Dnote.getLength().equals("q")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Qn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Qn-";
                }
            } else if (Dnote.getLength().equals("i")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-In-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-In-";
                }
            } else if (Dnote.getLength().equals("s")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Sn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Sn-";
                }
            } else if (Dnote.getLength().equals("t")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Tn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Tn-";
                }
            } else if (Dnote.getLength().equals("x")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Xn-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Xn-";
                }
            }
        } else if (Dnote.getAccidental() == Accidentals.SHARP || Dnote.getAccidental() == Accidentals.S) {
            if (Dnote.getLength().equals("w")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-W#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-W#-";
                }
            } else if (Dnote.getLength().equals("h")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-H#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-H#-";
                }
            } else if (Dnote.getLength().equals("q")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Q#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Q#-";
                }
            } else if (Dnote.getLength().equals("i")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-I#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-I#-";
                }
            } else if (Dnote.getLength().equals("s")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-S#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-S#-";
                }
            } else if (Dnote.getLength().equals("t")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-T#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-T#-";
                }
            } else if (Dnote.getLength().equals("x")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-X#-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-X#-";
                }
            }
        } else if (Dnote.getAccidental() == Accidentals.FLAT || Dnote.getAccidental() == Accidentals.B) {
            if (Dnote.getLength().equals("w")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Wb-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Wb-";
                }
            } else if (Dnote.getLength().equals("h")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Hb-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Hb-";
                }
            } else if (Dnote.getLength().equals("q")) {
                if (Dnote.getOctave() == 3) {
                    d3 += "-Qb-";
                }
                if (Dnote.getOctave() == 4) {
                    d4 += "-Qb-";
                }
            }
        } else {
            d3 += "----";
        }
    }
}
// Checks for E notes
for (Note Enote : measure.getNoteList()) {
    if (Enote.getPitch() == Pitches.E) {
        if (Enote.getAccidental() == Accidentals.NATURAL || Enote.getAccidental() == Accidentals.N) {
            if (Enote.getLength().equals("w")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Wn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Wn-";
                }
            } else if (Enote.getLength().equals("h")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Hn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Hn-";
                }
            } else if (Enote.getLength().equals("q")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Qn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Qn-";
                }
            } else if (Enote.getLength().equals("i")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-In-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-In-";
                }
            } else if (Enote.getLength().equals("s")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Sn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Sn-";
                }
            } else if (Enote.getLength().equals("t")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Tn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Tn-";
                }
            } else if (Enote.getLength().equals("x")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Xn-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Xn-";
                }
            }
        } else if (Enote.getAccidental() == Accidentals.SHARP || Enote.getAccidental() == Accidentals.S) {
            if (Enote.getLength().equals("w")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-W#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-W#-";
                }
            } else if (Enote.getLength().equals("h")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-H#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-H#-";
                }
            } else if (Enote.getLength().equals("q")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Q#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Q#-";
                }
            } else if (Enote.getLength().equals("i")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-I#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-I#-";
                }
            } else if (Enote.getLength().equals("s")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-S#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-S#-";
                }
            } else if (Enote.getLength().equals("t")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-T#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-T#-";
                }
            } else if (Enote.getLength().equals("x")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-X#-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-X#-";
                }
            }
        } else if (Enote.getAccidental() == Accidentals.FLAT || Enote.getAccidental() == Accidentals.B) {
            if (Enote.getLength().equals("w")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Wb-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Wb-";
                }
            } else if (Enote.getLength().equals("h")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Hb-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Hb-";
                }
            } else if (Enote.getLength().equals("q")) {
                if (Enote.getOctave() == 3) {
                    e3 += "-Qb-";
                }
                if (Enote.getOctave() == 4) {
                    e4 += "-Qb-";
                }
            }
        } else {
            e3 += "----";
        }
    }
}

// Checks for F notes
for (Note Fnote : measure.getNoteList()) {
    if (Fnote.getPitch() == Pitches.F) {
        if (Fnote.getAccidental() == Accidentals.NATURAL || Fnote.getAccidental() == Accidentals.N) {
            if (Fnote.getLength().equals("w")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Wn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Wn-";
                }
            } else if (Fnote.getLength().equals("h")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Hn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Hn-";
                }
            } else if (Fnote.getLength().equals("q")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Qn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Qn-";
                }
            } else if (Fnote.getLength().equals("i")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-In-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-In-";
                }
            } else if (Fnote.getLength().equals("s")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Sn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Sn-";
                }
            } else if (Fnote.getLength().equals("t")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Tn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Tn-";
                }
            } else if (Fnote.getLength().equals("x")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Xn-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Xn-";
                }
            }
        } else if (Fnote.getAccidental() == Accidentals.SHARP || Fnote.getAccidental() == Accidentals.S) {
            if (Fnote.getLength().equals("w")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-W#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-W#-";
                }
            } else if (Fnote.getLength().equals("h")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-H#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-H#-";
                }
            } else if (Fnote.getLength().equals("q")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Q#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Q#-";
                }
            } else if (Fnote.getLength().equals("i")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-I#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-I#-";
                }
            } else if (Fnote.getLength().equals("s")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-S#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-S#-";
                }
            } else if (Fnote.getLength().equals("t")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-T#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-T#-";
                }
            } else if (Fnote.getLength().equals("x")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-X#-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-X#-";
                }
            }
        } else if (Fnote.getAccidental() == Accidentals.FLAT || Fnote.getAccidental() == Accidentals.B) {
            if (Fnote.getLength().equals("w")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Wb-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Wb-";
                }
            } else if (Fnote.getLength().equals("h")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Hb-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Hb-";
                }
            } else if (Fnote.getLength().equals("q")) {
                if (Fnote.getOctave() == 3) {
                    f3 += "-Qb-";
                }
                if (Fnote.getOctave() == 4) {
                    f4 += "-Qb-";
                }
            }
        } else {
            f3 += "----";
        }
    }
}

// Checks for G notes
for (Note Gnote : measure.getNoteList()) {
    if (Gnote.getPitch() == Pitches.G) {
        if (Gnote.getAccidental() == Accidentals.NATURAL || Gnote.getAccidental() == Accidentals.N) {
            if (Gnote.getLength().equals("w")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Wn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Wn-";
                }
            } else if (Gnote.getLength().equals("h")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Hn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Hn-";
                }
            } else if (Gnote.getLength().equals("q")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Qn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Qn-";
                }
            } else if (Gnote.getLength().equals("i")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-In-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-In-";
                }
            } else if (Gnote.getLength().equals("s")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Sn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Sn-";
                }
            } else if (Gnote.getLength().equals("t")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Tn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Tn-";
                }
            } else if (Gnote.getLength().equals("x")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Xn-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Xn-";
                }
            }
        } else if (Gnote.getAccidental() == Accidentals.SHARP || Gnote.getAccidental() == Accidentals.S) {
            if (Gnote.getLength().equals("w")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-W#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-W#-";
                }
            } else if (Gnote.getLength().equals("h")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-H#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-H#-";
                }
            } else if (Gnote.getLength().equals("q")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Q#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Q#-";
                }
            } else if (Gnote.getLength().equals("i")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-I#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-I#-";
                }
            } else if (Gnote.getLength().equals("s")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-S#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-S#-";
                }
            } else if (Gnote.getLength().equals("t")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-T#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-T#-";
                }
            } else if (Gnote.getLength().equals("x")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-X#-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-X#-";
                }
            }
        } else if (Gnote.getAccidental() == Accidentals.FLAT || Gnote.getAccidental() == Accidentals.B) {
            if (Gnote.getLength().equals("w")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Wb-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Wb-";
                }
            } else if (Gnote.getLength().equals("h")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Hb-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Hb-";
                }
            } else if (Gnote.getLength().equals("q")) {
                if (Gnote.getOctave() == 3) {
                    g2 += "-Qb-";
                }
                if (Gnote.getOctave() == 4) {
                    g3 += "-Qb-";
                }
            }
        } else {
            g2 += "----";
        }
    }
}




        
    }
}
}


