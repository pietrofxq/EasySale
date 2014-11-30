package easysale.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import easysale.controller.FuncionarioController;
import easysale.main.MainApp;
import easysale.model.Funcionario;


public class FuncionarioViewController {

	private static ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
	private FuncionarioController funcionarioController;
	private SessionFactory sessionFactory;
	private MainApp mainApp;
	
	@FXML
	private TableView<Funcionario> tableFunc;
	@FXML
	private TableColumn<Funcionario, String> nomeColumn;
	@FXML
	private TableColumn<Funcionario, Number> cpfColumn;
	@FXML
	private TableColumn<Funcionario, String> cargoColumn;
	@FXML
	private Button deleteBtn;
	@FXML
	private Button editBtn;
	@FXML
	private TextField txPesquisa;
	
	
	public FuncionarioViewController() {
	
	}
	@FXML
	private void initialize() {
		nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
		tableFunc.getSelectionModel().selectedItemProperty().addListener(
		(observable, oldValue,newValue)-> handleFuncionarioClicado(newValue));
	}
	
	
	public void addFunc() {
		List<Funcionario> funcionarios = funcionarioController.findAllFuncionario();
		listaFuncionarios.clear();
		listaFuncionarios.addAll(funcionarios);
		tableFunc.setItems(listaFuncionarios);
	}
	
	private void handleFuncionarioClicado(Funcionario func) {
		if(func == null) {
			deleteBtn.setDisable(true);
			editBtn.setDisable(true);
		} else {
			deleteBtn.setDisable(false);
			editBtn.setDisable(false);
		}
	}
	
	
	@FXML
	private void handleNewFunc() {
		Funcionario func = new Funcionario();
		boolean okClicked = mainApp.showNewFuncDialog(func, "Adicionar novo Funcionário");
		if(okClicked) {
			funcionarioController.insertFuncionario(func);
		}
	}
	@FXML
	private void handlePesquisa() {
		if (!txPesquisa.getText().equals("")) {
			tableFunc.setItems(pesquisaFunc());
		} else {
			tableFunc.setItems(listaFuncionarios);
		}
	}
	private ObservableList<Funcionario> pesquisaFunc() {
		ObservableList<Funcionario> funcionariosEncontrados = FXCollections.observableArrayList();
		for (Funcionario func : listaFuncionarios) {
			if (func.getNome().toLowerCase().contains(txPesquisa.getText().toLowerCase())) {
				funcionariosEncontrados.add(func);
			}
		}
		return funcionariosEncontrados;
	}
	
	public MainApp getMainApp() {
		return mainApp;
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	public FuncionarioController getFuncionarioController() {
		return funcionarioController;
	}
	public void setFuncionarioController(FuncionarioController funcionarioController) {
		this.funcionarioController = funcionarioController;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

