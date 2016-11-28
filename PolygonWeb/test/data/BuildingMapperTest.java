/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janus
 */
public class BuildingMapperTest {
    
    public BuildingMapperTest() {
    }
    
    private Connection testDatabase;
    private static String USER = "polygon";
    private static String USERPW = "Polygon16sundbygning!";
    private static String DBNAME = "buildingsTest";
    
    @Before
    public void setUp() { try {
            String url = String.format("jdbc:mysql://vetterlain.dk/buildingsTest");
            Class.forName("com.mysql.jdbc.Driver");
            
            testDatabase =  DriverManager.getConnection(url, USER, USERPW);
            try( Statement stmt = testDatabase.createStatement()){
                stmt.execute( "drop table if exists Building");
                stmt.execute( "create table Building like testbuilding");
                stmt.execute( "insert into Building select * from testbuilding");
            }
            DB.setConnection(testDatabase);
            System.out.println("test connection");
            
        } catch ( ClassNotFoundException | SQLException ex ) {
            testDatabase = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    /**
     * Test of createBuilding method, of class BuildingMapper.
     */
    @Test
    public void testCreateBuilding() {
    }

    /**
     * Test of getBuildings method, of class BuildingMapper.
     */
    @Test
    public void testGetBuildings() {
        System.out.println("bygningid: "+BuildingMapper.getBuildings().get(0).getId());
        
    }

    /**
     * Test of getBuildingsForUser method, of class BuildingMapper.
     */
    @Test
    public void testGetBuildingsForUser() {
    }

    /**
     * Test of getBuilding method, of class BuildingMapper.
     */
    @Test
    public void testGetBuilding() {
    }

    /**
     * Test of updateBuilding method, of class BuildingMapper.
     */
    @Test
    public void testUpdateBuilding() {
    }

    /**
     * Test of loadZip method, of class BuildingMapper.
     */
    @Test
    public void testLoadZip() {
    }

    /**
     * Test of loadAddress method, of class BuildingMapper.
     */
    @Test
    public void testLoadAddress() {
    }

    /**
     * Test of findCity method, of class BuildingMapper.
     */
    @Test
    public void testFindCity() {
    }

    /**
     * Test of findZipID method, of class BuildingMapper.
     */
    @Test
    public void testFindZipID() {
    }

    /**
     * Test of insertAddress method, of class BuildingMapper.
     */
    @Test
    public void testInsertAddress() {
    }

    /**
     * Test of getDeletionBuildings method, of class BuildingMapper.
     */
    @Test
    public void testGetDeletionBuildings() {
    }

    /**
     * Test of hideBuilding method, of class BuildingMapper.
     */
    @Test
    public void testHideBuilding() {
    }
    
}
