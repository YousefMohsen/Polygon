package servlet;

import Domain.DomainFacade;
import entity.Address;
import entity.Building;
import entity.Document;
import entity.ZipCode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    int buildingID;

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
            HttpSession session = request.getSession();
            String origin = request.getParameter("switch");
            System.out.println(origin);
            switch (origin) {
                case "logout":
                    request.getSession().invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                case "editBuilding":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    session.setAttribute("ID", buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;
                case "createBuilding":
                    String address = request.getParameter("address");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    // String city = request.getParameter("city"); bliver ikke brugt                   
                    DomainFacade.createBuilding(zip, address, (int) session.getAttribute("userID"));
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
                    break;

                case "deletionRequest":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.deletionRequest(buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;

                case "acceptRequest":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.hideBuilding(buildingID);
                    DomainFacade.cancelDeletionRequest(buildingID); //remove building from deletion list
                    request.getRequestDispatcher("WEB-INF/Request.jsp").forward(request, response);
                    break;

                case "healthCheck":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.healthCheckRequest(buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;
                case "Submit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    String buildingStreet = request.getParameter("buildingStreet");                    
                    int buildingZip = Integer.parseInt(request.getParameter("buildingZip"));
                    String buildingCity = request.getParameter("buildingCity");
                    String reportURL = request.getParameter("reportURL");
                    ZipCode buildingZ = new ZipCode(buildingZip, buildingCity);
                    Address buildingA = new Address(buildingStreet, buildingZ);
                    Building b = new Building(id, buildingA, reportURL);
                    DomainFacade.updateBuilding(b);
                    String fileURL = request.getParameter("fileURL");
                    String note = request.getParameter("note");
                    Document d = new Document(id, fileURL, note);
                    DomainFacade.updateDocument(d, b.getId());
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
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
        processRequest(request, response);
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
