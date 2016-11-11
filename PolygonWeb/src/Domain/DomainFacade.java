package Domain;

import data.DatabaseFacade;
import entity.Document;
import entity.Address;
import entity.Building;
import entity.User;
import entity.ZipCode;
import java.util.ArrayList;

public class DomainFacade {



    public DomainFacade() {

    }

    private ArrayList<Building> buildings = new ArrayList();
    private ArrayList<User> users = new ArrayList();

    public static ArrayList<Building> getBuildings() {
        


       
        return (ArrayList<Building>) DatabaseFacade.getBuildings();

    }

    public void addBuilding(String contact, String address, int zip, String city, String phone) {
        //db.addBuilding(b);
        System.out.println("add building" + city);
        ZipCode newZip = new ZipCode(zip, city);// zip id or building id? db.addZip(newZip)
        Address newAddress = new Address(address, newZip); // db.addAddress(newAddress)
        //db.addBuilding(b);
        Building newBuilding = new Building(newAddress, "rapoort3", 1);
        buildings.add(newBuilding); //db.adBuilding(newBuilding)
    }

    public static Building getBuilding(int id) {
        return DatabaseFacade.getBuilding(id);
    }

    public static User getUser(int id) {
        return DatabaseFacade.getUser(id);
    }

    public static Document getDocument(int id) {
        return DatabaseFacade.getDocument(id);
    }

    public static void updateBuilding(Building b) {
        DatabaseFacade.updateBuilding(b);
    }
}
