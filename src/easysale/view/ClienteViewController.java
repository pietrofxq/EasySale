package easysale.view;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import easysale.main.*;
import easysale.model.*;
import easysale.controller.*;


public class ClienteViewController {
	
	private MainApp mainApp;
	private SessionFactory sessionFactory;
	private ClienteController clienteController;
	private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
	private ObservableList<Compra> listaCompras = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Cliente> tableClientes;
	@FXML
	private TableColumn<Cliente, String> columnNomeCliente;
	@FXML
	private TableColumn<Cliente, String> columnCpfCliente;
	@FXML
	private TableView<Compra> tableHistorico;
	@FXML
	private TableColumn<Compra, String> columnHistoricoNome;
	@FXML
	private TableColumn<Compra, Number> columnHistoricoPreco;
	@FXML
	private TableColumn<Compra, Number> columnHistoricoQnt;
	@FXML
	private TableColumn<Compra, LocalDateTime> columnHistoricoData;
	
	@FXML
	public void initialize() {
		configureCells();
		
		tableClientes.setItems(listaClientes);
		tableHistorico.setItems(listaCompras);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
		this.clienteController = new ClienteController(session);
	}
	
	public void configureCells() {
		columnNomeCliente.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		columnCpfCliente.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		
		columnHistoricoNome.setCellValueFactory(cellData -> cellData.getValue().nomeProdutoProperty());
		columnHistoricoPreco.setCellValueFactory(cellData -> cellData.getValue().precoProperty());
		columnHistoricoPreco.setCellFactory(col -> 
			new TableCell<Compra, Number>() {
				@Override
				public void updateItem(Number preco, boolean vazio) {
					super.updateItem(preco, vazio);
					if (vazio) {
						setText(null);
					} else {
						setText(String.format("R$ %.2f", preco.doubleValue()));
					}
				}
		});
		columnHistoricoQnt.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		columnHistoricoData.setCellValueFactory(cellData -> cellData.getValue().dataCompraProperty());
		
	}
	
	public void initEvents() {
		tableClientes.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showHistoricoCliente(newValue)
				);
	}
	
	public void showHistoricoCliente(Cliente cliente) {
		listaCompras.clear();
		listaCompras.addAll(cliente.getCompras());
	}
	
	@FXML
	public void handleNewCliente() {
		Cliente temp = new Cliente();
		boolean okClicked = mainApp.showClienteDialog(temp, "Adicionar Cliente");
		
		if (okClicked) {
			clienteController.persist(temp);
			showHistoricoCliente(temp);
			listaClientes.add(temp);
		}
	}
	
	public void addClientes() {
		List<Cliente> clientes = clienteController.findAll();
		
		for (Cliente cliente : clientes) {
			listaClientes.add(cliente);
			System.out.println(cliente.getNome());
		}
	}
	

}
