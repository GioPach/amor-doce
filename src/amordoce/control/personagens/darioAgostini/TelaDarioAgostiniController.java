package amordoce.control.personagens.darioAgostini;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaDarioAgostiniController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.darioAgostini);
        listenVisibilidadeNamoro(TelaPersonagensController.darioAgostini);
        listenVisibilidadeFofoca(TelaPersonagensController.darioAgostini);
        TelaPersonagensController.darioAgostini.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.darioAgostini);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.darioAgostini);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.darioAgostini.isPedidoEmNamoro()) {
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.darioAgostini.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.darioAgostini);
            listenVisibilidadeFofoca(TelaPersonagensController.darioAgostini);
            TelaPersonagensController.darioAgostini.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.darioAgostini);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.darioAgostini);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/darioAgostini/TelaLogDarioAgostini");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.darioAgostini.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.darioAgostini.pedirEmNamoro()) {
                labelPergunta.setText("SIM!");
                setVisibilidadeButton(this.btnProxima, true);
            }
            else {
                labelPergunta.setText("NÃO!");
                setVisibilidadeButton(this.btnVoltar, true);
                setVisibilidadeButton(this.btnConversas, true);
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

            TelaPersonagensController.darioAgostini.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.darioAgostini);
            labelPergunta.setText(TelaPersonagensController.darioAgostini.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.darioAgostini.concluirConversa(TelaPersonagensController.darioAgostini.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
