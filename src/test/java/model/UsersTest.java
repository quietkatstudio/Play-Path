package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import com.model.*;

public class UsersTest {
    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Test
    public void testValidLogin() {
        MusicApplication musicApplication = MusicApplication.getInstance();
        MusicApplication.login("asmith");
        String firstName = MusicApplication.getCurrentUser().getFirstName().toLowerCase();

        assertEquals("amy", firstName);
    }

    @Test
    public void testInValidLogin() {
        MusicApplication MusicApplication = MusicApplication.getInstance();
        boolean success = MusicApplication.login("bross");
        assertFalse(success);
    }

    @Test
    public void testAddValidUser() {
        MusicApplication MusicApplication = MusicApplication.getInstance();
        MusicApplication.createAccount("jmath", "John", "Math", 15, "803-222-3333");
        MusicApplication.logout();
        MusicApplication = MusicApplication.getInstance();
        MusicApplication.login("jmath");
        String lastName = MusicApplication.getCurrentUser().getLastName().toLowerCase();
        assertEquals("math", lastName);
    }

    @Test
    public void testDuplicateValidUser() {
        MusicApplication MusicApplication = MusicApplication.getInstance();
        boolean success = MusicApplication.createAccount("jmath", "Jannet", "Math", 15, "803-222-3333");
        assertFalse(success);
    }
}
