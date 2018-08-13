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
import mode.dao.DAO_Voto;
import model.Voto;

@WebServlet(name = "VotarServlet", urlPatterns = {"/votar.do"})
public class VotarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            String[] sos = request.getParameterValues("so");
            
            DAO_Voto d = new DAO_Voto();
            
            for (String so : sos) {
                Voto v = new Voto();
                v.setFkSistemaOperativo(so);
                
                d.create(v);
            }
            
            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VotarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VotarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
