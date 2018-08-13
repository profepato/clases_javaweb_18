package mode.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.ConteoVotos;

public class DAO_ConteoVotos extends Conexion implements DAO<ConteoVotos>{

    public DAO_ConteoVotos() throws ClassNotFoundException, SQLException {
        super("bd_votos");
    }

    @Override
    public void create(ConteoVotos object) throws Exception {
    }

    @Override
    public List<ConteoVotos> read() throws Exception {
        List<ConteoVotos> lista = new ArrayList<>();
        
        ResultSet rs = ejecutar("SELECT * FROM contarVotos;");
        
        ConteoVotos cv;
        while(rs.next()){
            cv = new ConteoVotos();
            
            cv.setSistemaOperativo(rs.getString(1));
            cv.setCantidadVotos(rs.getInt(2));
            
            lista.add(cv);
        }
        
        return lista;
    }

    @Override
    public void update(ConteoVotos object) throws Exception {
    }

    @Override
    public void delete(String id) throws Exception {
    }
    
}
