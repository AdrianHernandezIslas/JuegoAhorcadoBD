<%-- 
    Document   : bienvenida
    Created on : 7/05/2019, 01:53:12 PM
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionActual = request.getSession(true);
    String usuario = (String) sesionActual.getAttribute("nameUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ahorcado</title>
    </head>
    <body>
        <div class="container">
            <hr>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-5">
                    <h1 class="text-info">Bienvenido <%=usuario %></h1>
                </div>
            </div>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-5">
                    <label>¿Quieres Continuar?</label>
                    <a href="ServletJuego" class="btn btn-primary">Si</a>
                    <a href="http://localhost:8080/JuegoAhorcadoDB/" class="btn btn-secondary">No</a>
                </div>
            </div>
        </div>
        
    </body>
</html>
