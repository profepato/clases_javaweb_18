<%@page import="model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
        
        <%
            Persona p = (Persona)request.getAttribute("persona");
            
            if(p == null){
                out.print("Lo siento, no ha ganado :C");
            }else{
                out.print("Felicidades "+p.getNombre());
                out.print("<br> usted ha ganado!");
                out.print("<br>Su edad: "+p.getEdad());
            }
        %>
        
        <a href="index.html">Volver</a>
    </body>
</html>
