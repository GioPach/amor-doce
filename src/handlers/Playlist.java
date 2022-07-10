/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

/**
 *
 * @author gisig
 */
public class Playlist extends AudioHandler {
    
    public Playlist() {
        super.startPlaylist();
    }
    
    @Override
    protected Boolean call() throws Exception {
        try {
            criarMediaPlayers(); 
        } catch(Exception e) {
            System.out.println("AudioHandler: " + e);
        }        
               
        return setPlaylist();
               
    }
            
    @Override
    protected void succeeded() {
        players.get(0).play();
    }
    
}
