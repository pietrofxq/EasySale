package easysale.main;

import java.io.IOException;
import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import easysale.view.*;
import easysale.model.*;
import easysale.controller.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private SessionFactory sessionFactory = null;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("EasySale - Login");
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
	
	public void showHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Home.fxml"));
			AnchorPane homeScreen = (AnchorPane) loader.load();
			primaryStage.setTitle("EasySale - Home");
			
			rootLayout.setCenter(homeScreen);
	        HomeController controller = loader.getController();
	        controller.setSessionFactory(sessionFactory);
	        controller.addItens();
	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initSessionFactory() {
		try {
			
		
			Configuration config = new Configuration().configure();
			// Build a Registry with our configuration properties
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
			// create the session factory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			System.out.println("Session factory configured");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
