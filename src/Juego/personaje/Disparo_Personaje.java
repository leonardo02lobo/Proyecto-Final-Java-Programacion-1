package Juego.personaje;

import Juego.Disparo;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Disparo_Personaje extends Disparo{
    
    public Disparo_Personaje(int x, int y) {
        super(x, y);
        setIcon(new ImageIcon(imagenDisparo.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }
    
    private Image imagenDisparo = new ImageIcon(getClass().getResource("../../source/personaje/Bala.png")).getImage();
}
