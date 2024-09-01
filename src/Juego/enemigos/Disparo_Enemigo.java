package Juego.enemigos;

import Juego.Disparo;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Disparo_Enemigo extends Disparo{
    
    public Disparo_Enemigo(int x, int y) {
        super(x, y);
        setIcon(new ImageIcon(imagenDisparo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }
    
    public int movimientoDisparo() {
        return getY() + movimiento;
    }
    
    @Override
    public Rectangle getRectangle(){
        return this.getBounds();
    }
    
    private Image imagenDisparo = new ImageIcon(getClass().getResource("../../source/Sprites Color/enemylaser.png")).getImage();
}
