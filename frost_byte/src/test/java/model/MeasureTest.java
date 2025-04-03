/**
 * @author Ryan Evans
 */

package model;

import java.util.ArrayList;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.model.Accidentals;
import com.model.Measure;
import com.model.Note;
import com.model.Pitches;

public class MeasureTest {
    private Measure measure;
    private int beatAmount;
    private String clef;
    private Note note1;
    private Note note2;
    private Note note3;
    private Note note4;
    private boolean isRepeat;
    private ArrayList<Note> notes;

    @Before
    public void setUp() {
        beatAmount = 4;
        clef = "treble";
        note1 = new Note(Pitches.C, "quarter", Accidentals.FLAT, 0, 3);
        note2 = new Note(Pitches.D, "quarter", Accidentals.SHARP, 0, 3);
        note3 = new Note(Pitches.E, "quarter", Accidentals.NATURAL, 0, 3);
        note4 = new Note(Pitches.F, "quarter", Accidentals.FLAT, 0, 3);
        notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        isRepeat = false;
        measure = new Measure(beatAmount, clef, notes);
    }

    @After
    public void tearDown() {
        beatAmount = 0;
        clef = null;
        isRepeat = false;
        measure = null;
        notes = null;
        note1 = null;
        note2 = null;
        note3 = null;
        note4 = null;
    }

    @Test
    public void testMeasureCreation() {
        measure = new Measure(4, "treble", notes = new ArrayList<Note>());
        assertEquals(4, measure.getBeatAmount());
        assertEquals("treble", measure.getClef());
        assertTrue(measure.getNoteList().isEmpty());
        assertNotNull(measure);
    }

    @Test
    public void testAddNoteList() {
        measure = new Measure(4, "treble", notes);
        assertEquals(4, measure.getNoteList().size());
        Note newNote = new Note(Pitches.G, "quarter", Accidentals.NATURAL, 0, 3);
        measure.getNoteList().add(newNote);
        assertEquals(note1, measure.getNoteList().get(0));
        assertEquals(note2, measure.getNoteList().get(1));
        assertEquals(note3, measure.getNoteList().get(2));
        assertEquals(note4, measure.getNoteList().get(3));
        assertEquals(newNote, measure.getNoteList().get(4));
        assertEquals(5, measure.getNoteList().size());
    }
}
