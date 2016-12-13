package data;

import Domain.DomainFacade;
import static data.DatabaseFacade.*;
import static data.DatabaseFacade.getBuildings;
import static data.DatabaseFacade.getUsers;
import entity.Address;
import entity.Building;
import entity.User;
import exceptions.PolygonException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseFacadeTest {

    public DatabaseFacadeTest() {
        //DB.getConnection();

    }

    @Before
    public void setUp() {

    }

    /**
     * Test of getBuildings method, of class DatabaseFacade.
     * Her tjekker vi metoderne på den rigtige database
     */
    @Test
    public void testGetBuildings() throws PolygonException{
        //Tjekker mod den rigtige size på listen og hvis vi får den samme størrelse
        int expResultSize = 4;
        List<Building> result = getBuildings();
        assertEquals(expResultSize, result.size());
    }

    /**
     * Test of getBuilding method, of class DatabaseFacade.
     */
    @Test
    public void testGetBuilding()throws PolygonException {
        //Her laver vi et resultat vi gerne vil have
        Address testAddress = new Address("Buildingvej2", null);
        //Så tester vi om vi får det resultat når vi beder om bygningen
        Building result = getBuilding(2);
        assertEquals(result.getAddress().getAddressline(), testAddress.getAddressline());
    }
    /**
     * Test of GetUsers method, of class DatabaseFacade.
     */
    @Test
    public void testGetUsers()throws PolygonException {
    //Tjekker mod den rigtige size på listen og hvis vi får den samme størrelse
    int expResultSize = 3;
    List<User> result = getUsers();
    assertEquals(expResultSize, result.size());
    }
    
    
    /**
     * Test of getUser method, of class DatabaseFacade.
     */
    @Test
    public void testGetUser()throws PolygonException {
        //Vi starter med at lave et test resultat
        User testUser = new User("Joacim", null, null, null,null);
        User result = getUser(1);
        assertEquals(testUser.getFirstname(),result.getFirstname());
    }

    /**
     * Test of getDocument method, of class DatabaseFacade.
     */
    @Test
    public void testGetDocument() {
    }

    /**
     * Test of loadZip method, of class DatabaseFacade.
     */
    @Test
    public void testLoadZip() {
    }

    /**
     * Test of loadAddress method, of class DatabaseFacade.
     */
    @Test
    public void testLoadAddress() {
    }

}
