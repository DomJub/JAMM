package app.repository.impl;

import app.model.Auteur;
import app.repository.AbstractConnect;
import app.repository.AuteurRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jub on 31/05/2017.
 */
public class AuteurRepositoryImpl implements AuteurRepository{

    Connection conn = AbstractConnect.getConnection();

    public AuteurRepositoryImpl() throws SQLException {
    }

    @Override
    public ObservableList<Auteur> getAll() {
        ObservableList<Auteur> result = FXCollections.observableArrayList();
        try {
            //AbstractConnect.getConnection();

            ResultSet rs = conn
                    .prepareStatement("SELECT * FROM auteur ORDER BY id_auteur ASC")
                    .executeQuery();

            while (rs.next()) {

                Auteur a = new Auteur();
                a.setNomAuteur(rs.getString("nom_auteur"));
                result.add(a);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public String toString(Auteur auteur){
        return auteur.toString();
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
}
