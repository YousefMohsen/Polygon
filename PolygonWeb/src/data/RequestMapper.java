package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class contains and deals with all data about a request
 */
public class RequestMapper {

    /**
     * This method sends a request for deletion or health check of a building
     * and saves it in the database
     *
     * @param requestType int the type of request - 1 is a deletion request and
     * 2 is a health check request
     * @param buildingID int the ID of the building with the request
     * @throws EXCEPTION
     */
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

    /**
     * This method deletes a request for deletion or health check of a building
     * from the database
     *
     * @param requestType int the type of request - 1 is a deletion request and
     * 2 is a health check request
     * @param buildingID int the ID of the building with the request
     * @throws EXCEPTION
     */
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
