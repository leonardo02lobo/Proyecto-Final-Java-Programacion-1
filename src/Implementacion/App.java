package Implementacion;

import GUI.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import logica.musica;

public class App {

    /**
     * Variables que se utilizaran en el codigo de manera global. -la instancia
     * de JFrame estatica se realizo para mayor optimizacion. -las variables
     * estatcicas de ancho y alto estan para guardar el ancho y alto del Frame.
     */
    public static JFrame ventana = new JFrame();
    public static int ancho = 500;
    public static int alto = 500;
    public static JPanel panel = new JPanel();
    public static Menu menu = new Menu();
    public static musica Musica = new musica("src/source/music/tema_fondo.wav");

    public static void main(String[] args) {
        /**
         * creacion del JFrame y darle los valores con que aparecera
         */
        Toolkit miPantalla =   Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/source/extra/spaceinvaders_512_icon.png");
        ventana.setIconImage(miIcono);
        ventana.setSize(ancho, alto);
        ventana.setLocationRelativeTo(null);
        panel.setLayout(new BorderLayout());
        panel.add(menu, BorderLayout.CENTER);
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setTitle("Space Invader");
        ventana.setVisible(true);
        try {
            Musica.reproducir();
        } catch (Exception e) {
        }
    }
}
