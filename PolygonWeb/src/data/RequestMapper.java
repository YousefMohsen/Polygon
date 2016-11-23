/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.BuildingMapper.insertAddress;
import entity.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Yousinho
 */
public class RequestMapper {
    
 public static void sendRequest(int requestType, int buildingID) {//1=deletion, 2=health check

        String sql = "insert into Request_has_Building "
                + "(Request_requestId,Building_buildingId) "
                + "values(?,?);";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1,requestType);
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
    
 
 
 
    
    
 
    
}
