package amordoce.control.telaFimDeJogo;

import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Filipe
 */
public class TelaFimDeJogoBomController extends TelaFimDeJogoController {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.labelMensagemFinal.setText("Parabéns " + App.usuario.getNome() + "!\nVocê conquistou " + App.namorado.getNome() + " e ganhou o jogo.");
    }
}