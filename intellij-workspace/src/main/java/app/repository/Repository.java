package app.repository;

import app.model.Oeuvre;
import javafx.collections.ObservableList;

/**
 * Created by Philippe on 22/05/2017.
 */
public interface Repository<T> {
	ObservableList<T> getAll(String tableName, String columnName);

	T insert(T object);

	boolean delete(T object);

	T update(T object);

	ObservableList<T> getAll();
}
