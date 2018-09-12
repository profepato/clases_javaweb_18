<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Usuario u = (Usuario)session.getAttribute("usuario");

if(u == null){
    // no he iniciado sesión
    request.getRequestDispatcher("index.jsp").forward(request, response);
}
%>