<%-- 
    Document   : estudiantes
    Created on : 22/05/2021, 11:35:22 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="estudiantes" method="POST">
           Identificacion: <input name="identificacion" type="text"/>
           Nombre:  <input name="nombre" type="text" id="nombre"/>
            
           Apellido: <input name="apellido" type="text" id="apellido"/>
           edad: <input name="edad" type="text" id="edad"/>
            Correo:<input name="correo" type="text" id="correo"/>
            <button type="submit">crear</button>
        </form>
    </body>
</html>
