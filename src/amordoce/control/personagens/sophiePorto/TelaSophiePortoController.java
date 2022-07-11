package amordoce.control.personagens.sophiePorto;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaSophiePortoController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.sophiePorto);
        listenVisibilidadeNamoro(TelaPersonagensController.sophiePorto);
        listenVisibilidadeFofoca(TelaPersonagensController.sophiePorto);
        TelaPersonagensController.sophiePorto.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.sophiePorto);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.sophiePorto);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {    
        if(TelaPersonagensController.sophiePorto.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.sophiePorto; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {    
            TelaPersonagensController.sophiePorto.setFofoca("");
            
            listenVisibilidadeNamoro(TelaPersonagensController.sophiePorto);
            listenVisibilidadeFofoca(TelaPersonagensController.sophiePorto);
            TelaPersonagensController.sophiePorto.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.sophiePorto);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.sophiePorto);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/sophiePorto/TelaLogSophiePorto");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.sophiePorto.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.sophiePorto.pedirEmNamoro()) {
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
            
            TelaPersonagensController.sophiePorto.getConversaAtual().escolherResposta(idResposta);
            atualizarAtributosTela(TelaPersonagensController.sophiePorto);
            labelPergunta.setText(TelaPersonagensController.sophiePorto.getConversaAtual().getReacao(idResposta));
            TelaPersonagensController.sophiePorto.concluirConversa(TelaPersonagensController.sophiePorto.getConversaAtual().getId());
            setVisibilidadeRespostas(false);
            setVisibilidadeButton(this.btnProxima, true);
        }
    }
}
