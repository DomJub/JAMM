package app.repository.impl;

import app.model.Film;
import app.model.Oeuvre;
import app.repository.AbstractConnect;
import app.repository.OeuvreRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Oeuvre> result = new ArrayList<>();
        try {
            AbstractConnect.getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;

            String query = "SELECT * FROM oeuvre";
            preparedStatement = conn.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
                switch (type) {
                    case "video":
                        Film film = new Film();
                        film.setAuteur(rs.getString("auteur"));
                        result.add(film);
                        break;
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
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
