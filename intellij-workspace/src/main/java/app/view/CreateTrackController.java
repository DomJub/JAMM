package app.view;

import app.model.PisteMusicale;
import app.repository.AbstractConnect;
import app.repository.PisteMusicaleRepository;
import app.repository.impl.PisteMusicaleRepositoryImpl;
import javafx.collections.ObservableList;
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
 * Created by Jub on 01/06/2017.
 */
public class CreateTrackController implements Initializable{

    @FXML
    private TextField numTrackTf;

    @FXML
    private TextField nameTrackTf;

    @FXML
    private TableView<PisteMusicale> trackListTv;

    @FXML
    private TableColumn<?, ?> numTrackCol;

    @FXML
    private TableColumn<?, ?> nameTrackCol;

    @FXML
    private Button addTrackNumNNameBtn;

    @FXML
    private Label cdNamel;

    private PisteMusicaleRepository audioRepository;

    private String nameCD;

    public String getNameCD() {
        return nameCD;
    }

    public void setNameCD(String nameCD) {
        this.nameCD = nameCD;
    }

    public void setName(String name) {
        cdNamel.setText(name);
        this.setNameCD(name);
    }

    public void saveTrack(){
        String numero = numTrackTf.getText();
        String nom_piste = nameTrackTf.getText();
        String oeuvre = cdNamel.getText();
        System.out.println(this.nameCD);

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
        //System.out.println("entrée dans Initialize");

        addTrackNumNNameBtn.setOnMouseClicked(event -> saveTrack());
        ObservableList<PisteMusicale> items;
        numTrackCol.setCellValueFactory(new PropertyValueFactory<>("numero"));
        nameTrackCol.setCellValueFactory(new PropertyValueFactory<>("nom_piste"));
        //System.out.println(this.nameCD);
        try {
            audioRepository = new PisteMusicaleRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        items = audioRepository.getAllByIdOeuvre("piste_musicale", "nom_piste", this.nameCD);
        trackListTv.setItems(items);

    }


}


