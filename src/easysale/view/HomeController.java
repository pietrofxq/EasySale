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
	
	public HomeController() {
		
	}
	
	@FXML
	private void initialize() {
		idProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		descProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
		nomeProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		qntProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		
	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}
	
	public void addItens() {
		ProdutoController produtoController = new ProdutoController(sessionFactory);
		List<Produto> produtos = produtoController.findAll();
		
		for (Produto produto : produtos) {
			listaProdutos.add(produto);
			System.out.println(produto.getNome());
		}
		
		tableProdutos.setItems(listaProdutos);
	}
	
	
	
	
}
