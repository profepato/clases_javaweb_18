package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conexion;
import model.exceptions.ClienteNoEncontradoException;

public class DAO_Cliente extends Conexion implements DAO<Cliente>{

    public DAO_Cliente() throws ClassNotFoundException, SQLException {
        super("bd_prueba_DAO");
    }

    @Override
    public void create(Cliente cli) throws SQLException {
        ejecutar("INSERT INTO cliente VALUES(UUID(), "
                + "'"+cli.getNombre()+"',"
                + "'"+cli.getDireccion()+"')");
    }

    @Override
    public List<Cliente> read() throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        
        ResultSet rs = ejecutar("SELECT * FROM cliente;");
        
        Cliente c;
        while(rs.next()){
            c = new Cliente();
            
            c.setId(rs.getString(1));
            c.setNombre(rs.getString(2));
            c.setDireccion(rs.getString(3));
            
            lista.add(c);
        }
        
        close();
        
        return lista;
    }

    @Override
    public void update(Cliente cli) throws SQLException {
        ejecutar("UPDATE cliente "
                + "SET nombre = '"+cli.getNombre()+"', "
                + "direccion = '"+cli.getDireccion()+"' "
                + "WHERE id = '"+cli.getId()+"'");
    }

    @Override
    public void delete(String id) throws SQLException {
        ejecutar("DELETE FROM cliente WHERE id = '"+id+"'");
    }

    @Override
    public List<Cliente> read(String nombre) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        
        ResultSet rs = ejecutar("SELECT * FROM cliente "
                + "WHERE nombre LIKE '%"+nombre+"%';");
        
        Cliente c;
        while(rs.next()){
            c = new Cliente();
            
            c.setId(rs.getString(1));
            c.setNombre(rs.getString(2));
            c.setDireccion(rs.getString(3));
            
            lista.add(c);
        }
        
        close();
        
        return lista;
    }

    @Override
    public Cliente findByID(String id) throws SQLException {
        ResultSet rs = ejecutar("SELECT * FROM cliente "
                + "WHERE id = '"+id+"';");
        
        Cliente c = null;
        if(rs.next()){
            c = new Cliente();
            
            c.setId(rs.getString(1));
            c.setNombre(rs.getString(2));
            c.setDireccion(rs.getString(3));
        }
        
        close();
        
        return c;
    }
    
    public Cliente getClienteByID(String id) throws SQLException, ClienteNoEncontradoException{
        ResultSet rs = ejecutar("SELECT * FROM cliente "
                + "WHERE id = '"+id+"';");
        
        Cliente c = null;
        if(rs.next()){
            c = new Cliente();
            
            c.setId(rs.getString(1));
            c.setNombre(rs.getString(2));
            c.setDireccion(rs.getString(3));
        }
        
        close();
        
        if(c == null){
            throw new ClienteNoEncontradoException("El id "+id+" no se encuentra");
        }
        
        return c;
    }
    
    
}
