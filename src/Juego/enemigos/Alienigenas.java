package Juego.enemigos;

import java.awt.Rectangle;
import javax.swing.*;

public abstract class Alienigenas extends JLabel {

    protected final int ancho = 30;
    protected final int alto = 30;
    private int x;
    private int y;
    protected final int movimiento = 10;

    public Alienigenas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getRectangle() {
        return this.getBounds();
    }
    public void moverX(){
        x += movimiento;
        setLocation(x, y);
    }
    public void moverY(){
        y += 30;
        setLocation(x, y);
    }
    public void moverXNegativo(){
        x -= movimiento;
        setLocation(x, y);
    }
}
