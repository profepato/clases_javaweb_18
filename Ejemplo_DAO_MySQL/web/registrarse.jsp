<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Disfrute el sw</h1>
        <form action="crearUsuario.do" method="post">
            <input type="text" placeholder="Rut: " name="rut" required>
            <input type="text" placeholder="Nombre: " name="nombre" required>
            <input type="submit" value="Regístrame">
        </form>
        <a href="index.jsp">Volver</a>
    </body>
</html>
