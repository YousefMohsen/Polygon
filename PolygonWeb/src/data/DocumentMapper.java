package data;

import entity.Document;
import exceptions.PolygonException;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class deals with all data about a document.
 */
public class DocumentMapper {

    /**
     * This method returns a document from the database belonging to a specific
     * building
     *
     * @param buildingID int the ID of the building
     * @return Document object of entity class Document
     * @throws exceptions.PolygonException
     * @throws java.io.FileNotFoundException
     */
    public static Document getDocument(int buildingID) throws PolygonException, FileNotFoundException, IOException {
        byte[] byteArray = null;
        //Henter info om et dokument fra DB ud fra et givet bygningsID
        String sql = "SELECT file, note "
                + "FROM Document "
                + "WHERE Building_buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                byteArray = res.getBytes("file");
                InputStream file = new ByteArrayInputStream(byteArray);
                String note = res.getString("note");
                return new Document(file, note, buildingID);
            } else {     //if building has no file or note
                System.out.println("INTET DOKUMENT!!!");
                return new Document(null, "Skriv en note her", buildingID);
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in getDocument method: " + ex.getMessage());
        }
    }

    /**
     * This method updates the note about a specific document based on the
     * building ID in the database
     *
     * @param d Document the document that is going to be updated
     * @throws exceptions.PolygonException
     */
    public static void updateDocumentNote(Document d) throws PolygonException {
        //Opdaterer info om et dokument i DB ud fra et givet bygningsID
        String sql = "UPDATE Document "
                + "SET note=? "
                + "WHERE Building_buildingId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, d.getNote());
            stmt.setInt(2, d.getBuildingId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
            throw new PolygonException("Problem in updateDocuemntNote method: " + ex.getMessage());
        }
    }

    public static void createDocument(Document d) throws PolygonException {
        //Indsætter filen, noten og ID'et i DB   
        String sql = "INSERT INTO Document "
                + "(file, note, Building_buildingId) "
                + "VALUES (?, ?, ?);";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setBlob(1, d.getFile());
            stmt.setString(2, d.getNote());
            stmt.setInt(3, d.getBuildingId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
            throw new PolygonException("Problem in createDocuemnt method: " + ex.getMessage());
        }

    }
}
