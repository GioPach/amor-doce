package amordoce.control.personagens.sophiePorto;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.SophiePorto;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaSophiePortoController extends PersonagemController implements Initializable {
    
    public static SophiePorto sophiePorto = new SophiePorto("Sophie Porto", "Administração", 23, "Escorpião", "Brasileira", 'F', "Neutro", NivelDificuldade.MEDIO);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(sophiePorto);
        listenVisibilidadeNamoro(sophiePorto);
        sophiePorto.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(sophiePorto);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(sophiePorto);
        sophiePorto.verificarRespostaConversa3();
        carregarConversa(sophiePorto);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(sophiePorto.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/sophiePorto/TelaLogSophiePorto");
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
        
        sophiePorto.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(sophiePorto);
        labelPergunta.setText(sophiePorto.getConversaAtual().getReacao(idResposta));
        sophiePorto.concluirConversa(sophiePorto.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
