package data;

import entity.Address;
import entity.Login;
import entity.User;
import entity.ZipCode;
import exceptions.PolygonException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserMapperTest {

    public UserMapperTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLogin method, of class UserMapper.
     * Metoden tester om vi kan logge ind
     */
    @Test
    public void testGetLogin() throws PolygonException{
        String username = "";
        Login expResult = null;
        Login result = UserMapper.getLogin(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class UserMapper.
     * Metoden tester om vi får den rigtige bruger tilbage
     */
    @Test
    public void testGetUser() throws PolygonException {
        int buildingID = 5;
        String expResult = "Joacim";
        String result = UserMapper.getUser(buildingID).getFirstname();
        assertEquals(expResult, result);
    }

    /**
     * Test of findCity method, of class UserMapper.
     * Metoden tester om man får den rigtige by tilbage
     */
    @Test
    public void testFindCity() throws PolygonException {
        int zip = 2800;
        String expResult = "Kongens Lyngby";
        String result = UserMapper.findCity(zip);
        assertEquals(expResult, result);
    }

}
