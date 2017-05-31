package app.view;

import app.repository.AbstractConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddBookController extends PopupAddAuteur implements Initializable {
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
    private ChoiceBox<?> genreCb;

    @FXML
    private ChoiceBox<?> supportCb;

    @FXML
    private Button addGenreBtn;

    @FXML
    private Button addSupportBtn;

    @FXML
    private Button addAuthorBtn;

    @FXML
    private ChoiceBox<?> auteurCb;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveNCloseBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        String genre = genreCb.getSelectionModel().getSelectedItem().toString();
        String support = supportCb.getSelectionModel().getSelectedItem().toString();
        String auteur = auteurCb.getSelectionModel().getSelectedItem().toString();
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
