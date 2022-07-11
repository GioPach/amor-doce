package amordoce.control.telaFimDeJogo;

import amordoce.App;
import amordoce.control.TelaInicialController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * 
 * @author Filipe
 */

public class TelaFimDeJogoController extends TelaInicialController implements Initializable {

    @FXML
    public Label labelMensagemFinal;
    @FXML
    public Button btnCreditos;
    @FXML
    public Button btnConversas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void handlerMostrarCreditos() {
        //App.setRoot("TelaCreditos");
    }
    
    @FXML
    public void handlerLogConversas() {
        //App.setRoot("TelaLogConversas");
    }
}
