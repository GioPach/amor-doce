package amordoce.control;

import amordoce.model.Personagem;
import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaEmaMontenegroController extends PersonagemController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Personagem ema = new Personagem();
        ema.setEnergia(100);
        ema.setHumor("Feliz");
        ema.setInteresse(0.2);
        ema.setNivel("Médio");
        
        labelEnergia.setText("Energia: " + ema.getEnergia() + "%");
        labelHumor.setText("Humor: " + ema.getHumor());
        labelInteresse.setText("Interesse: " + ema.getInteresse() + "%");
        labelNivel.setText("Nivel: " + ema.getNivel());
        
        labelPergunta.setText(ema.getConversaAtual());
        btnOpcaoA.setText(ema.getConversaAtual().getResposta(0));
        btnOpcaoB.setText(ema.getConversaAtual().getResposta(1));
        btnOpcaoC.setText(ema.getConversaAtual().getResposta(2));
    }
    
    @FXML
    private void handlerButtonOpcaoA(ActionEvent event) throws Exception {
        System.out.println("Você clicou em na opção A");
    }
    
    @FXML
    private void handlerButtonOpcaoB(ActionEvent event) throws Exception {
        System.out.println("Você clicou em na opção B");
    }
    
    @FXML
    private void handlerButtonOpcaoC(ActionEvent event) throws Exception {
        System.out.println("Você clicou em na opção C");
    }
}
