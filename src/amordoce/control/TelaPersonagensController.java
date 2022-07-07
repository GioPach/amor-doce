package amordoce.control;

import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaPersonagensController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handlerButtonSairDoJogo(ActionEvent event) throws Exception {
        App.setRoot("TelaInicial");
    }
    
    @FXML
    private void handlerButtonEmaMontenegro(ActionEvent event) throws Exception {
        App.setRoot("TelaEmaMontenegro");
    }
}
