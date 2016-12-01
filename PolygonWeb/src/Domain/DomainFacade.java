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
import java.util.ArrayList;
import java.util.List;

public class DomainFacade {

    public static Request getRequest(int buildingId) throws PolygonException {
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

    public static Document getDocument(int id) throws PolygonException {
        return DatabaseFacade.getDocument(id);
    }

    public static void updateBuilding(Building b) throws PolygonException {
        DatabaseFacade.updateBuilding(b);
    }

    public static void updateUser(User u, int buildingID) throws PolygonException {
        DatabaseFacade.updateUser(u, buildingID);
    }

    public static void updateDocument(Document d, int buildingID) throws PolygonException {
        DatabaseFacade.updateDocument(d, buildingID);
    }

    public static void createBuilding(int zip, String address, int userID, String name) throws PolygonException {
        DatabaseFacade.createBuilding(zip, address, userID, name);
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
}
