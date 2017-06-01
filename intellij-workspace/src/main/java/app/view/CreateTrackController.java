package app.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Jub on 01/06/2017.
 */
public class CreateTrackController {

    @FXML
    private TextField numTrackTf;

    @FXML
    private Button addTrackNbBtn;

    @FXML
    private TableView<?> trackListTv;

    @FXML
    private TableColumn<?, ?> numTrackCol;

    @FXML
    private TableColumn<?, ?> nameTrackCol;

    @FXML
    private TextField nameTrackTf;

    @FXML
    private Button addTrackNameBtn;

    @FXML
    private Button addTrackListBtn;

    @FXML
    private Label cdNamel;

    public void setName(String name) {
        cdNamel.setText(name);
    }
}
