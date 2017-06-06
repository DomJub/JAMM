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
public class PopupAddMarque extends CreateView implements app.repository.PopupAdd, Initializable {

    public PopupAddMarque() {
    }

    @FXML
    private TextField createTf;

    @FXML
    private TextField modeleTf;

    @FXML
    private Button saveMarqueBtn;

    @FXML
    public void AddNewMarque(){
        String marque = createTf.getText();
        String modele = modeleTf.getText();
        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "INSERT INTO console (marque, nom_console) VALUES (?, ?)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, marque);
            p.setString(2, modele);
            p.execute();
            p.close();
            sceneClose();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveMarqueBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveMarqueBtn.setOnAction(event -> AddNewMarque());
    }

}
