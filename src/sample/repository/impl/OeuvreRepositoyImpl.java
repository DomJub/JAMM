package sample.repository.impl;

import sample.model.Oeuvre;
import sample.repository.AbstractConnect;
import sample.repository.OeuvreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Philippe on 22/05/2017.
 */
public class OeuvreRepositoyImpl implements OeuvreRepository {

    Connection conn = AbstractConnect.getConnection();

    public OeuvreRepositoyImpl() throws SQLException {
    }

    @Override
    public List<Oeuvre> getAll() {
        try {
            AbstractConnect.getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;

            String query = "SELECT * FROM oeuvre";
            //PreparedStatement = conn.prepareStatement(query);


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Oeuvre insert(Oeuvre object) {
        return null;
    }

    @Override
    public boolean delete(Oeuvre object) {
        return false;
    }

    @Override
    public Oeuvre update(Oeuvre object) {
        return null;
    }


}
