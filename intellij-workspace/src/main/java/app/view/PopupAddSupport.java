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
public class PopupAddSupport implements app.repository.PopupAdd, Initializable {


    @FXML
    private TextField createTf;

    @FXML
    private Button saveSupportBtn;

    @FXML
    public void AddNewSupport(){
        String support = createTf.getText();

        try {
            Connection conn = AbstractConnect.getConnection();
            String query = "INSERT INTO support (nom_support) VALUES (?)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, support);
            p.execute();
            p.close();
            sceneClose();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveSupportBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveSupportBtn.setOnAction(event -> AddNewSupport());
    }

    protected void createView(String name) {
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
