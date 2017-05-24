package app.view;

import java.net.URL;


import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import app.model.Oeuvre;
import app.repository.OeuvreRepository;
import app.repository.impl.OeuvreRepositoyImpl;

public class Controller implements Initializable {
    @FXML
    private MenuButton menu = new MenuButton();

    @FXML
    TableView<Oeuvre> tableListing;

    @FXML
    TableColumn<?, ?> Titre;

    @FXML
    TableColumn<?, ?> Note;


    private OeuvreRepository repository;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            repository = new OeuvreRepositoyImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<Oeuvre> items = FXCollections.observableArrayList();
        items.addAll(repository.getAll());

        tableListing.setItems(items);
    }


}