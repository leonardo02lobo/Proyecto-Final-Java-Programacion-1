package Juego;

import javax.swing.*;

public abstract class Disparo extends JLabel {

    protected final int ancho = 20;
    protected final int alto = 40;
    private int x;
    private int y;
    protected final int movimiento = 10;

    public Disparo(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
