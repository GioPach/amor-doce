package amordoce.control.personagens.catherineJones;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaCatherineJonesController extends PersonagemController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(TelaPersonagensController.catherineJones);
        listenVisibilidadeNamoro(TelaPersonagensController.catherineJones);
        TelaPersonagensController.catherineJones.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.catherineJones);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.catherineJones);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(TelaPersonagensController.catherineJones);
        TelaPersonagensController.catherineJones.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.catherineJones);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.catherineJones.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/catherineJones/TelaLogCatherineJones");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        Button btn = (Button) event.getSource();
        
        int idResposta;
        
        switch(btn.getId())
        {
            case "btnOpcaoA":
                idResposta = 0;
                break;
            
            case "btnOpcaoB":
                idResposta = 1;
                break;

            case "btnOpcaoC":
                idResposta = 2;
                break;
                
            default:
                idResposta = -1;
                break;
                
        }
        
        TelaPersonagensController.catherineJones.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.catherineJones);
        labelPergunta.setText(TelaPersonagensController.catherineJones.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.catherineJones.concluirConversa(TelaPersonagensController.catherineJones.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
