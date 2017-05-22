package sample.view;


import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import sample.Connect;

public class Controller implements Initializable{
    @FXML private MenuButton menu = new MenuButton();

    @FXML 
    TableView tableListing;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection conn = Connect.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}


}
