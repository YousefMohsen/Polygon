/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Address;
import entity.Login;
import entity.User;
import entity.ZipCode;
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
    public void testGetLogin() {
        String username = "";
        Login expResult = null;
        Login result = UserMapper.getLogin(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class UserMapper.
     */
    @Test
    public void testGetUser() {
        int buildingID = 5;
        String expResult = "Joacim";
        String result = UserMapper.getUser(buildingID).getFirstname();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUser method, of class UserMapper.
     */
    @Test
    public void testUpdateUser() {
        User u = new User("testname",null,null,null, new Address("1",new ZipCode(1,"1")));
        int buildingID = 5;
        UserMapper.updateUser(u, buildingID);
        assertEquals(UserMapper.getUser(buildingID).getFirstname(),"testname");
    }

    /**
     * Test of findCity method, of class UserMapper.
     */
    @Test
    public void testFindCity() {
        int zip = 2800;
        String expResult = "Kongens Lyngby";
        String result = UserMapper.findCity(zip);
        assertEquals(expResult, result);
    }
    
}
