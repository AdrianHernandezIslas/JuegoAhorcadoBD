/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.PalabraJpaController;
import controller.TiposJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import modelo.Palabra;
import modelo.Tipos;

/**
 *
 * @author adrian
 */
@WebServlet(name = "Editar", urlPatterns = {"/Editar"})
public class Editar extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
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
            out.println("<title>Servlet Editar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Editar at " + request.getContextPath() + "</h1>");
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
            emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
            TiposJpaController tjc = new TiposJpaController(utx, emf);
            List<Tipos> tipos = tjc.findTiposEntities();
            PalabraJpaController pjc = new PalabraJpaController(utx, emf);
            Palabra palabra = pjc.findPalabra(Integer.parseInt(request.getParameter("id")));
            emf.close();
            HttpSession sesionActual = request.getSession(true);   
            sesionActual.setAttribute("tipos",tipos);
            sesionActual.setAttribute("palabra",palabra);
               
            response.sendRedirect("editar.jsp");
            
            
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
        //processRequest(request, response);
        emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
        PalabraJpaController pjc = new PalabraJpaController(utx, emf);
        Palabra palabra = new Palabra();
        palabra.setIdPalabra(Integer.parseInt(request.getParameter("id")));
        palabra.setPalabra(request.getParameter("palabra"));
        palabra.setIdTipo(Integer.parseInt(request.getParameter("tipo")));
        palabra.setNivel(Integer.parseInt(request.getParameter("nivel")));
        try {
            pjc.edit(palabra);
            try (PrintWriter out = response.getWriter()) {
                response.sendRedirect("Listar");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        emf.close();
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
