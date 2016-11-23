/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Rapport;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Asger
 */
class RapportMapper {

    public static void createRapport(int buildingID, Rapport rapport) {
        
        String sql = "INSERT INTO Damage (room,comments,roomDamaged,when,where,whatHappend,whatRepaired,DamageNr,other,Building_buildingId,categorized) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"
                   + "INSERT INTO BuildingInfo (buildYear,area,use,Building_buildingId) VALUES (?,?,?,?);"
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
                   + "INSERT INTO RapportInfo (date,author,cooperation,document_documentId) VALUES (?,?,?, (SELECT TOP(1) documentId FROM Document ORDER BY documentId DESC));";

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
            
            stmt.setDate(88, Date.valueOf(LocalDate.MAX));
            stmt.setString(89, rapport.getWriter());
            stmt.setString(90, rapport.getCollaborator());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException ex) {
            System.out.println("Element not gotten: " + ex.getMessage());

        }
    }
}