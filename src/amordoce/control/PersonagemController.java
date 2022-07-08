package amordoce.control;

import amordoce.App;
import amordoce.model.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PersonagemController implements Initializable {
    
    @FXML
    public AnchorPane anchorPane;
    @FXML 
    public Label labelEnergia;
    @FXML 
    public Label labelHumor;
    @FXML 
    public Label labelInteresse;
    @FXML
    public Label labelPergunta;
    @FXML
    public Button btnOpcaoA;
    @FXML
    public Button btnOpcaoB;
    @FXML
    public Button btnOpcaoC;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    public void atualizarAtributosTela(Personagem personagem) {
        labelEnergia.setText("Energia: " + personagem.getEnergia() + "%");
        labelHumor.setText("Humor: " + personagem.getHumor());
        labelInteresse.setText("Interesse: " + personagem.getInteresse() + "%");
    }
    
    @FXML
    public void fecharPerguntas() {
        anchorPane.getChildren().remove(btnOpcaoA);
        anchorPane.getChildren().remove(btnOpcaoB);
        anchorPane.getChildren().remove(btnOpcaoC);
    }
}