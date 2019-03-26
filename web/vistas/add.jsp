<%-- 
    Document   : add
    Created on : 24-03-2019, 20:57:58
    Author     : 56974
--%>

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
                        <h1 class="p-4">Agregar Persona</h1>
                        <form action="Controlador" >
                            
                            <div class="form-group">
                                <input type="text" name="rut" class="form-control" id=""  placeholder="RUT">
                            </div>
                            <div class="form-group">
                                <input type="text" name="nombre" class="form-control" id="" placeholder="Nombre">
                            </div>

                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                        </form>



                    </div>                        
                </div>
            </div>


    </body>
</html>
