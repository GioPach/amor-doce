package amordoce.control.personagens.dylanAyala;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaDylanAyalaController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.dylanAyala);
        listenVisibilidadeNamoro(TelaPersonagensController.dylanAyala);
        listenVisibilidadeFofoca(TelaPersonagensController.dylanAyala);
        TelaPersonagensController.dylanAyala.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.dylanAyala);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.dylanAyala);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.dylanAyala.isPedidoEmNamoro()) {
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.dylanAyala.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.dylanAyala);
            listenVisibilidadeFofoca(TelaPersonagensController.dylanAyala);
            TelaPersonagensController.dylanAyala.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.dylanAyala);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.dylanAyala);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/dylanAyala/TelaLogDylanAyala");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.dylanAyala.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.dylanAyala.pedirEmNamoro()) {
                labelPergunta.setText("SIM!");
                setVisibilidadeButton(this.btnProxima, true);
            }
            else {
                labelPergunta.setText("NÃO!");
                setVisibilidadeButton(this.btnVoltar, true);
            }
            
        }
        else {
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

            TelaPersonagensController.dylanAyala.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.dylanAyala);
            labelPergunta.setText(TelaPersonagensController.dylanAyala.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.dylanAyala.concluirConversa(TelaPersonagensController.dylanAyala.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
