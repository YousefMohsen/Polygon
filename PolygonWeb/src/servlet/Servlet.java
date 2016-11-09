/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Domain.DomainFacade;
import entity.Building;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yousinho
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

   DomainFacade df = new DomainFacade();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
            String origin = request.getParameter("origin");
  
            switch (origin) {
                    
                case "addBuilding":
                        
                    String contact = request.getParameter("contact");
                    String adress = request.getParameter("adress");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    String city = request.getParameter("city");
                    String phone = request.getParameter("phone");

                    
                df.addBuilding(contact, adress, zip, city, phone);
                        session.setAttribute("buildings", df.getBuildings());

                   response.sendRedirect("seeBuildings.jsp");
                    break;
           case "index":
                       
           // request.setAttribute("buildings", df.getBuildings());
            
            
        session.setAttribute("buildings", df.getBuildings());
            //set attributes on request
        //    request.setAttribute("password", password);

            //request.getRequestDispatcher("seeBuildings.jsp").forward(request, response);
       // processRequest(request, response);
            response.sendRedirect("seeBuildings.jsp");

              break;
            }
       

        }
    }

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
        processRequest(request, response);
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
