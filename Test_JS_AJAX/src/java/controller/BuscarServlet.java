package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="BuscarServlet", urlPatterns={"/buscar.do"})
public class BuscarServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //response.sendRedirect(".jsp");
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String rut = request.getParameter("rut");
        
        // acá iría un objeto del tipo DAO llamando a un método
        // getCliente(rut)
        
        response.getWriter().println("<h4>Datos</h4>");
        if(rut.equals("11-1")){
            response.getWriter().println("Nombre: Pablo Pérez Ponce");
        }else if(rut.equals("22-2")){
            response.getWriter().println("Nombre: Pabli Cavieres San Martín");
        }else{
            response.getWriter().println("No se encuentra el rut "+rut);
        }
    }
}
