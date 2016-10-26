/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import entity.Building;
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
    
   
  
    public ArrayList<Building> getBuildings(){
 
    return buildings;
    //return db.getBuildings;
    }   
    
    
 private void demoBuildings(){//to delete

   buildings.add(new Building(1,1,1,"rapoort",2));
   buildings.add(new Building(2,4,2,"rapoort2",2));
   buildings.add(new Building(3,5,3,"rapoort3",1));


    }
    
    public void addBuilding(Building b){
    //db.addBuilding(b);
    buildings.add(b);//to delete

    }

 
}
