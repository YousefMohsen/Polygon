/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import entity.Adress;
import entity.Building;
import entity.User;
import entity.Zipcode;
import java.util.ArrayList;

/**
 *
 * @author Yousinho
 */
public class DomainFacade {

    public DomainFacade() {
         demoBuildings();
    }
    
    
    
  private ArrayList<Building> buildings = new ArrayList();
  private ArrayList<User> users = new ArrayList();
 

  
    public ArrayList<Building> getBuildings(){
 
    return buildings;
    //return db.getBuildings;
    }   
    
    
 private void demoBuildings(){//to delete

  Zipcode zip1 = new Zipcode(1,"2800", "Kongens Lyngby") ;
   Adress adr1 = new Adress(1, "Lyngby Hovedgade 1", zip1) ;

     
     
   buildings.add(new Building(1,1,adr1,"rapoort",2));
   buildings.add(new Building(2,4,adr1,"rapoort2",2));
   buildings.add(new Building(3,5,adr1,"rapoort3",1));


    }
    
    public void addBuilding(Building b){
    //db.addBuilding(b);
    buildings.add(b);//to delete

    }

 
}
