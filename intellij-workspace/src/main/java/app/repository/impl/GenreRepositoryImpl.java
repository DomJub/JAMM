package app.repository.impl;

import app.model.Genre;
import app.model.Langue;
import app.repository.AbstractConnect;
import app.repository.GenreRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class GenreRepositoryImpl extends AbstractConnect implements GenreRepository  {


    public GenreRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Genre> getAll(String tableName, String columnName) {
        ObservableList<Genre> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Genre g = new Genre();
                g.setName(rs.getString(columnName));
                result.add(g);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Genre insert(Genre object) {
        return null;
    }

    @Override
    public boolean delete(Genre object) {
        return false;
    }

    @Override
    public Genre update(Genre object) {
        return null;
    }

    @Override
    public ObservableList<Genre> getAll() {
        return null;
    }

}
