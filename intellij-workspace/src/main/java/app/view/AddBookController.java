package app.view;

import app.model.Auteur;
import app.repository.impl.AuteurRepositoryImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddBookController extends PopupAddAuteur implements Initializable{
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
    private Button addAuthorBtn;

    @FXML
    private ComboBox<Auteur> auteurCob;

    @FXML
    private ChoiceBox<?> langueCb;

    @FXML
    private Slider achevementSl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Auteur> items;
        AuteurRepositoryImpl auteurRepo = null;
        try {
            auteurRepo = new AuteurRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        items = auteurRepo.getAll();
        auteurCob.setItems(items);
        auteurCob.setConverter(new StringConverter<Auteur>() {
            @Override
            public String toString(Auteur object) {
                return object.getNomAuteur();
            }

            @Override
            public Auteur fromString(String string) {
                return null;
            }
        });

        addAuthorBtn.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBtn.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addSupportBtn.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));
    }
}
