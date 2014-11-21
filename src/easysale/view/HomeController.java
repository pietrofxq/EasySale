package easysale.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import easysale.main.*;
import easysale.controller.*;
import easysale.model.*;

import java.util.*;

import org.hibernate.*;

public class HomeController {
	
	private MainApp mainApp;
	private static ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
	private SessionFactory sessionFactory = null;
	private ProdutoController produtoController = null;
	
	@FXML
	private TableView<Produto> tableProdutos;
	
	@FXML
	private TableColumn<Produto, Number> idProdutoColumn;
	
	@FXML
	private TableColumn<Produto, String> nomeProdutoColumn;
	
	@FXML
	private TableColumn<Produto, String> descProdutoColumn;
	
	@FXML
	private TableColumn<Produto, Number> qntProdutoColumn;
	
	@FXML
	private Button btDelete;
	
	@FXML
	private Button btEdit;
	
	public HomeController() {
		
	}
	
	@FXML
	private void initialize() {
		idProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		descProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
		nomeProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		qntProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		
		tableProdutos.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> handleProdutoClicado(newValue)
				);
		
	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
		this.produtoController = new ProdutoController(sessionFactory);
		
	}
	
	public void addItens() {
		
		List<Produto> produtos = produtoController.findAll();
		
		for (Produto produto : produtos) {
			listaProdutos.add(produto);
			System.out.println(produto.getNome());
		}
		
		tableProdutos.setItems(listaProdutos);
	}
	
	@FXML
	
	public void handleNewProduct() {
		Produto temp = new Produto();
		boolean okClicked = mainApp.showNewProductDialog(temp, "Adicionar Produto");
		
		if (okClicked) {
			produtoController.persist(temp);
			listaProdutos.add(temp);
		}
	}
	
	@FXML
	public void handleEditProduct() {
		Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
		boolean okClicked = mainApp.showNewProductDialog(produto, "Editar Produto");
		
		if (okClicked) {
			produtoController.persist(produto);
			
		}
	}
	
	private void handleProdutoClicado(Produto produto) {
		if (produto == null) {
			btDelete.setDisable(true);
			btEdit.setDisable(true);
		} else {
			btDelete.setDisable(false);
			btEdit.setDisable(false);
		}
	}
	
	@FXML
	private void handleDeleteProduct() {
		Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
		listaProdutos.remove(produto);
		produtoController.delete(produto);
		
	}
	
	
	
	
}
