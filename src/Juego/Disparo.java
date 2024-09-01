package Juego;

import java.awt.Rectangle;
import javax.swing.*;

public abstract class Disparo extends JLabel {

    protected final int ancho = 12;
    protected final int alto = 34;
    private int x;
    private int y;
    protected final int movimiento = 30;

    public Disparo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getRectangle(){
        return this.getBounds();
    }
}
