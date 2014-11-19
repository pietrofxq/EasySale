package easysale.view;

import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import easysale.main.*;

public class LoginController {
	
	private MainApp mainApp;
	
	@FXML
	private TextField txLogin;
	@FXML
	private PasswordField txSenha;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleLogin() {
		String usuario = txLogin.getText();
		String senha = txSenha.getText();
		System.out.println("Usuario:" + usuario);
		
		if (usuario.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			// TODO: Ir para stage principal
			
			Dialogs.create()
	        .title("Erro")
	        .masthead(null)
	        .message("Usu�rio ou senha inv�lidos!")
	        .showError();
		} else {
			mainApp.initSessionFactory();
			mainApp.showHome();
			
		}
	}
	
	@FXML
	private void handleExit() {
        System.exit(0);
    }
	
	
	

}
