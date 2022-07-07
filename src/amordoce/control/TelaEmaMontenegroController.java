package amordoce.control;

import amordoce.App;
import amordoce.model.personagens.EmaMontenegro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaEmaMontenegroController extends PersonagemController implements Initializable {
    
    public static EmaMontenegro ema = new EmaMontenegro();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        atualizarAtributosTela(ema);
        labelPergunta.setText(ema.getConversaAtual().getPergunta());
        btnOpcaoA.setText(ema.getConversaAtual().getResposta(0));
        btnOpcaoB.setText(ema.getConversaAtual().getResposta(1));
        btnOpcaoC.setText(ema.getConversaAtual().getResposta(2));
    }
    

    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    @FXML
    private void handlerLogConversas(ActionEvent event) throws Exception {

        AnchorPane ap = new AnchorPane();
        
        
    }
    
    @FXML
    private void handlerButtonResposta(ActionEvent event) throws Exception {
        Button btn = (Button) event.getSource();
        
        //System.out.println(btn.getText());
        
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
        
        ema.getConversaAtual().escolherResposta(idResposta);
        atualizarAtributosTela(ema);
        labelPergunta.setText(ema.getConversaAtual().getReacao(idResposta));
        fecharPerguntas();
        
    }
}
