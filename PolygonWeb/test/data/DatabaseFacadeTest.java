/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.DatabaseFacade.getBuildings;
import entity.Address;
import entity.Building;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janus
 */
public class DatabaseFacadeTest {
    
    public DatabaseFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getBuildings method, of class DatabaseFacade.
     */
    @Test
    public void testGetBuildings() {
        int expResultSize = 3;
        List<Building> result = getBuildings();
        assertEquals( expResultSize, result.size() );
    }

    /**
     * Test of getBuilding method, of class DatabaseFacade.
     */
    @Test
    public void testGetBuilding() {
        //Creating test result
        Address testAddress = new Address("Roskildevej 153B",null);
        //testing if the building recieved has the same adressline as the test adress
       assertEquals(DatabaseFacade.getBuilding(1).getAddress().getAddressline(), testAddress.getAddressline());
    }

    /**
     * Test of updateBuilding method, of class DatabaseFacade.
     */
    @Test
    public void testUpdateBuilding() {
    }

    /**
     * Test of getUser method, of class DatabaseFacade.
     */
    @Test
    public void testGetUser() {
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
