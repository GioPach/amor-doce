package amordoce.control.personagens;

import amordoce.App;
import amordoce.model.Conversa;
import amordoce.model.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PersonagemController implements Initializable {
    
    @FXML 
    public Label labelEnergia;
    @FXML 
    public Label labelHumor;
    @FXML 
    public Label labelInteresse;
    @FXML
    public Label labelNivel;
    @FXML
    public Label labelPergunta;
    @FXML
    public Button btnOpcaoA;
    @FXML
    public Button btnOpcaoB;
    @FXML
    public Button btnOpcaoC;
    @FXML
    public Button btnProxima;
    
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
        labelNivel.setText("Nivel: " + personagem.getNivel());
    }
    
    public void carregarConversa(Personagem personagem) {
        Conversa conversa = personagem.getConversaAtual();

        if(conversa.getId() == -1) {
            setVisibilityRespostas(false);
            labelPergunta.setText("...");
        } else {
            setVisibilityRespostas(true);
            labelPergunta.setText(personagem.getConversaAtual().getPergunta());
            btnOpcaoA.setText(personagem.getConversaAtual().getResposta(0));
            btnOpcaoB.setText(personagem.getConversaAtual().getResposta(1));
            btnOpcaoC.setText(personagem.getConversaAtual().getResposta(2));
        }
    }
    
    @FXML
    public void setVisibilityRespostas(boolean valor) {
        btnOpcaoA.setVisible(valor);
        btnOpcaoB.setVisible(valor);
        btnOpcaoC.setVisible(valor);
    }
    
    @FXML
    public void setVisibilityButtonProxima(boolean valor) {
        btnProxima.setVisible(valor);
    }
}