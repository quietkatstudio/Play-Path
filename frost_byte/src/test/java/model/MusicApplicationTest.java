
package model;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
    public void testLoginWrongPassword(){
       assertFalse(application.login("NeonWave", "wrongpassword"));
    }

    @Test
    public void testLoginEmptyUsername(){
       assertFalse(application.login("", "wrongpassword"));
    }
    @Test
    public void testLoginEmptyPassword(){
       assertFalse(application.login("NeonWave", ""));
    }
    @Test
    public void testLoginNonWxistentUser(){
       assertFalse(application.login("testUser", "password"));
    }



    @Test
    public void testGetFirstName(){
       assertNotNull(application.getFirstName("NeonWave"));
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
