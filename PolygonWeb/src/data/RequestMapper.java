package data;

import entity.Request;

import exceptions.PolygonException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class deals with all data about a request.
 */
public class RequestMapper {

    /**
     * This method sends a request for deletion or health check of a building
     * and saves it in the database
     *
     * @param requestType int the type of request - 1 is a deletion request and
     * 2 is a health check request
     * @param buildingID int the ID of the building with the request
     * @throws exceptions.PolygonException
     */
    public static void sendRequest(int requestType, int buildingID) throws PolygonException {//1=deletion, 2=health check        
        String sql = "insert into Request_has_Building (Request_requestId,Building_buildingId) values(?,?);";

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
     * This method returns a request from the database belonging to a specific
     * building
     *
     * @param buildingId int the ID of the building
     * @return Request object of entity class Request or null
     * @throws exceptions.PolygonException
     */
    public static Request getRequest(int buildingId) throws PolygonException {
        System.out.println(buildingId);
        String sql = "SELECT Request_requestId FROM Request_has_Building WHERE Building_buildingID = ?;";
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, buildingId);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                System.out.println(res.getInt("Request_requestId") + "HEJ");
                int requestId = res.getInt("Request_requestId");
                return new Request(requestId);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
            throw new PolygonException("Problem in sendRequest method: " + ex.getMessage());

        }
    }

    /**
     * This method deletes a request for deletion or health check of a building
     * from the database
     *
     * @param requestType int the type of request - 1 is a deletion request and
     * 2 is a health check request
     * @param buildingID int the ID of the building with the request
     * @throws exceptions.PolygonException
     */
    public static void cancelRequest(int requestType, int buildingID) throws PolygonException {//deletes a given request from table Request_has_Building 
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
            throw new PolygonException("Problem in cancelRequest method: " + ex.getMessage());
        }
    }

}
