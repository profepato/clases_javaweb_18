<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="validar.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menú</h1>
        <h3>Bienvenid@ <%= u.getNombre() %></h3>
        <a href='crearProducto.jsp'>Producto</a>
        
        <%@include file="cerrar.jsp" %>
    </body>
</html>
