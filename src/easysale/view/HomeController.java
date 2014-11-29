package easysale.view;

import javafx.beans.binding.Bindings;
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
	private SessionFactory sessionFactory;
	private ProdutoController produtoController;
	private ClienteController clienteController;
	
	@FXML
	private TableView<Produto> tableProdutos;
	
	@FXML
	private TableColumn<Produto, Number> idProdutoColumn;
	
	@FXML
	private TableColumn<Produto, String> nomeProdutoColumn;
	
	@FXML
	private TableColumn<Produto, Number> precoProdutoColumn;
	
	@FXML
	private TableColumn<Produto, Number> qntProdutoColumn;
	
	@FXML
	private Button btDelete;
	
	@FXML
	private Button btEdit;
	
	@FXML
	private Button btVenda;
	
	@FXML
	private Label labelQntProdutos;
	
	@FXML
	private TextField txPesquisa;
	
	
	public HomeController() {
		
	}
	
	@FXML
	private void initialize() {
		
		idProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
		precoProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().precoProperty());
		
		precoProdutoColumn.setCellFactory(col -> 
				new TableCell<Produto, Number>() {
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
		nomeProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		qntProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		
		// Binda o label de quantidade de produtos com o tamanho do array listaProdutos
		labelQntProdutos.textProperty().bind(Bindings.size(listaProdutos).asString());
		
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
		this.clienteController = new ClienteController(sessionFactory);
		
	}
	
	public void addItens() {
		
		List<Produto> produtos = produtoController.findAll();
		listaProdutos.clear();
		listaProdutos.addAll(produtos);
		
		tableProdutos.setItems(listaProdutos);
		
	}
	
	@FXML
	private void handleNewProduct() {
		Produto temp = new Produto();
		boolean okClicked = mainApp.showNewProductDialog(temp, "Adicionar Produto");
		
		if (okClicked) {
			produtoController.persist(temp);
			listaProdutos.add(temp);
		}
	}
	
	@FXML
	private void handleEditProduct() {
		Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
		boolean okClicked = mainApp.showNewProductDialog(produto, "Editar Produto");
		
		if (okClicked) {
			produtoController.persist(produto);
			
		}
	}
	
	@FXML
	private void handleVendaProduto() {
		Produto produto = tableProdutos.getSelectionModel().getSelectedItem();
		boolean okClicked = mainApp.showVendaDialog(produto);
		
		if (okClicked) {
			
		}
	}
	
	
	private ObservableList<Produto> pesquisaProdutos() {
		ObservableList<Produto> produtosEncontrados = FXCollections.observableArrayList();
		for (Produto produto : listaProdutos) {
			if (produto.getNome().toLowerCase().contains(txPesquisa.getText().toLowerCase())) {
				produtosEncontrados.add(produto);
			}
		}
		
		return produtosEncontrados;
	}
	
	@FXML
	private void handlePesquisa() {
		if (!txPesquisa.getText().equals("")) {
			tableProdutos.setItems(pesquisaProdutos());
		} else {
			tableProdutos.setItems(listaProdutos);
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
	
	@FXML
	private void handleVenda() {
		
	}
	
	
	
}
