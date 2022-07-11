package amordoce.control;

import amordoce.App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaInicialController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlerButtonJogar(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    @FXML private void handlerButtonEasterEgg() throws Exception {
        App.setRoot("TelaEasterEgg");
    }
    
}
