<%@page import="model.ConteoVotos"%>
<%@page import="mode.dao.DAO_ConteoVotos"%>
<%@page import="model.SistemaOperativo"%>
<%@page import="mode.dao.DAO_SistemaOperativo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pregunta</h1>
        <div>
            ¿Qué sistemas operativos conoces?
        </div>
        
        <div>
            <form action="votar.do" method="post">
                <%
                DAO_SistemaOperativo d = new DAO_SistemaOperativo();
                
                for (SistemaOperativo so : d.read()) {
                    out.print("<input type='checkbox' name='so' value='"+so.getId()+"'/>"+so.getNombre()+"<br>");
                }
                %>
                <input type="submit" value="Votar"/>
            </form>
                
            <%
            DAO_ConteoVotos dcv = new DAO_ConteoVotos();
            %>    
            
            <h1>Resultados</h1>
            <table border="1">
                <tr>
                    <th>Sistema operativo</th>
                    <th>Votos</th>
                </tr>
                <%for (ConteoVotos cv : dcv.read()) {%>
                <tr>
                    <td><%= cv.getSistemaOperativo() %></td>
                    <td><%= cv.getCantidadVotos() %></td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
