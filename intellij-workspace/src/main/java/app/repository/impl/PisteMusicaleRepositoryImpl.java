package app.repository.impl;

import app.model.PisteMusicale;
import app.model.PisteMusicale;
import app.repository.AbstractConnect;
import app.repository.PisteMusicaleRepository;
import app.repository.SupportRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class PisteMusicaleRepositoryImpl extends AbstractConnect implements PisteMusicaleRepository  {


    public PisteMusicaleRepositoryImpl() throws ClassNotFoundException, SQLException {
    }

    @Override
    public ObservableList<PisteMusicale> getAll(String tableName, String columnName) {
        ObservableList<PisteMusicale> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " ASC")
                    .executeQuery();

            while (rs.next()) {

                PisteMusicale p = new PisteMusicale();
                p.setName(rs.getString(columnName));
                result.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }


    public ObservableList<PisteMusicale> getAllByIdOeuvre(String tableName, String columnName, String nameOeuvre) {
        ObservableList<PisteMusicale> result = FXCollections.observableArrayList();
        try {
            AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM " + tableName + "oeuvre_id_oeuvre IN (SELECT id_oeuvre FROM oeuvre WHERE titre = " + nameOeuvre +") ORDER BY " + columnName + " ASC ")
                    .executeQuery();

            while (rs.next()) {

                PisteMusicale p = new PisteMusicale();
                p.setNumPiste(rs.getInt("numero"));
                p.setNomPiste(rs.getString("nom_piste"));
                result.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }


    @Override
    public PisteMusicale insert(PisteMusicale object) {
        return null;
    }

    @Override
    public boolean delete(PisteMusicale object) {
        return false;
    }

    @Override
    public PisteMusicale update(PisteMusicale object) {
        return null;
    }

    @Override
    public ObservableList<PisteMusicale> getAll() {
        return null;
    }

    @Override
    public ObservableList<PisteMusicale> getAllByIdOeuvre() {
        return null;
    }
}
