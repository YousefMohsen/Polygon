package Domain;

import data.DatabaseFacade;
import data.UserMapper;
import entity.Document;
import entity.Building;
import entity.Login;
import entity.Rapport;
import entity.User;
import java.util.ArrayList;

public class DomainFacade {

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

    public static void updateUser(User u, int buildingID) {
        DatabaseFacade.updateUser(u, buildingID);
    }
    
    public static void updateDocument(Document d, int buildingID) {
        DatabaseFacade.updateDocument(d, buildingID);
    }

    public static void createBuilding(int zip, String address) {
        DatabaseFacade.createBuilding(zip, address);
    }
    
    public static Login getLogin(String username){
        return UserMapper.getLogin(username);
     }
    
    public static void createRapport(int buildingID, Rapport rapport) {
        DatabaseFacade.createRapport(buildingID, rapport);
    }
    
    public static Rapport getRapport(int buildingID) {
        return DatabaseFacade.getRapport(buildingID);
    }
    
    public static void clearRapportData(int buildingID) {
        DatabaseFacade.clearRapportData(buildingID);
    }
}
