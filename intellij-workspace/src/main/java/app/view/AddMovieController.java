package app.view;

import app.model.Auteur;
import app.model.Genre;
import app.model.Support;
import app.repository.impl.AuteurRepositoryImpl;
import app.repository.impl.GenreRepositoryImpl;
import app.repository.impl.SupportRepositoryImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
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
    private ChoiceBox<Genre> genreCb;

    @FXML
    private ChoiceBox<Support> supportCb;

    @FXML
    private ChoiceBox<Auteur> auteurCb;

    @FXML
    private ChoiceBox<?> langueCb;

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
        addAuteurBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        ajoutSupportBt.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
        addLangueBtn.setOnMouseClicked(event -> createView("/CreateLangue.fxml"));

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
}
