package app.view;

import app.model.Auteur;
import app.model.Genre;
import app.model.Langue;
import app.model.Support;
import app.repository.AbstractConnect;
import app.repository.impl.AuteurRepositoryImpl;
import app.repository.impl.GenreRepositoryImpl;
import app.repository.impl.LangueRepositoryImpl;
import app.repository.impl.SupportRepositoryImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddMovieController extends CreateView implements Initializable{
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
    private ComboBox<Genre> genreCb;

    @FXML
    private ComboBox<Support> supportCb;

    @FXML
    private ComboBox<Auteur> auteurCb;

    @FXML
    private ComboBox<Langue> langueCob;

    @FXML
    private Slider achevementSl;
    @FXML
    private Button addGenreBt;

    @FXML
    private Button ajoutSupportBt;

    @FXML
    private Button addAuteurBt;

    @FXML
    private Button addLangueBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        auteurCb.setOnShown(event -> displayAuthor());
        supportCb.setOnShown(event -> displaySupport());
        genreCb.setOnShown(event -> displayGenre());
        langueCob.setOnShown(event -> displayLangue());
        addAuteurBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        ajoutSupportBt.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
        addLangueBtn.setOnMouseClicked(event -> createView("/CreateLangue.fxml"));
        saveBtn.setOnMouseClicked(event -> saveVideo());
        saveNCloseBtn.setOnMouseClicked(event -> {
            saveVideo();
            sceneClose();
        });

    }

    @FXML
    private void sceneClose() {
        Stage stage = (Stage) saveNCloseBtn.getScene().getWindow();
        stage.close();
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
        auteurCb.setItems(auteurs);

        auteurCb.setConverter(new StringConverter<Auteur>() {
            @Override
            public String toString(Auteur object) {
                return object.getName();
            }

            @Override
            public Auteur fromString(String nomAuteur) {
				/*
				 * if (auteurCob.getValue() != null) {
				 * auteurCob.getValue().setName(nomAuteur); auteurCob.show();
				 * return auteurCob.getValue(); }
				 */
                return null;
            }
        });
    }

    @FXML
    private void displaySupport() {
        ObservableList<Support> supports;
        SupportRepositoryImpl supportRepo = null;
        try {
            supportRepo = new SupportRepositoryImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        supports = supportRepo.getAll("support", "nom_support");
        supportCb.setItems(supports);

        supportCb.setConverter(new StringConverter<Support>() {
            @Override
            public String toString(Support object) {
                return object.getName();
            }

            @Override
            public Support fromString(String nomSupport) {
				/*
				 * if (supportCob.getValue() != null) {
				 * supportCob.getValue().setName(nomSupport); supportCob.show();
				 * return supportCob.getValue(); }
				 */
                return null;
            }
        });

    }

    @FXML
    public void displayGenre(){
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
                if (genreCb.getValue() != null)
                {
                    ((Genre)genreCb.getValue()).setName(nomGenre);
                    genreCb.show();
                    return (Genre) genreCb.getValue();
                }
                return null;
            }
        });

    }

    public void displayLangue(){
        ObservableList<Langue> langues;
        LangueRepositoryImpl langueRepo = null;
        try {
            langueRepo = new LangueRepositoryImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        langues = langueRepo.getAll("langue", "nom_langue");
        langueCob.setItems(langues);

        langueCob.setConverter(new StringConverter<Langue>() {
            @Override
            public String toString(Langue object) {
                return object.getName();
            }
            @Override
            public Langue fromString(String nomLangue) {
                if (langueCob.getValue() != null)
                {
                    ((Langue)langueCob.getValue()).setName(nomLangue);
                    langueCob.show();
                    return (Langue) langueCob.getValue();
                }
                return null;
            }
        });

    }

    public void saveVideo() {
        String titre = titreTf.getText();
        String commentaire = commentaireAr.getText();
        String origine = origineTf.getText();
        double note = noteSl.getValue();
        double achevement = achevementSl.getValue();
        String genre = genreCb.getSelectionModel().getSelectedItem().getName();
        String support = supportCb.getSelectionModel().getSelectedItem().getName();
        String auteur = auteurCb.getSelectionModel().getSelectedItem().getName();
        String langue = langueCob.getSelectionModel().getSelectedItem().getName();

        try {
            Connection conn = AbstractConnect.getConnection();

            String query = "INSERT INTO oeuvre (titre, origine, note, commentaire, achevement, statut," +
                    " auteur_id_auteur, genre_id_genre, categorie_id_categorie, langue_id_langue," +
                    "support_id_support, console_id_console)" +
                    " VALUES(?,?,?,?,?,?," +
                    "(select id_auteur from auteur where nom_auteur = ? order by id_auteur limit 1 )," +
                    "(select id_genre from genre where nom_genre = ? order by id_genre limit 1 ),'3'," +
                    "(select id_langue from langue where nom_langue = ? order by id_langue limit 1)," +
                    "(select id_support from support where nom_support = ? order by id_support limit 1 ),'2')";

            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, titre);
            p.setString(2, origine);
            p.setInt(3, (int) note);
            p.setString(4, commentaire);
            p.setInt(5, (int) achevement);
            p.setInt(6, '1');
            p.setString(7, auteur);
            p.setString(8, genre);
            p.setString(9, langue);
            p.setString(10, support);

            p.execute();
            p.close();
            sceneClose();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
