/**
 * @author Jonathan Grimes
 */

package model;

import java.util.ArrayList;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import com.model.MusicApplication;
import com.model.Song;
import com.model.User;
import com.model.DataLoader;

public class DataLoaderTest {

    private ArrayList<User> users;
    private ArrayList<Song> songs;

    @Before
    public void setUp() {
        users = DataLoader.getUsers();
        songs = DataLoader.getSongs();
    }

    @After
    public void tearDown() {
        users = null;
        songs = null;
    }

    @Test
    public void testLoadUsersNotEmpty() {
        assertNotNull("Users list should not be nul", users);
        assertTrue("Users list should not be empty", users.size() > 0);
    }

    @Test
    public void testUser() {
        User user = users.get(0);
        assertNotNull("User ID should not be nul", user.getID());
        assertNotNull("Username should not be null", user.getUserName());
        assertNotNull("Email should not be null", user.getEmail());
    }

    @Test
    public void testLoadSongsNotEmpty() {
        assertNotNull("Songs list should not be null", songs);
        assertTrue("Songs list should not be empty", songs.size() > 0);
    }

    @Test
    public void testSongProperties() {
        Song song = songs.get(0);
        assertNotNull("Song ID should not be null", song.getID());
        assertNotNull("Title should not be null", song.getTitle());
        assertNotNull("Artist should not be null", song.getArtist());
    }

    @Test
    public void testSongKeySignature() {
        Song song = songs.get(0);
        assertNotNull("Song should have a key signature", song.getDefKeySig());
    }

    @Test
    public void testGetSongsByArtist() {
        ArrayList<Song> traditionalSongs = new MusicApplication().getSongsByArtist("Traditional");
        assertNotNull("Songs by Traditional should not be null", traditionalSongs);
        assertTrue("There should be at least one song by Traditional", traditionalSongs.size() > 0);
    }

    @Test
    public void testMissingUserName() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getUsers();
        });
        assertTrue(exception.getMessage().contains("USER_USER_NAME"));
    }

    @Test
    public void testMissingLessonTitle() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getLessons();
        });
        assertTrue(exception.getMessage().contains("title"));
    }

    @Test
    public void testMissingLessonContent() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getLessons();
        });
        assertTrue(exception.getMessage().contains("content"));
    }

    @Test
    public void testMissingSongTitle() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("title"));
    }

    @Test
    public void testMissingSongArtist() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("artist"));
    }

    @Test
    public void testMissingMeasureList() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("measureList"));
    }

    @Test
    public void testEmptyMeasureList() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("measureList"));
    }

    @Test
    public void testMissingTempo() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("tempo"));
    }

    @Test
    public void testInvalidUUIDFormat() {
        Exception exception = assertThrows(Exception.class, () -> {
            DataLoader.getSongs();
        });
        assertTrue(exception.getMessage().contains("Invalid UUID"));
    }

}