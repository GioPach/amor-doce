package amordoce;

import amordoce.model.Personagem;
import handlers.AudioHandler;
import java.util.HashSet;
import java.util.Set;
        
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    
    public static Personagem usuario;
    public static Set<Personagem> personagens = new HashSet<>();
    private static Scene scene;
    private boolean playlistPlaying;
    
    /**
     * Inicia o programa aplicando a TelaInicial como cena e implementa música de fundo
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("TelaInicial"), 1280, 720);
        stage.setScene(scene);
        stage.show();
        new AudioHandler().startPlaylist();
    }

    /**
     * Troca a cena de acordo com o arquivo fxml passado por parâmetro
     * @param fxml
     * @throws Exception 
     */
    public static void setRoot(String fxml) throws Exception {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carrega o novo arquivo fxml para a tela
     * @param fxml
     * @throws Exception 
     */
    private static Parent loadFXML(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
}