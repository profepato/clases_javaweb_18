package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Ciudad;
import model.Conexion;

public class DAO_Ciudad extends Conexion implements DAO<Ciudad>{

    public DAO_Ciudad() throws ClassNotFoundException, SQLException {
        super("bd_regiones");
    }

    @Override
    public void create(Ciudad ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> read() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ciudad ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Ciudad> read(String idRegion) throws SQLException {
        List<Ciudad> lista = new ArrayList<>();
        String query = "SELECT * FROM ciudad WHERE fk_region = "+idRegion;
        ResultSet rs = ejecutar(query);
        
        Ciudad c;
        while(rs.next()){
            c = new Ciudad();
            
            c.setId(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setFkRegion(rs.getInt(3));
            
            lista.add(c);
        }
        
        close();
        
        return lista;
    }
    
}
