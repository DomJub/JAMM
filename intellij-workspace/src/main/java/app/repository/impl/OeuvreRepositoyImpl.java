package app.repository.impl;

import app.model.Auteur;
import app.model.Oeuvre;
import app.model.OeuvreLite;
import app.model.OeuvreSearch;
import app.repository.AbstractConnect;
import app.repository.OeuvreRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Philippe on 22/05/2017.
 */
public class OeuvreRepositoyImpl implements OeuvreRepository {

	Connection conn = AbstractConnect.getConnection();

	public OeuvreRepositoyImpl() throws SQLException {
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

	@Override
	public ObservableList<Oeuvre> getAll() {
		ObservableList<Oeuvre> result = FXCollections.observableArrayList();
		try {
			ResultSet rs = conn
					.prepareStatement("SELECT * FROM oeuvre,categorie, auteur WHERE statut='1' AND " +
                            "oeuvre.categorie_id_categorie=categorie.id_categorie AND oeuvre.auteur_id_auteur=auteur.id_auteur ORDER BY id_oeuvre DESC LIMIT 10")
					.executeQuery();

			while (rs.next()) {
				OeuvreLite o = new OeuvreLite();
				o.setTitre(rs.getString("titre"));
                Auteur auteur = new Auteur();
                auteur.setName(rs.getString("nom_auteur"));
                o.setAuteur(auteur);
				o.setCategorie(rs.getString("nom"));
				result.add(o);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}


    @Override
	public ObservableList<Oeuvre> getAll(String tableName, String columnName) {
		ObservableList<Oeuvre> result = FXCollections.observableArrayList();
		try {
			ResultSet rs = conn
					.prepareStatement("SELECT * FROM " + tableName + " ORDER BY " + columnName + " DESC LIMIT 10")
					.executeQuery();

			while (rs.next()) {
				OeuvreLite o = new OeuvreLite();
				o.setTitre(rs.getString("titre"));
				o.setNote((rs.getInt("note")));
				o.setOrigine(rs.getString("origine"));
				result.add(o);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}


}
