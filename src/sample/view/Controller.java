package sample.view;


import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import sample.repository.Connect;
import sample.model.Oeuvre;
import sample.repository.Repository;

public class Controller implements Initializable{
    @FXML private MenuButton menu = new MenuButton();

    @FXML 
    TableView<Oeuvre> tableListing;

    private Repository<Oeuvre> repository;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection conn = Connect.getConnection();

            ObservableList<Oeuvre> items = new SimpleListProperty<>();
            items.addAll(repository.getAll());
            tableListing.setItems(items);


		} catch (SQLException e) {

			System.err.println(e.getMessage());
		}
		
	}


}
