package mode.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.SistemaOperativo;

public class DAO_SistemaOperativo  extends Conexion implements DAO<SistemaOperativo>{

    public DAO_SistemaOperativo() throws ClassNotFoundException, SQLException {
        super("bd_votos");
    }

    @Override
    public void create(SistemaOperativo object) throws SQLException {
        ejecutar("INSERT INTO sistema_operativo VALUES(NULL, '"+object.getNombre()+"')");
    }

    @Override
    public List<SistemaOperativo> read() throws SQLException {
        List<SistemaOperativo> lista = new ArrayList<>();
        ResultSet rs = ejecutar("SELECT * FROM sistema_operativo");
        
        SistemaOperativo so;
        while(rs.next()){
            so = new SistemaOperativo();
            
            so.setId(rs.getString(1));
            so.setNombre(rs.getString(2));
            
            lista.add(so);
        }
        
        return lista;
    }

    @Override
    public void update(SistemaOperativo object) {
    }

    @Override
    public void delete(String id) {
    }
    
}
