/**
 * @author Ryan Evans
 */

package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.model.KeySig;
import com.model.Keys;
import com.model.Measure;
import com.model.Note;
import com.model.Pitches;
import com.model.Song;

public class SongTest {
    private Song song;
    private UUID id = UUID.randomUUID();
    private String title = "Test Song";
    private String artist = "Test Artist";
    private UUID author = UUID.randomUUID();
    private String genre = "Test Genre";
    private String duration = "3:30";
    private String tempo = "120";
    private int defTimeSigNumer = 4;
    private int defTimeSigDenom = 4;
    private KeySig defKeySig = new KeySig(Keys.C, "A", "B", "C", "D", "E", "F", "G");
    private ArrayList<Note> notes = new ArrayList<Note>();
    private ArrayList<Measure> measureList = new ArrayList<Measure>();

    @Before
    public void setUp() {
        song = new Song(id, title, artist, author, genre, duration, tempo, defTimeSigNumer, defTimeSigDenom,
                defKeySig, measureList);
    }

    @After
    public void tearDown() {
        song = null;
        id = null;
        title = null;
        artist = null;
        author = null;
        genre = null;
        duration = null;
        tempo = null;
        defTimeSigNumer = 0;
        defTimeSigDenom = 0;
        defKeySig = null;
        measureList = null;
    }

    @Test
    public void testSongCreation() {
        assertNotNull("Song should not be null", song);
        assertEquals("Title should match", title, song.getTitle());
        assertEquals("Artist should match", artist, song.getArtist());
        assertEquals("Author should match", author, song.getAuthor());
        assertEquals("Genre should match", genre, song.getGenre());
        assertEquals("Duration should match", duration, song.getDuration());
        assertEquals("Tempo should match", tempo, song.getTempo());
        assertEquals("Default time signature numerator should match", defTimeSigNumer, song.getDefTimeSigNumer());
        assertEquals("Default time signature denominator should match", defTimeSigDenom, song.getDefTimeSigDenom());
        assertEquals("Default key signature should match", defKeySig, song.getDefKeySig());
    }

    @Test
    public void testAddMeasure() {
        Measure measure = new Measure(4, "treble", notes);
        song.addMeasure(measure);
        assertEquals("Measure list size should be 1", 1, song.getMeasureList().size());
        assertEquals("First measure should match", measure, song.getMeasureList().get(0));
    }

    @Test
    public void testGetMeasureList() {
        Note note1 = new Note(Pitches.C, "quarter", null, 0, 3);
        Note note2 = new Note(Pitches.D, "quarter", null, 0, 3);
        Note note3 = new Note(Pitches.E, "quarter", null, 0, 3);
        Note note4 = new Note(Pitches.F, "quarter", null, 0, 3);
        ArrayList<Note> notesA = new ArrayList<Note>();
        notesA.add(note1);
        notesA.add(note2);
        notesA.add(note3);
        notesA.add(note4);
        Note note5 = new Note(Pitches.G, "quarter", null, 0, 3);
        Note note6 = new Note(Pitches.A, "quarter", null, 0, 3);
        Note note7 = new Note(Pitches.B, "quarter", null, 0, 3);
        Note note8 = new Note(Pitches.C, "quarter", null, 0, 3);
        ArrayList<Note> notesB = new ArrayList<Note>();
        notesB.add(note5);
        notesB.add(note6);
        notesB.add(note7);
        notesB.add(note8);
        Measure measure1 = new Measure(4, "treble", notesA);
        Measure measure2 = new Measure(4, "bass", notesB);
        song.addMeasure(measure1);
        song.addMeasure(measure2);
        assertEquals("Measure list size should be 2", 2, song.getMeasureList().size());
        assertEquals("First measure should match", measure1, song.getMeasureList().get(0));
        assertEquals("Second measure should match", measure2, song.getMeasureList().get(1));
    }

    @Test
    public void testGetNoteFromMeasure() {
        Note note1 = new Note(Pitches.C, "quarter", null, 0, 3);
        Note note2 = new Note(Pitches.D, "quarter", null, 0, 3);
        ArrayList<Note> notesA = new ArrayList<Note>();
        notesA.add(note1);
        notesA.add(note2);
        Measure measure = new Measure(4, "treble", notesA);
        song.addMeasure(measure);
        assertEquals("First note should match", note1, song.getMeasureList().get(0).getNoteList().get(0));
        assertEquals("Second note should match", note2, song.getMeasureList().get(0).getNoteList().get(1));
    }
}
