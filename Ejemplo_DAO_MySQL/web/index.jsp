<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inicio de sesión</h1>
        
        <form action="inicioSesion.do" method="post">
            <input type="password" name="rut" placeholder="Rut: " required>
            <input type="submit" value="Entrar">
        </form>
        <a href="registrarse.jsp">Registrarse</a>
    </body>
</html>
