
import data.BuildingMapper;
import data.RequestMapper;
import entity.Building;
import entity.Request;
import exceptions.PolygonException;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yousinho
 */
public class toDelete {
      public static void main(String [] args) throws SQLException, ClassNotFoundException, PolygonException{
    
          for (Building b : BuildingMapper.getDeletedBuildings()) {
              System.out.println("\n \n"+b.getBuildingName()+" -  "+b.getAddress().toString());
          }
    
}
}