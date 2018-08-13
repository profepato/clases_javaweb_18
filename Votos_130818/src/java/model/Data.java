package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private Conexion c;
    private ResultSet rs;
    
    public Data() throws ClassNotFoundException, SQLException{
        c = new Conexion("votos_os");
    }
    
    public void votar(String fk_sistemaOperativo) throws SQLException{
        // Universal Unique IDentifier
        c.ejecutar("INSERT INTO voto VALUES(UUID(), '"+fk_sistemaOperativo+"',"
                + "NOW());");
    }
   
    
    public List<RegistroConteo> contarVotos() throws SQLException{
        List<RegistroConteo> lista = new ArrayList<>();
        
        rs = c.ejecutar("SELECT * FROM conteoVotos");
        
        RegistroConteo rc;
        while(rs.next()){
            rc = new RegistroConteo();
            
            rc.setNombreSistema(rs.getString(1));
            rc.setCantVotos(rs.getInt(2));
            
            lista.add(rc);
        }
        
        c.close();
        
        return lista;
    }
    
    public List<SistemaOperativo> getSistemasOperativos() throws SQLException{
        List<SistemaOperativo> lista = new ArrayList<>();
        
        rs = c.ejecutar("SELECT * FROM sistema_operativo ORDER BY nombre ASC;");
        SistemaOperativo so;
        
        while(rs.next()){
            so = new SistemaOperativo();
            
            so.setId(rs.getString(1));
            so.setNombre(rs.getString(2));
            
            lista.add(so);
        }
        
        c.close();
        
        return lista;
    }
    
}
