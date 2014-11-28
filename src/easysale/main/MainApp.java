package easysale.main;

import java.io.IOException;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import easysale.view.*;
import easysale.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
			
			// D� ao controller o acesso ao main app.
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
	        
	        
	        controller.setMainApp(this);
	        controller.setSessionFactory(sessionFactory);
		    controller.addItens();
	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void showClientes() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Clientes.fxml"));
			AnchorPane clienteScreen = (AnchorPane) loader.load();
			primaryStage.setTitle("EasySale - Clientes");
			
			rootLayout.setCenter(clienteScreen);
	        ClienteViewController controller = loader.getController();
	        controller.setMainApp(this);
	        controller.setSessionFactory(sessionFactory);
	        controller.addClientes();
	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public boolean showNewProductDialog(Produto produto, String title) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/ProdutoDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        ProdutoDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setProduto(produto);
	        controller.setTitle(title);
	        dialogStage.showAndWait();
	        
	        return controller.isOkClicked();
	        
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showClienteDialog(Cliente cliente, String title) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/ClienteDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle(title);
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        ClienteDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setCliente(cliente);
	        controller.setTitle(title);
	        dialogStage.showAndWait();
	        
	        return controller.isOkClicked();
	        
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
