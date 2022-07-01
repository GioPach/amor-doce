/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amordoce.control;

import amordoce.model.Personagem;
import amordoce.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaEmaMontenegroController implements Initializable {
    
    @FXML 
    private Label labelEnergia;
    @FXML 
    private Label labelHumor;
    @FXML 
    private Label labelInteresse;
    @FXML
    private Label labelNivel;
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Personagem ema = new Personagem();
        ema.setEnergia(100);
        ema.setHumor("Feliz");
        ema.setInteresse(0.2);
        ema.setNivel("Médio");
        labelEnergia.setText("Energia: " + ema.getEnergia() + "%");
        labelHumor.setText("Humor: " + ema.getHumor());
        labelInteresse.setText("Interesse: " + ema.getInteresse() + "%");
        labelNivel.setText("Nivel: " + ema.getNivel());
    }    
    
}
