package Juego;

import Juego.enemigos.Alienigenas;
import Juego.enemigos.Calamar;
import Juego.enemigos.Cangrejo;
import Juego.enemigos.Pulpo;
import Juego.personaje.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Esta clase se encarga del panel y de todo el hilo del juego en esta clase se
 * desarollaran la mayoria de la logica del programa esta clase tendra un hilo
 * que se encargara de repintar todo el Panel para poder una vista a tiempo real
 */
public class Game extends JPanel {

    private nave minave = new nave();
    Alienigenas enemigos[] = {
        new Calamar(200, 200),
        new Cangrejo(300, 200),
        new Pulpo(400, 200)
    };
    boolean band[] = {false,false,false};

    public Game() {
        setLayout(null);
        setBackground(Color.BLACK);
        /**
         * en esta parte llamamos a un evento de teclado y hacemos uso de una
         * clase anonima para poder llamar al metodo KeyPressed que se encarga
         * de mover la nave y crear los objetos de disparo de la nave
         */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    crearDisparo();
                }
                revalidate();
                repaint();
            }
        });
        add(minave);
        for (Alienigenas enemigo : enemigos) {
            add(enemigo);
        }
        setFocusable(true);

        /**
         * esta Timer se encarga de revalidar y repintar el panel para tener una
         * vista refresacada del juego
         */
        Timer hilo = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revalidate();
                repaint();
            }
        });
        hilo.start();
    }

    /**
     * este metodo se encarga de crear un objeto de tipo Disparo_Personaje y
     * mandarlo hacia arriba, crerando la ilusion de que el disparo va directo a
     * un enemigo
     */
    private void crearDisparo() {
        int x = minave.getRectangle().x + (minave.getRectangle().width / 2);
        Disparo_Personaje disparo = new Disparo_Personaje(x, minave.getRectangle().y - 50);
        add(disparo);
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (disparo.getY() != 0) {
                    disparo.setLocation(x, disparo.movimientoDisparo());
                } else {
                    remove(disparo);
                }
                int i = 0;
                for (Alienigenas enemigo : enemigos) {
                    if (enemigo.getRectangle().intersects(disparo.getRectangle()) && !band[i]) {
                        remove(disparo);
                        remove(enemigo);
                        band[i] = true;
                    }
                    i++;
                }

            }
        });
        t.start();
    }
}
