package app.view;

import app.repository.AbstractConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 30/05/2017.
 */
public class PopupAddAuteur extends CreateView implements app.repository.PopupAdd, Initializable {

    public PopupAddAuteur() {
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
