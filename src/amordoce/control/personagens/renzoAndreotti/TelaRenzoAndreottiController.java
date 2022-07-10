package amordoce.control.personagens.renzoAndreotti;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaRenzoAndreottiController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(TelaPersonagensController.renzoAndreotti);
        listenVisibilidadeNamoro(TelaPersonagensController.renzoAndreotti);
        TelaPersonagensController.renzoAndreotti.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.renzoAndreotti);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(TelaPersonagensController.renzoAndreotti);
        TelaPersonagensController.renzoAndreotti.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.renzoAndreotti);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.renzoAndreotti.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/renzoAndreotti/TelaLogRenzoAndreotti");
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
        
        TelaPersonagensController.renzoAndreotti.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.renzoAndreotti);
        labelPergunta.setText(TelaPersonagensController.renzoAndreotti.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.renzoAndreotti.concluirConversa(TelaPersonagensController.renzoAndreotti.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
