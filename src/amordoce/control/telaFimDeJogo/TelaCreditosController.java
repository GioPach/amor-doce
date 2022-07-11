package amordoce.control.telaFimDeJogo;

import amordoce.App;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 * FXML Controller class
 *
 * @author Filipe
 */
public class TelaCreditosController implements Initializable {

    @FXML
    public Hyperlink hyperlink;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        if(App.namorado == null) {
            App.setRoot("TelaFimDeJogoRuim");
        }
        else {
            App.setRoot("TelaFimDeJogoBom");
        }
    }
    
    @FXML
    private void openLink(ActionEvent event) throws URISyntaxException, Exception {
        Hyperlink link = (Hyperlink) event.getSource();
        
        switch(link.getId()) {
            case "githubIntegrante1":
                Desktop.getDesktop().browse(new URI("https://github.com/FilipeSiota"));
                break;
            case "githubIntegrante2":
                Desktop.getDesktop().browse(new URI("https://github.com/GioPach"));
                break;
            case "githubIntegrante3":
                Desktop.getDesktop().browse(new URI("https://github.com/estigarribia08"));
                break;
        }
    }
}
