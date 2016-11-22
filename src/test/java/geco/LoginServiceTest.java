package geco;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marti_000 on 22/11/2016.
 */
public class LoginServiceTest {

    LoginService login;

    @Before
    public void setUp() throws Exception {
        login = new LoginService(new String[]{"login1","login2","login3","marty"});
    }

    @Test
    public void testLoginExists() throws Exception {
        assertTrue("Le login existe",login.loginExists("login2"));
    }

    @Test
    public void testAddLogin() throws Exception {
        login.addLogin("login4");
        assertTrue("Ajout fonctionnel",login.loginExists("login4"));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {

        List<String> logins = login.findAllLoginsStartingWith("log");
        assertTrue("testcontains1",logins.contains("login1"));
        assertTrue("testcontains2",logins.contains("login2"));
        assertTrue("testcontains3",logins.contains("login3"));
        assertFalse("testcontains4",logins.contains("marty"));
    }

    @Test
    public void testFindAllLogins() throws Exception {
        List<String> logins = login.findAllLogins();
        assertTrue("testcontains1",logins.contains("login1"));
        assertTrue("testcontains2",logins.contains("login2"));
        assertTrue("testcontains3",logins.contains("login3"));
        assertTrue("testcontains4",logins.contains("marty"));
    }

}