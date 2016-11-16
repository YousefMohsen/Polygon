package data;

import entity.Document;
import entity.Address;
import entity.Building;
import entity.User;
import entity.ZipCode;
import java.sql.Connection;
import java.util.List;

public class DatabaseFacade {   
    
     public static void createBuilding(int zip, String address) {
         BuildingMapper.createBuilding(zip, address);
     }
    
    public static List<Building> getBuildings() {   
        return BuildingMapper.getBuildings();
    }
    
    public static Building getBuilding(int buildingID) {
        return BuildingMapper.getBuilding(buildingID);
    }
    
    public static void updateBuilding(Building b) {
        BuildingMapper.updateBuilding(b);
    }
    
    public static User getUser(int userID) {
        return UserMapper.getUser(userID);
    }
    
    public static void updateUser(User u) {
        UserMapper.updateUser(u);
    }
    
    public static Document getDocument(int documentID) {
        return DocumentMapper.getDocument(documentID);
    }
    
    public static void updateDocument(Document d) {
        DocumentMapper.updateDocument(d);
    }
    
    public static int insertAddress(int zip, String address, Connection con) {
        return BuildingMapper.insertAddress(zip, address, con);
    }

    public static int findZipID(int zip, Connection con) {
        return BuildingMapper.findZipID(zip, con);
    }
    
     public static Address loadAddress(int id, Connection con) {
         return BuildingMapper.loadAddress(id, con);
     }
     
     public static ZipCode loadZip(int id, Connection con) { 
         return BuildingMapper.loadZip(id, con);
     }
}