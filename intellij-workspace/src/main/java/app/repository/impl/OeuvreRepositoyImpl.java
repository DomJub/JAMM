package app.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.Oeuvre;
import app.model.OeuvreLite;
import app.repository.AbstractConnect;
import app.repository.OeuvreRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Philippe on 22/05/2017.
 */
public class OeuvreRepositoyImpl implements OeuvreRepository {

	Connection conn = AbstractConnect.getConnection();

	public OeuvreRepositoyImpl() throws SQLException {
	}

	@Override
	public ObservableList<Oeuvre> getAll() {
		ObservableList<Oeuvre> result = FXCollections.observableArrayList();
		try {
			AbstractConnect.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;

			String query = "SELECT * FROM oeuvre ORDER BY id_oeuvre DESC LIMIT 10";
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				 OeuvreLite oeuvreLite = new OeuvreLite();
				 oeuvreLite.setTitre(rs.getString("titre"));
				 oeuvreLite.setNote((rs.getInt("note")));
				 oeuvreLite.setOrigine(rs.getString("origine"));
				 result.add(oeuvreLite);
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
