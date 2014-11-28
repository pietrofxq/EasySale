package easysale.view;

import javafx.fxml.FXML;
import easysale.main.MainApp;

public class RootLayoutController {
	
	// Referência à aplicação principal
	private MainApp mainApp;

    /**
     * É chamado pela aplicação principal para referenciar a si mesma.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    public void showHome() {
    	mainApp.showHome();
    }
    
    @FXML
    public void showClientes() {
    	mainApp.showClientes();
    }
    
    
    /**
     * Fecha a aplicação.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    
}
