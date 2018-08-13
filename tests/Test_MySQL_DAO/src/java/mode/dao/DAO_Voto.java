package mode.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.Voto;

public class DAO_Voto extends Conexion implements DAO<Voto>{

    public DAO_Voto() throws ClassNotFoundException, SQLException {
        super("bd_votos");
    }

    @Override
    public void create(Voto voto) throws Exception {
        ejecutar("INSERT INTO voto VALUES(NULL, '"+voto.getFkSistemaOperativo()+"',NOW());");
    }

    @Override
    public List<Voto> read() throws Exception {
        List<Voto> votos = new ArrayList<>();
        
        Voto v;
        ResultSet rs = ejecutar("SELECT * FROM voto");
        
        while(rs.next()){
            v = new Voto();
            
            v.setId(rs.getString(1));
            v.setFkSistemaOperativo(rs.getString(2));
            v.setFecha(rs.getTimestamp(3));
            
            votos.add(v);
        }
        
        return votos;
    }

    @Override
    public void update(Voto object) throws Exception {
    }

    @Override
    public void delete(String id) throws Exception {
    }
    
}
