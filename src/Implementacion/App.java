package Implementacion;

import GUI.*;
import javax.swing.*;
import logica.musica;

public class App {

    /**
     * Variables que se utilizaran en el codigo de manera global.
     * -la instancia de JFrame estatica se realizo para mayor optimizacion. 
     * -las variables estatcicas de ancho y alto estan para guardar el ancho y alto del Frame.
     */
    public static JFrame ventana = new JFrame();
    public static int ancho = 500;
    public static int alto = 500;

    public static void main(String[] args) {
        /**
         * creacion del JFrame y darle los valores con que aparecera
         */
        ventana.setSize(ancho, alto);
        ventana.setLocationRelativeTo(null);
        ventana.add(new Menu());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setTitle("Space Invader");
        ventana.setVisible(true);
        new musica("src/source/music/tema_fondo.wav").reproducir();
    }

}
