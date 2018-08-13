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
import model.Data;

@WebServlet(name = "VotarServlet", urlPatterns = {"/votar.do"})
public class VotarServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // nada
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            String[] uuids = req.getParameterValues("so");
            
            Data d = new Data();
            
            for (String uuid : uuids) {
                d.votar(uuid);
            }
            
            res.sendRedirect("index.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VotarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
