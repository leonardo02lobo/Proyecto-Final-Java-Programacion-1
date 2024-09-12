package GUI;

import Implementacion.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

/**
 * Clase encargada de la creacion del panel del menu principal En este panel
 * iran las opciones para guardar y cargar partida, salir del juego,
 * instrucciones y los creditos
 */
public class Menu extends JPanel {

    public Menu() {
        setLayout(null);
        setSize(App.ancho, App.alto);
        setBackground(Color.BLACK);

        //Llamando al metodo 'crearEtiquetas' para las diferentes opciones del juego
        crearEtiquetas(titulo, 60, 50, 350, 70, false, 35);
        crearEtiquetas(iniciarPartida, 163, 150, 180, 30, false, 20);
        crearEtiquetas(GuardarPartida, 150, 200, 200, 30, false, 20);
        crearEtiquetas(Instrucciones, 160, 250, 180, 30, false, 20);
        crearEtiquetas(Creditos, 160, 300, 180, 30, false, 20);
        crearEtiquetas(SalirJuego, 160, 350, 200, 30, false, 20);
        crearEtiquetas(flecha, 105, 150, 30, 30, true, 20);
        flecha.setFocusable(true);
    }

    //Metodo para mantener el focus cuando se cambie de panel
    public void requestFocus() {
        flecha.requestFocusInWindow();
    }

    /**
     * Este metodo se encarga de crear las etiquetas de texto para ahorrar
     * lineas de codigo
     */
    private void crearEtiquetas(JLabel label, int x, int y, int ancho, int alto, boolean band, int tam) {
        if (band) {
            Image imagenFlecha = new ImageIcon(Menu.class.getResource("/source/flecha_menu.png")).getImage();
            label.setIcon(new ImageIcon(imagenFlecha.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        }
        if(label.equals(titulo)){
            label.setForeground(Color.YELLOW);
        }else{
            label.setForeground(Color.white);
        }
        label.setFont(new Font("OCR A Extended", Font.BOLD, tam));
        label.setBounds(x, y, ancho, alto);
        label.addKeyListener(new Evento_Flecha(x, y));
        add(label);
    }

    /**
     * clase interna que se encarga del movimiento de las flechas y del cambio
     * de paneles para trabajar en el mismo Frame con respecto al menu
     */
    private class Evento_Flecha extends KeyAdapter {

        public Evento_Flecha(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                if (y != 350) {
                    y += 50;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                if (y != 150) {
                    y -= 50;
                }
            }
            flecha.setLocation(x, y);
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (flecha.getY() == iniciarPartida.getY()) {

                    cambiarPanel(new Iniciar_Juego());
                } else if (flecha.getY() == GuardarPartida.getY()) {

                    cambiarPanel(new Guardar_Partida());
                } else if (flecha.getY() == Instrucciones.getY()) {

                    cambiarPanel(new Instrucciones());
                } else if (flecha.getY() == Creditos.getY()) {

                    cambiarPanel(new Creditos());
                } else if (flecha.getY() == SalirJuego.getY()) {

                    System.exit(0);
                }
            }
            try {
                new musica("src/source/music/clic.wav").reproducirClic();        
            } catch (Exception ex) {
            }
        }

        /**
         * metodo encargado del cambio de paneles
         */
        private void cambiarPanel(JPanel panel) {
            App.panel.removeAll();
            App.panel.add(panel, BorderLayout.CENTER);
            App.panel.revalidate();
            App.panel.repaint();
        }

        private int x;
        private int y;
    }

    /**
     * variables usada en esta clase
     */
    private JLabel titulo = new JLabel(" Space Invader", SwingConstants.CENTER);
    private JLabel iniciarPartida = new JLabel("Iniciar Juego", SwingConstants.CENTER);
    private JLabel GuardarPartida = new JLabel("Guardar Partida", SwingConstants.CENTER);
    private JLabel Instrucciones = new JLabel("Instrucciones", SwingConstants.CENTER);
    private JLabel Creditos = new JLabel("Creditos", SwingConstants.CENTER);
    private JLabel SalirJuego = new JLabel("Salir Del Juego", SwingConstants.CENTER);
    private JLabel flecha = new JLabel();
}
