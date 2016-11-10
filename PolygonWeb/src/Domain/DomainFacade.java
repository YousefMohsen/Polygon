package Domain;

import data.DatabaseFacade;
import data.Document;
import entity.Address;
import entity.Building;
import entity.User;
import entity.ZipCode;
import java.util.ArrayList;

public class DomainFacade {

    DatabaseFacade dbf = new DatabaseFacade();

    public DomainFacade() {
        demoToDelete();
    }

    private ArrayList<Building> buildings = new ArrayList();
    private ArrayList<User> users = new ArrayList();

    public ArrayList<Building> getBuildings() {

// return buildings;
        return (ArrayList<Building>) dbf.getBuildings();
    }

    private void demoToDelete() {//to delete

        ZipCode zip1 = new ZipCode(2800, "Kongens Lyngby");
        Address adr1 = new Address(1, "Lyngby Hovedgade 1", zip1);

        users.add(new User("Leo", "Messi", "0987656789", "messi@cat.com", adr1));

        buildings.add(new Building(1, 1, adr1, "rapoort", 2));
        buildings.add(new Building(2, 4, adr1, "rapoort2", 2));
        buildings.add(new Building(3, 5, adr1, "rapoort3", 1));

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

}
