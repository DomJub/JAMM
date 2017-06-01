package app.repository.impl;

import app.model.Marque;
import app.model.Modele;
import app.repository.AbstractConnect;
import app.repository.MarqueRepository;
import app.repository.ModeleRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class ModeleRepositoryImpl extends AbstractConnect implements ModeleRepository {


    public ModeleRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<Modele> getAll(String tableName, String columnName) {
        ObservableList<Modele> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                Modele mo = new Modele();
                mo.setName(rs.getString(columnName));
                result.add(mo);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public Modele insert(Modele object) {
        return null;
    }

    @Override
    public boolean delete(Modele object) {
        return false;
    }

    @Override
    public Modele update(Modele object) {
        return null;
    }

    @Override
    public ObservableList<Modele> getAll() {
        return null;
    }


}


