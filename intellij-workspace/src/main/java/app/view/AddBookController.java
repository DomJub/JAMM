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
public class AddBookController extends CreateView implements Initializable{

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

    @FXML
    public void displayAuthor(){
        ObservableList<Auteur> auteurs;
        AuteurRepositoryImpl auteurRepo = null;
        try {
            auteurRepo = new AuteurRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auteurs = auteurRepo.getAll();
        auteurCob.setItems(auteurs);

        auteurCob.setConverter(new StringConverter<Auteur>() {
            @Override
            public String toString(Auteur object) {
                return object.getNomAuteur();
            }
            @Override
            public Auteur fromString(String nomAuteur) {
                if (auteurCob.getValue() != null)
                {
                    ((Auteur)auteurCob.getValue()).setNomAuteur(nomAuteur);
                    auteurCob.show();
                    return (Auteur)auteurCob.getValue();
                }
                return null;
            }
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        auteurCob.setOnMouseClicked(event -> displayAuthor());
        addAuthorBtn.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBtn.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        addSupportBtn.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));





        /*auteurCob.setEditable(true);
        auteurCob.getEditor().setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                  Auteur auteur = auteurCob.getValue();
                  if(null != auteur){
                      int index = auteurs.indexOf(auteur);
                      auteur.setNomAuteur(auteurCob.getEditor().getText());
                      auteurs.set(index, auteur);
                      auteurCob.setValue(auteur);
                  }

              }
        });*/

    }
}
