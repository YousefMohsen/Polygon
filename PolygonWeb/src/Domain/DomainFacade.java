package Domain;

import data.DatabaseFacade;
import entity.Address;
import entity.Document;
import entity.Building;
import entity.Login;
import entity.Rapport;
import entity.Request;
import entity.User;
import java.util.ArrayList;
import java.util.List;

public class DomainFacade {
    
    public static Request getRequest(int buildingId){
        return DatabaseFacade.getRequest(buildingId);
    }
    
    public static Address getAddress(int addressId){
        return DatabaseFacade.getAddress(addressId);
    }
    
    public static int getZip(int zip){
        return DatabaseFacade.getZip(zip);
    }
    
    public static void updateAddress(int buildingAddressId, int AddressId) {
        DatabaseFacade.updateAddress(buildingAddressId,AddressId);
    }

    public static ArrayList<Building> getBuildings() {
        return (ArrayList<Building>) DatabaseFacade.getBuildings();
    }

    public static Building getBuilding(int id) {
        return DatabaseFacade.getBuilding(id);
    }

    public static User getUser(int id) {
        return DatabaseFacade.getUser(id);
    }
    
    public static User getUserViaId(int id) {
        return DatabaseFacade.getUserViaId(id);
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

    public static void createBuilding(int zip, String address, int userID,String name) {
        DatabaseFacade.createBuilding(zip, address, userID,name);
    }

    public static Login getLogin(String username) {
        return DatabaseFacade.getLogin(username);
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

    public static void deletionRequest(int buildingID) {
        DatabaseFacade.deletionRequest(buildingID);
    }

    public static void cancelDeletionRequest(int buildingID) {
        DatabaseFacade.cancelDeletionRequest(buildingID);
    }

    public static void healthCheckRequest(int buildingID) {
        DatabaseFacade.healthCheckRequest(buildingID);
        EmailSender.sendEmail(buildingID);
    }

    public static List<Building> getDeletionBuildings() {
        return DatabaseFacade.getDeletionBuildings();
    }

    public static void hideBuilding(int buildingID) {
        DatabaseFacade.hideBuilding(buildingID);
    }

    public static List<Building> getBuildingsForUser(int userID, int userRank) {
        return DatabaseFacade.getBuildingsForUser(userID, userRank);
    }

    public static void sendMail(int buildingID) {

    }

    

}
