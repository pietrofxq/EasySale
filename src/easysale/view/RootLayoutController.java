package easysale.view;

import javafx.fxml.FXML;
import easysale.main.MainApp;

public class RootLayoutController {
	
	// Refer�ncia � aplica��o principal
	private MainApp mainApp;

    /**
     * � chamado pela aplica��o principal para referenciar a si mesma.
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
     * Fecha a aplica��o.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    
}
