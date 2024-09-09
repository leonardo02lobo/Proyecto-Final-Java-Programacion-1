package Juego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Esta clase se encarga del panel y de todo el hilo del juego en esta clase se
 * desarollaran la mayoria de la logica del programa esta clase tendra un hilo
 * que se encargara de repintar todo el Panel para poder una vista a tiempo real
 */
public class Nivel_1 extends Logica_Juego {

    //variables de la apariencia del juego
    private JFrame ventana = new JFrame();

    //metodo constructor del juego que inicializa el frame y coloca los paneles respectivos
    public Nivel_1(byte tipoJuego) {
        this.tipoJuego = tipoJuego;//variable que determina la apariencia del jugador
    }

    public Nivel_1() {
    }

    //-------------------------------CREACION DE LA VENTANA Y LLAMADA A LOS METODOS IMPORNTANTES-----
    /**
     * En este metodo se crea el Jframe y se instancia el panel para poder
     * llamar a la logica del juego.
     */
    public void inicializarFrame() {
        //colocacion del frame
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/source/extra/spaceinvaders_512_icon.png");
        ventana.setIconImage(miIcono);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Space Invader-Nivel 1");
        ventana.setSize(600, 750);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.add(principal);
        ventana.setVisible(true);

        //agregando el panel
        principal.setBackground(Color.BLACK);
        principal.setLayout(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        principal.add(vista_superior, BorderLayout.NORTH);
        principal.add(panel, BorderLayout.CENTER);
        principal.add(vista_inferior, BorderLayout.SOUTH);
        ventana.setVisible(true);

        //metodo que se encarga de la logica del juego y llamar a la nave y los enemigos 
        CrearNave();
        CrearEnemigos();
        Logica_Juego();

        /**
         * en esta parte llamamos a un evento de teclado y hacemos uso de una
         * clase anonima para poder llamar al metodo KeyPressed que se encarga
         * de mover la nave y crear los objetos de disparo de la nave
         */
        ventana.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);

                //crear el disparo
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    crearDisparo();
                }
            }
        });
        ventana.setFocusable(true);

        //llamar al metodo que se encarga de la animacion del juego
        hiloJuego(ventana);
    }
}
