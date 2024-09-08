package Juego.personaje;

import java.awt.*;
import javax.swing.*;

public class Escudos_Personaje extends JLabel {

    private int x;
    private int y;
    private int ancho = 10;
    private int alto = 7;
    private Escudos esc = new Escudos();
    public JLabel[][] matriz = new JLabel[esc.escudo.length][esc.escudo[0].length];
    public boolean band = true;
    private int total;

    public Escudos_Personaje(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 70, 65);
    }

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
                if(esc.escudo[i][j] == 0){
                    cont++;
                }
            }
        }
        
        if(cont == total){
            band = false;
        }
    }
}
