package app.view;

import javafx.fxml.Initializable;
import app.model.Auteur;
import app.model.DataOeuvre;
import app.model.Support;
import app.repository.impl.AuteurRepositoryImpl;
import app.repository.impl.SupportRepositoryImpl;
import javafx.collections.ObservableList;


import app.repository.AbstractConnect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import app.model.Auteur;
import app.repository.impl.AuteurRepositoryImpl;
import javafx.collections.ObservableList;

import javafx.util.StringConverter;


import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */

public class AddBookController extends CreateView implements Initializable {

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
    private ComboBox<?> genreCob;

    @FXML
    private ComboBox<Support> supportCob;

    @FXML
    private Button addGenreBtn;

    @FXML
    private Button addSupportBtn;

    @FXML
    private Button addAuthorBtn;

    @FXML
    private ComboBox<Auteur> auteurCob;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveNCloseBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void displayAuthor(){
        ObservableList<Auteur> auteurs;
        AuteurRepositoryImpl auteurRepo = null;
        try {
            auteurRepo = new AuteurRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auteurs = auteurRepo.getAll("auteur", "nom_auteur");
        auteurCob.setItems(auteurs);

        auteurCob.setConverter(new StringConverter<Auteur>() {
            @Override
            public String toString(Auteur object) {
                return object.getName();
            }
            @Override
            public Auteur fromString(String nomAuteur) {
                if (auteurCob.getValue() != null)
                {
                    ((Auteur)auteurCob.getValue()).setName(nomAuteur);
                    auteurCob.show();
                    return (Auteur)auteurCob.getValue();
                }
                return null;
            }
        });

    }

    @FXML
    public void displaySupport(){
        ObservableList<Support> supports;
        SupportRepositoryImpl supportRepo = null;
        try {
            supportRepo = new SupportRepositoryImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        supports = supportRepo.getAll("auteur", "nom_auteur");
        supportCob.setItems(supports);

        supportCob.setConverter(new StringConverter<Support>() {
            @Override
            public String toString(Support object) {
                return object.getName();
            }
            @Override
            public Support fromString(String nomSupport) {
                if (supportCob.getValue() != null)
                {
                    ((Support)supportCob.getValue()).setName(nomSupport);
                    supportCob.show();
                    return (Support)supportCob.getValue();
                }
                return null;
            }
        });

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //auteurCob.setOnMouseClicked(event -> displayAuthor());
        auteurCob.setOnShown(event -> displayAuthor());
        addAuthorBtn.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBtn.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addSupportBtn.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
        saveBtn.setOnMouseClicked(event -> saveBook());
        saveNCloseBtn.setOnMouseClicked(event -> {
            saveBook(); sceneClose();
        });
    }

    public void saveBook() {
        String titre = titreTf.getText();
        String commentaire = commentaireAr.getText();
        String origine = origineTf.getText();
        double note = noteSl.getValue();
        double achevement = achevementSl.getValue();
        String genre = genreCob.getSelectionModel().getSelectedItem().toString();
        String support = supportCob.getSelectionModel().getSelectedItem().toString();
        String auteur = auteurCob.getSelectionModel().getSelectedItem().toString();
        String langue = langueCb.getSelectionModel().getSelectedItem().toString();


        try {
            Connection conn = AbstractConnect.getConnection();

            String query = "INSERT INTO oeuvre (titre, origine, note, commentaire, achevement, stats," +
                    " auteur_id_auteur, genre_id_genre, categorie_id_categorie, langue_id_langue," +
                    "support_id_support, console_id_console, piste_id_piste)" +
                    " VALUES(?,?,?,?,?,?," +
                    "(select id_auteur from auteur where nom_auteur = ? order by id_auteur limit 1 )," +
                    "(select id_genre from genre where nom_genre = ? order by id_genre limit 1 ),'1'," +
                    "(select id_langue from langue where nom_langue = ? order by id_langue limit 1)," +
                    "(select id_support from support where nom_support = ? order by id_support limit 1 ),'2','1')";

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
