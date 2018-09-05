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
import model.Producto;
import model.dao.DAO_Producto;

@WebServlet(name = "CrearProductoServlet", urlPatterns = {"/crearProducto.do"})
public class CrearProductoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
//          
            // vivo la vida al límite
            new DAO_Producto().create(
                new Producto()
                .setNombre(request.getParameter("nombre"))
                .setStock(Integer.parseInt(request.getParameter("stock")))
                .setPrecio(Integer.parseInt(request.getParameter("precio")))
            );
            
            response.sendRedirect("crearProducto.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
