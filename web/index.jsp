<%-- 
    Document   : index
    Created on : 7/05/2019, 09:29:28 AM
    Author     : adrian
--%>

<%@page import="modelo.Tipos"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="controller.TiposJpaController"%>
<%@page import="javax.transaction.UserTransaction"%>
<%@page import="javax.annotation.Resource"%>
<%@page import="javax.annotation.Resource"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.PersistenceUnit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ahorcado</title>
        <%! 
            @PersistenceUnit
            private static EntityManagerFactory emf;
            @Resource
            private static UserTransaction utx;
        %>
        
        <%
            emf = Persistence.createEntityManagerFactory("JuegoAhorcadoDBPU");
            TiposJpaController tjc = new TiposJpaController(utx, emf);
            
            List<Tipos> tipo = tjc.findTiposEntities();
            emf.close();
        %>
    </head>
    <body>
        <br>
        <br>
        <form name="inicio" action="ServletJuego" method="POST">
            <div class="container">
                <hr>
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-4">
                        <h1>Juego Ahorcado</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3"></div>
                    <div class="col-3">
                        <div class="form-group">
                            <label>¿Como te llamas?</label>
                            <input type="text" name="nameUser" placeholder="Ej. Adrian" required>
                        </div>
                       
                    </div>
                    <div class="col-3">
                         <div class="form-group">
                            <label>Numero Intentos</label>
                            <input type="number" name="intent" value="2" min="2">
                        </div>
                    </div>
                   
                </div>
                <div class="row">
                    <div class="col-3"></div>
                     <div class="col-3">
                        <div class="form-group">
                            <label for="palabra">Nivel</label>
                            <select class="custom-select" name="nivel">
                                <option value="1">Facil</option>
                                <option value="2">Intermedio</option>
                                <option value="3">Dificil</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="palabra">Tipo</label>
                            <select class="custom-select" name="tipo">
                                <% for (Tipos tipos : tipo) {%>
                                 <option value="<%=tipos.getIdTipos() %>" ><%=tipos.getDescripcion() %></option>
                                <% } %>

                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-5"></div>
                    <div class="col-3">
                        <button class="btn btn-info btn-block" type="submit">Aceptar</button>
                    </div>
                </div>
            </div>
            
        </form>
       <hr>
    </body>
</html>
