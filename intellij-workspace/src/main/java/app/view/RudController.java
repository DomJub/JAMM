package app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 06/06/2017.
 */
public class RudController implements Initializable {

    @FXML
    private TableView<?> tableSearch;

    @FXML
    private TableColumn<?, ?> titreCol;

    @FXML
    private TableColumn<?, ?> noteCol;

    @FXML
    private TableColumn<?, ?> origineCol;

    @FXML
    private TableColumn<?, ?> achevementCol;

    @FXML
    private TableColumn<?, ?> auteurCol;

    @FXML
    private TableColumn<?, ?> categorieCol;

    @FXML
    private TextField titreTf;

    @FXML
    private Slider noteSl;

    @FXML
    private TextField origineTf;

    @FXML
    private Slider achevementSl;

    @FXML
    private TextField auteurTf;

    @FXML
    private ComboBox<?> categCob;

    @FXML
    private ComboBox<?> langueCob;

    @FXML
    private ComboBox<?> supportCob;

    @FXML
    private ComboBox<?> MarqueCob;

    @FXML
    private ComboBox<?> NomConsoleCob;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button updateBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
