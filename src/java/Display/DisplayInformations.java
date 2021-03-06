/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stephane.grangier
 */
public class DisplayInformations extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DisplayInformations</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet: " + request.getContextPath() + "</h1>");
            
                        
            out.println("<h2>Nom: " + request.getParameter("nom") + "</h2>");
            out.println("<h2>Prenom: " + request.getParameter("prenom") + "</h2>");

            out.println("<h3>Session_id: " + request.getSession().getId() + "</h3>");

            Date currentDate = new Date(request.getSession().getCreationTime());
            out.println("<h3>Création session: " + currentDate + "</h3>");

            ServletConfig config = getServletConfig();
            String paramTest = config.getInitParameter("paramTest");
                    
            out.println("<h3>Param du servelet: " + paramTest + "</h3>");
            
            
            
            out.println("<h3>Informations de la session</h3>");
            
            HttpSession session = request.getSession(true);
            out.println("<h2>Nom: " + session.getAttribute("nom") + "</h2>");
            out.println("<h2>Prenom: " + session.getAttribute("prenom") + "</h2>");
   
    
            
            out.println("</body>");
            out.println("</html>");
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
