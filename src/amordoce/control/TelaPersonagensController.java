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
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(TelaPersonagensController.start) {
            initPersonagens();          
            TelaPersonagensController.start = false;
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
        // Verica para cada personagem a turma dos outros e coloca dentro de um array aqueles que forem da turma dele
        for(Personagem personagem : App.personagens) {
            for(Personagem colega : App.personagens) {
                if(colega != personagem && colega.getTurma().equals(personagem.getTurma())) {
                    personagem.setColega(colega);
                }
            }
        }
    }
    
    //Ema Montenegro
    private void handlerButtonEmaMontenegro(ActionEvent event) throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaEmaMontenegro");
    }
    
    //Judy Willis
    private void handlerButtonJudyWillis(ActionEvent event) throws Exception {
        App.setRoot("personagens/judyWillis/TelaJudyWillis");
    }
    
    //Dylan Ayala
    private void handlerButtonDylanAyala(ActionEvent event) throws Exception {
        App.setRoot("personagens/dylanAyala/TelaDylanAyala");
    }
    
    //Dario Agostini
    private void handlerButtonDarioAgostini(ActionEvent event) throws Exception {
        App.setRoot("personagens/darioAgostini/TelaDarioAgostini");
    }
    
    //Matthew Williams
    private void handlerButtonMatthewWilliams(ActionEvent event) throws Exception {
        App.setRoot("personagens/matthewWilliams/TelaMatthewWilliams"); 
    }
    
    //Susanne Lefort
    private void handlerButtonSusanneLefort(ActionEvent event) throws Exception {
        App.setRoot("personagens/susanneLefort/TelaSusanneLefort"); 
    }
    
    //Caio Lopes
    private void handlerButtonCaioLopes(ActionEvent event) throws Exception {
        App.setRoot("personagens/caioLopes/TelaCaioLopes"); 
    }
    
    //Renzo Andreotti
    private void handlerButtonRenzoAndreotti(ActionEvent event) throws Exception {
        App.setRoot("personagens/renzoAndreotti/TelaRenzoAndreotti"); 
    }
    
    //Sophie Porto
    private void handlerButtonSophiePorto(ActionEvent event) throws Exception {
        App.setRoot("personagens/sophiePorto/TelaSophiePorto"); 
    }
    
    //Catherine Jones
    private void handlerButtonCatherineJones(ActionEvent event) throws Exception {
        App.setRoot("personagens/catherineJones/TelaCatherineJones"); 
    }

    @FXML
    private void handlerButtonEmaMontenegro(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonDarioAgostini(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonJudyWillis(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonDylanAyala(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonMatthewWilliams(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonSusanneLefort(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonCaioLopes(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonSophiePorto(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonCatherineJones(javafx.event.ActionEvent event) {
    }

    @FXML
    private void handlerButtonRenzoAndreotti(javafx.event.ActionEvent event) {
    }
    
}
