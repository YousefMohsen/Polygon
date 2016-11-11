/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janus
 */
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
