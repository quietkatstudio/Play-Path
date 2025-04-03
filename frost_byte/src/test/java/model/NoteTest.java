package model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import com.model.Accidentals;
import com.model.Note;
import com.model.Pitches;

public class NoteTest {
    private Note note;
    private Pitches pitch;
    private String length;
    private Accidentals accidental;
    private int octave;
    private String noteSymbol;

    @Before
    public void setUp() {
        pitch = Pitches.C;
        length = "quarter";
        accidental = Accidentals.FLAT;
        octave = 4;
        note = new Note(pitch, length, accidental, 0, octave);
    }

    @After
    public void tearDown() {
        note = null;
        pitch = null;
        length = null;
        accidental = null;
        octave = 0;
        noteSymbol = null;
    }
    
    @Test
    public void testNoteCreation() {
        assertEquals(Pitches.C, note.getPitch());
        assertEquals("quarter", note.getLength());
        assertEquals(Accidentals.FLAT, note.getAccidental());
        assertEquals(0, note.getDot());
        assertEquals(4, note.getOctave());
    }
    @Test
    public void testGetSymbol() {
        Note note = new Note(Pitches.C, "quarter", Accidentals.FLAT, 0, 4);
        String expectedSymbol = "𝅘𝅥♭";
        String actualSymbol = note.getSymbol();
        assertEquals(expectedSymbol, actualSymbol);
    }
    
}
