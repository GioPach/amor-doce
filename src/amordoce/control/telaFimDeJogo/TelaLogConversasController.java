package amordoce.control.telaFimDeJogo;

import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 *
 * @author Filipe
 */
public class TelaLogConversasController implements Initializable {

    public ObservableList<String> listaPerguntasRespostas = FXCollections.observableArrayList();
    
    @FXML
    public ListView listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.personagens.forEach((personagem) -> {
            personagem.logPersonagem().forEach((log) -> {
                this.listaPerguntasRespostas.add(log);
            });
        });
        
        listView.setItems(listaPerguntasRespostas);
    }    
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        if(App.namorado == null) {
            App.setRoot("TelaFimDeJogoRuim");
        }
        else {
            App.setRoot("TelaFimDeJogoBom");
        }
    }
}