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
import model.dao.DAO_Producto;

@WebServlet(name = "EliminarProductoServlet", urlPatterns = {"/eliminarProducto.do"})
public class EliminarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            new DAO_Producto().delete(request.getParameter("id"));
            
            response.sendRedirect("crearProducto.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EliminarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
