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
     */
    @Test
    public void testGetUser() throws PolygonException {
        int buildingID = 5;
        String expResult = "Joacim";
        String result = UserMapper.getUser(buildingID).getFirstname();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUser method, of class UserMapper.
     */
    @Test
    public void testUpdateUser() throws PolygonException{
        User u = new User("testname", null, null, null, new Address("1", new ZipCode(1, "1")));
        int buildingID = 5;
        UserMapper.updateUser(u, buildingID);
        assertEquals(UserMapper.getUser(buildingID).getFirstname(), "testname");
    }

    /**
     * Test of findCity method, of class UserMapper.
     */
    @Test
    public void testFindCity() throws PolygonException {
        int zip = 2800;
        String expResult = "Kongens Lyngby";
        String result = UserMapper.findCity(zip);
        assertEquals(expResult, result);
    }

}
