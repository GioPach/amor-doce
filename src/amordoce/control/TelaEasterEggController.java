package amordoce.control;

import amordoce.App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaEasterEggController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML private void handlerButtonVoltar() throws Exception {
        App.setRoot("TelaInicial");
    }
    
}
