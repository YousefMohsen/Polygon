package Domain;

import data.DatabaseFacade;
import entity.Address;
import entity.Document;
import entity.Building;
import entity.Login;
import entity.Rapport;
import entity.Request;
import entity.User;
import exceptions.PolygonException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomainFacade {

    public static ArrayList<User> getUsers() throws PolygonException {
        return DatabaseFacade.getUsers();
    }

    public static ArrayList<Request> getRequest(int buildingId) throws PolygonException {
        return DatabaseFacade.getRequest(buildingId);
    }

    public static Address getAddress(int addressId) throws PolygonException {
        return DatabaseFacade.getAddress(addressId);
    }

    public static int getZip(int zip) throws PolygonException {
        return DatabaseFacade.getZip(zip);
    }

    public static void updateAddress(int buildingAddressId, int AddressId) throws PolygonException {
        DatabaseFacade.updateAddress(buildingAddressId, AddressId);
    }

    public static ArrayList<Building> getBuildings() throws PolygonException {
        return (ArrayList<Building>) DatabaseFacade.getBuildings();
    }

    public static Building getBuilding(int id) throws PolygonException {
        return DatabaseFacade.getBuilding(id);
    }

    public static User getUser(int id) throws PolygonException {
        return DatabaseFacade.getUser(id);
    }

    public static User getUserViaId(int id) throws PolygonException {
        return DatabaseFacade.getUserViaId(id);
    }

    public static void createDocument(Document d) throws PolygonException {
        DatabaseFacade.createDocument(d);
    }

    public static Document getDocument(int id) throws PolygonException, IOException {
        return DatabaseFacade.getDocument(id);
    }

//    public static void updateDocument(Document d, int buildingID) throws PolygonException {
//        DatabaseFacade.updateDocument(d, buildingID);
//    }

    public static void updateBuilding(Building b) throws PolygonException {
        DatabaseFacade.updateBuilding(b);
    }

    public static void updateUser(User u, int buildingID) throws PolygonException {
        DatabaseFacade.updateUser(u, buildingID);
    }

    public static void createBuilding(int zip, String address, int userID, String name) throws PolygonException {
        DatabaseFacade.createBuilding(zip, address, userID, name);
    }
    
    public static int createUser(String firstname, String lastname,String phone,String email, String uaddress, int uzip) throws PolygonException {
        return DatabaseFacade.createUser(firstname,lastname,phone,email,uaddress,uzip);
    }

    public static Login getLogin(int userId) throws PolygonException {
        return DatabaseFacade.getLogin(userId);
    }

    public static Login getLogin(String username) throws PolygonException {
        return DatabaseFacade.getLogin(username);
    }

    public static void createRapport(int buildingID, Rapport rapport) throws PolygonException {
        DatabaseFacade.createRapport(buildingID, rapport);
    }

    public static Rapport getRapport(int buildingID) throws PolygonException {
        return DatabaseFacade.getRapport(buildingID);
    }

    public static void clearRapportData(int buildingID) throws PolygonException {
        DatabaseFacade.clearRapportData(buildingID);
    }

    public static void deletionRequest(int buildingID) throws PolygonException {
        DatabaseFacade.deletionRequest(buildingID);
    }

    public static void cancelDeletionRequest(int buildingID) throws PolygonException {
        DatabaseFacade.cancelDeletionRequest(buildingID);
    }

    public static void healthCheckRequest(int buildingID) throws PolygonException {
        DatabaseFacade.healthCheckRequest(buildingID);
    }

    public static List<Building> getDeletionBuildings() throws PolygonException {
        return DatabaseFacade.getDeletionBuildings();
    }

    public static void hideBuilding(int buildingID) throws PolygonException {
        DatabaseFacade.hideBuilding(buildingID);
    }

    public static List<Building> getBuildingsForUser(int userID, int userRank) throws PolygonException {
        return DatabaseFacade.getBuildingsForUser(userID, userRank);
    }

    public static void sendMail(int buildingID) throws PolygonException {

    }

    public static void createLogin(String login, String password, int rank, int userId) throws PolygonException {
        DatabaseFacade.createLogin(login,password,rank,userId);
    }

    
}
