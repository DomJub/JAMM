package app.view;

import app.model.OeuvreSearch;
import app.repository.SearchRepository;
import app.repository.impl.SearchRepositoyImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 06/06/2017.
 */
public class RudController implements Initializable {

    @FXML
    private TableView<OeuvreSearch> tableSearch;

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

    private SearchRepository repository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<OeuvreSearch> items;
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        origineCol.setCellValueFactory(new PropertyValueFactory<>("origine"));
        achevementCol.setCellValueFactory(new PropertyValueFactory<>("achevement"));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        try {
            repository = new SearchRepositoyImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        items = repository.getSearch();
        tableSearch.setItems(items);
    }
}
