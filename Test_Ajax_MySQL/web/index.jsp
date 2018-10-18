<%@page import="model.Region"%>
<%@page import="model.DAO.DAO_Region"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-3.3.1.min.js"></script>
    </head>
    <body>
        <script>
            
            $( document ).ready(function() {
                buscar();
            });
            
            function buscar(){
                var idRegion = $("#cboRegiones").val();
                //console.log("ID Región: "+idRegion);
                
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/Test_Ajax_MySQL/buscarCiudad.do',
                    data: {
                        cboRegiones: idRegion
                    }
                }).done(function (resultadoHtml) {
                    $("#divCiudades").html(resultadoHtml);
                });
            }
        </script>
        
        <form>
            <select id="cboRegiones" name="cboRegiones" onchange="buscar()">
                <%
                DAO_Region dr = new DAO_Region();
                
                for (Region reg : dr.read()) {
                    out.print("<option value='"+reg.getId()+"'>"+reg.getNombre()+"</option>");
                }
                %>
            </select>
            
            <div id="divCiudades"> <!-- Se va a cargar con ajax -->
                <select></select>
            </div>
        </form>
    </body>
</html>
