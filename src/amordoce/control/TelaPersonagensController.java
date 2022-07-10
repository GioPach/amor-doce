package amordoce.control;

import amordoce.App;
import amordoce.model.personagens.EmaMontenegro;
import enums.NivelDificuldade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaPersonagensController implements Initializable {
    
    //public static CaioLopes caioLopes = new CaioLopes("Caio Lopes", "Música", 21, "Peixes", "Brasileiro", 'M', "Neutro", NivelDificuldade.MEDIO);
    //public static CatherineJones catherineJones = new CatherineJones("Catherine Jones", "Música", 22, "Libra", "Britânica", 'F', "Neutro", NivelDificuldade.MEDIO);
    //public static DarioAgostini darioAgostini = new DarioAgostini("Dario Agostini", "Informática", 20, "Câncer", "Italiano", 'M', "Neutro", NivelDificuldade.FACIL);
    //public static DylanAyala dylanAyala = new DylanAyala("Dylan Ayala", "Eletrônica", 21, "Escorpião", "Britânico", 'M', "Neutro", NivelDificuldade.MEDIO);
    public static EmaMontenegro emaMontenegro = new EmaMontenegro("Ema Montenegro", "Música", 21, "Gêmeos", "Espanhola", 'F', "Neutro", NivelDificuldade.DIFICIL);
    //public static JudyWillis judyWillis = new JudyWillis("Judy Willis", "Administração", 22, "Sagitário", "Alemã", 'F', "Neutro", NivelDificuldade.FACIL);
    //public static MatthewWilliams matthewWilliams = new MatthewWilliams("Matthew Williams", "Música", 23, "Aquário", "Alemão", 'M', "Neutro", NivelDificuldade.FACIL);
    //public static RenzoAndreotti renzoAndreotti = new RenzoAndreotti("Renzo Andreotti", "Eletrônica", 22, "Capricórnio", "Italiano", 'M', "Neutro", NivelDificuldade.DIFICIL);
    //public static SophiePorto sophiePorto = new SophiePorto("Sophie Porto", "Administração", 23, "Escorpião", "Brasileira", 'F', "Neutro", NivelDificuldade.MEDIO);
    //public static SusanneLefort susanneLefort = new SusanneLefort("Susanne Lefort", "Informática", 23, "Leão", "Francesa", 'F', "Neutro", NivelDificuldade.FACIL);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handlerButtonSairDoJogo(ActionEvent event) throws Exception {
        App.setRoot("TelaInicial");
    }
    //Ema Montenegro
    @FXML
    private void handlerButtonEmaMontenegro(ActionEvent event) throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaEmaMontenegro");
    }
    //Judy Willis
    @FXML
    private void handlerButtonJudyWillis(ActionEvent event) throws Exception {
        App.setRoot("personagens/judyWillis/TelaJudyWillis");
    }
    //Dylan Ayala
        @FXML
    private void handlerButtonDylanAyala(ActionEvent event) throws Exception {
        App.setRoot("personagens/dylanAyala/TelaDylanAyala");
    }
    //Dario Agostini
     @FXML
    private void handlerButtonDarioAgostini(ActionEvent event) throws Exception {
        App.setRoot("personagens/darioAgostini/TelaDarioAgostini");
    }
    //Matthew Williams
          @FXML
    private void handlerButtonMatthewWilliams(ActionEvent event) throws Exception {
        App.setRoot("personagens/matthewWilliams/TelaMatthewWilliams"); 
    }
    //Susanne Lefort
           @FXML
    private void handlerButtonSusanneLefort(ActionEvent event) throws Exception {
        App.setRoot("personagens/susanneLefort/TelaSusanneLefort"); 
    }
    //Caio Lopes
           @FXML
    private void handlerButtonCaioLopes(ActionEvent event) throws Exception {
        App.setRoot("personagens/caioLopes/TelaCaioLopes"); 
    }
    //Renzo Andreotti
        @FXML
    private void handlerButtonRenzoAndreotti(ActionEvent event) throws Exception {
        App.setRoot("personagens/renzoAndreotti/TelaRenzoAndreotti"); 
    }
    //Sphie Porto
         @FXML
    private void handlerButtonSophiePorto(ActionEvent event) throws Exception {
        App.setRoot("personagens/sophiePorto/TelaSophiePorto"); 
    }
    //Catherine Jones
         @FXML
    private void handlerButtonCatherineJones(ActionEvent event) throws Exception {
        App.setRoot("personagens/catherineJones/TelaCatherineJones"); 
    }
}
