/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package amordoce.control.personagens.emaMontenegro;

import amordoce.App;
import amordoce.control.TelaPersonagensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author gisig
 */
public class TelaLogEmaMontenegroController implements Initializable {
    
    public ObservableList<String> listaPerguntasRespostas;
    
    @FXML
    public ListView<String> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        this.listaPerguntasRespostas = TelaPersonagensController.emaMontenegro.logPersonagem();
        listView.setItems(listaPerguntasRespostas);
    }    
    
    @FXML
    private void handlerButtonVoltar(ActionEvent event) throws Exception {
        App.setRoot("personagens/emaMontenegro/TelaEmaMontenegro");
    }
    
  
    
}
