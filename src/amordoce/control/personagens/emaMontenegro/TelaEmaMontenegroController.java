package amordoce.control.personagens.emaMontenegro;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaEmaMontenegroController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.emaMontenegro);
        listenVisibilidadeNamoro(TelaPersonagensController.emaMontenegro);
        listenVisibilidadeFofoca(TelaPersonagensController.emaMontenegro);
        listenConversasAlternativas();
        carregarConversa(TelaPersonagensController.emaMontenegro);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.emaMontenegro);
    }
       
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception { 
        if(TelaPersonagensController.emaMontenegro.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.emaMontenegro; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.emaMontenegro.setFofoca("");        
            listenVisibilidadeNamoro(TelaPersonagensController.emaMontenegro);
            listenVisibilidadeFofoca(TelaPersonagensController.emaMontenegro);
            listenConversasAlternativas();
            carregarConversa(TelaPersonagensController.emaMontenegro);
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
            TelaPersonagensController.emaMontenegro.verificarConversa2();
        }
    }
    
    private void listenConversaAlternativa5() {
        int idConversa5 = 4;
        if(TelaPersonagensController.emaMontenegro.getConversaAtual().getId() == idConversa5) {
            TelaPersonagensController.emaMontenegro.verificarConversa4();
        }
    }
    
    private void listenConversaAlternativa7() {
        int idConversa7 = 6;
        if(TelaPersonagensController.emaMontenegro.getConversaAtual().getId() == idConversa7) {
            TelaPersonagensController.emaMontenegro.verificarConversa6();
        }
    }
    
    @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.emaMontenegro);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaLogEmaMontenegro");
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
            }
            
        }
        else {
            Button btn = (Button) event.getSource();
            int idRespostaEscolhida = tratarResposta(btn.getId(), TelaPersonagensController.emaMontenegro);
            atualizarAtributosTela(TelaPersonagensController.emaMontenegro);
            labelPergunta.setText(TelaPersonagensController.emaMontenegro.getConversaAtual().getReacao(idRespostaEscolhida));
            concluirConversa(TelaPersonagensController.emaMontenegro);
        }
    }
}
