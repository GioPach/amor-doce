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
        listenConversasAlternativas();
        carregarConversa(TelaPersonagensController.caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.caioLopes);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.caioLopes.isPedidoEmNamoro()) {
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.caioLopes.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.caioLopes);
            listenVisibilidadeFofoca(TelaPersonagensController.caioLopes);
            listenConversasAlternativas();
            carregarConversa(TelaPersonagensController.caioLopes);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
    private void listenConversasAlternativas() {
        listenConversaAlternativa3();
        listenConversaAlternativa5();
        listenConversaAlternativa7();
    }
    
    private void listenConversaAlternativa3() {
        int idConversa3 = 2;
        if(TelaPersonagensController.caioLopes.getConversaAtual().getId() == idConversa3) {
            TelaPersonagensController.caioLopes.verificarConversa2();
        }
    }
    
    private void listenConversaAlternativa5() {
        int idConversa5 = 4;
        if(TelaPersonagensController.caioLopes.getConversaAtual().getId() == idConversa5) {
            TelaPersonagensController.caioLopes.verificarConversa4();
        }
    }
    
    private void listenConversaAlternativa7() {
        int idConversa7 = 6;
        if(TelaPersonagensController.caioLopes.getConversaAtual().getId() == idConversa7) {
            TelaPersonagensController.caioLopes.verificarConversa6();
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
        if(TelaPersonagensController.caioLopes.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.caioLopes.pedirEmNamoro()) {
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

            TelaPersonagensController.caioLopes.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.caioLopes);
            labelPergunta.setText(TelaPersonagensController.caioLopes.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.caioLopes.concluirConversa(TelaPersonagensController.caioLopes.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
