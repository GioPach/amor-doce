package amordoce.control.personagens.emaMontenegro;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaEmaMontenegroController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(TelaPersonagensController.emaMontenegro);
        listenVisibilidadeNamoro(TelaPersonagensController.emaMontenegro);
        listenVisibilidadeFofoca(TelaPersonagensController.emaMontenegro);
        TelaPersonagensController.emaMontenegro.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.emaMontenegro);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.emaMontenegro);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception { 
        TelaPersonagensController.emaMontenegro.setFofoca("");
        
        listenVisibilidadeNamoro(TelaPersonagensController.emaMontenegro);
        listenVisibilidadeFofoca(TelaPersonagensController.emaMontenegro);
        TelaPersonagensController.emaMontenegro.verificarRespostaConversa3();
        carregarConversa(TelaPersonagensController.emaMontenegro);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(TelaPersonagensController.emaMontenegro.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaLogEmaMontenegro");
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
        
        TelaPersonagensController.emaMontenegro.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(TelaPersonagensController.emaMontenegro);
        labelPergunta.setText(TelaPersonagensController.emaMontenegro.getConversaAtual().getReacao(idResposta));
        TelaPersonagensController.emaMontenegro.concluirConversa(TelaPersonagensController.emaMontenegro.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
