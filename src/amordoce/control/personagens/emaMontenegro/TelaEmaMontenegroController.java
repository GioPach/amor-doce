package amordoce.control.personagens.emaMontenegro;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.EmaMontenegro;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaEmaMontenegroController extends PersonagemController implements Initializable {
    
    public static EmaMontenegro emaMontenegro = new EmaMontenegro("Ema Montenegro", "Música", 21, "Gêmeos", "Espanhola", 'F', "Neutro", NivelDificuldade.DIFICIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(emaMontenegro);
        listenVisibilidadeNamoro(emaMontenegro);
        emaMontenegro.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(emaMontenegro);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(emaMontenegro);
        emaMontenegro.verificarRespostaConversa3();
        carregarConversa(emaMontenegro);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(emaMontenegro.pedirEmNamoro()) {
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
        
        emaMontenegro.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(emaMontenegro);
        labelPergunta.setText(emaMontenegro.getConversaAtual().getReacao(idResposta));
        emaMontenegro.concluirConversa(emaMontenegro.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
