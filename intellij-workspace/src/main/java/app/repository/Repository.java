package app.repository;

import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Philippe on 22/05/2017.
 */
public interface Repository<T> {
    ObservableList<T> getAll();
    T insert(T object);
    boolean delete(T object);
    T update(T object);

}
