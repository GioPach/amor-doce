package amordoce.control;

import amordoce.App;
import amordoce.model.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Filipe
 * @author Giovani
 */
public class TelaInputUsuarioController implements Initializable {

    @FXML
    private Label labelMsgErro;
    
    @FXML
    private TextField inputNome;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private boolean validarNome(String nome) {
        if(nome.length() < 3) {
            return false;
        } else {
            return true;
        }
    }
    
    @FXML
    private void handlerButtonProximo(ActionEvent event) throws Exception {
        App.usuario = new Personagem();
        String nome = inputNome.getText();
        
        if(validarNome(nome)) {
            App.usuario.setNome(nome);
            App.setRoot("TelaPersonagens");
        } else {
            inputNome.getStyleClass().add("nomeInvalido");
            labelMsgErro.setVisible(true);
        }
    }
    
    @FXML private void handlerButtonEasterEgg() throws Exception {
        App.setRoot("TelaEasterEgg");
    }
}
