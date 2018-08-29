package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Conexion;

public class DAO_Cliente extends Conexion implements DAO<Cliente>{

    public DAO_Cliente() throws ClassNotFoundException, SQLException {
        super("bd_prueba_DAO");
    }

    @Override
    public void create(Cliente ob) throws SQLException {
        ejecutar("INSERT INTO cliente VALUES(UUID(), "
                + "'"+ob.getNombre()+"',"
                + "'"+ob.getDireccion()+"')");
    }

    @Override
    public List<Cliente> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> read(String txt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findByID(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
