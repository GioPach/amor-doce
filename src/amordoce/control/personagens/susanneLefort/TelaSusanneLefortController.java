package amordoce.control.personagens.susanneLefort;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaSusanneLefortController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.susanneLefort);
        listenVisibilidadeNamoro(TelaPersonagensController.susanneLefort);
        listenVisibilidadeFofoca(TelaPersonagensController.susanneLefort);
        TelaPersonagensController.susanneLefort.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.susanneLefort);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.susanneLefort);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {
        if(TelaPersonagensController.susanneLefort.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.susanneLefort; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {        
            TelaPersonagensController.susanneLefort.setFofoca("");
            
            listenVisibilidadeNamoro(TelaPersonagensController.susanneLefort);
            listenVisibilidadeFofoca(TelaPersonagensController.susanneLefort);
            TelaPersonagensController.susanneLefort.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.susanneLefort);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
    @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.susanneLefort);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/susanneLefort/TelaLogSusanneLefort");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.susanneLefort.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.susanneLefort.pedirEmNamoro()) {
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
            
            TelaPersonagensController.susanneLefort.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.susanneLefort);
            labelPergunta.setText(TelaPersonagensController.susanneLefort.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.susanneLefort.concluirConversa(TelaPersonagensController.susanneLefort.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
