/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            
            String buildingName = request.getParameter("nameOnBuilding");
            String address = request.getParameter("address");
            String zip = request.getParameter("zipCity");
            
            String buildYear = request.getParameter("buildYear");
            String buildingArea = request.getParameter("buildingArea");
            String buildingUse = request.getParameter("buildingUse");
            
            int commentRoof;
            if(request.getParameter("comments1") != null ){
                commentRoof = Integer.parseInt(request.getParameter("comments1"));
            }
            int pictureRoof;
            if(request.getParameter("picture1") != null ){
                pictureRoof = Integer.parseInt(request.getParameter("picture1"));
            }
            String descriptionRoof = request.getParameter("roofDescription");
            
            int commentOuterwall;
            if(request.getParameter("comments2") != null ){
                commentOuterwall = Integer.parseInt(request.getParameter("comments2"));
            }
            int pictureOuterwall;
            if(request.getParameter("picture2") != null ){
                pictureOuterwall = Integer.parseInt(request.getParameter("picture2"));
            }
            String descriptionOuterwall = request.getParameter("outerwallDescription");
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
