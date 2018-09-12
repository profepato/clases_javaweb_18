package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.dao.DAO_Usuario;

@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/inicioSesion.do"})
public class InicioSesionServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Usuario u = new DAO_Usuario().getUsuario(request.getParameter("rut"));
        
            if(u == null){
                // error
                response.sendRedirect("error.jsp");
            }else{
                // menu
                request.getSession().setAttribute("usuario", u);
                response.sendRedirect("menu.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InicioSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
