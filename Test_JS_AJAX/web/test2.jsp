
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
            
            $( document ).ready(function() {
                cambiarCSS();
                otraFuncion();
            });

            function otraFuncion(){
                console.log("otra función");
            }
    
            function cambiarCSS(){
                var ob = setInterval(function(){
                    var r = Math.round(Math.random()*255);
                    var g = Math.round(Math.random()*255);
                    var b = Math.round(Math.random()*255);
                    var color = "rgb("+r+","+g+","+b+")";

                    $("#cuadrado").html(color);
                    $("#cuadrado").css("background-color",color);
                }, 1000);
                
                // clearInterval(ob); detener el pseudo hilo
            }
        </script>
        
        <div id="cuadrado">rgb(255,0,0)</div>
        
        <style>
            #cuadrado{
                width: 200px;
                background-color: rgb(255,0,0);
                color: white;
                font-size: 25px;
                text-align: center;
                font-family: arial;
                /*Centrado mal hecho*/
                padding: 85px 0px 85px 0px;
            }
        </style>
    </body>
</html>
