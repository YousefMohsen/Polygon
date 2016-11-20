package data;

import entity.Address;
import entity.Building;
import entity.ZipCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joaci
 */
public class BuildingMapper {
    private DB db = new DB();  
    
    public static void createBuilding(int zip, String address) {

        String sql = "insert into Building "
                + "(Address_addressId,rapportURL,User_userId) "
                + "values(?,?,?);";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, insertAddress(zip, address, con));
            stmt.setString(2, "testURL");// fix rapport url!
            stmt.setInt(3, 1); //fix user ID

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }

        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }

    }
    
    public static List<Building> getBuildings() {
        Connection con = DB.getConnection();
        String sql = "SELECT buildingId,Address_addressId,User_userId "
                + "FROM Building; ";

        List<Building> buildings = new ArrayList<>();
        try (
                Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Building newBuilding = new Building();
                int id = res.getInt("buildingId");
                int addressId = res.getInt("Address_addressId");
                int userId = res.getInt("User_userId");

                newBuilding.setId(id);
                newBuilding.setAddress(loadAddress(addressId, con));
                newBuilding.setUser(userId);
                System.out.println(id);
                buildings.add(newBuilding);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return buildings;
    }
    
    //Henter info om en bygning fra DB ud fra et givet bygningsID
    public static Building getBuilding(int buildingID) {
        String sql = "SELECT Building.rapportURL, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM Building "
                + "JOIN Address "
                + "ON Building.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String rapportURL = res.getString("rapportURL");
                ZipCode zip = new ZipCode(res.getInt("zip"), res.getString("city"));
                Address address = new Address(res.getString("addressline"), zip);
                return new Building(buildingID, address, rapportURL);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }
    //Opdaterer info om en bygning i DB
    public static void updateBuilding(Building b) {
        String sql = "UPDATE Building "
                + "JOIN Address "
                + "ON Building.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "SET Building.rapportURL=?, "
                + "Address.addressline=?, "
                + "Zipcode.zip=?, "
                + "Zipcode.city=? "
                + "WHERE BuildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, b.getReport());
            stmt.setString(2, b.getAddress().getAddressline());
            stmt.setInt(3, b.getAddress().getZipCode().getZip());
            stmt.setString(4, b.getAddress().getZipCode().getCity());
            stmt.setInt(5, b.getId());
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
    
    public static ZipCode loadZip(int id, Connection con) { //afleverer et ZipCode objekt med data fra det tilhørende zipID
        String sql = "SELECT zip,city "
                + "FROM Zipcode "
                + "WHERE zipId=?;";
        ZipCode loadedZip = new ZipCode();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int zip = res.getInt("zip");
                String city = res.getString("city");

                loadedZip.setCity(city);
                loadedZip.setZip(zip);

            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }

        return loadedZip;
    }

    public static Address loadAddress(int id, Connection con) { //afleverer et Address objekt med data fra det tilhørende addressID
        String sql = "SELECT addressline,zipcode_addressId "
                + "FROM Address "
                + "WHERE addressId=?;";
        Address loadedAddress = new Address();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int zip = res.getInt("zipcode_addressId");
                String addressLine = res.getString("addressline");
                loadedAddress.setZipCode(loadZip(zip, con));
                loadedAddress.setAddressline(addressLine);

            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }

        return loadedAddress;
    }

    public static int findZipID(int zip, Connection con) {
        String sql = "select zipId from Zipcode where zip = ?;";
        int zipID = 0;
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, zip);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                zipID = res.getInt("zipId");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return zipID;
    }

    public static int insertAddress(int zip, String address, Connection con) {

        String sql = " insert into Address "
                + "(addressline,zipcode_addressId) "
                + "values (?,?);";
        String sqlGetAdrID = "SELECT MAX(addressId) FROM Address;";

        int adressID = 0;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, address);
            stmt.setInt(2, findZipID(zip, con));
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }

        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
        //get adressId of recent inserted adress 
        try (PreparedStatement stmt = con.prepareStatement(sqlGetAdrID)) {
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                adressID = res.getInt("MAX(addressId)");

            }
        } catch (SQLException ex) {
        }

        return adressID;
    }
}
