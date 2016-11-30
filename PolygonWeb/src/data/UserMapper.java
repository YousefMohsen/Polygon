package data;

import entity.Address;
import entity.Login;
import entity.User;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class deals with all data about a user.
 */
public class UserMapper {

    /**
     * This method returns a user with a specific ID from the database
     *
     * @param id int the ID of the user
     * @return User object of entity class User or null
     * @throws EXCEPTION
     */
    public static User getUserViaID(int id) throws PolygonException {
        String SQL = "SELECT * From Polygon.User WHERE User.userId = ?;";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String phone = res.getString("phone");
                String email = res.getString("email");
                int addressId = res.getInt("Address_addressId");
                int uId = res.getInt("userId");
                return new User(uId, firstname, lastname, phone, email, addressId);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getUserViaID method: " + ex.getMessage());
        }
        // User doesnt exist
        return null;

    }

    /**
     * This method returns information about login from the database
     *
     * @param username String the username of the user
     * @return Login object of entity class Login or new user if doesn't exist
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static Login getLogin(String username) throws PolygonException {
        //Henter login info
        String sql = "SELECT * FROM Polygon.Login WHERE username = ?;";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String userName = res.getString("username");
                String password = res.getString("password");
                int rank = res.getInt("rank");
                int id = res.getInt("loginId");
                int uId = res.getInt("User_userId");
                return new Login(uId, userName, password, rank, id);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getLogin method: " + ex.getMessage());
        }
        // User doesnt exist
        return new Login("no", "no", 0, 0);
    }

    /**
     * This method returns a User from the database belonging to a specific
     * building
     *
     * @param buildingID int the ID of the building
     * @return User object of entity class User or null
     * @throws exceptions.PolygonException
     * @throws EXCEPTION
     */
    public static User getUser(int buildingID) throws PolygonException {
        //Henter info om en bruger fra DB ud fra et givet bygningsID
        String sql = "SELECT User.firstname, User.lastname, User.phone, User.email, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM User "
                + "JOIN Building "
                + "ON userId = User_userId "
                + "JOIN Address "
                + "ON User.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String phone = res.getString("phone");
                String email = res.getString("email");
                ZipCode zip = new ZipCode(res.getInt("zip"), res.getString("city"));
                Address address = new Address(res.getString("addressline"), zip);
                return new User(buildingID, firstname, lastname, phone, email, address);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getUser method: " + ex.getMessage());
        }
        return null;
    }

    /**
     * This method updates the information about a specific user in the database
     *
     * @param u User the user that is going to be updated
     * @param buildingID int the ID of the building whose owner is going to be
     * updated
     * @throws EXCEPTION
     */
    public static void updateUser(User u, int buildingID) throws PolygonException {
        //Opdaterer info om en bruger i DB ud fra et givet bygningsID
        String sql = "UPDATE User "
                + "JOIN Building "
                + "ON userId = User_userId "
                + "JOIN Address "
                + "ON User.Address_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "SET User.firstname=?, "
                + "User.lastname=?, "
                + "User.phone=?, "
                + "User.email=?, "
                + "Address.addressline=?, "
                + "Zipcode.zip=?, "
                + "Zipcode.city=? "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, u.getFirstname());
            stmt.setString(2, u.getLastname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getAddress().getAddressline());
            stmt.setInt(6, u.getAddress().getZipCode().getZip());
            stmt.setString(7, findCity(u.getAddress().getZipCode().getZip()));
            stmt.setInt(8, buildingID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
            throw new PolygonException("Problem in updateUser method: " + ex.getMessage());
        }
    }

    /**
     * This method returns a city with a specific zip code from the database
     *
     * @param zip int the zip code that matches the city
     * @return city String a String with the name of the city or null
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
}
