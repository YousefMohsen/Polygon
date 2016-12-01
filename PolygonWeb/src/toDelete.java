
import data.RequestMapper;
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
    
          for (Request r : RequestMapper.getRequest(2)) {
              System.out.println(r.getId());
          }
    
}
}