package app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddVideoGameController extends PopupAddAuteur implements Initializable{
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
    private ChoiceBox<?> consoleCb;

    @FXML
    private ChoiceBox<?> studioCb;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;

    @FXML
    private Button resetBt;

    @FXML
    private Button addGenreBt;

    @FXML
    private Button addConsoleBt;

    @FXML
    private Button addStudioBt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addStudioBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addConsoleBt.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
    }
}
