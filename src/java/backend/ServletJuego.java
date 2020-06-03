/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrian
 */
@WebServlet(name = "ServletJuego", urlPatterns = {"/ServletJuego"})
public class ServletJuego extends HttpServlet {

    private String palabra, letrasUsadas = "", userName;
    private String letrasEncontradas[];
    private int intentos,aciertos,nivel,tipo;
    private final char letras[] = Juego.getLetras();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("<title>Presentacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br>");
            out.println("<br>");
            out.println("<div class=\"container\" >");
            out.println("<h1>Comencemos: " + userName + "</h1>");
            out.println("<h3>Intentos disponibles: " + intentos + "</h3>");
           
            if(intentos >0){
                out.println("<div class='row'>");
                out.println(getEspacios(request.getParameter("letra")));
                out.println("</div>");
                out.print("<hr>");
                out.println("<div class='row'>");
                out.println(getLetras(request.getParameter("letra")));
                out.println("</div>");
                out.println("</div>");
            }else{
                out.println("<div class='row'>");
                out.println("<center><h1>Juego Terminado perdiste :(</h1>");
                out.println("<a href='http://localhost:8080/JuegoAhorcadoDB/' class='btn btn-warning' >salir</a>");
                out.println("</center>");
                out.println("</div>");
                palabra = null;
                letrasEncontradas = null;
                letrasUsadas="";
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    private void getLetraEncontrada(String btn) {
        if (btn != null) {
            
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.toLowerCase().charAt(i) == btn.charAt(0)) {
                    letrasEncontradas[i] = "" + btn.charAt(0);
                }
            }
        }
    }

    private String getLetras(String btn) {
        String as = "";
        for (char letra : letras) {
            if (btn == null) {
                as += "<a class='btn btn-success' href=\"ServletJuego?letra=" + letra + "\">" + letra + "</a>";
            } else {
                letrasUsadas += btn.toLowerCase();
                if (!letrasUsadas.contains("" + letra)) {
                    as += "<a class='btn btn-success' href=\"ServletJuego?letra=" + letra + "\">" + letra + "</a>";
                }
            }

        }
        return as;
    }

    private String getEspacios(String btn) {
        getLetraEncontrada(btn);
        String as = "";
        for (String letrasEncontrada : letrasEncontradas) {
            if (letrasEncontrada == null) {
                as += "<a class='btn btn-outline-info' > * </a>";
            } else {
                as += "<a class='btn btn-outline-info' > " + letrasEncontrada + " </a>";
            }
        }

        return as;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (palabra != null && !palabra.toLowerCase().contains(request.getParameter("letra"))) {
                intentos--;
        }else if (palabra != null ){
                 aciertos++;
        }
        
        if (palabra == null) {
            palabra = Juego.getPalabra(nivel,tipo);
            letrasEncontradas = new String[palabra.length()];
        }
        
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
        String nombreUsuario = request.getParameter("nameUser");
        intentos = Integer.parseInt(request.getParameter("intent"));
        userName = request.getParameter("nameUser");
        nivel = Integer.parseInt(request.getParameter("nivel"));
        tipo = Integer.parseInt(request.getParameter("tipo"));
        try {
            //se crea una variable de tipo session para guardar el nombre de usuario
            HttpSession sesionActual = request.getSession(true);
            //se almacena el nombre de usuario en la variable de sesión
            sesionActual.setAttribute("nameUser", nombreUsuario);
            //se direcciona hacia paginaPrincipal.jsp
            response.sendRedirect("bienvenida.jsp");
        } finally {
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
