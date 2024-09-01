package Juego.enemigos;

import java.awt.*;
import javax.swing.*;

public abstract class Alienigenas extends JLabel {

    protected int ancho = 25;
    protected int alto = 25;
    private int x;
    private int y;
    protected final int movimiento = 10;
    private final int DataTime = 300;
    public Timer animacion = null;

    public Alienigenas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getRectangle() {
        return this.getBounds();
    }
    
    public int getDataTime(){
        return this.DataTime;
    }

    public void moverX() {
        x += movimiento;
        setLocation(x, y);
    }

    public void moverY() {
        y += 30;
        setLocation(x, y);
    }

    public void moverXNegativo() {
        x -= movimiento;
        setLocation(x, y);
    }
    
    public abstract void AnimacionYSkin(byte tipo);
    public abstract int getPuntos();
}
