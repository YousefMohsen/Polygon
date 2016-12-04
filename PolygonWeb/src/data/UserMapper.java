package data;

import static data.BuildingMapper.findZipID;
import entity.Address;
import entity.Login;
import entity.User;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class deals with all data about a user.
 */
public class UserMapper {

    public static ArrayList<User> getUsers() throws PolygonException {
        String SQL = "SELECT * From Polygon.User;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            ArrayList<User> userList = new ArrayList<>();
            ResultSet res = stmt.executeQuery();
            while (res.next()) {                
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String phone = res.getString("phone");
                String email = res.getString("email");
                int addressId = res.getInt("userAddress_addressId");
                int uId = res.getInt("userId");
                Login login = getLogin(uId);
                userList.add(new User(uId, firstname, lastname, phone, email, addressId, login));           
            }           
            return userList;
        } catch (SQLException ex) {
            throw new PolygonException("Problem in getUsers method: " + ex.getMessage());
        }
    }

    /**
     * This method returns a user with a specific ID from the database
     *
     * @param id int the ID of the user
     * @return User object of entity class User or null
     * @throws exceptions.PolygonException
     */
    public static User getUserViaID(int id) throws PolygonException {
        String SQL = "SELECT * From Polygon.User WHERE User.userId = ?;";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                String firstname = res.getString("firstname");
                String lastname = res.getString("lastname");
                String phone = res.getString("phone");
                String email = res.getString("email");
                int addressId = res.getInt("userAddress_addressId");
                int uId = res.getInt("userId");
                Login login = getLogin(uId);
                return new User(uId, firstname, lastname, phone, email, addressId, login);
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
     * This method returns information about login from the database
     *
     * @param userId int the userId of the user
     * @return Login object of entity class Login or new user if doesn't exist
     * @throws exceptions.PolygonException
     */
    public static Login getLogin(int userId) throws PolygonException {
        //Henter login info
        String sql = "SELECT * FROM Polygon.Login WHERE User_userId = ?;";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
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
    
    public static void createLogin(String login, String password, int rank, int userId) throws PolygonException{            
        String SQL = "INSERT INTO `Polygon`.`Login` (`username`, `password`, `rank`, `User_userId`) VALUES (?,?,?,?);";
        PreparedStatement stmt;
        try (Connection con = DB.getConnection()) {
            stmt = con.prepareStatement(SQL);
            stmt.setString(1,login);
            stmt.setString(2,password);
            stmt.setInt(3, rank);                                 
            stmt.setInt(4, userId);                                 
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
    }   catch (SQLException ex) {
            throw new PolygonException("Problem in createLogin method: " + ex.getMessage());
        }
    }
    
    

    /**
     * This method returns a User from the database belonging to a specific
     * building
     *
     * @param buildingID int the ID of the building
     * @return User object of entity class User or null
     * @throws exceptions.PolygonException
     */
    public static User getUser(int buildingID) throws PolygonException {
        //Henter info om en bruger fra DB ud fra et givet bygningsID

        String sql = "SELECT User.firstname, User.lastname, User.phone, User.email, Address.addressline, Zipcode.zip, Zipcode.city "
                + "FROM User "
                + "JOIN Building "
                + "ON userId = User_userId "
                + "JOIN Address "
                + "ON User.userAddress_addressId=Address.addressId "
                + "JOIN Zipcode "
                + "ON Address.zipcode_addressId=Zipcode.zipId "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
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
     * @throws exceptions.PolygonException
     */
    public static void updateUser(User u, int buildingID) throws PolygonException {
        //Opdaterer info om en bruger i DB ud fra et givet bygningsID
        String sql = "UPDATE User "
                + "JOIN Building "
                + "ON userId = User_userId "
                + "JOIN Address "
                + "ON User.userAddress_addressId=Address.addressId "
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
     * @throws exceptions.PolygonException
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
     * This method will create a new user
     * @param firstname
     * @param lastname
     * @param phone
     * @param email
     * @param uaddress
     * @param uzip
     * @return userId
     * @throws PolygonException 
     */
    public static int createUser(String firstname, String lastname,String phone,String email, String uaddress, int uzip) throws PolygonException {       
        String sql = "insert into User(`firstname`, `lastname`, `phone`, `email`, `userAddress_addressId`) values(?,?,?,?,?);";
        PreparedStatement stmt;
        try (Connection con = DB.getConnection()) {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,firstname);
            stmt.setString(2,lastname);
            stmt.setString(3, phone);
            stmt.setString(4, email);
            stmt.setInt(5, insertAddress(uzip, uaddress));                      
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            throw new PolygonException("Problem in createUser method, sql: " + ex.getMessage());
        }  
        String sql2 = "SELECT userId FROM User WHERE email=?";
        try (Connection con = DB.getConnection()) {
            stmt = con.prepareStatement(sql2);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return res.getInt("userId");               
            } else {
                System.out.println("No change");
            }
    }   catch (SQLException ex) {
            throw new PolygonException("Problem in createUser method, sql2: " + ex.getMessage());
        } return -1;
}
    
    public static int insertAddress(int zip, String address) throws PolygonException {
        String sql = " insert into userAddress (addressline,zipcode_zipId) values (?,?);";
        String sqlGetAdrID = "SELECT MAX(addressId) FROM Address;";
        int adressID = 0;
        try (Connection con = DB.getConnection();PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, address);
            stmt.setInt(2, findZipID(zip));
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
        try (Connection con = DB.getConnection();PreparedStatement stmt = con.prepareStatement(sqlGetAdrID)) {
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                adressID = res.getInt("MAX(addressId)");
            }
        } catch (SQLException ex) {
            throw new PolygonException("Problem in insertAddress method, sqlGetAdrID: " + ex.getMessage());
        }
        return adressID;
    }
    
    
}
