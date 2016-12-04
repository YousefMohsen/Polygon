package servlet;

import Domain.DomainFacade;
import entity.Login;
import exceptions.PolygonException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            Login login = DomainFacade.getLogin(request.getParameter("username"));
            String username = login.getUsername();
            int userID = login.getId();
            int uId = login.getuId();
            int rank = login.getRank();
            if (login.getPassword().equals(request.getParameter("password"))) {
                request.getSession().setAttribute("name", username);
                request.getSession().setAttribute("userID", userID);
                request.getSession().setAttribute("uId", uId);
                request.getSession().setAttribute("rank", rank);
                request.getRequestDispatcher("WEB-INF/buildingTable.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
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
