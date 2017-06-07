package app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import app.model.Auteur;
import app.model.Genre;
import app.model.Langue;
import app.model.Marque;
import app.model.Modele;
import app.repository.AbstractConnect;
import app.repository.impl.AuteurRepositoryImpl;
import app.repository.impl.GenreRepositoryImpl;
import app.repository.impl.LangueRepositoryImpl;
import app.repository.impl.MarqueRepositoryImpl;
import app.repository.impl.ModeleRepositoryImpl;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddVideoGameController extends CreateView implements Initializable {
	@FXML
	private TextField titreTf;

	@FXML
	private TextArea commentaireAr;

	@FXML
	private Button saveBtn;

	@FXML
	private Button saveNCloseBtn;

	@FXML
	private TextField origineTf;

	@FXML
	private Slider noteSl;

	@FXML
	private Button addGenreBt;

	@FXML
	private Button addStudioBt;

	@FXML
	private Slider achevementSl;

	@FXML
	private ComboBox<Auteur> studioCb;

	@FXML
	private ComboBox<Genre> genreCb;

	@FXML
	private Button addLangueBtn;

	@FXML
	private ComboBox<Langue> langueCb;

	@FXML
	private ComboBox<Marque> marqueCb;

	@FXML
	private ComboBox<Modele> modeleCob;

	@FXML
	private Button ajoutModeleBtn;

	@FXML
	private void sceneClose() {
		Stage stage = (Stage) saveNCloseBtn.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addStudioBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
		addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
		ajoutModeleBtn.setOnMouseClicked(event -> createView("/CreateMarque.fxml"));
		addLangueBtn.setOnMouseClicked(event -> createView("/CreateLangue.fxml"));
		studioCb.setOnShown(event -> displayAuthor());
		genreCb.setOnShown(event -> displayGenre());
		marqueCb.setOnShown(event -> displayMarque());
		modeleCob.setOnShown(event -> displayMod());
		langueCb.setOnShown(event -> displayLangue());
		saveBtn.setOnMouseClicked(event -> savejeux());
		saveNCloseBtn.setOnMouseClicked(event -> {
			savejeux();
			sceneClose();
		});

	}

	@FXML
	private void displayAuthor() {
		ObservableList<Auteur> auteurs;
		AuteurRepositoryImpl auteurRepo = null;
		try {
			auteurRepo = new AuteurRepositoryImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		auteurs = auteurRepo.getAll("auteur", "nom_auteur");
		studioCb.setItems(auteurs);

		studioCb.setConverter(new StringConverter<Auteur>() {
			@Override
			public String toString(Auteur object) {
				return object.getName();
			}

			@Override
			public Auteur fromString(String nomAuteur) {
				/*
				 * if (auteurCob.getValue() != null) {
				 * auteurCob.getValue().setName(name); auteurCob.show();
				 * return auteurCob.getValue(); }
				 */
				return null;
			}
		});

	}

	@FXML
	public void displayGenre() {
		ObservableList<Genre> genres;
		GenreRepositoryImpl genreRepo = null;
		try {
			genreRepo = new GenreRepositoryImpl();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		genres = genreRepo.getAll("genre", "nom_genre");
		genreCb.setItems(genres);

		genreCb.setConverter(new StringConverter<Genre>() {
			@Override
			public String toString(Genre object) {
				return object.getName();
			}

			@Override
			public Genre fromString(String nomGenre) {
				/*
				 * if (genreob.getValue() != null) {
				 * ((Genre)genreCob.getValue()).setName(nomGenre);
				 * genreCob.show(); return (Genre) genreCob.getValue(); }
				 */
				return null;
			}
		});
	}

	@FXML
	private void displayMarque() {
		ObservableList<Marque> marques;
		MarqueRepositoryImpl marqueRepo = null;
		try {
			marqueRepo = new MarqueRepositoryImpl();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		marques = marqueRepo.getAll("console", "marque");
		marqueCb.setItems(marques);

		marqueCb.setConverter(new StringConverter<Marque>() {
			@Override
			public String toString(Marque object) {
				return object.getName();
			}

			@Override
			public Marque fromString(String string) {
				return null;
			}
		});
		displayMod();
	}

	@FXML
	private void displayMod() {
		ObservableList<Modele> mod;
		ModeleRepositoryImpl modeleRepo = null;
		try {
			modeleRepo = new ModeleRepositoryImpl();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		mod = modeleRepo.getAll("console", "nom_console");
		modeleCob.setItems(mod);
		modeleCob.setConverter(new StringConverter<Modele>() {

			@Override
			public String toString(Modele object) {
				return object.getName();
			}

			@Override
			public Modele fromString(String string) {
				return null;
			}
		});
	}

	public void displayLangue() {
		ObservableList<Langue> langues;
		LangueRepositoryImpl langueRepo = null;
		try {
			langueRepo = new LangueRepositoryImpl();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		langues = langueRepo.getAll("langue", "nom_langue");
		langueCb.setItems(langues);

		langueCb.setConverter(new StringConverter<Langue>() {
			@Override
			public String toString(Langue object) {
				return object.getName();
			}

			@Override
			public Langue fromString(String nomLangue) {
				/*
				 * if (langueCob.getValue() != null) {
				 * ((Langue)langueCob.getValue()).setName(nomLangue);
				 * langueCob.show(); return (Langue) langueCob.getValue(); }
				 */
				return null;
			}
		});

	}

	public void savejeux() {
		String titre = titreTf.getText();
		String commentaire = commentaireAr.getText();
		String origine = origineTf.getText();
		double note = noteSl.getValue();
		double achevement = achevementSl.getValue();
		String genre = genreCb.getSelectionModel().getSelectedItem().getName();
		String auteur = studioCb.getSelectionModel().getSelectedItem().getName();
		String langue = langueCb.getSelectionModel().getSelectedItem().getName();
		String modele = modeleCob.getSelectionModel().getSelectedItem().getName();

		try {
			Connection conn = AbstractConnect.getConnection();

			String query = "INSERT INTO oeuvre (titre, origine, note, commentaire, achevement, statut,"
					+ " auteur_id_auteur, genre_id_genre, categorie_id_categorie, langue_id_langue,"
					+ "support_id_support, console_id_console)" + " VALUES(?,?,?,?,?,?,"
					+ "(select id_auteur from auteur where nom_auteur = ? order by id_auteur limit 1 ),"
					+ "(select id_genre from genre where nom_genre = ? order by id_genre limit 1 ),'5',"
					+ "(select id_langue from langue where nom_langue = ? order by id_langue limit 1)," + "'1',"
					+ "(select id_console from console where nom_console = ? order by id_console limit 1 ))";

			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, titre);
			p.setString(2, origine);
			p.setInt(3, (int) note);
			p.setString(4, commentaire);
			p.setInt(5, (int) achevement);
			p.setInt(6, 1);
			p.setString(7, auteur);
			p.setString(8, genre);
			p.setString(9, langue);
			p.setString(10, modele);

			p.execute();
			p.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
	}
}
