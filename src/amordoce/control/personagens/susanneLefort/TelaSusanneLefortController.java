package amordoce.control.personagens.susanneLefort;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.SusanneLefort;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaSusanneLefortController extends PersonagemController implements Initializable {
    
    public static SusanneLefort susanneLefort = new SusanneLefort("Susanne Lefort", "Informática", 23, "Leão", "Francesa", 'F', "Neutro", NivelDificuldade.FACIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(susanneLefort);
        listenVisibilidadeNamoro(susanneLefort);
        susanneLefort.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(susanneLefort);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(susanneLefort);
        susanneLefort.verificarRespostaConversa3();
        carregarConversa(susanneLefort);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(susanneLefort.pedirEmNamoro()) {
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/susanneLefort/TelaLogSusanneLefort");
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
        
        susanneLefort.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(susanneLefort);
        labelPergunta.setText(susanneLefort.getConversaAtual().getReacao(idResposta));
        susanneLefort.concluirConversa(susanneLefort.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
