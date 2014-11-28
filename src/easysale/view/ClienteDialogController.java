package easysale.view;

import easysale.model.*;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.fxml.*;

public class ClienteDialogController {
	
	private Stage dialogStage;
	private Cliente cliente;
	private boolean okClicked = false;
	
	@FXML
	private Text txTitle;
	@FXML
	private TextField txNome;
	@FXML
	private TextField txCpf;
	
	@FXML
	public void initialize() {
		
	}
	
	 public void setTitle(String title) {
    	txTitle.setText(title);
    }
	 
	 public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    	txNome.setText(cliente.getNome());
    	txCpf.setText(cliente.getCpf());
    	
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
    	cliente.setNome(txNome.getText());
    	cliente.setCpf(txCpf.getText());
    	okClicked = true;
    	dialogStage.close();
    }
    
    @FXML
    private void handleSair() {
    	okClicked = false;
    	dialogStage.close();
    }

}
