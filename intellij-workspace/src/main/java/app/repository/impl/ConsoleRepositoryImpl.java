package app.repository.impl;

import app.model.Console;
import app.model.Langue;
import app.repository.AbstractConnect;
import app.repository.ConsoleRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class ConsoleRepositoryImpl extends AbstractConnect implements ConsoleRepository {


    public ConsoleRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Console> getAll(String tableName, String columnName) {
        ObservableList<Console> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Console c = new Console();
                c.setName(rs.getString(columnName));
                result.add(c);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Console insert(Console object) {
        return null;
    }

    @Override
    public boolean delete(Console object) {
        return false;
    }

    @Override
    public Console update(Console object) {
        return null;
    }

    @Override
    public ObservableList<Console> getAll() {
        return null;
    }
}
