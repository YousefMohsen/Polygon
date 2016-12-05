package data;

import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The purpose of this class is to provide a database connection to the
 * database.
 */
public final class DB {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://vetterlain.dk/Polygon?allowMultiQueries=true";   
    //  Database credentials    
    static final String USER = "polygon";    
    static final String PASS = "Polygon16sundbygning!";
    private static Connection conn = null;

    

    /**
     * This method connects to the database
     *
     * @return a connection or null
     * @throws exceptions.PolygonException
     */
    public static Connection getConnection() throws PolygonException {
        try {
            if(conn == null)
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 2: Open a connection            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            throw new PolygonException("Problem in getConnection method: " + e.getMessage());
        }
        return conn;
    }
    
    public static void setConnection(Connection conn){
        DB.conn = conn;
    }

    /**
     * This method closes the connection.
     * @throws exceptions.PolygonException
     */
    public void close() throws PolygonException {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new PolygonException("Problem in getConnection method: " + ex.getMessage());
        }
    }
}
