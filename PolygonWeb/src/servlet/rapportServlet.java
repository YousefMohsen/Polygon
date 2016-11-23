/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Domain.DomainFacade;
import entity.Rapport;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asger
 */
@WebServlet(name = "rapportServlet", urlPatterns = {"/rapportServlet"})
public class rapportServlet extends HttpServlet {
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //HttpSession session = request.getSession(true);
            int buildingID = 5;//Integer.parseInt((String) session.getAttribute("ID"));
            
            String buildingName = request.getParameter("nameOnBuilding");
            String address = request.getParameter("address");
            String zip = request.getParameter("zipCity");
            
            int buildYear = Integer.parseInt(request.getParameter("buildYear"));
            double buildingArea = Double.parseDouble(request.getParameter("buildingArea"));
            String buildingUse = request.getParameter("buildingUse");
            
            int commentRoof = 1;
            if(request.getParameter("comments1") != null ){
                commentRoof = Integer.parseInt(request.getParameter("comments1"));
            }
            int pictureRoof = 0;
            if(request.getParameter("picture1") != null ){
                pictureRoof = Integer.parseInt(request.getParameter("picture1"));
            }
            String descriptionRoof = request.getParameter("roofDescription");
            
            int commentOuterwall = 1;
            if(request.getParameter("comments2") != null ){
                commentOuterwall = Integer.parseInt(request.getParameter("comments2"));
            }
            int pictureOuterwall = 0;
            if(request.getParameter("picture2") != null ){
                pictureOuterwall = Integer.parseInt(request.getParameter("picture2"));
            }
            String descriptionOuterwall = request.getParameter("outerwallDescription");
            
            String room = request.getParameter("room");
            int commentRoom = 1;
            if(request.getParameter("comments3") != null ){
                commentRoom = Integer.parseInt(request.getParameter("comments3"));
            }
            
            int yesNoRoomDamage = 1;
            if(request.getParameter("yesNo1") != null ){
                yesNoRoomDamage = Integer.parseInt(request.getParameter("yesNo1"));
            }
            String when = request.getParameter("when");
            String where = request.getParameter("where");
            String whatHappend = request.getParameter("whatHappend");
            String whatRepaired = request.getParameter("whatRepaired");
            int damageType = 0;
            if(request.getParameter("damageRadio") != null ){
                damageType = Integer.parseInt(request.getParameter("damageRadio"));
            }
            String otherDamageType = request.getParameter("otherText");
            
            int commentWall = 1;
            if(request.getParameter("comments4") != null ){
                commentWall = Integer.parseInt(request.getParameter("comments4"));
            }
            int pictureWall = 0;
            if(request.getParameter("pictureWall") != null ){
                pictureWall = Integer.parseInt(request.getParameter("pictureWall"));
            }
            String descriptionWall = request.getParameter("wallDescription");
            
            int commentCeiling = 1;
            if(request.getParameter("comments5") != null ){
                commentCeiling = Integer.parseInt(request.getParameter("comments5"));
            }
            int pictureCeiling = 0;
            if(request.getParameter("pictureCeiling") != null ){
                pictureCeiling = Integer.parseInt(request.getParameter("pictureCeiling"));
            }
            String descriptionCeiling = request.getParameter("ceilingDescription");
            
            int commentFloor = 1;
            if(request.getParameter("comments6") != null ){
                commentFloor = Integer.parseInt(request.getParameter("comments6"));
            }
            int pictureFloor = 0;
            if(request.getParameter("pictureFloor") != null ){
                pictureFloor = Integer.parseInt(request.getParameter("pictureFloor"));
            }
            String descriptionFloor = request.getParameter("floorDescription");
            
            int commentWindows = 1;
            if(request.getParameter("comments7") != null ){
                commentWindows = Integer.parseInt(request.getParameter("comments7"));
            }
            int pictureWindows = 0;
            if(request.getParameter("pictureWindows") != null ){
                pictureWindows = Integer.parseInt(request.getParameter("pictureWindows"));
            }
            String descriptionWindows = request.getParameter("windowsDescription");
            
