package easysale.view;

import easysale.model.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FuncionarioDialogController {
	private Stage dialogStage;
	private Funcionario func;
	private boolean okClicked = false;

	@FXML
	private TextField nameField;
	@FXML
	private TextField passField;
	@FXML
	private TextField cargoField;
	@FXML
	private TextField cpfField;
	@FXML
	private Text txTitle;

	public FuncionarioDialogController() {
		
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
	
    
    public void setFuncionario(Funcionario func) {
    	this.func = func;
    	nameField.setText(func.getNome());
    	passField.setText(func.getPass());
    	cargoField.setText(func.getCargo());
    	cpfField.setText(String.valueOf((func.getCpf())));	
    }
     
    public boolean isOkClicked() {
    	return okClicked;
    }
    
    @FXML
    private void handleOk(){
    	func.setNome(nameField.getText());
    	func.setCargo(cargoField.getText());
    	func.setCpf(Integer.parseInt(cpfField.getText()));
    	func.setPass(passField.getText());
    	okClicked = true;
    	dialogStage.close();
    }
    
    @FXML
    private void handleSair() {
    	okClicked = false;
    	dialogStage.close();
    }

    
    
}
