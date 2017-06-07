package app.repository.impl;


import app.model.Auteur;
import app.model.OeuvreSearch;
import app.repository.AbstractConnect;

import app.repository.SearchRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Philippe on 22/05/2017.
 */
public class SearchRepositoyImpl implements SearchRepository{

	Connection conn = AbstractConnect.getConnection();

	public SearchRepositoyImpl() throws SQLException {
	}

	@Override
	public ObservableList<OeuvreSearch> getAll() {

		return null;
	}

	@Override
	public ObservableList<OeuvreSearch> getAll(String tableName, String columnName) {

		return null;
	}

	@Override
	public OeuvreSearch insert(OeuvreSearch object) {
		return null;
	}

	@Override
	public boolean delete(OeuvreSearch object) {
		return false;
	}

	@Override
	public OeuvreSearch update(OeuvreSearch object) {
		return null;
	}
	@Override
	public ObservableList<OeuvreSearch> getSearch(){
		ObservableList<OeuvreSearch> result = FXCollections.observableArrayList();
		try{
			ResultSet rs = conn.prepareStatement("SELECT oeuvre.titre, oeuvre.note, oeuvre.origine, " +
					"oeuvre.achevement, auteur.nom_auteur, categorie.nom FROM oeuvre\n" +
					"INNER JOIN auteur, categorie WHERE oeuvre.auteur_id_auteur=auteur.id_auteur" +
					" AND oeuvre.categorie_id_categorie=categorie.id_categorie\n")
					.executeQuery();
			while (rs.next()) {
				OeuvreSearch os = new OeuvreSearch();
				os.setTitre(rs.getString("titre"));
				os.setNote(rs.getInt("note"));
				os.setOrigine(rs.getString("origine"));
				os.setAchevement(rs.getInt("achevement"));
				Auteur auteur = new Auteur();
				auteur.setName(rs.getString("nom_auteur"));
				os.setAuteur(auteur);
				os.setCategorie(rs.getString("nom"));
				result.add(os);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  result;
	}
}
