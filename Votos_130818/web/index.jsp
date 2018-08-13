<%@page import="model.RegistroConteo"%>
<%@page import="java.util.List"%>
<%@page import="model.SistemaOperativo"%>
<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Preguntas</h1>
        <form action="votar.do" method="post">
            <%
                Data d = new Data();

                List<SistemaOperativo> lista = d.getSistemasOperativos();

                for (SistemaOperativo so : lista) {%>
            <input type="checkbox" name="so" value="<%= so.getId()%>"/><%= so.getNombre()%><br>
            <%}%>
            <input type="submit" value="Votar"/>
        </form>

        <table border="1">
            <tr>
                <th>Sistema operativo</th>
                <th>Votos</th>
            </tr>

            <%
                for (RegistroConteo rc : d.contarVotos()) {%>
                    <tr>
                        <td><%= rc.getNombreSistema() %></td>
                        <td><%= rc.getCantVotos() %></td>
                    </tr>  
            <%}
            %>
        </table>
    </body>
</html>
