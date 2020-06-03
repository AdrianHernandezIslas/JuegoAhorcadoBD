/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import controller.PalabraJpaController;
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

/**
 *
 * @author adrian
 */
@WebServlet(name = "Listar", urlPatterns = {"/Listar"})
public class Listar extends HttpServlet {
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
            out.println("<title>Servlet Listar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Listar at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
           
            PalabraJpaController pjc = new PalabraJpaController(utx, emf);
            List<Palabra> palabras = pjc.findPalabraEntities();
            
            emf.close();
            HttpSession sesionActual = request.getSession(true);
               
            sesionActual.setAttribute("palabras",palabras);
               
            response.sendRedirect("listar.jsp");
        //processRequest(request, response);
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
            Palabra palabra = pjc.findPalabra(Integer.parseInt(request.getParameter("id")));
            emf.close();
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
                out.println("<title>Servlet Listar</title>");            
                out.println("</head>");
                out.println("<body class='container'>");
                out.println("<br>");
                out.println("<br>");
                out.println("<h1>Resultados de Busqueda</h1>");
                if(palabra != null){
                    out.println("<table class=\"table table-hover\">");
                    out.println("<thead>");
                    out.println("<tr class=\"bg-info text-white\">");
                    out.println("<th scope=\"col\">ID</th>");
                    out.println("<th scope=\"col\">Palabra</th>");
                    out.println("<th scope=\"col\">Tipo</th>");
                    out.println("<th scope=\"col\">Nivel</th>");
                    out.println("<th scope=\"col\">Editar</th>");
                    out.println("<th scope=\"col\">Eliminar</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<td scope=\"row\">"+palabra.getIdPalabra()+"</td>");
                    out.println("<td>"+palabra.getPalabra()+"</td>");
                    out.println("<td>"+palabra.getIdTipo()+"</td>");
                    out.println("<td>"+(palabra.getNivel()==1?"Facil":(palabra.getNivel()==2?"Intermedio":"Dificil"))+"</td>");
                    out.println("<td><a href='http://localhost:8080/JuegoAhorcadoDB/Editar?id="+palabra.getIdPalabra()+"' class='btn btn-outline-warning'><img src=\"./assets/img/edit.png\" class=\"\" width=\"32px\" height=\"32px\"></a></td>");
                    out.println("<td><a href='http://localhost:8080/JuegoAhorcadoDB/Eliminar?id="+palabra.getIdPalabra()+"&palabra="+palabra.getPalabra()+"' class='btn btn-outline-danger'><img src=\"./assets/img/delete.png\" class=\"\" width=\"32px\" height=\"32px\"></a></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                }else{
                    out.println("<h1>Sin coincidencias</h1>");
                    out.println("<h1><a href=\"admin.jsp\" class=\"btn btn-outline-info\">Inicio</a></h1>");
                    
                }

                    out.println("<br>");
                    out.println("<br>");
                    out.println("<a href=\"buscar.jsp\" class=\"btn btn-secondary\">Regresar</a>");
                    out.println("</body>");
                    out.println("</html>");
            }
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
