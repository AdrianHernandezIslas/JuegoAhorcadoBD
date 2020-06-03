<%-- 
    Document   : crear
    Created on : 11/05/2019, 10:00:17 PM
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesionActual = request.getSession(true);
    String tipo = (String) sesionActual.getAttribute("tipos");
    
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
        <h2>Nueva Palabra</h2>
        <hr>
        <form name="registro" action="Crear" method="POST">
            <div class="row">
            <div class="col-3">
              <div class="form-group">
                <label for="palabra">Palabra</label>
                <input type="text" class="form-control" id="palabra" name="palabra" placeholder="Escribe nueva palabra">
              </div>
            </div>
            <div class="col-3">
                <div class="form-group">
                    <label for="palabra">Tipo</label>
                    <select class="custom-select" name="tipo">
                        <%=tipo %>
                    </select>
                </div>
            </div>
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
          </div>
          <div class="row">
            <div class="col-3"></div>
            <div class="col-2">
                <button type="submit" class="btn btn-info btn-block">Registrar</button>
            </div> 
            <div class="col-2">
                <a href="admin.jsp" class="btn btn-secondary btn-block">Cancelar</a>
            </div>
          </div>
        </form>
       <hr>
    </body>
</html>
