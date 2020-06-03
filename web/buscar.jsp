<%-- 
    Document   : buscar
    Created on : 11/05/2019, 11:33:08 PM
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <br>
        <br>
        <br>
        <hr>
        <div class="row">
            <div class="col-3"></div>
            <h2>Encontrar Palabra</h2>
        </div>
        
        <div class="row">
            <div class="col-3"></div>
            <div class="col-1"><img src="./assets/img/search.png" class="card-img-top" alt="..."></div>
            <div class="col-5">
                <form name="busca" action="Listar" method="POST">
                    <label>Ingrese ID</label>
                    <input type="text" name="id" required>
                    <button type="submit" class=" btn btn-info">Buscar</button>
                </form>
                
            </div>
        </div>
        <div class="row">
            <div class="col-5"></div>
            <div class="col-5">
                <a href="admin.jsp" class="btn btn-outline-secondary">Inicio</a>
            </div>
        </div>
        <hr>
    </body>
</html>
