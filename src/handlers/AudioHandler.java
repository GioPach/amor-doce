package handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioHandler {
    
    final private List<MediaPlayer> players = new ArrayList<MediaPlayer>();
    
    /** Executa os procedimentos para a composição da playlist e toca o primeiro MediaPlayer da lista */
    public void startPlaylist() {
        try {
            criarMediaPlayers(); 
        } catch(Exception e) {
            System.out.println("AudioHandler: " + e);
        }
        
        setPlaylist();
        players.get(0).play();
    }
    
    /** Compõe a playlist settando o MediaPlayer a tocar após o término do anterior */
    private void setPlaylist() {
        for (int i = 0; i < players.size(); i++) {
            final MediaPlayer player = players.get(i);
            final MediaPlayer nextPlayer = players.get((i + 1) % players.size()); // garante que reiniciará a playlist após o último MediaPlayer
            player.setOnEndOfMedia(new Runnable() {
                @Override public void run() {
                nextPlayer.play();
                }
            });   
        }
        
    }
    
    /** adiciona um MediaPlayer à lista de players para cada arquivo do diretório fonte pelo path ("diretório fonte/nome do arquivo") */
    // gera exceção caso a url do diretório fonte seja mal informada
    private void criarMediaPlayers() throws Exception {
     
        final File dir = new File("src/assets/audio"); // determina o diretório fonte para a playlist 

        for (String file : dir.list()) {    
            players.add(criarPlayer(dir.toURI().toURL().toString() + "/" + file));
        }
    
        if (players.isEmpty()) {
            System.out.println("No audio found in " + dir);
            return;
        }
    }
    
    /** @return um MediaPlayer para determinado áudio que reportará qualquer erro encontrado */
    private MediaPlayer criarPlayer(String pathAudio) {
        
        final MediaPlayer player = new MediaPlayer(new Media(pathAudio));
        player.setOnError(new Runnable() {
        @Override public void run() {
            System.out.println("Media error occurred: " + player.getError());
        }
        });
        return player;
        
    }   
      
}
