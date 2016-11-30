package servlet;

import Domain.DomainFacade;
import entity.Document;
import exceptions.PolygonException;
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
            throws ServletException, IOException, PolygonException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String origin = request.getParameter("switch");

            switch (origin) {
                case "logout":
                    request.getSession().invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                case "editBuilding":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    request.setAttribute("ID", buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;
                case "createBuilding":
                    String address = request.getParameter("address");
                    String name = request.getParameter("buildingName");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    DomainFacade.createBuilding(zip, address, (int) session.getAttribute("userID"), name);
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
                    break;

                case "deletionRequest":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.deletionRequest(buildingID);

                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
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
//                    String buildingStreetId = request.getParameter("buildingStreet");                    
//                    int buildingZip = Integer.parseInt(request.getParameter("buildingZip"));                    
//                    String reportURL = request.getParameter("reportURL");
//                    String buildingName = request.getParameter("buildingName");
//                    
//                    int buildingAddressId = Integer.parseInt(request.getParameter("buildingAddressId"));
//                    
//                    int addressId = DomainFacade.getZip(buildingZip);                    
//                    Address address1 = new Address(addressId,  buildingStreetId);
//                    Building building = new Building(id, addressId, address1, reportURL, buildingName,(int)session.getAttribute("uId"));                    
//                    
//                    DomainFacade.updateBuilding(building);                 
//                    DomainFacade.updateAddress(buildingAddressId,addressId);
//                    
                    String fileURL = request.getParameter("fileURL");
                    String note = request.getParameter("note");
                    Document d = new Document(id, "URL", note);
                    DomainFacade.updateDocument(d, id);
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
        try {
            processRequest(request, response);
        } catch (PolygonException ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            processRequest(request, response);
        } catch (PolygonException ex) {
            System.out.println(ex.getMessage());
        }
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
