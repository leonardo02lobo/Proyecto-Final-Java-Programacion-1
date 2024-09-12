package GUI;

import Implementacion.*;
import Juego.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

/**
 * Esta clase representa el panel del guardado de partida, esta clase nos
 * proporcionaria las diferentes partidas jugadas,podiendo cargar y continuar
 * con varias partidas
 *
 * @author equipo
 */
public class Guardar_Partida extends JPanel {

    public Guardar_Partida() {
        setBackground(Color.BLACK);

        /**
         * Boton el cual contiene el sonido del clic y llama al metodo para
         * salir del panel
         */
        JButton boton = new JButton("atras");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new musica("src/source/music/clic.wav").reproducirClic();
                } catch (Exception ex) {
                }
                volverMenu();
            }
        });
        add(boton);
        /**
         * Este boton deberia llamar a la clase Niveles para poder almacenar los
         * datos y cargar las diferentes partidas
         */
        JButton boton2 = new JButton("cargar partida");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nivel_1 juego = (Nivel_1) new Guardar_Datos_Partida().obtenerPartida();
            }
        });
        add(boton2);
        /**
         * Poder salir por medio de la tecla escape hacia el otro panel
         */
        App.panel.setFocusable(true);
        App.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    volverMenu();
                }
            }
        });

    }

    /**
     * Este metodo privado nos genera un cambio en el panel
     */
    private void volverMenu() {
        App.panel.removeAll();
        App.panel.add(App.menu, BorderLayout.CENTER);
        App.panel.revalidate();
        App.panel.repaint();
        App.menu.requestFocus();
    }
}
