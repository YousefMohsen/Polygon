package data;

import entity.Address;
import entity.Building;
import exceptions.PolygonException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testSendRequest()throws PolygonException {
        //The method isnt working right now
        int requestType = 1;
        int buildingID = 5;
        RequestMapper.sendRequest(requestType, buildingID);
        assertEquals(1, BuildingMapper.getBuilding(5).getHidden());
    }

}
