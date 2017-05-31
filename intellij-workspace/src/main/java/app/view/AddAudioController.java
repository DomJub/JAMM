package app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddAudioController extends PopupAddAuteur implements Initializable{

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
    private Button addArtistBtn;

    @FXML
    private ChoiceBox<?> auteurCb;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;

    @FXML
    private TextField titreTf1;

    @FXML
    private Button addTrackBtn;

    @FXML
    private TableColumn<?, ?> numPisteCol;

    @FXML
    private TableColumn<?, ?> nomPisteCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addArtistBtn.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBtn.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addSupportBtn.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
        addTrackBtn.setOnMouseClicked(event -> createView("/CreateTrack.fxml"));
    }
}
