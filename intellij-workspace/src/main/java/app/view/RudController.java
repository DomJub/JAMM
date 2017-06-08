package app.view;


import app.model.OeuvreSearch;
import app.model.SimpleStringProperty;
import app.repository.AbstractConnect;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


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

    @FXML
    private TextArea commentArea;

    private SearchRepository repository;
    PreparedStatement preparedStatement;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<OeuvreSearch> items;
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        origineCol.setCellValueFactory(new PropertyValueFactory<>("origine"));
        achevementCol.setCellValueFactory(new PropertyValueFactory<>("achevement"));
        auteurCol.setCellValueFactory(param -> new SimpleStringProperty(() -> param.getValue().getAuteur().getName()));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        deleteBtn.setOnMouseClicked(event -> disableOeuvre());
        updateBtn.setOnMouseClicked(event -> updateOeuvre());

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
        commentArea.setText(oeuvre.getCommentaire());
    }

    public void disableOeuvre(){
        OeuvreSearch oeuvre = tableSearch.getSelectionModel().getSelectedItem();
        int valueId = oeuvre.getId_oeuvre();
        System.out.println(valueId);
        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "UPDATE oeuvre SET statut = '0' WHERE id_oeuvre ='" + valueId+ "'";
            preparedStatement= conn.prepareStatement(query);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOeuvre(){
        OeuvreSearch oeuvre = tableSearch.getSelectionModel().getSelectedItem();
        int valueId = oeuvre.getId_oeuvre();


        System.out.println(valueId);
        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "UPDATE oeuvre, categorie, langue, support, auteur," +
                    "console SET oeuvre.titre=?, oeuvre.note=?," +
                    " oeuvre.origine=?, oeuvre.achevement=?, auteur.nom_auteur=?," +
                    "categorie.nom=?, langue.nom_langue=?, support.nom_support=?, console.marque=?," +
                    "console.nom_console=?, oeuvre.commentaire=? WHERE oeuvre.statut='1' AND oeuvre.id_oeuvre='" + valueId + "' AND" +
                    " oeuvre.auteur_id_auteur=auteur.id_auteur AND oeuvre.categorie_id_categorie=categorie.id_categorie AND " +
                    "oeuvre.langue_id_langue=langue.id_langue AND oeuvre.support_id_support=support.id_support AND " +
                    "oeuvre.console_id_console=console.id_console";
            preparedStatement=conn.prepareStatement(query);
            preparedStatement.setString(1,titreTf.getText());
            preparedStatement.setDouble(2, noteSl.getValue());
            preparedStatement.setString(3, origineTf.getText());
            preparedStatement.setDouble(4, achevementSl.getValue());
            preparedStatement.setString(5, auteurTf.getText());
            preparedStatement.setString(6, categorieTf.getText());
            preparedStatement.setString(7, langueTf.getText());
            preparedStatement.setString(8, supportTf.getText());
            preparedStatement.setString(9, marqueTf.getText());
            preparedStatement.setString(10, modeleTf.getText());
            preparedStatement.setString(11, commentArea.getText());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
