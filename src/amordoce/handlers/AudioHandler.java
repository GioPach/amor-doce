package amordoce.handlers;

import javafx.scene.media.AudioClip;

public class AudioHandler {

    public static AudioClip currentSong;

    public void playSong(String fileName) {
        if (currentSong != null && currentSong.isPlaying()) {
            currentSong.stop();
        }
        
        try {
        currentSong = new AudioClip(
                getClass().getResource("../../assets/audio/" + fileName + ".mp3").toExternalForm());
        } catch(Exception e) {
            System.out.println("AudioHandler: Nao foi possivel encontrar o arquivo de audio mp3 indicado!");
        }
        currentSong.play();
    }

}
