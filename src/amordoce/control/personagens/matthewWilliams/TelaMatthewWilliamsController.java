package amordoce.control.personagens.matthewWilliams;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import amordoce.control.personagens.PersonagemController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaMatthewWilliamsController extends PersonagemController implements Initializable {
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        atualizarAtributosTela(TelaPersonagensController.matthewWilliams);
        listenVisibilidadeNamoro(TelaPersonagensController.matthewWilliams);
        listenVisibilidadeFofoca(TelaPersonagensController.matthewWilliams);
        TelaPersonagensController.matthewWilliams.verificarRespostaConversa3(); // instanciar conversa alternativa de acordo com a resposta da conversa 3
        carregarConversa(TelaPersonagensController.matthewWilliams);
        setVisibilidadeButton(this.btnProxima, false);
        gerarStats(TelaPersonagensController.matthewWilliams);
    }
    
    @FXML
    private void handlerButtonProxima(ActionEvent event) throws Exception {        
        if(TelaPersonagensController.matthewWilliams.isPedidoEmNamoro()) {
            App.namorado = TelaPersonagensController.matthewWilliams; // adiciona a pessoa que o usuário começou a namorar
            App.setRoot("TelaFimDeJogoBom");
        }
        else {
            TelaPersonagensController.matthewWilliams.setFofoca("");
        
            listenVisibilidadeNamoro(TelaPersonagensController.matthewWilliams);
            listenVisibilidadeFofoca(TelaPersonagensController.matthewWilliams);
            TelaPersonagensController.matthewWilliams.verificarRespostaConversa3();
            carregarConversa(TelaPersonagensController.matthewWilliams);
            setVisibilidadeButton(this.btnProxima, false);
        }
    }
    
     @FXML
    public void handlerPedirEmNamoro(ActionEvent event) throws Exception {
        mostrarPedidoDeNamoro(TelaPersonagensController.matthewWilliams);
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {
        App.setRoot("personagens/matthewWilliams/TelaLogMatthewWilliams");
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        if(TelaPersonagensController.matthewWilliams.isPedidoEmNamoro()) {
            setVisibilidadeRespostas(false);
            Thread.sleep(2000);
            
            if(TelaPersonagensController.matthewWilliams.pedirEmNamoro()) {
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
            int idRespostaEscolhida = tratarResposta(btn.getId(), TelaPersonagensController.matthewWilliams);
            atualizarAtributosTela(TelaPersonagensController.matthewWilliams);
            labelPergunta.setText(TelaPersonagensController.matthewWilliams.getConversaAtual().getReacao(idRespostaEscolhida));
            concluirConversa(TelaPersonagensController.matthewWilliams);
        }
    }
}
