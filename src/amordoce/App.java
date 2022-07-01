package amordoce;

import amordoce.handlers.AudioHandler;
import amordoce.model.Personagem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class App extends Application {
    
    public static Personagem usuario;
    public static Set<Personagem> personagens = new HashSet<>();
    //private HashSet<Conversa> conversas = new HashSet<Conversa>();
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("TelaInicial"), 833, 697);
        stage.setScene(scene);
        stage.show();
        new AudioHandler().playSong("vital-whales");
    }

    public static void setRoot(String fxml) throws Exception {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
