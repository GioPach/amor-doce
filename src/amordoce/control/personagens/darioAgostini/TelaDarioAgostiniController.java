package amordoce.control.personagens.darioAgostini;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.Conversa;
import amordoce.model.Resposta;
import amordoce.model.personagens.EmaMontenegro;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaDarioAgostiniController extends PersonagemController implements Initializable {
    
    public static EmaMontenegro ema = new EmaMontenegro("Ema Montenegro", "DS3", 21, "Gêmeos", "Espanhola", 'F', "Neutro", NivelDificuldade.FACIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(ema);
        listenVisibilidadeNamoro(ema);
        ema.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(ema);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(ema);
        ema.verificarRespostaConversa3();
        carregarConversa(ema);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(ema.pedirEmNamoro()) {
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
        
        ema.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(ema);
        labelPergunta.setText(ema.getConversaAtual().getReacao(idResposta));
        ema.concluirConversa(ema.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
