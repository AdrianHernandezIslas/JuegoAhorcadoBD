<%-- 
    Document   : listar
    Created on : 11/05/2019, 11:05:43 PM
    Author     : adrian
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Palabra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionActual = request.getSession(true);
    List<Palabra> palabras = (List<Palabra>) sesionActual.getAttribute("palabras");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <h2>Palabras</h2>
        <div class="row">
        <table class="table table-hover">
            <thead>
              <tr class="bg-info text-light">
                <th scope="col">ID</th>
                <th scope="col">Palabra</th>
                <th scope="col">Tipo</th>
                <th scope="col">Nivel</th>
                <th scope="col">Editar</th>
                <th scope="col">Eliminar</th>
              </tr>
            </thead>
            <tbody>
                <% for (int idx = 0; idx < palabras.size(); idx++) {%>
                    <tr>
                      <td scope="row"><%=palabras.get(idx).getIdPalabra() %></td>
                      <td><%=palabras.get(idx).getPalabra() %></td>
                      <td><%=palabras.get(idx).getIdTipo() %></td>
                      <td><%=(palabras.get(idx).getNivel()==1?"Facil":(palabras.get(idx).getNivel()==2?"Intermedio":"Dificil")) %></td>
                      <td><a href="<%="Editar?id="+palabras.get(idx).getIdPalabra() %>" class="btn btn-outline-warning"><img src="./assets/img/edit.png" class="" width="32px" height="32px" ></a></td>
                      <td><a href="<%="Eliminar?id="+palabras.get(idx).getIdPalabra()+"&palabra="+palabras.get(idx).getPalabra() %>" class="btn btn-outline-danger"><img src="./assets/img/delete.png" class="" width="32px" height="32px"></a></td>
                    </tr>
                <% } %>
              
            </tbody>
        </table>
        </div>
        <div class="row">
            <div class="col-4"></div>
            <div class="col-3">
                <a href="admin.jsp" class="btn btn-outline-info btn-block">Inicio</a>
            </div>
        </div>
        
    </body>
</html>
