/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joaci
 */
public class DocumentMapper {
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

    //Opdaterer info om et dokument i DB
    public static void updateDocument(Document d) {
        String sql = "UPDATE Document "
                + "SET fileURL=?, "
                + "note=? "
                + "WHERE documentId=?";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, d.getFileURL());
            stmt.setString(2, d.getNote());
            stmt.setInt(3, d.getId());
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
