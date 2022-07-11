package amordoce.control.telaFimDeJogo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Filipe
 */
public class TelaFimDeJogoBomController extends TelaFimDeJogoController {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.labelMensagemFinal.setText("Parabéns <USUARIO>!\nVocê conquistou <PERSONAGEM> e ganhou o jogo.");
    }
}