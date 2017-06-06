package app.repository.impl;

import app.model.Langue;
import app.model.Marque;
import app.repository.AbstractConnect;
import app.repository.MarqueRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class MarqueRepositoryImpl extends AbstractConnect implements MarqueRepository {


    public MarqueRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Marque> getAll(String tableName, String columnName) {
        ObservableList<Marque> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Marque m = new Marque();
                m.setName(rs.getString(columnName));
                result.add(m);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Marque insert(Marque object) {
        return null;
    }

    @Override
    public boolean delete(Marque object) {
        return false;
    }

    @Override
    public Marque update(Marque object) {
        return null;
    }

    @Override
    public ObservableList<Marque> getAll() {
        return null;
    }


}


