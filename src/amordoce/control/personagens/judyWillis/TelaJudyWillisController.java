package amordoce.control.personagens.judyWillis;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaJudyWillisController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.judyWillis);
        listenVisibilidadeNamoro(TelaPersonagensController.judyWillis);
        listenVisibilidadeFofoca(TelaPersonagensController.judyWillis);
        TelaPersonagensController.judyWillis.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.judyWillis);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.judyWillis);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.judyWillis.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.judyWillis; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.judyWillis.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.judyWillis);
            listenVisibilidadeFofoca(TelaPersonagensController.judyWillis);
            TelaPersonagensController.judyWillis.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.judyWillis);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.judyWillis);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/judyWillis/TelaLogJudyWillis");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.judyWillis.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.judyWillis.pedirEmNamoro()) {
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
            int idRespostaEscolhida = tratarResposta(btn.getId(), TelaPersonagensController.judyWillis);
            atualizarAtributosTela(TelaPersonagensController.judyWillis);
            labelPergunta.setText(TelaPersonagensController.judyWillis.getConversaAtual().getReacao(idRespostaEscolhida));
            concluirConversa(TelaPersonagensController.judyWillis);
        }
    }
}
