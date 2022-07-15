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
        carregarConversa(TelaPersonagensController.caioLopes);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.caioLopes);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.caioLopes.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.caioLopes; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.caioLopes.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.caioLopes);
            listenVisibilidadeFofoca(TelaPersonagensController.caioLopes);
            carregarConversa(TelaPersonagensController.caioLopes);
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
            int idRespostaEscolhida = tratarResposta(btn.getId(), TelaPersonagensController.caioLopes);
            atualizarAtributosTela(TelaPersonagensController.caioLopes);
            labelPergunta.setText(TelaPersonagensController.caioLopes.getConversaAtual().getReacao(idRespostaEscolhida));
            concluirConversa(TelaPersonagensController.caioLopes);   
        }
    }
}
