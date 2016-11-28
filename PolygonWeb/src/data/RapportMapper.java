/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Rapport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Asger
 */
class RapportMapper {

    public static Rapport getRapport(int buildingID){
        String sql1 = "SELECT Building.buildingName, Address.addressline, Zipcode.zip, Zipcode.city, Damage.*, BuildingInfo.*, Humidity.*, RapportInfo.*"
                + "FROM Building "
                + "JOIN Address ON Building.Address_addressId=Address.addressId "
                + "JOIN Zipcode ON Address.zipcode_addressId=Zipcode.zipId "
                + "JOIN Damage ON Damage.Building_buildingId=buildingId "
                + "JOIN BuildingInfo ON BuildingInfo.Building_buildingId=buildingId "
                + "JOIN Humidity ON Humidity.Building_buildingId=buildingId "
                + "JOIN Document ON Document.Building_buildingId=buildingId "
                + "JOIN RapportInfo ON RapportInfo.Document_documentId=documentId "
                + "WHERE buildingId=? AND documentId=(SELECT documentId FROM Document ORDER BY documentId DESC LIMIT 1)";
        
        String sql2 = "SELECT * FROM BuildingExamination WHERE Building_buildingId = ?";
        String sql3 = "SELECT * FROM Conclusion WHERE Building_buildingId = ?";
        Rapport rapport = new Rapport();
        
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql1)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            if(res.next()) {
                rapport.setBuildingName(res.getString("buildingName"));
                rapport.setAddress(res.getString("addressline"));
                rapport.setZip(res.getString("zip") + "/" + res.getString("city"));
                rapport.setRoom(res.getString("room"));
                rapport.setCommentRoom(res.getInt("room"));
                rapport.setYesNoRoomDamage(res.getInt("roomDamaged"));
                rapport.setWhen(res.getString("when"));
                rapport.setWhere(res.getString("where"));
                rapport.setWhatHappend(res.getString("whatHappend"));
                rapport.setWhatRepaired(res.getString("whatRepaired"));
                rapport.setDamageType(res.getInt("DamageNr"));
                rapport.setOtherDamageType(res.getString("other"));
                rapport.setCategorize(res.getInt("categorized"));
                rapport.setBuildYear(res.getInt("buildYear"));
                rapport.setBuildingArea(res.getDouble("area"));
                rapport.setBuildingUse(res.getString("use"));
                rapport.setHumidityYesNo(res.getInt("scanning"));
                rapport.setDescriptionScanning(res.getString("humidityScan"));
                rapport.setDescriptionMeasuring(res.getString("point"));
                rapport.setDescriptionHumidity(res.getString("description"));
                rapport.setWriter(res.getString("author"));
                rapport.setCollaborator(res.getString("cooperation"));
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql2)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            int count = 0;
            while(res.next()) {
                switch(count) {
                    case 0:
                        rapport.setCommentRoof(res.getInt("comments"));
                        rapport.setPictureRoof(res.getInt("picture"));
                        rapport.setDescriptionRoof(res.getString("description"));
                        break;
                    case 1:
                        rapport.setCommentOuterwall(res.getInt("comments"));
                        rapport.setPictureOuterwall(res.getInt("picture"));
                        rapport.setDescriptionOuterwall(res.getString("description"));
                        break;
                    case 2:
                        rapport.setCommentWall(res.getInt("comments"));
                        rapport.setPictureWall(res.getInt("picture"));
                        rapport.setDescriptionWall(res.getString("description"));
                        break;
                    case 3:
                        rapport.setCommentCeiling(res.getInt("comments"));
                        rapport.setPictureCeiling(res.getInt("picture"));
                        rapport.setDescriptionCeiling(res.getString("description"));
                        break;
                    case 4:
                        rapport.setCommentFloor(res.getInt("comments"));
                        rapport.setPictureFloor(res.getInt("picture"));
                        rapport.setDescriptionFloor(res.getString("description"));
                        break;
                    case 5:
                        rapport.setCommentWindows(res.getInt("comments"));
                        rapport.setPictureWindows(res.getInt("picture"));
                        rapport.setDescriptionWindows(res.getString("description"));
                        break;
                    case 6:
                        rapport.setOtherReview(res.getString("reviewing"));
                        rapport.setCommentOther(res.getInt("comments"));
                        rapport.setPictureOther(res.getInt("picture"));
                        rapport.setDescriptionOther(res.getString("description"));
                        break;
                    case 7:
                        rapport.setOtherReview2(res.getString("reviewing"));
                        rapport.setCommentOther2(res.getInt("comments"));
                        rapport.setPictureOther2(res.getInt("picture"));
                        rapport.setDescriptionOther2(res.getString("description"));
                        break;
                }
                count++;
            }
            System.out.println("count: " +count);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        
        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql3)) {
            stmt.setInt(1, buildingID);
            ResultSet res = stmt.executeQuery();
            int count = 0;
            while(res.next()) {
                switch(count) {
                    case 0:
                        rapport.setConclusionRoom1(res.getString("room"));
                        rapport.setConclusionConclusion1(res.getString("recommendations"));
                        break;
                    case 1:
                        rapport.setConclusionRoom2(res.getString("room"));
                        rapport.setConclusionConclusion2(res.getString("recommendations"));
                        break;
                    case 2:
                        rapport.setConclusionRoom3(res.getString("room"));
                        rapport.setConclusionConclusion3(res.getString("recommendations"));
                        break;
                    case 3:
                        rapport.setConclusionRoom4(res.getString("room"));
                        rapport.setConclusionConclusion4(res.getString("recommendations"));
                        break;
                    case 4:
                        rapport.setConclusionRoom5(res.getString("room"));
                        rapport.setConclusionConclusion5(res.getString("recommendations"));
                        break;
                    case 5:
                        rapport.setConclusionRoom6(res.getString("room"));
                        rapport.setConclusionConclusion6(res.getString("recommendations"));
                        break;
                    case 6:
                        rapport.setConclusionRoom7(res.getString("room"));
                        rapport.setConclusionConclusion7(res.getString("recommendations"));
                        break;
                    case 7:
                        rapport.setConclusionRoom8(res.getString("room"));
                        rapport.setConclusionConclusion8(res.getString("recommendations"));
                        break;
                }
                count++;
            }
            System.out.println("count: " +count);
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());
        }
        return rapport;
    }
    
    public static void createRapport(int buildingID, Rapport rapport) {
        
        String sql = "INSERT INTO Damage (room,comments,roomDamaged,Damage.when,Damage.where,whatHappend,whatRepaired,DamageNr,other,Building_buildingId,categorized) VALUES (?,?,?,?,?,?,?,?,?,?,?);"
                   + "INSERT INTO BuildingInfo (buildYear,area,BuildingInfo.use,Building_buildingId) VALUES (?,?,?,?);"
                   + "INSERT INTO Humidity (scanning,humidityScan,point,description,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO BuildingExamination (reviewing,description,comments,picture,Building_buildingId) VALUES (?,?,?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Conclusion (room,recommendations,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO Document (fileURL,note,Building_buildingId) VALUES (?,?,?);"
                   + "INSERT INTO RapportInfo (date,author,cooperation,document_documentId) VALUES (NOW(),?,?, (SELECT documentId FROM Document ORDER BY documentId DESC LIMIT 1));";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, rapport.getRoom());
            stmt.setInt(2, rapport.getCommentRoom());
            stmt.setInt(3, rapport.getYesNoRoomDamage());
            stmt.setString(4, rapport.getWhen());
            stmt.setString(5, rapport.getWhere());
            stmt.setString(6, rapport.getWhatHappend());
            stmt.setString(7, rapport.getWhatRepaired());
            stmt.setInt(8, rapport.getDamageType());
            stmt.setString(9, rapport.getOtherDamageType());
            stmt.setInt(10, buildingID);
            stmt.setInt(11, rapport.getCategorize());
            
            stmt.setInt(12, rapport.getBuildYear());
            stmt.setDouble(13, rapport.getBuildingArea());
            stmt.setString(14, rapport.getBuildingUse());
            stmt.setInt(15, buildingID);
            
            stmt.setInt(16, rapport.getHumidityYesNo());
            stmt.setString(17, rapport.getDescriptionScanning());
            stmt.setString(18, rapport.getDescriptionMeasuring());
            stmt.setString(19, rapport.getDescriptionHumidity());
            stmt.setInt(20, buildingID);
            
            stmt.setString(21, "Tag");
            stmt.setString(22, rapport.getDescriptionRoof());
            stmt.setInt(23, rapport.getCommentRoof());
            stmt.setInt(24, rapport.getPictureRoof());
            stmt.setInt(25, buildingID);
            
            stmt.setString(26, "Ydervægge");
            stmt.setString(27, rapport.getDescriptionOuterwall());
            stmt.setInt(28, rapport.getCommentOuterwall());
            stmt.setInt(29, rapport.getPictureOuterwall());
            stmt.setInt(30, buildingID);
            
            stmt.setString(31, "Vægge");
            stmt.setString(32, rapport.getDescriptionWall());
            stmt.setInt(33, rapport.getCommentWall());
            stmt.setInt(34, rapport.getPictureWall());
            stmt.setInt(35, buildingID);
            
            stmt.setString(36, "Loft");
            stmt.setString(37, rapport.getDescriptionCeiling());
            stmt.setInt(38, rapport.getCommentCeiling());
            stmt.setInt(39, rapport.getPictureCeiling());
            stmt.setInt(40, buildingID);
            
            stmt.setString(41, "Gulv");
            stmt.setString(42, rapport.getDescriptionFloor());
            stmt.setInt(43, rapport.getCommentFloor());
            stmt.setInt(44, rapport.getPictureFloor());
            stmt.setInt(45, buildingID);
            
            stmt.setString(46, "VinduerDøre");
            stmt.setString(47, rapport.getDescriptionWindows());
            stmt.setInt(48, rapport.getCommentWindows());
            stmt.setInt(49, rapport.getPictureWindows());
            stmt.setInt(50, buildingID);
            
            stmt.setString(51, rapport.getOtherReview());
            stmt.setString(52, rapport.getDescriptionOther());
            stmt.setInt(53, rapport.getCommentOther());
            stmt.setInt(54, rapport.getPictureOther());
            stmt.setInt(55, buildingID);
            
            stmt.setString(56, rapport.getOtherReview2());
            stmt.setString(57, rapport.getDescriptionOther2());
            stmt.setInt(58, rapport.getCommentOther2());
            stmt.setInt(59, rapport.getPictureOther2());
            stmt.setInt(60, buildingID);
            
            stmt.setString(61, rapport.getConclusionRoom1());
            stmt.setString(62, rapport.getConclusionConclusion1());
            stmt.setInt(63, buildingID);
            
            stmt.setString(64, rapport.getConclusionRoom2());
            stmt.setString(65, rapport.getConclusionConclusion2());
            stmt.setInt(66, buildingID);
            
            stmt.setString(67, rapport.getConclusionRoom3());
            stmt.setString(68, rapport.getConclusionConclusion3());
            stmt.setInt(69, buildingID);
            
            stmt.setString(70, rapport.getConclusionRoom4());
            stmt.setString(71, rapport.getConclusionConclusion4());
            stmt.setInt(72, buildingID);
            
            stmt.setString(73, rapport.getConclusionRoom5());
            stmt.setString(74, rapport.getConclusionConclusion5());
            stmt.setInt(75, buildingID);
            
            stmt.setString(76, rapport.getConclusionRoom6());
            stmt.setString(77, rapport.getConclusionConclusion6());
            stmt.setInt(78, buildingID);
            
            stmt.setString(79, rapport.getConclusionRoom7());
            stmt.setString(80, rapport.getConclusionConclusion7());
            stmt.setInt(81, buildingID);
            
            stmt.setString(82, rapport.getConclusionRoom8());
            stmt.setString(83, rapport.getConclusionConclusion8());
            stmt.setInt(84, buildingID);
            
            stmt.setString(85, "rapport_" + rapport.getBuildingName() + rapport.getRapportNr() + ".pdf");
            stmt.setString(86, "rapport as pdf");
            stmt.setInt(87, buildingID);
            
            stmt.setString(88, rapport.getWriter());
            stmt.setString(89, rapport.getCollaborator());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
        
        String sqlDelete = "DELETE FROM BuildingExamination WHERE reviewing = '';"
                         + "DELETE FROM Conclusion WHERE room = ''";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sqlDelete)) {
            
            int rowsAffectedDelete = stmt.executeUpdate();
            if (rowsAffectedDelete > 0) {
                System.out.println("Element removed");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
    }
    
    public static void clearRapportData(int buildingID) {
        String sqlDelete = "DELETE FROM BuildingExamination WHERE Building_buildingId = ?;"
                         + "DELETE FROM Conclusion WHERE Building_buildingId = ?;"
                         + "DELETE FROM Damgage WHERE Building_buildingId = ?;"
                         + "DELETE FROM BuildingInfo WHERE Building_buildingId = ?;"
                         + "DELETE FROM Humidity WHERE Building_buildingId = ?;"
                         + "DELETE FROM Document WHERE Building_buildingId = ?";

        try (Connection con = DB.getConnection();
                PreparedStatement stmt = con.prepareStatement(sqlDelete)) {
            stmt.setInt(1, buildingID);
            stmt.setInt(2, buildingID);
            stmt.setInt(3, buildingID);
            stmt.setInt(4, buildingID);
            stmt.setInt(5, buildingID);
            stmt.setInt(6, buildingID);
            
            int rowsAffectedDelete = stmt.executeUpdate();
            if (rowsAffectedDelete > 0) {
                System.out.println("Element removed");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
    }
}