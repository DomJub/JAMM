package sample.view;


import java.net.URL;


import java.util.ResourceBundle;
import javafx.beans.property.SimpleListProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Oeuvre;
import sample.repository.OeuvreRepository;

public class Controller implements Initializable{
    @FXML private MenuButton menu = new MenuButton();

    @FXML 
    TableView<Oeuvre> tableListing;

    @FXML
    TableColumn<?, ?> Titre;

    @FXML
    TableColumn<?, ?> Note;


    private OeuvreRepository repository;


    @Override
	public void initialize(URL location, ResourceBundle resources) {

			ObservableList<Oeuvre> items = FXCollections.observableArrayList();

            //items.addAll(repository.getAll());
           // Titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
           // Note.setCellValueFactory(new PropertyValueFactory<>("Note"));




	}


}
