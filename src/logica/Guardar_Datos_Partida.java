package logica;

import Juego.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guardar_Datos_Partida {

    public void GuardarDatos(Game juego) {
        try {
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("src/Datos/Guardado De Partida.txt"));

            guardar.writeObject(juego);
            guardar.close();
        } catch (IOException ex) {
        }
    }

    public Game obtenerPartida() {
        Game cargarPartida = null;

        ObjectInputStream leerJuego;
        try {
            leerJuego = new ObjectInputStream(new FileInputStream("src/Datos/Guardado De Partida.txt"));

            cargarPartida = (Game) leerJuego.readObject();
        } catch (Exception ex) {
            Logger.getLogger(Guardar_Datos_Partida.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cargarPartida;
    }
}
