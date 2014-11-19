package easysale.main;

import java.io.IOException;

import org.controlsfx.dialog.Dialogs;

import easysale.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Address App");
		initRootLayout();
		showLoginScreen();
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}
	
	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Mostra a scene
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			// Dá ao controller o acesso ao main app.
	        RootLayoutController controller = loader.getController();
	        controller.setMainApp(this);
	        
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void showLoginScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Login.fxml"));
			AnchorPane loginScreen = (AnchorPane) loader.load();
			
			rootLayout.setCenter(loginScreen);
			
			LoginController controller = loader.getController();
	        controller.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
