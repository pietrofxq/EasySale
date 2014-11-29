package easysale.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.controlsfx.dialog.Dialogs;
import org.hibernate.SessionFactory;

import easysale.controller.ClienteController;
import easysale.model.*;
import javafx.scene.control.TextField;
import javafx.stage.*;
import javafx.fxml.*;

public class VendaDialogController {
	
	private Stage dialogStage;
	private Produto produto;
	private boolean okClicked = false;
	private SessionFactory sessionFactory;
	private ClienteController clienteController;
	
	@FXML
	private TextField txNomeProduto;
	
	@FXML
	private TextField txPreco;
	
	@FXML
	private TextField txCpfCliente;
	
	@FXML
	private TextField txQnt;
	
	
	
	@FXML
	public void initialize() {
	
	}
	
	 
	 public void setProduto(Produto produto) {
    	this.produto = produto;
    	txNomeProduto.setText(produto.getNome());
    	txPreco.setText(String.valueOf(produto.getPreco()));
    	
    }
    
	 public void setSessionFactory(SessionFactory session) {
		 this.sessionFactory = session;
		 this.clienteController = new ClienteController(sessionFactory);
	 }
    
    public void setDialogStage(Stage stage) {
    	this.dialogStage = stage;
    }
    
    public boolean isOkClicked() {
    	return okClicked;
    }
    
    @FXML
    private void handleOk() {
    	// TODO: input is valid
    	String cpf = txCpfCliente.getText();
    	Cliente cliente = clienteController.findByCpf(cpf);
    	if (cliente == null) {
    		Dialogs.create()
	        .title("Erro")
	        .masthead(null)
	        .message("Cliente não encontrado. Tente outro CPF")
	        .showError();
    		return;
    	}
    	String quantidade = txQnt.getText();
    	Compra compra = new Compra();
    	compra.setProduto(produto);
    	compra.setNomeProduto(produto.getNome());
    	compra.setPreco(produto.getPreco());
    	compra.setQuantidade(Integer.valueOf(quantidade));
    	compra.setDataCompra(LocalDateTime.now());
    	cliente.addCompra(compra);
    	produto.setQuantidade(produto.getQuantidade() - Integer.valueOf(quantidade));
    	clienteController.persist(cliente);
    	okClicked = true;
    	dialogStage.close();
    }
    
    @FXML
    private void handleSair() {
    	okClicked = false;
    	dialogStage.close();
    }

}
