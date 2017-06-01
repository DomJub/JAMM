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
public class PopupAddLangue extends CreateView implements app.repository.PopupAdd, Initializable {

    public PopupAddLangue() {
    }

    @FXML
    private TextField createTf;

    @FXML
    private Button saveLangueBtn;

    @FXML
    public void AddNewLangue(){
        String langue = createTf.getText();

        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "INSERT INTO langue (nom_langue) VALUES (?)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, langue);
            p.execute();
            p.close();
            sceneClose();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveLangueBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveLangueBtn.setOnAction(event -> AddNewLangue());
    }

}
