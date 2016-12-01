package servlet;

import exceptions.PolygonException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig
public class UploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws exceptions.PolygonException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PolygonException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("WEB-INF/seeFloorPlan.jsp").forward(request, response);
//            HttpSession session = request.getSession();
//            String buildingID = request.getParameter("buildingID");
//            session.setAttribute("ID", buildingID);
//            request.setAttribute("ID", buildingID);
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
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String buildingID = request.getParameter("buildingID");
//            // get access to file that is uploaded from client
            Part p = request.getPart("file");
            InputStream is = p.getInputStream();
//
//            // get filename to use on the server
//            String outputfile = this.getServletContext().getRealPath("/floorPlan/");  // get path on the server
//            FileOutputStream os = new FileOutputStream (outputfile + buildingID + ".jpg");

//            String fileName = Paths.get(p.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//            File uploads = new File("");
            FileOutputStream os = new FileOutputStream(buildingID + ".jpg");

            // write bytes taken from uploaded file to target file
            int ch = is.read();
            while (ch != -1) {
                os.write(ch);
                ch = is.read();
            }
            os.close();
            out.println("<h3>File uploaded successfully!</h3>");
            out.println("<a href=\"FrontController?ID=LinkServlet&page=buildingTable.jsp\" class=\"btn btn-default\">Back</a>");
        } catch (IOException | ServletException ex) {
            out.println("Exception -->" + ex.getMessage());
        } finally {
            out.close();
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
