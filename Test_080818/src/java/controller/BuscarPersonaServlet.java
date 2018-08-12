package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Persona;

@WebServlet(name = "BuscarPersonaServlet", urlPatterns = {"/buscarPersona.do"})
public class BuscarPersonaServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut = request.getParameter("rut");
        
        /*
        Ganadores:
        - 19254755-5 - Mati Díaz
        - 19017603-7 - Franco Barrera
        */

        Persona p = null;
        
        if(rut.equals("19254755-5")){
            p = new Persona(rut, "Mati Díaz", 22);
        }else if(rut.equals("19017603-7")){
            p = new Persona(rut, "Franco Barrera", 23);
        }
            
        request.setAttribute("persona", p);
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
}
