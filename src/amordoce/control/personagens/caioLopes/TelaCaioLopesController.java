package amordoce.control.personagens.caioLopes;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.CaioLopes;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaCaioLopesController extends PersonagemController implements Initializable {
    
    public static CaioLopes caioLopes = new CaioLopes("Caio Lopes", "Música", 21, "Peixes", "Brasileiro", 'M', "Neutro", NivelDificuldade.MEDIO);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(caioLopes);
        listenVisibilidadeNamoro(caioLopes);
        caioLopes.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(caioLopes);
        caioLopes.verificarRespostaConversa3();
        carregarConversa(caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(caioLopes.pedirEmNamoro()) {
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
        
        caioLopes.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(caioLopes);
        labelPergunta.setText(caioLopes.getConversaAtual().getReacao(idResposta));
        caioLopes.concluirConversa(caioLopes.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
