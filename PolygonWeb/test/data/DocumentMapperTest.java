package data;

import entity.*;
import exceptions.PolygonException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Metoden tester om vi får det rigtige document tilbage
     */
    @Test
    public void testGetDocument() throws PolygonException, IOException{
        //Work in Progress
        Document result = DocumentMapper.getDocument(0);
        assertFalse(null == result);
    }

    /**
     * Test of updateDocument method, of class DocumentMapper.
     */
    @Test
    public void testUpdateDocument() throws PolygonException{
    }

}
