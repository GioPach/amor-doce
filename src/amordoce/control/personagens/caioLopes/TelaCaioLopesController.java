package amordoce.control.personagens.caioLopes;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaCaioLopesController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.caioLopes);
        listenVisibilidadeNamoro(TelaPersonagensController.caioLopes);
        listenVisibilidadeFofoca(TelaPersonagensController.caioLopes);
        TelaPersonagensController.caioLopes.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.caioLopes);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.emaMontenegro.isPedidoEmNamoro()) {
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.emaMontenegro.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.emaMontenegro);
            listenVisibilidadeFofoca(TelaPersonagensController.emaMontenegro);
            TelaPersonagensController.emaMontenegro.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.emaMontenegro);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.caioLopes);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/caioLopes/TelaLogCaioLopes");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.emaMontenegro.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.emaMontenegro.pedirEmNamoro()) {
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

            TelaPersonagensController.emaMontenegro.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.emaMontenegro);
            labelPergunta.setText(TelaPersonagensController.emaMontenegro.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.emaMontenegro.concluirConversa(TelaPersonagensController.emaMontenegro.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
