/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Address;
import entity.Building;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JanusPC
 */
public class RequestMapperTest {
    
    public RequestMapperTest() {
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
     * Test of sendRequest method, of class RequestMapper.
     */
    @Test
    public void testSendRequest() {
        //The method isnt working right now
        int requestType = 1;
        int buildingID = 5;
        RequestMapper.sendRequest(requestType, buildingID);
        assertEquals(1, BuildingMapper.getBuilding(5).getHidden());
    }
    
}
