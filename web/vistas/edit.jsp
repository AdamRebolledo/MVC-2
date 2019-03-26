<%-- 
    Document   : edit
    Created on : 24-03-2019, 20:58:25
    Author     : 56974
--%>

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
        <%
        PersonaDAO dao=new PersonaDAO();
        int id = Integer.parseInt((String)request.getAttribute("id"));
        Persona per = (Persona)dao.list(id);
        %>
        <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <h1 class="p-4">Editar Persona</h1>
                        <form action="Controlador" >
                            
                            <div class="form-group">
                                <input type="text" name="rut" class="form-control" id=""  value="<%= per.getRut()%>">
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="id" class="form-control" id="" value="<%= per.getId()%>">
                            </div>
                            <div class="form-group">
                                <input type="text" name="nombre" class="form-control" id="" value="<%= per.getNombre()%>">
                            </div>

                            <input type="submit" name="accion" value="Actualizar" class="btn btn-primary">
                            
                            <a href="Controlador?accion=listar" class="btn btn-info">Regresar</a>
                        </form>



                    </div>                        
                </div>
            </div>
    </body>
</html>
