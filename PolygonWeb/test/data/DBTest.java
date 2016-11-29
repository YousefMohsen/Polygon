package data;

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
     */
    @Test
    public void testGetConnection() {
        //Testing if the connection is null
        assertNotNull(DB.getConnection());
    }

    /**
     * Test of close method, of class DB.
     */
    @Test
    public void testClose() {
    }

}
