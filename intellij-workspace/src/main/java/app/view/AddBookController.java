package app.view;

import app.model.Auteur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddBookController extends PopupAddAuteur implements Initializable{
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
    private ChoiceBox<Auteur> auteurCb;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        addAuthorBtn.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBtn.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addSupportBtn.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
    }
}
