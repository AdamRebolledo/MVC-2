<%-- 
    Document   : listar
    Created on : 24-03-2019, 20:57:47
    Author     : 56974
--%>

<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    
                       <h1>Personas !</h1>

        <table border="1" class="table table-striped table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>RUT</th>
                    <th>NOMBRES</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            
            <%
            PersonaDAO dao = new PersonaDAO();
            List<Persona> list = dao.listar();
            Iterator<Persona>iter = list.iterator();
            Persona per = null; 
            while(iter.hasNext()){
            per=iter.next();
            
            %>
            
            <tbody>
                <tr>
                    <td><%= per.getId() %></td>
                    <td><%= per.getRut()%></td>
                    <td><%= per.getNombre()%></td>
                    <td>
                        <a href="Controlador?accion=editar&id=<%= per.getId()%>" class="btn btn-warning">Editar</a>
                        <a href="Controlador?accion=eliminar&id=<%= per.getId()%>" class="btn btn-danger">Eliminar</a>                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
 
            <a href="Controlador?accion=add" class="btn btn-info">Agregar Persona</a>
            
         </div>
                
            </div>
        </div>
        
    </body>
</html>
