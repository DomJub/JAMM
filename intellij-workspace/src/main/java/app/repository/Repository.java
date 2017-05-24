package app.repository;

import java.util.List;

/**
 * Created by Philippe on 22/05/2017.
 */
public interface Repository<T> {
    List<T> getAll();
    T insert(T object);
    boolean delete(T object);
    T update(T object);

}
