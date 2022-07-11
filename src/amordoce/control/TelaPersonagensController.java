package amordoce.control;

import amordoce.App;
import amordoce.model.Personagem;
import amordoce.model.personagens.CaioLopes;
import amordoce.model.personagens.CatherineJones;
import amordoce.model.personagens.DarioAgostini;
import amordoce.model.personagens.DylanAyala;
import amordoce.model.personagens.EmaMontenegro;
import amordoce.model.personagens.JudyWillis;
import amordoce.model.personagens.MatthewWilliams;
import amordoce.model.personagens.RenzoAndreotti;
import amordoce.model.personagens.SophiePorto;
import amordoce.model.personagens.SusanneLefort;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaPersonagensController implements Initializable {
    
    public static CaioLopes caioLopes = new CaioLopes("Caio Lopes", "Música", 21, "Peixes", "Brasileiro", 'M', NivelDificuldade.MEDIO);
    public static CatherineJones catherineJones = new CatherineJones("Catherine Jones", "Música", 22, "Libra", "Britânica", 'F', NivelDificuldade.MEDIO);
    public static DarioAgostini darioAgostini = new DarioAgostini("Dario Agostini", "Informática", 20, "Câncer", "Italiano", 'M', NivelDificuldade.FACIL);
    public static DylanAyala dylanAyala = new DylanAyala("Dylan Ayala", "Eletrônica", 21, "Escorpião", "Britânico", 'M', NivelDificuldade.MEDIO);
    public static EmaMontenegro emaMontenegro = new EmaMontenegro("Ema Montenegro", "Música", 21, "Gêmeos", "Espanhola", 'F', NivelDificuldade.DIFICIL);
    public static JudyWillis judyWillis = new JudyWillis("Judy Willis", "Administração", 22, "Sagitário", "Alemã", 'F', NivelDificuldade.FACIL);
    public static MatthewWilliams matthewWilliams = new MatthewWilliams("Matthew Williams", "Música", 23, "Aquário", "Alemão", 'M', NivelDificuldade.FACIL);
    public static RenzoAndreotti renzoAndreotti = new RenzoAndreotti("Renzo Andreotti", "Eletrônica", 22, "Capricórnio", "Italiano", 'M', NivelDificuldade.DIFICIL);
    public static SophiePorto sophiePorto = new SophiePorto("Sophie Porto", "Administração", 23, "Escorpião", "Brasileira", 'F', NivelDificuldade.MEDIO);
    public static SusanneLefort susanneLefort = new SusanneLefort("Susanne Lefort", "Informática", 23, "Leão", "Francesa", 'F', NivelDificuldade.FACIL);
    
    private static boolean start = true;
    
    @FXML
    public Button btnDylanAyala;
    @FXML
    public Button btnMatthewWilliams;
    @FXML
    public Button btnCaioLopes;
    @FXML
    public Button btnRenzoAndreotti;
    @FXML
    public Button btnSophiePorto;
    @FXML
    public Button btnCatherineJones;
    @FXML
    public Button btnDarioAgostini;
    @FXML
    public Button btnJudyWillis;
    @FXML
    public Button btnEmaMontenegro;
    @FXML
    public Button btnSusanneLefort;
    @FXML
    public Button btnFimDeJogo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(TelaPersonagensController.start) {
            initPersonagens();          
            TelaPersonagensController.start = false;
        }
        else {
            int numPersonagensIndisponiveis = verificaDisponibilidadeBtnPersonagens();
            
            if(numPersonagensIndisponiveis == App.personagens.size()) {
                btnFimDeJogo.setVisible(true);
            }
        }
    }
    
    private void initPersonagens() {
        App.personagens.add(caioLopes);
        App.personagens.add(catherineJones);
        App.personagens.add(darioAgostini);
        App.personagens.add(dylanAyala);
        App.personagens.add(emaMontenegro);
        App.personagens.add(judyWillis);
        App.personagens.add(matthewWilliams);
        App.personagens.add(renzoAndreotti);
        App.personagens.add(sophiePorto);
        App.personagens.add(susanneLefort);
        
        instanciarColegas();       
    }
    
    private void instanciarColegas() {
        // Verifica para cada personagem a turma dos outros e coloca dentro de um array aqueles que forem da turma dele
        for(Personagem personagem : App.personagens) {
            for(Personagem colega : App.personagens) {
                if(colega != personagem && colega.getTurma().equals(personagem.getTurma())) {
                    personagem.setColega(colega);
                }
            }
        }
    }
    
    /**
     * Verifica se o personagem ainda pode ser acessado (se ainda não foi pedido em namoro)
     */
    private int verificaDisponibilidadeBtnPersonagens() {
        int numPersonagensIndisponiveis = 0;
        
        if(caioLopes.isPedidoEmNamoro()) {
            btnCaioLopes.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(catherineJones.isPedidoEmNamoro()) {
            btnCatherineJones.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(darioAgostini.isPedidoEmNamoro()) {
            btnDarioAgostini.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(dylanAyala.isPedidoEmNamoro()) {
            btnDylanAyala.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(emaMontenegro.isPedidoEmNamoro()) {
            btnEmaMontenegro.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(judyWillis.isPedidoEmNamoro()) {
            btnJudyWillis.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(matthewWilliams.isPedidoEmNamoro()) {
            btnMatthewWilliams.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(renzoAndreotti.isPedidoEmNamoro()) {
            btnRenzoAndreotti.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(sophiePorto.isPedidoEmNamoro()) {
            btnSophiePorto.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        if(susanneLefort.isPedidoEmNamoro()) {
            btnSusanneLefort.setDisable(true);
            numPersonagensIndisponiveis++;
        }
        
        return numPersonagensIndisponiveis;
    }
    
    //Fim de Jogo
    @FXML
    private void handlerButtonFimDeJogo() throws Exception {
        App.setRoot("TelaFimDeJogoRuim");
    }
    
    //Ema Montenegro
    @FXML
    private void handlerButtonEmaMontenegro() throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaEmaMontenegro");
    }
    
    //Judy Willis
    @FXML
    private void handlerButtonJudyWillis() throws Exception {
        App.setRoot("personagens/judyWillis/TelaJudyWillis");
    }
    
    //Dylan Ayala
    @FXML
    private void handlerButtonDylanAyala() throws Exception {
        App.setRoot("personagens/dylanAyala/TelaDylanAyala");
    }
    
    //Dario Agostini
    @FXML
    private void handlerButtonDarioAgostini() throws Exception {
        App.setRoot("personagens/darioAgostini/TelaDarioAgostini");
    }
    
    //Matthew Williams
    @FXML
    private void handlerButtonMatthewWilliams() throws Exception {
        App.setRoot("personagens/matthewWilliams/TelaMatthewWilliams"); 
    }
    
    //Susanne Lefort
    @FXML
    private void handlerButtonSusanneLefort() throws Exception {
        App.setRoot("personagens/susanneLefort/TelaSusanneLefort"); 
    }
    
    //Caio Lopes
    @FXML
    private void handlerButtonCaioLopes() throws Exception {
        App.setRoot("personagens/caioLopes/TelaCaioLopes"); 
    }
    
    //Renzo Andreotti
    @FXML
    private void handlerButtonRenzoAndreotti() throws Exception {
        App.setRoot("personagens/renzoAndreotti/TelaRenzoAndreotti"); 
    }
    
    //Sophie Porto
    @FXML
    private void handlerButtonSophiePorto() throws Exception {
        App.setRoot("personagens/sophiePorto/TelaSophiePorto"); 
    }
    
    //Catherine Jones
    @FXML
    private void handlerButtonCatherineJones() throws Exception {
        App.setRoot("personagens/catherineJones/TelaCatherineJones"); 
    }

}
