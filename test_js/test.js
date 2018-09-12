var cont = 0;

function hola(){
    cont++;
    var btn = document.getElementById("btnPush");
    btn.style.color = "red";
    btn.style.backgroundColor = "yellow";
    btn.value = "Hola!";
    document.getElementById("mensaje").innerHTML = cont;
}