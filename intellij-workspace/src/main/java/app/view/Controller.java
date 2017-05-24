package app.view;

import java.io.IOException;
import java.net.URL;


import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import app.model.Oeuvre;
import app.repository.OeuvreRepository;
import app.repository.impl.OeuvreRepositoyImpl;
import javafx.stage.Stage;

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


    public void openAddBookView(ActionEvent actionEvent) throws IOException{
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
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }



}
