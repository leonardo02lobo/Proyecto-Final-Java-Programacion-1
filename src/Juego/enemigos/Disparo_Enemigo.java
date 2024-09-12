package Juego.enemigos;

import Juego.Disparo;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Disparo_Enemigo extends Disparo{
    /**
     * Contructor con parametros que establece la posicion y trayectoria de la bala de los enemigos o alienigenas
     * y su moviento aumenta en torno a Y
     * @param x
     * @param y 
     */
    public Disparo_Enemigo(int x, int y) {
        super(x, y);
        setIcon(new ImageIcon(imagenDisparo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }
    
    public int movimientoDisparo() {
        return getY() + movimiento;
    }
    //Colision de la bala enemiga
    @Override
    public Rectangle getRectangle(){
        return this.getBounds();
    }
    //Atributo privado que muestra la imagen de la bala enemiga
    private Image imagenDisparo = new ImageIcon(Disparo_Enemigo.class.getResource("/source/Sprites Color/enemylaser.png")).getImage();
}
