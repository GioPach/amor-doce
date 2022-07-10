package amordoce.control.personagens.matthewWilliams;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaMatthewWilliamsController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.matthewWilliams);
        listenVisibilidadeNamoro(TelaPersonagensController.matthewWilliams);
        listenVisibilidadeFofoca(TelaPersonagensController.matthewWilliams);
        TelaPersonagensController.matthewWilliams.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.matthewWilliams);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.matthewWilliams);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        TelaPersonagensController.matthewWilliams.setFofoca("");
        
        listenVisibilidadeNamoro(TelaPersonagensController.matthewWilliams);
        listenVisibilidadeFofoca(TelaPersonagensController.matthewWilliams);
        TelaPersonagensController.matthewWilliams.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.matthewWilliams);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.matthewWilliams.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/matthewWilliams/TelaLogMatthewWilliams");
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
        
        TelaPersonagensController.matthewWilliams.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.matthewWilliams);
        labelPergunta.setText(TelaPersonagensController.matthewWilliams.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.matthewWilliams.concluirConversa(TelaPersonagensController.matthewWilliams.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
