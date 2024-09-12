package logica;

import java.io.*;
import javax.sound.sampled.*;

/**
 * Esta clase contiene metodos para poder manipular la musica
 *
 * @author equipo
 */
public class musica {

    /**
     * Constructor que recibe por parametro una ruta para inicializar las
     * variables e inciar el sonido
     *
     * @param ruta
     */
    public musica(String ruta) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            sonido = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));

            sonido.open(audio);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Este metodo reproduce el sonido del juego 2000 en un bucle
     */
    public void reproducir() {
        sonido.loop(2000);
    }

    /**
     * Este metodo se encarga de reproducir el audio una vez
     */
    public void reproducirClic() {
        sonido.start();
    }

    /**
     * Este metodo se encarga de detener el sonido del juego
     */
    public void detener() {
        sonido.stop();
    }
    private Clip sonido;
}
