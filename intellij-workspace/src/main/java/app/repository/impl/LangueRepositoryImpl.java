package app.repository.impl;

import app.model.Langue;
import app.repository.AbstractConnect;
import app.repository.LangueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class LangueRepositoryImpl extends AbstractConnect implements LangueRepository  {


    public LangueRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Langue> getAll(String tableName, String columnName) {
        ObservableList<Langue> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Langue l = new Langue();
                l.setName(rs.getString(columnName));
                result.add(l);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Langue insert(Langue object) {
        return null;
    }

    @Override
    public boolean delete(Langue object) {
        return false;
    }

    @Override
    public Langue update(Langue object) {
        return null;
    }


    @Override
    public ObservableList<Langue> getAll() {
        return null;
    }
}
