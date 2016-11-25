package data;

import entity.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentMapper {
    
    //Henter info om et dokument fra DB ud fra et givet bygningsID
    public static Document getDocument(int buildingID) {
        String sql = "SELECT fileURL, note "
                + "FROM Document "
                + "JOIN Building "
                + "ON buildingId = Building_buildingId "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {System.out.println("document true");
                String fileURL = res.getString("fileURL");
                String note = res.getString("note");
                return new Document(buildingID, fileURL, note);
            } else{     //if building has no file or note
                System.out.println("document false");
                return new Document(buildingID, " ", " ");}
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return null;
    }
    
    //Opdaterer info om et dokument i DB ud fra et givet bygningsID
    public static void updateDocument(Document d, int buildingID) {
        String sql = "UPDATE Document "
                + "JOIN Building "
                + "ON buildingId = Building_buildingId "
                + "SET fileURL=?, "
                + "note=? "
                + "WHERE buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, d.getFileURL());
            stmt.setString(2, d.getNote());
            stmt.setInt(3, buildingID);
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
