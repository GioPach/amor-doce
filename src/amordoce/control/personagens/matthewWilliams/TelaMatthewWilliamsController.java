package amordoce.control.personagens.matthewWilliams;

import amordoce.App;
import amordoce.control.personagens.PersonagemController;
import amordoce.model.personagens.MatthewWilliams;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaMatthewWilliamsController extends PersonagemController implements Initializable {
    
    public static MatthewWilliams matthewWilliams = new MatthewWilliams("Matthew Williams", "Música", 23, "Aquário", "Alemão", 'M', "Neutro", NivelDificuldade.FACIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        esconderButtonNamoro();
        atualizarAtributosTela(matthewWilliams);
        listenVisibilidadeNamoro(matthewWilliams);
        matthewWilliams.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(matthewWilliams);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        listenVisibilidadeNamoro(matthewWilliams);
        matthewWilliams.verificarRespostaConversa3();
        carregarConversa(matthewWilliams);
        setVisibilidadeButton(this.btnProxima, false);
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        if(matthewWilliams.pedirEmNamoro()) {
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
        
        matthewWilliams.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(matthewWilliams);
        labelPergunta.setText(matthewWilliams.getConversaAtual().getReacao(idResposta));
        matthewWilliams.concluirConversa(matthewWilliams.getConversaAtual().getId());
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
    }
}