            String otherReview = request.getParameter("other");
            int commentOther = 1;
            if(request.getParameter("comments8") != null ){
                commentOther = Integer.parseInt(request.getParameter("comments8"));
            }
            int pictureOther = 0;
            if(request.getParameter("pictureOther") != null ){
                pictureOther = Integer.parseInt(request.getParameter("pictureOther"));
            }
            String descriptionOther = request.getParameter("otherDescription");
            
            String otherReview2 = request.getParameter("other2");
            int commentOther2 = 1;
            if(request.getParameter("comments9") != null ){
                commentOther2 = Integer.parseInt(request.getParameter("comments9"));
            }
            int pictureOther2 = 0;
            if(request.getParameter("pictureOther2") != null ){
                pictureOther2 = Integer.parseInt(request.getParameter("pictureOther2"));
            }
            String descriptionOther2 = request.getParameter("other2Description");
            
            int humidityYesNo = 1;
            if(request.getParameter("yesNo2") != null ){
                humidityYesNo = Integer.parseInt(request.getParameter("yesNo2"));
            } 
            String descriptionScanning = request.getParameter("humidityScan");
            String descriptionMeasuring = request.getParameter("measuring");
            String descriptionHumidity = request.getParameter("humidityDescription");
            
            String conclusionRoom1 = request.getParameter("room1");
            String conclusionConclusion1 = request.getParameter("conclusion1");
            String conclusionRoom2 = request.getParameter("room2");
            String conclusionConclusion2 = request.getParameter("conclusion2");
            String conclusionRoom3 = request.getParameter("room3");
            String conclusionConclusion3 = request.getParameter("conclusion3");
            String conclusionRoom4 = request.getParameter("room4");
            String conclusionConclusion4 = request.getParameter("conclusion4");
            String conclusionRoom5 = request.getParameter("room5");
            String conclusionConclusion5 = request.getParameter("conclusion5");
            String conclusionRoom6 = request.getParameter("room6");
            String conclusionConclusion6 = request.getParameter("conclusion6");
            String conclusionRoom7 = request.getParameter("room7");
            String conclusionConclusion7 = request.getParameter("conclusion7");
            String conclusionRoom8 = request.getParameter("room8");
            String conclusionConclusion8 = request.getParameter("conclusion8");
            
            String writer = request.getParameter("writer");
            String collaborator = request.getParameter("collaborator");
            
            int categorize = 0;
            if(request.getParameter("grade") != null ){
                categorize = Integer.parseInt(request.getParameter("grade"));
            } 
            
            int rapportNr = Integer.parseInt(request.getParameter("rapportnr1"));
            
            Rapport rapport = new Rapport(buildingName, address, zip, buildYear, buildingArea, buildingUse, descriptionRoof, descriptionOuterwall, room, when, where, whatHappend, whatRepaired, otherDamageType, descriptionWall, descriptionCeiling, descriptionFloor, descriptionWindows, otherReview, descriptionOther, otherReview2, descriptionOther2, descriptionScanning, descriptionMeasuring, descriptionHumidity, conclusionRoom1, conclusionConclusion1, conclusionRoom2, conclusionConclusion2, conclusionRoom3, conclusionConclusion3, conclusionRoom4, conclusionConclusion4, conclusionRoom5, conclusionConclusion5, conclusionRoom6, conclusionConclusion6, conclusionRoom7, conclusionConclusion7, conclusionRoom8, conclusionConclusion8, writer, collaborator, commentRoof, pictureRoof, commentOuterwall, pictureOuterwall, commentRoom, yesNoRoomDamage, damageType, commentWall, pictureWall, commentCeiling, pictureCeiling, commentFloor, pictureFloor, commentWindows, pictureWindows, commentOther, pictureOther, commentOther2, pictureOther2, humidityYesNo, categorize, rapportNr);
            
            DomainFacade.createRapport(buildingID, rapport);
            
            DomainFacade.getRapport(buildingID);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
