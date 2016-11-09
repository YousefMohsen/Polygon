/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Adress;
import entity.Building;
import entity.Zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Yousinho
 */
public class DatabaseFacade {

        DB db = new DB();

    
    public List<Building> getBuildings() {

  String sql = "SELECT buildingId,Address_addressId,User_userId "
                + "FROM Building; ";
                    
        List<Building> buildings = new ArrayList<>();
        try ( Connection con = db.getConnection();
                Statement stmt = con.createStatement() ) {
            ResultSet res = stmt.executeQuery( sql );
            while ( res.next() ) {
                Building newBuilding = new Building();
                int id = res.getInt( "buildingId" );
                int addressId = res.getInt( "Address_addressId" );
                int userId = res.getInt( "User_userId" );
                
                newBuilding.setId(id);
                newBuilding.setAdress(loadAdress(addressId));
                newBuilding.setUser(userId);
                System.out.println(id);
                buildings.add( newBuilding );
            }
        } catch ( SQLException ex ) {
            System.out.println( "Element not gotten: " + ex.getMessage() );
        }
        return buildings;
    }

    
  public Zipcode loadZip(int id){ //afleverer et Zipcode objekt med data fra det tilhørende zipID
  String sql = "SELECT zip,city "
                + "FROM Zipcode "
                + "WHERE zipId=?;";
  Zipcode loadedZip = new Zipcode();
       try ( Connection con = db.getConnection();
                PreparedStatement stmt = con.prepareStatement( sql ) ) {
            stmt.setInt( 1, id);
            ResultSet res = stmt.executeQuery();
            if ( res.next() ) {
                int zip = res.getInt( "zip" );
                String city = res.getString( "city" );
      
                loadedZip.setCity(city);
                loadedZip.setZip(zip);
               
            }
        } catch ( SQLException ex ) {
            System.out.println( "Element not gotten: " + ex.getMessage() );
        

        }
 
return loadedZip;
  }  
    
  
  
  
    
  public Adress loadAdress(int id){ //afleverer et Adress objekt med data fra det tilhørende adressID
  String sql = "SELECT addressline,zipcode_addressId "
                + "FROM Address "
                + "WHERE addressId=?;";
  Adress loadedAdress = new Adress();

       try ( Connection con = db.getConnection();
                PreparedStatement stmt = con.prepareStatement( sql ) ) {
            stmt.setInt( 1, id);
            ResultSet res = stmt.executeQuery();
            if ( res.next() ) {
                int zip = res.getInt("zipcode_addressId" );
                String adressLine = res.getString( "addressline" );
                loadedAdress.setZipCode(loadZip(zip));
                loadedAdress.setAdressline(adressLine);
                
            }
        } catch ( SQLException ex ) {
            System.out.println( "Element not gotten: " + ex.getMessage() );
        
    
        }
 
return loadedAdress;
  }  
}
