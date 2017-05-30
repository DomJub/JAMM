package app.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jub on 24/05/2017.
 */
public class AddMovieController implements Initializable{
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
    private Button addGenreBt;

    @FXML
    private Button ajoutSupportBt;

    @FXML
    private Button addAuteurBt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addAuteurBt.setOnMouseClicked(event -> createView("/CreateAuteur.fxml"));
        addGenreBt.setOnMouseClicked(event -> createView("/CreateGenre.fxml"));
        ajoutSupportBt.setOnMouseClicked(event -> createView("/CreateSupport.fxml"));

    }

    private void createView(String name) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

}
