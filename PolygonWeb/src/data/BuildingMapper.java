package data;

import entity.Address;
import entity.Building;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class deals with all data about a building.
 */
public class BuildingMapper {

    /**
     * This method creates a new building and saves it in the database
     *
     * @param zip int the zip code of the building
     * @param address String the address of the building
     * @param userID int identifies the owner of the building
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static void createBuilding(int zip, String address, int userID) throws PolygonException {
        System.out.println(zip + address + userID);
        String sql = "insert into Building "
                + "(Address_addressId,rapportURL,User_userId,hidden,buildingName) "
                + "values(?,?,?,?,?);";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, insertAddress(zip, address, con));
            stmt.setString(2, "testURL");// fix rapport url!
            stmt.setInt(3, userID); //fix user ID
            stmt.setInt(4, 0); //0 = shown, 1=hidden
            stmt.setString(5, "navnpaabygning");
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in createBuilding method: " + ex.getMessage());
        }
    }

    /**
     * This method returns a list with all the buildings from the database
     *
     * @return ArrayList() of type Building
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static List<Building> getBuildings() throws PolygonException {
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
                buildings.add(newBuilding);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getBuildings method: " + ex.getMessage());
        }
        return buildings;
    }

    /**
     * This method returns a list with all the buildings from the database
     * belonging to a specific user
     *
     * @param userID int identifies the owner of the buildings
     * @param userType int tells about if the user is an admin or a customer - 0
     * is a customer and 1 is admin
     * @return ArrayList() of type Building
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static List<Building> getBuildingsForUser(int userID, int userType) throws PolygonException {//Returns a list for a given user
        List<Building> buildings = new ArrayList<>();
        String sql = "SELECT buildingId,Address_addressId,User_userId FROM Building ";
        if (userType != 1) {
            sql += "where User_userId=? And hidden=0";
        } //if user is not an admin, then hide deleted buildings   
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);) {
            if (userType != 1) {
                stmt.setInt(1, userID);
            }
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                Building newBuilding = new Building();
                int id = res.getInt("buildingId");
                int addressId = res.getInt("Address_addressId");
                int userId = res.getInt("User_userId");
                newBuilding.setId(id);
                newBuilding.setAddress(loadAddress(addressId, con));
                newBuilding.setUser(userId);
                buildings.add(newBuilding);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getBuildingsForUser method: " + ex.getMessage());
        }
        return buildings;
    }

    /**
     * This method returns a building from the database belonging to a specific
     * user
     *
     * @param buildingID int the ID of the building
     * @return Building object of entity class Building
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static Building getBuilding(int buildingID) throws PolygonException {
        //Henter info om en bygning fra DB ud fra et givet bygningsID
        String sql = "SELECT Building.rapportURL, Building.buildingName, Building.User_userId, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM Building "
                + "JOIN Address "
                + "ON Building.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE buildingId=?";
        System.out.println(sql);
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {

                String rapportURL = res.getString("rapportURL");
                int userID = res.getInt("User_userId");
                ZipCode zip = new ZipCode(res.getInt("zip"), res.getString("city"));
                Address address = new Address(res.getString("addressline"), zip);
                String buildingName = res.getString("buildingName");

                return new Building(buildingID, address, rapportURL, userID, buildingName);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getBuilding method: " + ex.getMessage());
        }
        return null;
    }

    /**
     * This method returns a building from the database belonging to a specific
     * user when there is no connection
     *
     * @param buildingID int the ID of the building
     * @param con Connection a new connection
     * @return Building object of entity class Building
     * @throws EXCEPTION
     */
    private static Building getBuildingNoConnection(int buildingID, Connection con) throws PolygonException {
        //Henter info om en bygning fra DB ud fra et givet bygningsID
        String sql = "SELECT Building.rapportURL, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM Building "
                + "JOIN Address "
                + "ON Building.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE buildingId=?";
        try (
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
            throw new PolygonException("Problem in getBuildingNoConnection method: " + ex.getMessage());
        }
        return null;
    }

