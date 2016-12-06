package data;

import exceptions.PolygonException;
import java.sql.Connection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DBTest {

    public DBTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getConnection method, of class DB.
     * Metoden tjekker om vi får en connection
     */
    @Test
    public void testGetConnection() throws PolygonException {
        //Vi tester om connection er null
        assertNotNull(DB.getConnection());
    }

    /**
     * Test of close method, of class DB.
     */
    @Test
    public void testClose() {
    }

}
