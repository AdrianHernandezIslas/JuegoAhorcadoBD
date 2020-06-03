<%-- 
    Document   : editar
    Created on : 12/05/2019, 12:21:56 AM
    Author     : adrian
--%>

<%@page import="modelo.Tipos"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Palabra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionActual = request.getSession(true);
    Palabra palabra = (Palabra) sesionActual.getAttribute("palabra");
    List<Tipos> tipos = (List<Tipos>) sesionActual.getAttribute("tipos");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body  class="container">
        <br>
        <br>
        <h2>Editar Palabra</h2>
        <hr>
        <form name="registro" action="Editar" method="POST">
            <div class="row">
            <div class="col-2">
              <div class="form-group">
                <label for="palabra">ID</label>
                <input type="text" class="form-control" id="id" name="id" value="<%=palabra.getIdPalabra() %>" readonly>
              </div>
            </div>
            <div class="col-3">
              <div class="form-group">
                <label for="palabra">Palabra</label>
                <input type="text" class="form-control" id="palabra" name="palabra" value="<%=palabra.getPalabra() %>">
              </div>
            </div>
            <div class="col-3">
                <div class="form-group">
                    <label for="palabra">Tipo</label>
                    <select class="custom-select" name="tipo">
                        <% for (Tipos tipo : tipos) {%>
                        <option value="<%=tipo.getIdTipos() %>" <%=palabra.getIdTipo() == tipo.getIdTipos()?"selected":"" %> ><%=tipo.getDescripcion() %></option>
                        <% } %>

                    </select>
                </div>
            </div>
            <div class="col-3">
                <div class="form-group">
                    <label for="palabra">Nivel</label>
                    <select class="custom-select" name="nivel">
                        <option value="1" <%=palabra.getNivel()== 1?"selected":"" %>>Facil</option>
                        <option value="2" <%=palabra.getNivel()== 2?"selected":"" %>>Intermedio</option>
                        <option value="3" <%=palabra.getNivel()== 3?"selected":"" %>>Dificil</option>
                    </select>
                </div>
            </div>
          </div>
          <div class="row">
            <div class="col-2"></div>
            <div class="col-3">
                <button type="submit" class="btn btn-info btn-block">Actualizar</button>
            </div>
            <div class="col-3">
                <a href="Listar" class="btn btn-secondary btn-block">Cancelar</a>
            </div>
          </div>
        </form>
       <hr>
    </body>
</html>
