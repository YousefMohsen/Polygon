
import Domain.DomainFacade;
import data.DatabaseFacade;
import entity.Adress;
import entity.Building;
import entity.Zipcode;
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
  DatabaseFacade dbf = new DatabaseFacade();
  
//  
//  for(int i = 1; i<3; i++){
//  Adress adr = dbf.loadAdress(i);
//      System.out.println("////+\n"+adr.toString());
//  
//  }
  
  //loadBuilding
  //System.out.println( dbf.getBuildings().get(0).getAdress().getZipCode().getCity());
  
  //Load adress
// Adress adr = dbf.loadAdress(1);
// System.out.println( adr.getAdressline() + " - " +adr.getZipCode().getCity() + " - " +adr.getZipCode().getZip() );
//         
         
         


        //add building 
//        if(dbf.loadZip(0)==null){System.out.println("null"); }
//        
//        else{System.out.println(dbf.loadZip(0).getCity());}
//         for (Building b : df.getBuildings()) {
//System.out.println(b.getAdress().getAdressline()+" "+b.getAdress().getZipCode().getZip()+" "+b.getAdress().getZipCode().getCity());
//         }
//
//  //       df.addBuilding(new Building(4,4,4,"rapoort4",4));
//                 
//               
// df.addBuilding("Messi","Camp nou street","09771","Barcelona","009182739");
//
//
//     
           for (Building b : df.getBuildings()) {
System.out.println(b.getAdress().getAdressline()+" "+b.getAdress().getZipCode().getZip()+" "+b.getAdress().getZipCode().getCity());
         }
 

     
     }
}
