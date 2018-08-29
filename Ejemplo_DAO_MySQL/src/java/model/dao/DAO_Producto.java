package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.Producto;


public class DAO_Producto extends Conexion implements DAO<Producto>{

    public DAO_Producto() throws ClassNotFoundException, SQLException {
        super("bd_prueba_DAO");
    }

    @Override
    public void create(Producto pro) throws SQLException {
        ejecutar("INSERT INTO producto VALUES(UUID(), "
                + "'"+pro.getNombre()+"',"
                + "'"+pro.getStock()+"', "
                + "'"+pro.getPrecio()+"')");
    }

    @Override
    public List<Producto> read() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        
        ResultSet rs = ejecutar("SELECT * FROM producto;");
        
        Producto pro;
        while(rs.next()){
            pro = new Producto();
            
            pro.setId(rs.getString(1));
            pro.setNombre(rs.getString(2));
            pro.setStock(rs.getInt(3));
            pro.setPrecio(rs.getInt(4));
            
            lista.add(pro);
        }
        
        return lista;
    }

    @Override
    public void update(Producto pro) throws SQLException {
        ejecutar("UPDATE producto "
                + "SET nombre = '"+pro.getNombre()+"', "
                + "stock = '"+pro.getStock()+"', "
                + "precio = '"+pro.getPrecio()+"' "
                + "WHERE id = '"+pro.getId()+"'");
    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM producto WHERE id = '"+id+"'");
    }

    @Override
    public List<Producto> read(String nombre) throws SQLException {
        List<Producto> lista = new ArrayList<>();
        
        ResultSet rs = ejecutar("SELECT * FROM producto "
                + "WHERE nombre LIKE '%"+nombre+"%';");
        
        Producto pro;
        while(rs.next()){
            pro = new Producto();
            
            pro.setId(rs.getString(1));
            pro.setNombre(rs.getString(2));
            pro.setStock(rs.getInt(3));
            pro.setPrecio(rs.getInt(4));
            
            lista.add(pro);
        }
        
        return lista;
    }

    @Override
    public Producto findByID(String id) throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM producto "
                + "WHERE id = '"+id+"';");
        
        Producto pro = null;
        if(rs.next()){
            pro = new Producto();
            
            pro.setId(rs.getString(1));
            pro.setNombre(rs.getString(2));
            pro.setStock(rs.getInt(3));
            pro.setPrecio(rs.getInt(4));
        }
        
        return pro;
    }
    
}
