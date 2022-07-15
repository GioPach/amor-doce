package amordoce.control.personagens.renzoAndreotti;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaRenzoAndreottiController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.renzoAndreotti);
        listenVisibilidadeNamoro(TelaPersonagensController.renzoAndreotti);
        listenVisibilidadeFofoca(TelaPersonagensController.renzoAndreotti);
        TelaPersonagensController.renzoAndreotti.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.renzoAndreotti);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.renzoAndreotti);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.renzoAndreotti.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.renzoAndreotti; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.renzoAndreotti.setFofoca("");
            
            listenVisibilidadeNamoro(TelaPersonagensController.renzoAndreotti);
            listenVisibilidadeFofoca(TelaPersonagensController.renzoAndreotti);
            TelaPersonagensController.renzoAndreotti.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.renzoAndreotti);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.renzoAndreotti);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/renzoAndreotti/TelaLogRenzoAndreotti");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.renzoAndreotti.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.renzoAndreotti.pedirEmNamoro()) {
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
            int idRespostaEscolhida = tratarResposta(btn.getId(), TelaPersonagensController.renzoAndreotti);
            atualizarAtributosTela(TelaPersonagensController.renzoAndreotti);
            labelPergunta.setText(TelaPersonagensController.renzoAndreotti.getConversaAtual().getReacao(idRespostaEscolhida));
            concluirConversa(TelaPersonagensController.renzoAndreotti);
        }
    }
}
