/**
 * @author Katie Turner
 */
package model;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.model.MusicApplication;


public class MusicApplicationTest {
    private MusicApplication application = new MusicApplication();
    @Test
    public void testTesting(){
        assertTrue(true);
    }

    @Test
    public void testLoginSuccess(){
       assertTrue(application.login("NeonWave", "AncientTome"));
    }
    @Test
    public void testLoginLeadingWrongCaseUsername(){
       assertFalse(application.login(" neonWave", "AncientTome"));
    }
    @Test
    public void testLoginLeadingSpaceUsername(){
       assertFalse(application.login(" NeonWave", "AncientTome"));
    }
    @Test
    public void testLoginLeadingSpacePassword(){
       assertFalse(application.login("NeonWave", " AncientTome"));
    }
    
    @Test
    public void testLoginWrongPassword(){
       assertFalse(application.login("NeonWave", "wrongpassword"));
    }
    @Test
    public void testLoginWrongUsername(){
       assertFalse(application.login("wrongUsername", "AncientTome"));
    }

    @Test
    public void testLoginEmptyUsername(){
       assertFalse(application.login("", "wrongpassword"));
    }
    @Test
    public void testLoginEmptyUsernameandPassword(){
       assertFalse(application.login("", ""));
    }
    @Test
    public void testLoginEmptyPassword(){
       assertFalse(application.login("NeonWave", ""));
    }
    @Test
    public void testLoginNonExistentUser(){
       assertFalse(application.login("testUser", "password"));
    }

   

    @Test
    public void testAvailableUsernameAlreadyExists(){
        assertTrue(application.availableUsername("NeonWave"));
    }

    @Test
    public void testAvailableUsernameDoesntExist(){
        assertFalse(application.availableUsername("Kitty123"));
    }

}
