package Juego.personaje;

import java.awt.*;
import javax.swing.*;

/**
 * Esta clase genera los escudos del juego
 *
 * @author equipo
 */
public class Escudos_Personaje extends JLabel {

    private int x;
    private int y;
    private int ancho = 10;
    private int alto = 7;
    private Escudos esc = new Escudos();
    public JLabel[][] matriz = new JLabel[esc.escudo.length][esc.escudo[0].length];
    public boolean band = true;
    private int total;

    /**
     * El metodo constructor proporciona los valores de X y Y y le da las
     * dimensiones al label
     *
     * @param x
     * @param y
     */
    public Escudos_Personaje(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 70, 65);
    }

    /**
     * Este metodo nos genera el escudo para el personaje
     */
    public void pintarMatriz() {
        int xs = 0;
        int ys = 0;
        for (int i = 0; i < esc.escudo.length; i++) {
            for (int j = 0; j < esc.escudo[i].length; j++) {
                matriz[i][j] = new JLabel();
                if (esc.escudo[i][j] == 1) {
                    matriz[i][j].setBackground(Color.green);
                } else {
                    matriz[i][j].setBackground(Color.black);
                }
                matriz[i][j].setOpaque(true);
                matriz[i][j].setBounds(xs, ys, ancho, alto);
                add(matriz[i][j]);
                xs += ancho;
                total++;
            }
            xs = 0;
            ys += alto;
        }
    }

    /**
     * Este metodo nos genera la colision de los escudos, cada vez que se
     * colisionen generara una posicion random para eliminar
     */
    public void Colision() {
        int cont = 0;
        int xi = (int) (Math.random() * esc.escudo.length);
        int xj = (int) (Math.random() * esc.escudo[0].length);
        if (esc.escudo[xi][xj] != 0) {
            esc.escudo[xi][xj] = 0;
            matriz[xi][xj].setBackground(Color.black);
            matriz[xi][xj].setOpaque(true);
            revalidate();
            repaint();
        }

        for (int i = 0; i < esc.escudo.length; i++) {
            for (int j = 0; j < esc.escudo[i].length; j++) {
                if (esc.escudo[i][j] == 0) {
                    cont++;
                }
            }
        }

        if (cont == total) {
            band = false;
        }
    }
}
