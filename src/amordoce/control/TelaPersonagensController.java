package amordoce.control;

import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TelaPersonagensController implements Initializable {
    
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
    private void handlerButtonCaoiLopes(ActionEvent event) throws Exception {
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
        App.setRoot("personagens/sophiePorto/TelaSpohiePorto"); 
    }
    //Catherine Jones
         @FXML
    private void handlerButtonCatherineJones(ActionEvent event) throws Exception {
        App.setRoot("personagens/catherineJones/TelaCatherineJones"); 
    }
}
