package app.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddVideoGameController {
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
}
