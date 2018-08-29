package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.Conexion;
import model.Producto;

public class DAO_Producto extends Conexion implements DAO<Producto>{

    public DAO_Producto() throws ClassNotFoundException, SQLException {
        super("bd_prueba_DAO");
    }

    @Override
    public void create(Producto ob) throws SQLException {
        ejecutar("INSERT INTO producto "
                + "VALUES(UUID(), '"+ob.getNombre()+"', "
                + "'"+ob.getStock()+"', "
                + "'"+ob.getPrecio()+"');");
    }

    @Override
    public List<Producto> read() throws SQLException {
    }

    @Override
    public void update(Producto ob) throws SQLException {
    }

    @Override
    public void delete(String id) throws SQLException {
    }

    @Override
    public List<Producto> read(String txt) throws SQLException {
    }

    @Override
    public Producto findByID(String id) throws SQLException {
    }

    
}
