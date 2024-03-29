package amordoce.control;

import amordoce.App;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

public class TelaInicialController implements Initializable {
    
    @FXML
    public VBox containerTimeDev;
    @FXML
    public Button btnVoltar;
    @FXML
    public Button btnJogar;
    @FXML
    public Button btnCreditos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlerButtonJogar(ActionEvent event) throws Exception {
        App.setRoot("TelaInputUsuario");
    }
    
    @FXML
    private void handlerButtonMostrarCreditos(ActionEvent event) throws Exception {
        if(this.btnJogar.isVisible()) {
            this.btnJogar.setVisible(false);
            this.btnCreditos.setVisible(false);
            this.containerTimeDev.setVisible(true);
            this.btnVoltar.setVisible(true);
        }
        else {
            this.btnJogar.setVisible(true);
            this.btnCreditos.setVisible(true);
            this.containerTimeDev.setVisible(false);
            this.btnVoltar.setVisible(false);
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
    
    @FXML private void handlerButtonEasterEgg() throws Exception {
        App.setRoot("TelaEasterEgg");
    }
    
}
