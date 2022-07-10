package amordoce.control.personagens.darioAgostini;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.DarioAgostini;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaDarioAgostiniController extends PersonagemController implements Initializable {
    
    public static DarioAgostini darioAgostini = new DarioAgostini("Dario Agostini", "Informática", 20, "Câncer", "Italiano", 'M', "Neutro", NivelDificuldade.FACIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(darioAgostini);
        listenVisibilidadeNamoro(darioAgostini);
        darioAgostini.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(darioAgostini);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(darioAgostini);
        darioAgostini.verificarRespostaConversa3();
        carregarConversa(darioAgostini);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(darioAgostini.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/darioAgostini/TelaLogDarioAgostini");
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
        
        darioAgostini.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(darioAgostini);
        labelPergunta.setText(darioAgostini.getConversaAtual().getReacao(idResposta));
        darioAgostini.concluirConversa(darioAgostini.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
