<%-- 
    Document   : admin
    Created on : 12/05/2019, 09:43:40 AM
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
        <hr>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-7">
                <h1>¡ Bienvenido Administrador !</h1>
            </div>
            
        </div>
        
        <div class="row">
            <div class="col-3"></div>
            <div class="col-2">  
               <a href="http://localhost:8080/JuegoAhorcadoDB/Listar" class="btn btn-outline-info" ><img src="./assets/img/list.png" class="card-img-top" alt="...">Listar</a> 
            </div>
            <div class="col-2">
                <a href="http://localhost:8080/JuegoAhorcadoDB/buscar.jsp" class="btn btn-outline-info" ><img src="./assets/img/search.png" class="card-img-top" alt="...">Buscar</a>
            </div>
            <div class="col-2">
                <a href="http://localhost:8080/JuegoAhorcadoDB/Crear" class="btn btn-outline-info" ><img src="./assets/img/creativity.png" class="card-img-top" alt="...">Registrar</a>
            </div>
        </div>
        <hr>
    </body>
</html>
