package Juego.enemigos;

import java.awt.*;
import javax.swing.*;

public class NaveNodriza_Nivel_2 extends Alienigenas {
//Atributo privado que muestra la imagen de la nave en el nivel 2
    private Image imagenNave = new ImageIcon(NaveNodriza_Nivel_2.class.getResource("/source/enemigos/Nave Nodriza.png")).getImage();
    public byte golpes = 0;
/**
 * Metodo constructor  que da las dimensiones de la nave y su posicion
 * en el plano X y Y
 * @param x
 * @param y 
 */
    public NaveNodriza_Nivel_2(int x, int y) {
        super(x, y);
        ancho = 100;
        alto = 50;
        setIcon(new ImageIcon(imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
        setBounds(x, y, ancho, alto);
    }

    @Override
    public void AnimacionYSkin(byte tipo) {
        return;
    }
//Metodo que muestra el laser que la nave tiene 
    public JLabel laser(int x, int y, int anchoIncrementado, int alto) {
        JLabel laser = new JLabel();
        Image imagenLaser = new ImageIcon(NaveNodriza_Nivel_2.class.getResource("/source/enemigos/Laser_Nave Nodirza.png")).getImage();
        laser.setIcon(new ImageIcon(imagenLaser.getScaledInstance(anchoIncrementado, alto, Image.SCALE_SMOOTH)));
        laser.setBounds(x, y, anchoIncrementado, alto);
        return laser;
    }
//Si el usuario logra acertar el disparo sera premiado con 100 puntos
    @Override
    public int getPuntos() {
        return 100;
    }

}
