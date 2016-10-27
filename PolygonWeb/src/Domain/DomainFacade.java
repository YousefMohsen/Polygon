/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import data.DatabaseFacade;
import entity.Adress;
import entity.Building;
import entity.User;
import entity.Zipcode;
import java.util.ArrayList;

/**
 *
 * @author Yousinho
 */
public final class DomainFacade {
DatabaseFacade dbf = new DatabaseFacade();
    public DomainFacade() {
         demoToDelete();
    }
    
    
    
  private ArrayList<Building> buildings = new ArrayList();
  private ArrayList<User> users = new ArrayList();
 

  
    public ArrayList<Building> getBuildings(){
 
 return buildings;
    //return (ArrayList<Building>) dbf.getBuildings();
    }   
    
    
 private void demoToDelete(){//to delete

     
     
  Zipcode zip1 = new Zipcode("2800", "Kongens Lyngby") ;
   Adress adr1 = new Adress(1, "Lyngby Hovedgade 1", zip1) ;

 users.add(new User("Leo","Messi","0987656789","messi@cat.com",adr1));
 
     
   buildings.add(new Building(1,1,adr1,"rapoort",2));
   buildings.add(new Building(2,4,adr1,"rapoort2",2));
   buildings.add(new Building(3,5,adr1,"rapoort3",1));


    }
    
    public void addBuilding(String contact,String adress,String zip,String city,String phone){
    //db.addBuilding(b);
           System.out.println("add building"+city);
  Zipcode newZip = new Zipcode(zip, city);// zip id or building id? db.addZip(newZip)
  Adress newAdress = new Adress(adress, newZip) ; // db.addAdress(newAdress)
  //db.addBuilding(b);

 Building newBuilding =  new Building(newAdress,"rapoort3",1);

  buildings.add(newBuilding); //db.adBuilding(newBuilding)
  
    }

 
}
