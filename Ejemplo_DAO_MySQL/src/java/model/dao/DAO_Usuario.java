package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Conexion;
import model.Usuario;

public class DAO_Usuario extends Conexion implements DAO<Usuario>{

    public DAO_Usuario() throws ClassNotFoundException, SQLException {
        super("bd_prueba_DAO");
    }

    
    public Usuario getUsuario(String rut) throws SQLException{
        ResultSet rs = ejecutar("SELECT * FROM usuario WHERE rut = '"+rut+"';");
        
        Usuario u = null;
        if(rs.next()){
            u = new Usuario();
            
            u.setId(rs.getString(1));
            u.setRut(rs.getString(2));
            u.setNombre(rs.getString(3));
            
        }
        
        close();
        
        return u;
    }

    @Override
    public void create(Usuario usu) throws SQLException {
        ejecutar("INSERT INTO usuario VALUES(NULL, '"+usu.getRut()+"','"+usu.getNombre()+"');");
    }

    @Override
    public List<Usuario> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> read(String txt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByID(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
