package app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddMovieController extends PopupAddAuteur implements Initializable{
    @FXML
    private TextField titreTf;

    @FXML
    private TextArea commentaireAr;

    @FXML
    private TextField origineTf;

    @FXML
    private Slider noteSl;

    @FXML
    private ChoiceBox<?> genreCb;

    @FXML
    private ChoiceBox<?> supportCb;

    @FXML
    private ChoiceBox<?> auteurCb;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addAuteurBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        ajoutSupportBt.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));

    }

}
