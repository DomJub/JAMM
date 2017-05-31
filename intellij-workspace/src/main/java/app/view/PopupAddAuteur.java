package app.view;

import app.repository.AbstractConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Philippe on 30/05/2017.
 */
public class PopupAddAuteur extends CreateView implements app.repository.PopupAdd, Initializable {

    protected AddBookController addBookController;

    public PopupAddAuteur() {
    }

    public PopupAddAuteur(AddBookController addBookController) {
        this.addBookController = addBookController;
    }

    @FXML
    private TextField createTf;

    @FXML
    private Button saveAuthorBtn;

    @FXML
    public void AddNewAuthor(){
        String auteur = createTf.getText();

        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "INSERT INTO auteur (nom_auteur) VALUES (?)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, auteur);
            p.execute();
            p.close();
            sceneClose();
            //this.addBookController.displayAuthor();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveAuthorBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveAuthorBtn.setOnAction(event -> AddNewAuthor());
    }

}
