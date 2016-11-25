/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.*;
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
public class DocumentMapperTest {
    
    public DocumentMapperTest() {
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
     * Test of getDocument method, of class DocumentMapper.
     */
    @Test
    public void testGetDocument() {
        //Work in Progress
        Document result = DocumentMapper.getDocument(0);
        assertFalse(null==result);
    }

    /**
     * Test of updateDocument method, of class DocumentMapper.
     */
    @Test
    public void testUpdateDocument() {
        //First we make a new document and then update it
        Document d = new Document("Test.pdf","notetest");
        DocumentMapper.updateDocument(d, 0);
        Document result = DocumentMapper.getDocument(0);
        //Then we test if the document received from the building matches the one we created
        assertFalse(d==result);
    }
    
}
