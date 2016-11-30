package data;

import entity.Address;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jvetterlain
 */
public class AddressMapper {
    
     public static Address getUserAddress(int id) throws PolygonException {
        String SQL = "SELECT Zipcode_zipId, addressLine FROM userAddress WHERE addressId = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery(); 
            int zipId = 0;
            String addressLine = "";
            if (res.next()) {
                zipId = res.getInt("Zipcode_zipId");
                addressLine = res.getString("addressLine");
            }
            
            return new Address(addressLine,  getZipCity(zipId));
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }

    public static ZipCode getZipCity(int zipId) throws PolygonException{
        String SQL = "SELECT zip,city FROM Zipcode WHERE zipId = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, zipId);
            ResultSet res = stmt.executeQuery(); 
            int zip = 0;
                String city ="";
            if (res.next()) {
                zip = res.getInt("zip");
                city = res.getString("city");
            }
            
            return new ZipCode(zip,city);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    } 
     
    public static int getZipId(int zip) throws PolygonException {
        String SQL = "select zipId FROM Zipcode WHERE zip = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, zip);
            ResultSet res = stmt.executeQuery();
            int zipId = 0;
            if (res.next()) {
                zipId = res.getInt("zipId");
            }
            return zipId;
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return 0;
    }

    public static void updateAdress(int buildingAddressId, int addressId) throws PolygonException {        
        String SQL = "Update Address SET Address.zipcode_addressId = ? WHERE addressId = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, addressId);
            stmt.setInt(2, buildingAddressId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
    }

}
