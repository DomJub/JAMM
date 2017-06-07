package app.view;

import app.model.Oeuvre;
import app.model.OeuvreSearch;
import app.model.SimpleStringProperty;
import app.repository.SearchRepository;
import app.repository.impl.SearchRepositoyImpl;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * Created by Philippe on 06/06/2017.
 */
public class RudController implements Initializable {

    @FXML
    private TableView<OeuvreSearch> tableSearch;

    @FXML
    private TableColumn<OeuvreSearch, ?> titreCol;

    @FXML
    private TableColumn<?, ?> noteCol;

    @FXML
    private TableColumn<?, ?> origineCol;

    @FXML
    private TableColumn<?, ?> achevementCol;

    @FXML
    private TableColumn<OeuvreSearch, String> auteurCol;

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
    private TextField langueTf;

    @FXML
    private TextField supportTf;

    @FXML
    private TextField marqueTf;

    @FXML
    private TextField modeleTf;

    @FXML
    private TextField categorieTf;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private TextField searchTf;

    private SearchRepository repository;
    //private ObservableList<OeuvreSearch> filteredData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<OeuvreSearch> items;
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        origineCol.setCellValueFactory(new PropertyValueFactory<>("origine"));
        achevementCol.setCellValueFactory(new PropertyValueFactory<>("achevement"));
        auteurCol.setCellValueFactory(param -> new SimpleStringProperty(() -> param.getValue().getAuteur().getName()));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        try {
            repository = new SearchRepositoyImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        items = repository.getSearch();
        tableSearch.setItems(items);


        FilteredList<OeuvreSearch> filtered = new FilteredList<>(items, p -> true);

        searchTf.textProperty().addListener((observable, oldValue, newValue) -> {
            filtered.setPredicate(OeuvreSearch -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (OeuvreSearch.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return  true;
                } else if
                    (OeuvreSearch.getAuteur().getName().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                } else if
                        (OeuvreSearch.getCategorie().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });
        SortedList<OeuvreSearch> sortedData = new SortedList<>(filtered);
        sortedData.comparatorProperty().bind(tableSearch.comparatorProperty());
        tableSearch.setItems(sortedData);
    }

    @FXML
    public void showDatas(){
        OeuvreSearch oeuvre = tableSearch.getSelectionModel().getSelectedItem();

        titreTf.setText(oeuvre.getTitre());
        noteSl.setValue(oeuvre.getNote());
        origineTf.setText(oeuvre.getOrigine());
        achevementSl.setValue(oeuvre.getAchevement());
        auteurTf.setText(oeuvre.getAuteur().getName());
        supportTf.setText(oeuvre.getSupport());
        langueTf.setText(oeuvre.getLangue());
        marqueTf.setText(oeuvre.getMarque());
        modeleTf.setText(oeuvre.getModele());
        marqueTf.setText(oeuvre.getMarque());
        modeleTf.setText(oeuvre.getModele());
        categorieTf.setText(oeuvre.getCategorie());

    }
}
