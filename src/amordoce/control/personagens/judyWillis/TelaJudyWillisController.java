package amordoce.control.personagens.judyWillis;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaJudyWillisController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(TelaPersonagensController.judyWillis);
        listenVisibilidadeNamoro(TelaPersonagensController.judyWillis);
        TelaPersonagensController.judyWillis.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.judyWillis);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.judyWillis);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(TelaPersonagensController.judyWillis);
        TelaPersonagensController.judyWillis.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.judyWillis);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.judyWillis.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/judyWillis/TelaLogJudyWillis");
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
        
        TelaPersonagensController.judyWillis.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.judyWillis);
        labelPergunta.setText(TelaPersonagensController.judyWillis.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.judyWillis.concluirConversa(TelaPersonagensController.judyWillis.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
