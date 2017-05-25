package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
	    Main.stage = primaryStage;
	    Main.stage.setTitle("JAMM - Gestion Mediathèque");
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
            stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
