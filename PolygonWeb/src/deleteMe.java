
import Domain.DomainFacade;
import entity.Building;
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
public class deleteMe {
     public static void main(String [] args) throws SQLException{
   DomainFacade df = new DomainFacade();  
      
         for (Building b : df.getBuildings()) {
                System.out.println("User: "+b.getUser()+"Adress: "+b.getAdressID()+"Rapport: "+b.getRapoort());
         }

  //       df.addBuilding(new Building(4,4,4,"rapoort4",4));
                 
               
             
     
           for (Building b : df.getBuildings()) {
                System.out.println("User: "+b.getUser()+"Adress: "+b.getAdressID()+"Rapport: "+b.getRapoort());
         }

     
     }
}
