package amordoce.control.personagens.caioLopes;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaCaioLopesController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(TelaPersonagensController.caioLopes);
        listenVisibilidadeNamoro(TelaPersonagensController.caioLopes);
        listenVisibilidadeFofoca(TelaPersonagensController.caioLopes);
        TelaPersonagensController.caioLopes.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.caioLopes);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        TelaPersonagensController.caioLopes.setFofoca("");
        
        listenVisibilidadeNamoro(TelaPersonagensController.caioLopes);
        listenVisibilidadeFofoca(TelaPersonagensController.caioLopes);
        TelaPersonagensController.caioLopes.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.caioLopes.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/caioLopes/TelaLogCaioLopes");
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
        
        TelaPersonagensController.caioLopes.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.caioLopes);
        labelPergunta.setText(TelaPersonagensController.caioLopes.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.caioLopes.concluirConversa(TelaPersonagensController.caioLopes.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
