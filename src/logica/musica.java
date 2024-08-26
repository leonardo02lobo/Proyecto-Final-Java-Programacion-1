package logica;

import java.io.*;
import javax.sound.sampled.*;

public class musica {
    
    public musica(String ruta){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            sonido = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            
            sonido.open(audio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void reproducir(){
        sonido.loop(Integer.MAX_VALUE);
    }
    
    public void reproducirClic(){
        sonido.start();
    }
    
    public void detener(){
        sonido.stop();
    }
    private Clip sonido;
}
