/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amordoce.control;

import amordoce.App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Aluno
 */
public class TelaInicialController implements Initializable {
    
    @FXML
    private void handlerButtonAction(ActionEvent event) throws Exception {
        App.setRoot("TelaPersonagens");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
