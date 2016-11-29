package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestMapper {

    public static void sendRequest(int requestType, int buildingID) {//1=deletion, 2=health check
        System.out.println(requestType + "hejh" + buildingID);
        String sql = "insert into Request_has_Building "
                + "(Request_requestId,Building_buildingId) "
                + "values(?,?);";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, requestType);
            stmt.setInt(2, buildingID); //0 = shown, 1=hidden

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

    public static void cancelRequest(int requestType, int buildingID) {//deletes a given request from table Request_has_Building 
//1=deletion, 2=health check

        String sql = "Delete FROM Request_has_Building "
                + " WHERE Request_requestId=? And Building_buildingId =?; ";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, requestType);
            stmt.setInt(2, buildingID); //0 = shown, 1=hidden

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element deleted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
    }

}
