package mode.dao;

import java.util.List;

public interface DAO<T> {
    void create(T object) throws Exception;
    List<T> read() throws Exception;
    void update(T object) throws Exception;
    void delete(String id) throws Exception;
}
