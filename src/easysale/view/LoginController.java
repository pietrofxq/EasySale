package easysale.view;

import org.controlsfx.dialog.Dialogs;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import easysale.main.*;

public class LoginController {
	
	private MainApp mainApp;
	@FXML
	private TextField txLogin;
	@FXML
	private PasswordField txSenha;
	
	private SessionFactory sessionFactory;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	@FXML
	private void handleLogin() {
		String usuario = txLogin.getText();
		String senha = txSenha.getText();
		System.out.println("Usuario:" + usuario);
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String select = "select count(*) from Funcionario func where func.nome= :usuario and func.pass= :pass";
			Query query = session.createQuery(select);
			query.setString("usuario", usuario);
			query.setString("pass", senha);
			short count = (short)query.uniqueResult();
			session.getTransaction().commit();
			if(count == 1) 
			{
				System.out.println("Autenticado com Sucesso!");
				mainApp.showHome();
			} else {
				Dialogs.create()
		        .title("Erro")
		        .masthead(null)
		        .message("Usuário ou senha inválidos!")
		        .showError();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleExit() {
        System.exit(0);
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

}
