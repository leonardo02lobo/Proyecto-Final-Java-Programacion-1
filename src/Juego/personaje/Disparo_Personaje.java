package Juego.personaje;

import Juego.Disparo;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Disparo_Personaje extends Disparo {

    public Disparo_Personaje(int x, int y) {
        super(x, y);
        setBorder(BorderFactory.createLineBorder(Color.yellow));
        setIcon(new ImageIcon(imagenDisparo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    public int movimientoDisparo() {
        return getY() - movimiento;
    }
    
    public Rectangle getRectangle(){
        return this.getBounds();
    }

    private Image imagenDisparo = new ImageIcon(getClass().getResource("../../source/personaje/Bala.png")).getImage();
}
