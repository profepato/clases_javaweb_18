package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import model.dao.DAO_Producto;


@WebServlet(name = "ActualizarProductoServlet", urlPatterns = {"/actualizarProducto.do"})
public class ActualizarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Producto p = new Producto();
            
            p.setId(request.getParameter("id"));
            p.setNombre(request.getParameter("nombre"));
            p.setStock(Integer.parseInt(request.getParameter("stock")));
            p.setPrecio(Integer.parseInt(request.getParameter("precio")));
            
            new DAO_Producto().update(p);
            
            response.sendRedirect("crearProducto.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ActualizarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
