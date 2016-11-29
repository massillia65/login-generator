package geco;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Marti_000 on 22/11/2016.
 */
public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[]{"JROL","BPER","CGUR","JDUP","JRAL","JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom1() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertTrue("test generation 1",login.equals("PDUR"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenom2() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertTrue("test generation 2",login.equals("JROL1"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenom3() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertTrue("test generation 3",login.equals("PDUR"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomIncrement() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertTrue("test generation incrément",login.equals("JRAL2"));
    }

    @Test
    public void testGenerateLoginAuMoins3Caracteres() throws Exception {
        String login = loginGenerator.generateLoginForNomAndPrenom("Du","Paul");
        assertTrue("test generation au moins 3 caractères",login.equals("PDU"));
    }
}