package data;

import entity.Address;
import entity.User;
import entity.ZipCode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    //Henter info om en bruger fra DB ud fra et givet bygningsID
    public static User getUser(int buildingID) {
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
        }
        return null;
    }
    
    //Opdaterer info om en bruger i DB ud fra et givet bygningsID
    public static void updateUser(User u, int buildingID) {
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
            stmt.setString(7, u.getAddress().getZipCode().getCity());
            stmt.setInt(8, buildingID);
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
