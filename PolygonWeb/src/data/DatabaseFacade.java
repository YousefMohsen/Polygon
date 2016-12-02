package data;

import entity.Document;
import entity.Address;
import entity.Building;
import entity.Login;
import entity.Rapport;
import entity.Request;
import entity.User;
import entity.ZipCode;
import exceptions.PolygonException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseFacade {
    
    public static ArrayList<User> getUsers() throws PolygonException{
        return UserMapper.getUsers();
    }

    public static ArrayList<Request> getRequest(int buildingId) throws PolygonException {
        return RequestMapper.getRequest(buildingId);
    }

    public static Address getAddress(int addressId) throws PolygonException {
        return AddressMapper.getUserAddress(addressId);
    }

    public static void updateAddress(int buildingAddressId, int AddressId) throws PolygonException {
        AddressMapper.updateAdress(buildingAddressId, AddressId);
    }

    public static int getZip(int zip) throws PolygonException {
        return AddressMapper.getZipId(zip);
    }

    public static void createBuilding(int zip, String address, int userID, String name) throws PolygonException {      
            BuildingMapper.createBuilding(zip, address, userID, name);        
    }
    
    public static int createUser(String firstname, String lastname,String phone,String email, String uaddress, int uzip) throws PolygonException {
        return UserMapper.createUser(firstname,lastname,phone,email,uaddress,uzip);
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

    public static void createDocument(Document d) throws PolygonException {
        DocumentMapper.createDocument(d);
    }
    
    public static Document getDocument(int buildingID) throws PolygonException, IOException {
        return DocumentMapper.getDocument(buildingID);
    }

//    public static void updateDocument(Document d, int buildingID) throws PolygonException {
//        DocumentMapper.updateDocument(d, buildingID);
//    }

    public static int insertAddress(int zip, String address) throws PolygonException {
        return BuildingMapper.insertAddress(zip, address);
    }

    public static int findZipID(int zip) throws PolygonException {
        return BuildingMapper.findZipID(zip);
    }

    public static Address loadAddress(int id, Connection con) throws PolygonException {
        return BuildingMapper.loadAddress(id, con);
    }

    public static ZipCode loadZip(int id, Connection con) throws PolygonException {
        return BuildingMapper.loadZip(id, con);
    }

    public static Login getLogin(int userId) throws PolygonException {
        return UserMapper.getLogin(userId);
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
        EmailSender.sendEmail(buildingID);
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

    public static void createLogin(String login, String password, int rank, int userId) throws PolygonException {
        UserMapper.createLogin(login, password, rank, userId);
    }

    
}
