package amordoce.control.personagens;

import amordoce.App;
import amordoce.model.Conversa;
import amordoce.model.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PersonagemController implements Initializable {
    
    @FXML 
    public Label labelEnergia;
    @FXML 
    public Label labelHumor;
    @FXML 
    public Label labelInteresse;
    @FXML
    public Label labelNivel;
    @FXML
    public Label labelPergunta;
    @FXML
    public Button btnOpcaoA;
    @FXML
    public Button btnOpcaoB;
    @FXML
    public Button btnOpcaoC;
    @FXML
    public Button btnProxima;
    @FXML
    public Pane btnNamoro;
    @FXML
    public VBox statsBox;
    @FXML
    public Label labelNome;
    @FXML
    public Label labelIdade;
    @FXML
    public Label labelSigno;
    @FXML
    public Label labelNacionalidade;
    @FXML
    public Label labelTurma;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        esconderButtonNamoro();
    }
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    @FXML
    private void handlerMostrarStats(ActionEvent event) throws Exception {
        if(statsBox.isVisible()) {
            statsBox.setVisible(false);
        }
        else {
            statsBox.setVisible(true);
        }
    }
    
    /**
     * Gera os stats (descrição) de cada personagem que vai para a statsBox de cada personagem
     * @param personagem 
     */
    public void gerarStats(Personagem personagem) {
        labelNome.setText(personagem.getNome());
        labelIdade.setText(Integer.toString(personagem.getIdade()) + " anos");
        labelSigno.setText(personagem.getSigno());
        labelNacionalidade.setText(personagem.getNacionalidade());
        labelTurma.setText(personagem.getTurma());
    }
    
    /**
     * Atualiza as labels de atributos dinâmicos
     * @param personagem 
     */
    public void atualizarAtributosTela(Personagem personagem) {
        labelEnergia.setText("Energia: " + personagem.getEnergia() + "%");
        labelHumor.setText("Humor: " + personagem.getHumor());
        labelInteresse.setText("Interesse: " + personagem.getInteresse() + "%");
    }
    
    /**
     * Carrega a pergunta e as possíveis respostas do usuário
     * @param personagem 
     */
    public void carregarConversa(Personagem personagem) {
        Conversa conversa = personagem.getConversaAtual();

        if(conversa.getId() == -1) {
            this.setVisibilidadeRespostas(false);
            labelPergunta.setText("...");
        } else {
            this.setVisibilidadeRespostas(true);
            labelPergunta.setText(personagem.getConversaAtual().getPergunta());
            btnOpcaoA.setText(personagem.getConversaAtual().getResposta(0));
            btnOpcaoB.setText(personagem.getConversaAtual().getResposta(1));
            btnOpcaoC.setText(personagem.getConversaAtual().getResposta(2));
        }
    }
    
    @FXML
    public void esconderButtonNamoro() {
        this.btnNamoro.setVisible(false);
    }
    
    @FXML
    public void mostrarButtonNamoro() {
        this.btnNamoro.setVisible(true);
    }
    
    /**
     * Checa se o grau de interesse satisfaz a possibilidade de pedir em namoro
     * @param personagem 
     */
    @FXML
    public void listenVisibilidadeNamoro(Personagem personagem) {
        if(personagem.validarInteresse()) {
            mostrarButtonNamoro();
        } else {
            esconderButtonNamoro();
        }
    }
    
    /**
     * Altera a visibilidade das opções de respostas do usuário 
     * @param visibilidade 
     */
    @FXML
    public void setVisibilidadeRespostas(boolean visibilidade) {
        btnOpcaoA.setVisible(visibilidade);
        btnOpcaoB.setVisible(visibilidade);
        btnOpcaoC.setVisible(visibilidade);
    }
    
    /**
     * Altera a visibilidade do botão passado como paramêtro
     * @param button
     * @param visibilidade 
     */
    @FXML
    public void setVisibilidadeButton(Button button, boolean visibilidade) {
        button.setVisible(visibilidade);
    }
    
   
}