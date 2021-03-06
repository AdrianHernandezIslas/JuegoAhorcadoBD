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
@WebServlet(name = "Crear", urlPatterns = {"/Crear"})
public class Crear extends HttpServlet {
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
            
            emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
            TiposJpaController tjc = new TiposJpaController(utx, emf);
            
            List<Tipos> tipo = tjc.findTiposEntities();
            emf.close();
            HttpSession sesionActual = request.getSession(true);
               
            sesionActual.setAttribute("tipos",getTipos(tipo));
               
            response.sendRedirect("crear.jsp");
            
        }
    }
    
    private String getTipos(List<Tipos> tipo){
        String salida = "";
        for (Tipos tipos : tipo) {
            salida+="<option value='"+tipos.getIdTipos()+"' >"+tipos.getDescripcion()+"</option>\n";
        }
        return salida;
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
        emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
        PalabraJpaController pjc = new PalabraJpaController(utx, emf);
        Palabra palabra = new Palabra();
        palabra.setPalabra(request.getParameter("palabra"));
        palabra.setIdTipo(Integer.parseInt(request.getParameter("tipo")));
        palabra.setNivel(Integer.parseInt(request.getParameter("nivel")));
        try {
            pjc.create(palabra);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        emf.close();
        response.sendRedirect("Listar");
        //processRequest(request, response);
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