    /**
     * This method updates the information about a specific building in the
     * database
     *
     * @param b Building the building that is going to be updated
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static void updateBuilding(Building b) throws PolygonException {
        //Opdaterer info om en bygning i DB
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
            stmt.setString(4, findCity(b.getAddress().getZipCode().getZip()));
            stmt.setInt(5, b.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
            throw new PolygonException("Problem in updateBuilding method: " + ex.getMessage());
        }
    }

    /**
     * This method returns an object of ZipCode with information from the
     * database
     *
     * @param id int the ID of the ZipCode
     * @param con Connection a new connection
     * @return ZipCode object of entity class ZipCode
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static ZipCode loadZip(int id, Connection con) throws PolygonException { //afleverer et ZipCode objekt med data fra det tilhørende zipID
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
            throw new PolygonException("Problem in loadZip method: " + ex.getMessage());
        }
        return loadedZip;
    }

    /**
     * This method returns an object of Address with information from the
     * database
     *
     * @param id int the ID of the address
     * @param con Connection a new connection
     * @return Address object of entity class Address
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static Address loadAddress(int id, Connection con) throws PolygonException { //afleverer et Address objekt med data fra det tilhørende addressID
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
            throw new PolygonException("Problem in loadAddress method: " + ex.getMessage());
        }
        return loadedAddress;
    }

    /**
     * This method returns a city with a specific zip code from the database
     *
     * @param zip int the zip code that matches the city
     * @return city String a String with the name of the city
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static String findCity(int zip) throws PolygonException {
        //Finder og retunerer en by fra DB ud fra et givet post nr. (zip)
        String sql = "SELECT city "
                + "FROM Zipcode "
                + "WHERE zip=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, zip);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String city = res.getString("city");
                return city;
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in findCity method: " + ex.getMessage());
        }
        return null;

    }

    /**
     * This method returns a zip ID with a specific zip code from the database
     *
     * @param zip int the zip code that matches the zip ID
     * @param con Connection a new connection
     * @return zipID int a int with the ID
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static int findZipID(int zip, Connection con) throws PolygonException {
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
            throw new PolygonException("Problem in findZipID method: " + ex.getMessage());
        }
        return zipID;
    }

    /**
     * This method inserts a new address in the database and returns an
     * addressID of recent inserted address
     *
     * @param zip int the zip code of the new address
     * @param address the addressline of the new address
     * @param con Connection a new connection
     * @return addressID int a int with the ID
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static int insertAddress(int zip, String address, Connection con) throws PolygonException {
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
            throw new PolygonException("Problem in insertAddress method, sql: " + ex.getMessage());
        }
        //get adressId of recent inserted address 
        try (PreparedStatement stmt = con.prepareStatement(sqlGetAdrID)) {
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                adressID = res.getInt("MAX(addressId)");
            }
        } catch (SQLException ex) {
            throw new PolygonException("Problem in insertAddress method, sqlGetAdrID: " + ex.getMessage());
        }
        return adressID;
    }

    /**
     * This method returns a list with all the requests from the database
     *
     * @param con Connection a new connection
     * @return ArrayList() of type Integer
     * @throws EXCEPTION
     */
    private static List<Integer> getRequestList(Connection con) throws PolygonException {
        ArrayList<Integer> requestIds = new ArrayList();
        String sql = "SELECT * FROM Request_has_Building "
                + "where Request_requestId=1; ";

        try (Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int buildingID = res.getInt("Building_buildingId");
                requestIds.add(buildingID);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getRequestList method: " + ex.getMessage());
        }

        return requestIds;
    }

    /**
     * This method returns a list with all the buildings requested to be deleted
     * from the database
     *
     * @return ArrayList() of type Building
     * @throws exceptions.PolygonException
     */
    public static List<Building> getDeletionBuildings() throws PolygonException {
        Connection con = DB.getConnection();
        List<Building> buildings = new ArrayList<>();
        for (int id : getRequestList(con)) {
            buildings.add(getBuildingNoConnection(id, con));
        }
        return buildings;
    }

    /**
     * This method sets a building to be hidden in the database
     *
     * @param id int the ID of the building
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static void hideBuilding(int id) throws PolygonException {
        String sql = "UPDATE Building SET hidden=1 WHERE buildingId=?;";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element updated");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
            throw new PolygonException("Problem in hideBuilding method: " + ex.getMessage());
        }
    }
}
