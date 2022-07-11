package amordoce.control;

import amordoce.App;
import amordoce.model.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Filipe
 */
public class TelaInputUsuarioController implements Initializable {

    @FXML
    private TextField inputNome;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlerButtonProximo(ActionEvent event) throws Exception {
        App.usuario = new Personagem();
        App.usuario.setNome(inputNome.getText());
        
        App.setRoot("TelaPersonagens");
    }
    
    @FXML private void handlerButtonEasterEgg() throws Exception {
        App.setRoot("TelaEasterEgg");
    }
}
