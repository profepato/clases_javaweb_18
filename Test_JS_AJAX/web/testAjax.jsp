<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="js/jquery-3.3.1.min.js"></script>

        <script>
            function buscar() {
                var rutUsuario = $("#rut").val();
                //alert(rutUsuario);

                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/Test_JS/buscar.do',
                    data: {
                        rut: rutUsuario
                    }
                }).done(function (resultadoHtml) {
                    $("#datos").html(resultadoHtml);
                });
            }
        </script>

        <input type="text" id="rut" name="rut" placeholder="Rut:"/>
        <input type="button" value="Buscar" onclick="buscar()"/>

        <div id="datos"></div>
    </body>
</html>
