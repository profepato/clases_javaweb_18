package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.Region;

public class DAO_Region extends Conexion implements DAO<Region>{

    public DAO_Region() throws ClassNotFoundException, SQLException {
        super("bd_regiones");
    }

    @Override
    public void create(Region ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Region> read() throws SQLException {
        List<Region> lista = new ArrayList<>();
        String query = "SELECT * FROM region";
        ResultSet rs = ejecutar(query);
        
        Region r;
        while(rs.next()){
            r = new Region();
            
            r.setId(rs.getInt(1));
            r.setNombre(rs.getString(2));
            
            lista.add(r);
        }
        
        close();
        
        return lista;
    }

    @Override
    public void update(Region ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
