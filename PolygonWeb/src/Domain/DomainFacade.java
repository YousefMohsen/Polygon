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

    public static void updateUser(User u) {
        DatabaseFacade.updateUser(u);
    }

    public static void updateDocument(Document d) {
        DatabaseFacade.updateDocument(d);
    }

    public static void createBuilding(int zip, String address) {

        DatabaseFacade.createBuilding(zip, address);

    }

}
