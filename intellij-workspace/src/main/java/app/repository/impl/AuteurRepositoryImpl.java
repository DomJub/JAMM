package app.repository.impl;

import app.model.Auteur;
import app.repository.AbstractConnect;
import app.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class AuteurRepositoryImpl implements Repository<Auteur> {

    Connection conn = AbstractConnect.getConnection();

    public AuteurRepositoryImpl() throws SQLException {
    }

    @Override
    public ObservableList<Auteur> getAll(String tableName, String columnName) {
        ObservableList<Auteur> result = FXCollections.observableArrayList();
        try {

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Auteur a = new Auteur();
                a.setName(rs.getString(columnName));
                result.add(a);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Auteur insert(Auteur object) {
        return null;
    }

    @Override
    public boolean delete(Auteur object) {
        return false;
    }

    @Override
    public Auteur update(Auteur object) {
        return null;
    }

    @Override
    public ObservableList<Auteur> getAll() {
        return null;
    }

}
