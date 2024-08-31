package Juego.enemigos;

import java.awt.Rectangle;
import javax.swing.*;

public abstract class Alienigenas extends JLabel{

    protected final int ancho = 50;
    protected final int alto = 50;
    private int x;
    private int y;
    protected final int movimiento = 10;
    
    public Alienigenas(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getRectangle() {
        return this.getBounds();
    }
}
