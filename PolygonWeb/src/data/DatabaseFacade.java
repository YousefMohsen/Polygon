package data;

import entity.Document;
import entity.Address;
import entity.Building;
import entity.Login;
import entity.Rapport;
import entity.User;
import entity.ZipCode;
import exceptions.PolygonException;
import java.sql.Connection;
import java.util.List;

public class DatabaseFacade {

    public static void createBuilding(int zip, String address, int userID) throws PolygonException {
        BuildingMapper.createBuilding(zip, address, userID);
    }

    public static List<Building> getBuildings() throws PolygonException {
        return BuildingMapper.getBuildings();
    }

    public static Building getBuilding(int buildingID) throws PolygonException {
        return BuildingMapper.getBuilding(buildingID);
    }

    public static void updateBuilding(Building b) throws PolygonException {
        BuildingMapper.updateBuilding(b);
    }

    public static User getUser(int buildingID) throws PolygonException {
        return UserMapper.getUser(buildingID);
    }

    public static User getUserViaId(int id) throws PolygonException {
        return UserMapper.getUserViaID(id);
    }

    public static void updateUser(User u, int buildingID) throws PolygonException {
        UserMapper.updateUser(u, buildingID);
    }

    public static Document getDocument(int buildingID) throws PolygonException {
        return DocumentMapper.getDocument(buildingID);
    }

    public static void updateDocument(Document d, int buildingID) throws PolygonException {
        DocumentMapper.updateDocument(d, buildingID);
    }

    public static int insertAddress(int zip, String address, Connection con) throws PolygonException {
        return BuildingMapper.insertAddress(zip, address, con);
    }

    public static int findZipID(int zip, Connection con) throws PolygonException {
        return BuildingMapper.findZipID(zip, con);
    }

    public static Address loadAddress(int id, Connection con) throws PolygonException {
        return BuildingMapper.loadAddress(id, con);
    }

    public static ZipCode loadZip(int id, Connection con) throws PolygonException {
        return BuildingMapper.loadZip(id, con);
    }

    public static Login getLogin(String username) throws PolygonException {
        return UserMapper.getLogin(username);
    }

    public static void createRapport(int buildingID, Rapport rapport) throws PolygonException {
        RapportMapper.createRapport(buildingID, rapport);
    }

    public static Rapport getRapport(int buildingID) throws PolygonException {
        return RapportMapper.getRapport(buildingID);
    }

    public static void clearRapportData(int buildingID) throws PolygonException {
        RapportMapper.clearRapportData(buildingID);
    }

    public static void deletionRequest(int buildingID) throws PolygonException {
        RequestMapper.sendRequest(1, buildingID);
    }

    public static void cancelDeletionRequest(int buildingID) throws PolygonException {
        RequestMapper.cancelRequest(1, buildingID);
    }

    public static void healthCheckRequest(int buildingID) throws PolygonException {
        RequestMapper.sendRequest(2, buildingID);
    }

    public static List<Building> getDeletionBuildings() throws PolygonException {
        return BuildingMapper.getDeletionBuildings();
    }

    public static void hideBuilding(int buildingID) throws PolygonException {
        BuildingMapper.hideBuilding(buildingID);
    }

    public static List<Building> getBuildingsForUser(int userID, int userRank) throws PolygonException {
        return BuildingMapper.getBuildingsForUser(userID, userRank);
    }
}
