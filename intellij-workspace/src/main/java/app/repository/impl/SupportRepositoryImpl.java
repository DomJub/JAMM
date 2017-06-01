package app.repository.impl;

import app.model.Langue;
import app.model.Support;
import app.repository.AbstractConnect;
import app.repository.SupportRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class SupportRepositoryImpl extends AbstractConnect implements SupportRepository  {


    public SupportRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Support> getAll(String tableName, String columnName) {
        ObservableList<Support> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Support s = new Support();
                s.setName(rs.getString(columnName));
                result.add(s);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Support insert(Support object) {
        return null;
    }

    @Override
    public boolean delete(Support object) {
        return false;
    }

    @Override
    public Support update(Support object) {
        return null;
    }

    @Override
    public ObservableList<Support> getAll() {
        return null;
    }
}
