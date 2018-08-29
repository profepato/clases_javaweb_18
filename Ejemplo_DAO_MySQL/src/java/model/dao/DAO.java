package model.dao;

import java.sql.SQLException;
import java.util.List;


public interface DAO<T> {
    void create(T ob) throws SQLException;
    List<T> read() throws SQLException;
    void update(T ob) throws SQLException;
    void delete(String id) throws SQLException;
    
    // extra
    List<T> read(String txt) throws SQLException;
    T findByID(String id) throws SQLException; 
}
