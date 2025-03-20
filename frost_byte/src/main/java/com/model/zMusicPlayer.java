package com.model;

import java.lang.Thread;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import java.io.File;
import java.io.IOException;
import org.jfugue.midi.MidiFileManager;
import javax.sound.midi.InvalidMidiDataException;

public class zMusicPlayer {
    
    Pattern song = new Pattern();

    
    // Doesn't work the tempo is extremely slow and I can't figure out why or how to fix it -Ryan
    public static void Midi() {
        Pattern cruel = new Pattern();
        try{
            File midiFile = new File("frost_byte/src/main/java/com/model/MusicPlayerTesting/Neon_Genesis_Evangelion_A_Cruel_Angels_Thesis_-_Trombone_Solo.mid");
            cruel = MidiFileManager.loadPatternFromMidi(midiFile);
            
        } catch (IOException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
        cruel.setTempo(80000);
        Player player = new Player();
        player.play(cruel);
        }
    
        public void playCruelAngel() {
            try {
                Player player = new Player();
                
                Pattern Beginning = new Pattern();
                Beginning.setInstrument("Tuba");
                Beginning.setTempo(80);
                Beginning.add("C3q E3bq F3is E3bis F3i");
                Beginning.add("F3q Bb3i Ab3i G3s F3i G3is Ri");
                Beginning.add("G3q Bb3q C4is F3is Eb3i");
                Beginning.add("Bb3q G3i Bb3i Bb3is C4w");
               
                Pattern mainPart = new Pattern("T129");
                mainPart.setInstrument("Tuba");
                mainPart.add("C3q Eb3q F3is Eb3is F3i");
                mainPart.add("F3i F3i Bb3i Ab3i G3s F3i G3is Ri");
                mainPart.add("G3q Bb3q C4is F3is Eb3i");
              
                Pattern bar9_14 = new Pattern("T129");
                bar9_14.setInstrument("Tuba");
                bar9_14.add("Rq Eb3i Bb2i Bb2qi Eb3i");
                bar9_14.add("Eb3is F3is Bb2i Bb2qi Bb2i");
                bar9_14.add("G3is Ab3is G3i F3is Eb3is F3i");
                bar9_14.add("G3is Ab3is G3i C3qi C3s D3s");
                bar9_14.add("Eb3is Eb3is D3i D3qi D3s F3s");
                bar9_14.add("Ab3is G3is F3i Eb3qi G3i");
            
                Pattern bar19_22 = new Pattern("T129");
                bar19_22.setInstrument("Tuba");
                bar19_22.add("Eb3is Eb3is D3i Eb3is Eb3is D3i");
                bar19_22.add("F3is F3is Eb3i D3is C3is D3i");
                bar19_22.add("Eb3is Eb3is D3i F3is D3is C3i");

                Pattern bar23_26 = new Pattern("T129");
                bar23_26.setInstrument("Tuba");
                bar23_26.add("Eb3is+C4is Eb3is+C4is D3i Eb3is Eb3is D3i");
                bar23_26.add("F3is F3is Eb3i D3is Eb3is F3i");
                bar23_26.add("G3is Ab3is G3i F3is Eb3is F3i");
                bar23_26.add("G3h G3is A3is B3i");

                Pattern mainPart2 = new Pattern("T129");
                mainPart2.setInstrument("Tuba");
                mainPart2.add("C3q C4q+Eb3q F3is Eb3is F3i");
                mainPart2.add("F3i F3i Bb3i Ab3i G3s F3i G3is Ri");
                mainPart2.add("G3q Bb3q C4is F3is Eb3i");

                Pattern mainPart3 = new Pattern("T129");
                mainPart3.setInstrument("Tuba");
                mainPart3.add("C4q+C3q Eb3q F3is Eb3is F3i");
                mainPart3.add("F3i F3i Bb3i Ab3i G3s F3i G3is Ri");
                mainPart3.add("G3q Bb3q C4is F3is Eb3i");
            
                Pattern CruelAngelsThesis = new Pattern();
                CruelAngelsThesis.setInstrument("Tuba");
                CruelAngelsThesis.add(Beginning);
                CruelAngelsThesis.add(mainPart);
                CruelAngelsThesis.add("Bb3i Bb3i G3i Bb3i Bb3is C4is Ri");
                CruelAngelsThesis.add(bar9_14);
                CruelAngelsThesis.add("G3is F3is E3i F3q C3q | C3qi D3i D3h");
                CruelAngelsThesis.add(bar9_14);
                CruelAngelsThesis.add("I[Tuba] G3is F3is E3i F3is G3is Ab3i | G3w");
                CruelAngelsThesis.add(bar19_22);
                CruelAngelsThesis.add("F3q+Bb2q G3q+Bb2q | Ab3q Bb3q");
                CruelAngelsThesis.add(bar23_26);
                CruelAngelsThesis.add(mainPart3);
                CruelAngelsThesis.add("D3i D3i C3i D3i D3s D3i Eb3is Ri");
                CruelAngelsThesis.add(mainPart2);
                CruelAngelsThesis.add("Bb3i Bb3i G3i Bb3i Bb3is C3is Ri");
                CruelAngelsThesis.add(mainPart3);
                CruelAngelsThesis.add("Bb3st Rt Bb3st Rt G3st Rt Bb3st Rt Bb3i Rs C4q");
                player.play(CruelAngelsThesis);

            }
            catch(Exception e) {
                System.out.println("Error: " + e);
            }
        }
    
        public static void main(String[] args) {
            zMusicPlayer player = new zMusicPlayer();
            player.playCruelAngel();
            //Midi();
    }
}
