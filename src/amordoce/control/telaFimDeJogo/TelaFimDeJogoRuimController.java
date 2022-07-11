package amordoce.control.telaFimDeJogo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Filipe
 */
public class TelaFimDeJogoRuimController extends TelaFimDeJogoController {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.labelMensagemFinal.setText("Game over <USUARIO>!\nVocê não conseguiu conquistar nenhum dos personagens e perdeu o jogo.");
    }
}