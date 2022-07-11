package amordoce.control.telaFimDeJogo;

import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Filipe
 */
public class TelaFimDeJogoRuimController extends TelaFimDeJogoController {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.labelMensagemFinal.setText("Game over " + App.usuario.getNome() + "!\nVocê não conseguiu conquistar nenhum dos personagens e perdeu o jogo.");
    }
}