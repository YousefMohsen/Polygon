package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://vetterlain.dk/Polygon";
   //  Database credentials
   static final String USER = "polygon";
   static final String PASS = "Polygon16sundbygning!";   
   private Connection conn = null;
   

   public Connection conn(){           
   try{
      //STEP 1: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      //STEP 2: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);   
      
   }catch(ClassNotFoundException | SQLException e){
       System.out.println(e);
   }
   return conn;
   }
   
   public void close(){
       try {
           conn.close();
       } catch (SQLException ex) {
           /* Ignored */
       }
   }
}
   
    
   
