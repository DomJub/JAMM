package app.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.model.Oeuvre;
import app.repository.OeuvreRepository;
import app.repository.impl.OeuvreRepositoyImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainViewController implements Initializable {
	@FXML
	private MenuButton menu = new MenuButton();

	@FXML
	private TableView<Oeuvre> tableListing;

	@FXML
	private TableColumn<?, ?> titre;

	@FXML
	private TableColumn<?, ?> note;

	@FXML
	private TableColumn<?, ?> origine;

	private OeuvreRepository repository;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Oeuvre> items;
		titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
		note.setCellValueFactory(new PropertyValueFactory<>("note"));
		origine.setCellValueFactory(new PropertyValueFactory<>("origine"));
		try {
			repository = new OeuvreRepositoyImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		items = repository.getAll();
		tableListing.setItems(items);

	}

	public void openAddBookView(ActionEvent actionEvent) {
		changePage("/AddBookView.fxml");
	}

	public void openAddAudioView(ActionEvent actionEvent) {
		changePage("/AddAudioView.fxml");
	}

	public void openAddMovieView(ActionEvent actionEvent) {
		changePage("/AddMovieView.fxml");
	}

	public void openAddVideoGameView(ActionEvent actionEvent) {
		changePage("/AddVideoGameView.fxml");
	}

	private void changePage(String location) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(location));
			Parent root1 = fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException e) {
			Logger logger = Logger.getLogger(getClass().getName());
			logger.log(Level.SEVERE, "Failed to create new Window.", e);
		}
	}

}
