package easysale.view;

import easysale.controller.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;
import easysale.model.*;

public class ProdutoDialogController {
	
	private Stage dialogStage;
    private Produto produto;
    private boolean okClicked = false;
    
    @FXML
    private TextField txNome;
    @FXML
    private TextField txDesc;
    @FXML
    private TextField txCod;
    @FXML
    private TextField txQnt;
    @FXML
    private Text txTitle;
    
    public ProdutoDialogController() {
    }
    
    
    @FXML
    private void initialize() {
    	
    }
    
    public void setTitle(String title) {
    	txTitle.setText(title);
    }
    
    
    public void setDialogStage(Stage stage) {
    	this.dialogStage = stage;
    }
    
    public void setProduto(Produto produto) {
    	this.produto = produto;
    	txNome.setText(produto.getNome());
    	txDesc.setText(produto.getDescricao());
    	txCod.setText(String.valueOf(produto.getCodigo()));
    	txQnt.setText(String.valueOf(produto.getQuantidade()));
    }
    
    public boolean isOkClicked() {
    	return okClicked;
    }
    
    @FXML
    private void handleOk() {
    	// TODO: is input valid
    	produto.setNome(txNome.getText());
    	produto.setDescricao(txDesc.getText());
    	produto.setCodigo(Integer.parseInt(txCod.getText()));
    	produto.setQuantidade(Integer.parseInt(txQnt.getText()));
    	okClicked = true;
    	dialogStage.close();
    }
    
    @FXML
  
    private void handleSair() {
    	dialogStage.close();
    }

}
