package app.view;

import app.model.*;
import app.repository.impl.*;
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
public class AddVideoGameController extends CreateView implements Initializable{
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
    private ComboBox<Modele> modeleCb;

    @FXML
    private Button ajoutModeleBtn;

    @FXML
    private Button ajoutMarqueBtn;

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
        modeleCb.setOnShown(event -> displayMarque());
        langueCb.setOnShown(event -> displayLangue());


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
				 * auteurCob.getValue().setName(nomAuteur); auteurCob.show();
				 * return auteurCob.getValue(); }
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
               /* if (genreob.getValue() != null)
                {
                    ((Genre)genreCob.getValue()).setName(nomGenre);
                    genreCob.show();
                    return (Genre) genreCob.getValue();
                }*/
                return null;
            }
        });
    }

    @FXML
    private void displayMarque() {
        ObservableList<Marque> marques;
        ObservableList<Modele> modeles;
        MarqueRepositoryImpl marqueRepo = null;
        ModeleRepositoryImpl modeleRepo = null;
        try {
            marqueRepo = new MarqueRepositoryImpl();
            modeleRepo = new ModeleRepositoryImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        modeles = modeleRepo.getAll("console", "modele");
        marques = marqueRepo.getAll("console", "marque");
        marqueCb.setItems(marques);
        modeleCb.setItems(modeles);
        modeleCb.setConverter(new StringConverter<Modele>() {
            @Override
            public String toString(Modele object) {
                return null;
            }

            @Override
            public Modele fromString(String string) {
                return null;
            }
        });
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
        langueCb.setItems(langues);

        langueCb.setConverter(new StringConverter<Langue>() {
            @Override
            public String toString(Langue object) {
                return object.getName();
            }
            @Override
            public Langue fromString(String nomLangue) {
              /*  if (langueCob.getValue() != null)
                {
                    ((Langue)langueCob.getValue()).setName(nomLangue);
                    langueCob.show();
                    return (Langue) langueCob.getValue();
                }*/
                return null;
            }
        });

    }


}
