package servlet;

import Domain.DomainFacade;
import entity.Address;
import entity.Building;
import entity.Document;
import entity.User;
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
            HttpSession session = request.getSession();
            String origin = request.getParameter("origin");         
            int buildingID  = Integer.parseInt(request.getParameter("buildingID"));;           
   
            switch (origin) {
                case "editBuilding":
                    out.println(origin+" "+buildingID );
                    session.setAttribute("ID", buildingID);
              response.sendRedirect("editBuilding.jsp");
                    break;
                case "createBuilding":
                   
                    String address = request.getParameter("address");
                    int zip = Integer.parseInt(request.getParameter("zip"));
                    String city = request.getParameter("city");
       int userID =  Integer.parseInt( session.getAttribute("userID").toString());
              
                    DomainFacade.createBuilding(zip, address,userID);
                    response.sendRedirect("index.jsp");
                    break;
                
                  case "deletionRequest":
                      buildingID = Integer.parseInt(request.getParameter("buildingID"));
                    DomainFacade.deletionRequest(buildingID);
                    session.setAttribute("ID", buildingID);
                    request.setAttribute("ID", buildingID);
             
                    response.sendRedirect("editBuilding.jsp");
            
                      break;
                      
               case "acceptRequest":
                   buildingID = Integer.parseInt(request.getParameter("buildingID"));
            DomainFacade.hideBuilding(buildingID);
            DomainFacade.cancelDeletionRequest(buildingID); //remove building from deletion list
            response.sendRedirect("Request.jsp");
                      break;
                      
                         case "healthCheck":
        buildingID = Integer.parseInt(request.getParameter("buildingID"));
   
   
DomainFacade.healthCheckRequest(buildingID);

response.sendRedirect("editBuilding.jsp");
                      break;
                      
                
                case "Submit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String userStreet = request.getParameter("userStreet");
                    int userZip = Integer.parseInt(request.getParameter("userZip"));
                    String userCity = request.getParameter("userCity");
                    ZipCode userZ = new ZipCode(userZip, userCity);
                    Address userA = new Address(userStreet, userZ);
                    User u = new User(id, firstname, lastname, phone, email, userA);
                    
                    String buildingStreet = request.getParameter("buildingStreet");
                    int buildingZip = Integer.parseInt(request.getParameter("buildingZip"));
                    String buildingCity = request.getParameter("buildingCity");
                    String reportURL = request.getParameter("reportURL");
                    ZipCode buildingZ = new ZipCode(buildingZip, buildingCity);
                    Address buildingA = new Address(buildingStreet, buildingZ);
                    Building b = new Building(id, buildingA, reportURL);
                    
                    DomainFacade.updateUser(u, b.getId());
                    DomainFacade.updateBuilding(b);
                    
                    String fileURL = request.getParameter("fileURL");
                    String note = request.getParameter("note");
                    Document d = new Document(id, fileURL, note);
                    DomainFacade.updateDocument(d, b.getId());
                    
                    response.sendRedirect("index.jsp");
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
