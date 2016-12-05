
import data.BuildingMapper;
import data.EmailSender;
import data.RequestMapper;
import data.UserMapper;
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
   
          
         
          for (String arg : UserMapper.getMails()) {
              System.out.println(arg);
          }

// EmailSender.sendNewsletter("subject testtestteste ", "messege tetsfjhvbfkj vbdfjhdfljhvfjhvbzxcjvhb xcjhvb xzcjhvbxczjkhvbxcjkhvbkj");
          
          
}
}