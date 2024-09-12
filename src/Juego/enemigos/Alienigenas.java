package Juego.enemigos;

import java.awt.*;
import javax.swing.*;

public abstract class Alienigenas extends JLabel {
/**
 * Atributos de la clase que determinan la proporcion de los alienigenas, sus movientos tanto en X como en Y,
 * tambien posee un metodo rectangle que generan las colisiones, ademas el metodo getDataTime genra la animacion
 * en la que los alienigenas se van a pintar dentro del panel
 * 
 */
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
    //Metodos abstractos
    public abstract void AnimacionYSkin(byte tipo);
    public abstract int getPuntos();
}
