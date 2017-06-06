package app.view;

import app.repository.AbstractConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Jub on 01/06/2017.
 */
public class CreateTrackController implements Initializable{

    @FXML
    private TextField numTrackTf;

    @FXML
    private TextField nameTrackTf;

    @FXML
    private TableView<?> trackListTv;

    @FXML
    private TableColumn<?, ?> numTrackCol;

    @FXML
    private TableColumn<?, ?> nameTrackCol;

    @FXML
    private Button addTrackNumNNameBtn;

    @FXML
    private Label cdNamel;


    public void setName(String name) {
        cdNamel.setText(name);
    }

    public void saveTrack(){
        String numero = numTrackTf.getText();
        String nom_piste = nameTrackTf.getText();
        String oeuvre = cdNamel.getText();
        System.out.println(numero);
        System.out.println(nom_piste);
        System.out.println(oeuvre);

        try {
            Connection conn = AbstractConnect.getConnection();

            String query = "INSERT INTO piste_musicale (numero, nom_piste, oeuvre_id_oeuvre)" +
                    " VALUES(?,?," +
                    "(select id_oeuvre from oeuvre where titre = ? order by id_oeuvre limit 1 ))" ;


            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, numero);
            p.setString(2, nom_piste);
            p.setString(3, oeuvre);
            p.execute();
            p.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("entrée dans Initialize");
        addTrackNumNNameBtn.setOnMouseClicked(event -> saveTrack());

}






}
