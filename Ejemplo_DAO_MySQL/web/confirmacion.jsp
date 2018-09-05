<%@page import="model.Producto"%>
<%@page import="model.dao.DAO_Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
Producto pro = new DAO_Producto().findByID(request.getParameter("id"));
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Confirmación</h1>
        
        <div>
            <h3>Datos del producto</h3>
            <div>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Nombre:</td>
                            <td><%= pro.getNombre() %></td>
                        </tr>
                        <tr>
                            <td>Precio:</td>
                            <td>$ <%= pro.getPrecio()%></td>
                        </tr>
                        <tr>
                            <td>Stock</td>
                            <td><%= pro.getStock()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            
            <br>
            ¿Desea eliminar dicho producto?
            
            <form action="eliminarProducto.do" method="post">
                <input type="hidden" name="id" value="<%= pro.getId() %>">
                <input type="submit" value="Si">
            </form>
            
            <form action="crearProducto.jsp" method="post">
                <input type="submit" value="No">
            </form>
            
            
            <!--
            2 formularios (SI, NO)
            
            NO -> action -> crearProducto.jsp
            SI -> action -> EliminarProductoServlet 
                -> id -> hidden -> eliminarProducto.do
            
            -->
        </div>
    </body>
</html>
