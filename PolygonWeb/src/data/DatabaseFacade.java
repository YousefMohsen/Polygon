package data;

import entity.Address;
import entity.Building;
import entity.User;
import entity.ZipCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {

    DB db = new DB();

    public List<Building> getBuildings() {

        String sql = "SELECT buildingId,Address_addressId,User_userId "
                + "FROM Building; ";

        List<Building> buildings = new ArrayList<>();
        try (Connection con = db.getConnection();
                Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Building newBuilding = new Building();
                int id = res.getInt("buildingId");
                int addressId = res.getInt("Address_addressId");
                int userId = res.getInt("User_userId");

                newBuilding.setId(id);
                newBuilding.setAddress(loadAddress(addressId));
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

    //Henter info om en bruger fra DB ud fra et givet brugerID
    public static User getUser(int userID) {
        String sql = "SELECT User.firstname, User.lastname, User.phone, User.email, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM User "
                + "JOIN Address "
                + "ON User.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE userId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String phone = res.getString("phone");
                String email = res.getString("email");
                ZipCode zip = new ZipCode(res.getInt("zip"), res.getString("city"));
                Address address = new Address(res.getString("addressline"), zip);
                return new User(userID, firstname, lastname, phone, email, address);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }

    //Henter info om et dokument fra DB ud fra et givet dokumentID
    public static Document getDocument(int documentID) {
        String sql = "SELECT fileURL, note "
                + "FROM Document "
                + "WHERE documentId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, documentID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String fileURL = res.getString("fileURL");
                String note = res.getString("note");
                return new Document(documentID, fileURL, note);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }

    public ZipCode loadZip(int id) { //afleverer et ZipCode objekt med data fra det tilhørende zipID
        String sql = "SELECT zip,city "
                + "FROM Zipcode "
                + "WHERE zipId=?;";
        ZipCode loadedZip = new ZipCode();
        try (Connection con = db.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
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

    public Address loadAddress(int id) { //afleverer et Address objekt med data fra det tilhørende addressID
        String sql = "SELECT addressline,zipcode_addressId "
                + "FROM Address "
                + "WHERE addressId=?;";
        Address loadedAddress = new Address();

        try (Connection con = db.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int zip = res.getInt("zipcode_addressId");
                String addressLine = res.getString("addressline");
                loadedAddress.setZipCode(loadZip(zip));
                loadedAddress.setAddressline(addressLine);

            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }

        return loadedAddress;
    }
}
