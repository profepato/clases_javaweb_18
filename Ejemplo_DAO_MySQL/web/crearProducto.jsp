<%@page import="model.Producto"%>
<%@page import="model.dao.DAO_Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="validar.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Producto</h1>
        
        <form action="crearProducto.do" method="post">
            <input type="text"      name="nombre" placeholder="Nombre: " required/>
            <input type="number"    name="precio" placeholder="Precio: " required/>
            <input type="number"    name="stock" placeholder="Stock: " required/>
            <input type="submit" value="Registrar" name="btnRegistrar" />
        </form>
        
        <div>
            <h3>Productos</h3>
            <table border="1">
                <thead>
                    <tr>
                        <!-- <th>ID</th> -->
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Eliminar</th>
                        <th>Actualizar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAO_Producto dp = new DAO_Producto();
                    
                    for (Producto pro : dp.read()) {%>
                    
                        <%
                        if(request.getParameter("idActualizar") != null){
                            String idActualizar = request.getParameter("idActualizar");
                            
                            if(idActualizar.equals(pro.getId())){%>
                                <form action="actualizarProducto.do" method="post">
                                    <tr>
                                        <input type="hidden" name="id" value="<%= pro.getId() %>"/>
                                        <!-- <td><%= pro.getId() %></td> -->
                                        <td><input type="text" name="nombre" value="<%= pro.getNombre()%>"></td>
                                        <td><input type="number" name="precio" value="<%= pro.getPrecio()%>"></td>
                                        <td><input type="number" name="stock" value="<%= pro.getStock()%>"></td>
                                        <td>
                                            Eliminar
                                        </td>
                                        <td>
                                            <input type="submit" value="Aceptar"/>
                                        </td>
                                    </tr>
                                </form>
                            <%}else{%>
                                <tr>
                                    <!-- <td><%= pro.getId() %></td> -->
                                    <td><%= pro.getNombre()%></td>
                                    <td>$ <%= pro.getPrecio()%></td>
                                    <td><%= pro.getStock() %></td>
                                    <td>
                                        <form action="confirmacion.jsp" method="post">
                                            <input type="hidden" name="id" value="<%= pro.getId() %>"/>
                                            <input type="submit" value="Eliminar"/>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="crearProducto.jsp" method="post">
                                            <input type="hidden" name="idActualizar" value="<%= pro.getId() %>"/>
                                            <input type="submit" value="Actualizar"/>
                                        </form>
                                    </td>
                                </tr>
                            <%}
                        }else{%>
                            <tr>
                                <!-- <td><%= pro.getId() %></td> -->
                                <td><%= pro.getNombre()%></td>
                                <td>$ <%= pro.getPrecio()%></td>
                                <td><%= pro.getStock() %></td>
                                <td>
                                    <form action="confirmacion.jsp" method="post">
                                        <input type="hidden" name="id" value="<%= pro.getId() %>"/>
                                        <input type="submit" value="Eliminar"/>
                                    </form>
                                </td>
                                <td>
                                    <form action="crearProducto.jsp" method="post">
                                        <input type="hidden" name="idActualizar" value="<%= pro.getId() %>"/>
                                        <input type="submit" value="Actualizar"/>
                                    </form>
                                </td>
                            </tr>
                        <%}
                        %>
                        
                    <%}%>
                    
                    <%
                    
                    /*for (Producto pro : dp.read()) {
                        out.println("<tr>");
                            out.println("<td>"+pro.getId()+"</td>");
                            out.println("<td>"+pro.getNombre()+"</td>");
                            out.println("<td>"+pro.getPrecio()+"</td>");
                            out.println("<td>"+pro.getStock()+"</td>");
                        out.println("</tr>");
                    }*/%>
                </tbody>
            </table>

        </div>
        <a href='menu.jsp'>Volver</a>
        <%@include file="cerrar.jsp" %>
    </body>
</html>
