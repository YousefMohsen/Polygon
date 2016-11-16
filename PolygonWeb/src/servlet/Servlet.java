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
            System.out.println(origin);
            String buildingID = request.getParameter("buildingID");

            switch (origin) {
                case "editBuilding":
                    session.setAttribute("ID", buildingID);
                    request.setAttribute("ID", buildingID);
                    response.sendRedirect("editBuilding.jsp");
                    break;

                case "Submit":
                    int id = (Integer) session.getAttribute("ID");
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String CustomerStreet = request.getParameter("CustomerStreet");
                    int CustomerZip = Integer.parseInt(request.getParameter("CustomerZip"));
                    String CustomerCity = request.getParameter("CustomerCity");
                    ZipCode userZ = new ZipCode(CustomerZip, CustomerCity);
                    Address userA = new Address(CustomerStreet, userZ);
                    User u = new User(1, firstname, lastname, phone, email, userA);
                    String buildingStreet = request.getParameter("buildingStreet");
                    int buildingZip = Integer.parseInt(request.getParameter("buildingZip"));
                    String buildingCity = request.getParameter("buildingCity");
                    String reportURL = request.getParameter("reportURL");
                    ZipCode buildingZ = new ZipCode(buildingZip, buildingCity);
                    Address buildingA = new Address(buildingStreet, buildingZ);
                    Building b = new Building(id, buildingA, reportURL);
                    String fileURL = request.getParameter("fileURL");
                    String note = request.getParameter("note");
                    Document d = new Document(1, fileURL, note);

                    DomainFacade.updateUser(u);
                    DomainFacade.updateBuilding(b);
                    DomainFacade.updateDocument(d);

                    response.sendRedirect("index.jsp");
                    break;

                case "Cancel":
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
