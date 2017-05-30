package app.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddAudioController {

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
    private TextField titreTf1;

    @FXML
    private TableColumn<?, ?> numPisteCol;

    @FXML
    private TableColumn<?, ?> nomPisteCol;
}
