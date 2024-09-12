package logica;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de proporcionar metodos para el guardado y cargado de
 * las partidas
 *
 * @author equipo
 */
public class Guardar_Datos_Partida {

    /**
     * Metodo que proporciona por parametro un arreglo de objeto que guardar los
     * datos usando Serializacion
     *
     * @param juego
     */
    public void GuardarDatos(Object[] juego) {
        try {
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("src/Datos/Guardado De Partida.txt"));

            guardar.writeObject(juego);
            guardar.close();
        } catch (IOException ex) {
        }
    }

    /**
     * Este metodo nos devuelve un Objeto y obtiene los datos del archivo de
     * guardado de partida
     *
     * @return
     */
    public Object obtenerPartida() {
        Object cargarPartida = null;

        ObjectInputStream leerJuego;
        try {
            leerJuego = new ObjectInputStream(new FileInputStream("src/Datos/Guardado De Partida.txt"));

            cargarPartida = (Object) leerJuego.readObject();
        } catch (Exception ex) {
            Logger.getLogger(Guardar_Datos_Partida.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cargarPartida;
    }
}
