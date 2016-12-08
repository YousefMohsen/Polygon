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
            throws ServletException, IOException {
       // System.out.println("servlet");
        try { 
        System.out.println("servlet1");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String origin = request.getParameter("switch");
        switch (origin) {

                case "logout":
                    request.getSession().invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "editBuilding":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    request.setAttribute("buildingID", buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;
                case "createBuilding":
                    String address = request.getParameter("address");
                    String name = request.getParameter("buildingName");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    DomainFacade.createBuilding(zip, address, (int) session.getAttribute("userID"), name);
                    request.setAttribute("buildingID", buildingID);
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
                    break;
                     case "createUser":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String uaddress = request.getParameter("address");
                String uname = request.getParameter("username");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                int uzip = Integer.parseInt(request.getParameter("zip"));
                int rank = Integer.parseInt(request.getParameter("rank"));
                int userId = DomainFacade.createUser(firstname, lastname, phone, email, uaddress, uzip);
                DomainFacade.createLogin(uname, password, rank, userId);
                request.setAttribute("buildingID", buildingID);
                request.getRequestDispatcher("WEB-INF/users.jsp").forward(request, response);
                break;
                case "deletionRequest":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.deletionRequest(buildingID);
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
                    break;
                case "restoreBuilding":
            buildingID = Integer.parseInt(request.getParameter("buildingID"));
          DomainFacade.recoverBuilding(buildingID);
            request.getRequestDispatcher("WEB-INF/hiddenBuildings.jsp").forward(request, response);
                    break;
                case "acceptRequest":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.hideBuilding(buildingID);
                    DomainFacade.cancelDeletionRequest(buildingID); //remove building from deletion list
                    request.getRequestDispatcher("WEB-INF/Request.jsp").forward(request, response);
                    break;
                case "healthCheck":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    request.setAttribute("buildingID", buildingID);
                    DomainFacade.healthCheckRequest(buildingID);
                    request.getRequestDispatcher("WEB-INF/editBuilding.jsp").forward(request, response);
                    break;
                    
                case "newsletter":
                    String subject = request.getParameter("subject");
                    String messege = request.getParameter("mailMessege");
                     DomainFacade.sendNewsletter(subject,messege);
                    request.getRequestDispatcher("WEB-INF/Newsletter.jsp").forward(request, response);
                
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
                    request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
                    break;
                case "updateNote":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    String note = request.getParameter("note");

                    Document d = new Document(note, buildingID);

                    DomainFacade.updateDocumentNote(d);

                    request.getRequestDispatcher("WEB-INF/seeFloorPlan.jsp").forward(request, response);
                    break;
                case "showImage":
                    buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    request.getRequestDispatcher("WEB-INF/showFloorPlan.jsp").forward(request, response);
                    break;
            }
        } catch(ServletException | IOException | NumberFormatException | PolygonException e) {
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect("error.jsp");
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
