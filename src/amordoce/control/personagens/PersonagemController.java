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

/**
 * @author Giovani
 * @author Filipe
 */

public class PersonagemController implements Initializable {
    
    @FXML 
    public Label labelEnergia;
    @FXML 
    public Label labelHumor;
    @FXML 
    public Label labelInteresse;
    @FXML
    public Label labelPergunta;
    @FXML
    public Button btnOpcaoA;
    @FXML
    public Button btnOpcaoB;
    @FXML
    public Button btnOpcaoC;
    @FXML
    public Button btnVoltar;
    @FXML
    public Button btnProxima;
    @FXML
    public Button btnConversas;
    @FXML
    public Button btnStats;
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
    @FXML
    public Label labelFofoca;
    
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
     * Verifica se alguém fofocou com o personagem e ativa ou desativa a visibilidade da label de fofoca
     * @param personagem 
     */
    public void listenVisibilidadeFofoca(Personagem personagem) {
        if(!personagem.getFofoca().isEmpty()) {
            labelFofoca.setVisible(true);
            labelFofoca.setText(personagem.getFofoca());
        }
        else {
            labelFofoca.setVisible(false);
        }
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
            setVisibilidadeRespostas(false);
            labelPergunta.setText(conversa.getPergunta());
        } else {
            setVisibilidadeRespostas(true);
            labelPergunta.setText(personagem.getConversaAtual().getPergunta());
            btnOpcaoA.setText(personagem.getConversaAtual().getResposta(0));
            btnOpcaoB.setText(personagem.getConversaAtual().getResposta(1));
            btnOpcaoC.setText(personagem.getConversaAtual().getResposta(2));
        }
    }
    
    /**
     * Setta a resposta escolhida pelo usuário na conversa atual
     * @param respostaEscolhida
     * @param personagem
     * @return id da resposta escolhida -> importante para selecionar a reação adequada do personagem
     */
    public int tratarResposta(String respostaEscolhida, Personagem personagem) {
        int idResposta;
        
        switch(respostaEscolhida)
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

        personagem.getConversaAtual().escolherResposta(idResposta);        
        return idResposta;
        
    }
    
    public void concluirConversa(Personagem personagem) {
        personagem.moverConversaAtual();
        setVisibilidadeRespostas(false);
        setVisibilidadeButton(this.btnProxima, true);
        setVisibilidadeButton(this.btnProxima, true);
    }
    
    public void mostrarPedidoDeNamoro(Personagem personagem) {
        personagem.setPedidoEmNamoro(true);
        
        btnVoltar.setVisible(false);
        btnConversas.setVisible(false);
        btnStats.setVisible(false);
        btnProxima.setVisible(false);
        btnNamoro.setVisible(false);
        
        labelFofoca.setVisible(false);
        labelEnergia.setVisible(false);
        labelHumor.setVisible(false);
        labelInteresse.setVisible(false);
              
        btnOpcaoB.setVisible(false);
        btnOpcaoC.setVisible(false);
        
        labelPergunta.setText("...");
        btnOpcaoA.setVisible(true);
        btnOpcaoA.setText(personagem.getNome() + ", você aceita namorar comigo?");
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
     * Utilizado nos controladores de cada personagem.
     */
    @FXML
    public void setVisibilidadeButton(Button button, boolean visibilidade) {
        button.setVisible(visibilidade);
    }
    
   
}