package data;

import entity.Address;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class deals with all data about an address.
 */
public class AddressMapper {

    /**
     * This method returns an address from the database belonging to a specific
     * user
     *
     * @param id int the ID of the address
     * @return Address object of entity class Address or null
     * @throws exceptions.PolygonException
     */
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

            return new Address(addressLine, getZipCity(zipId));
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }

    /**
     * This method returns a specific zip code and city from the database based
     * on a zipID
     *
     * @param zipId int the ID of the zip
     * @return ZipCode object of entity class ZipCode or null
     * @throws exceptions.PolygonException
     */
    public static ZipCode getZipCity(int zipId) throws PolygonException {
        String SQL = "SELECT zip,city FROM Zipcode WHERE zipId = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, zipId);
            ResultSet res = stmt.executeQuery();
            int zip = 0;
            String city = "";
            if (res.next()) {
                zip = res.getInt("zip");
                city = res.getString("city");
            }

            return new ZipCode(zip, city);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }

    /**
     * This method returns a zipId from the database based on a specific zip
     * code
     *
     * @param zip int the zip code
     * @return zipId int the zipId or 0
     * @throws exceptions.PolygonException
     */
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

    /**
     * This method updates the information about a specific address in the
     * database
     *
     * @param buildingAddressId int the ID of the building
     * @param addressId int the ID of the address
     * @throws exceptions.PolygonException
     */
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
